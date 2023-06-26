package ru.nabokov.passportservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.client.PassportClient;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.dto.client.OrganizationDto;
import ru.nabokov.passportservice.dto.passport.NewPassportDto;
import ru.nabokov.passportservice.dto.passport.ShortPassportDto;
import ru.nabokov.passportservice.dto.passport.PassportDto;
import ru.nabokov.passportservice.dto.passport.UpdatePassportDto;
import ru.nabokov.passportservice.dto.repair.RepairDto;
import ru.nabokov.passportservice.dto.survey.SurveyDto;
import ru.nabokov.passportservice.exceptions.BadRequestException;
import ru.nabokov.passportservice.exceptions.NotFoundException;
import ru.nabokov.passportservice.mapper.PassportMapper;
import ru.nabokov.passportservice.mapper.RepairMapper;
import ru.nabokov.passportservice.mapper.SurveyMapper;
import ru.nabokov.passportservice.model.Passport;
import ru.nabokov.passportservice.model.Repair;
import ru.nabokov.passportservice.model.Survey;
import ru.nabokov.passportservice.repository.PassportRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService {

    private final PassportRepository repository;
    private final PassportMapper mapper;
    private final SurveyMapper surveyMapper;
    private final RepairMapper repairMapper;
    private final PassportClient client;
    private final CharacteristicService characteristicService;
    private final SurveyService surveyService;
    private final RepairService repairService;

    @Override
    public PassportDto save(NewPassportDto passportDto) {
        if (repository.existsByObjectDataId(passportDto.getObjectDataId())) {
            throw new BadRequestException((String.format("Passport for object data with id=%s found",
                                                                                       passportDto.getObjectDataId())));
        }
        Passport passport = mapper.mapFromNewPassportDto(passportDto);
        ObjectDataDto objectData = getObjectData(passportDto.getObjectDataId());
        passport.setTypeId(objectData.getType().getId());
        passport.setObjectDataId(objectData.getId());
        passport.setRepairs(repairService.save(passportDto.getRepairs()));
        passport.setSurveys(surveyService.save(passportDto.getSurveys()));
        Passport passportDb = repository.save(passport);
        passportDb.setCharacteristics(characteristicService.save(passportDb, passportDto.getCharacteristics()));
        return setValues(passportDb, objectData);
    }

    @Override
    public PassportDto update(UpdatePassportDto passportDto) {
        if (repository.existsById(passportDto.getId())) {
            throw new NotFoundException((String.format("Passport with id=%s not found for save", passportDto.getId())));
        }
        Passport passport = mapper.mapFromUpdatePassportDto(passportDto);
        ObjectDataDto objectData = getObjectData(passportDto.getObjectDataId());
        passport.setTypeId(objectData.getType().getId());
        passport.setObjectDataId(objectData.getId());
        passport.setCharacteristics(characteristicService.update(passport, passportDto.getCharacteristics()));
        passport.setRepairs(repairService.update(passportDto.getRepairs()));
        passport.setSurveys(surveyService.update(passportDto.getSurveys()));
        return setValues(repository.save(passport), objectData);
    }

    @Override
    public PassportDto get(Long id) {
        Passport passport = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Passport with id=%s not found for save", id)));
        PassportDto passportDto = mapper.mapToPassportDto(passport);
        passportDto.setObjectData(getObjectData(passport.getObjectDataId()));
        Map<Long, OrganizationDto> organizations = getOrganizations(passport);
        passportDto.setRepairs(setOrganizationForRepair(passport, organizations));
        passportDto.setSurveys(setOrganizationForSurvey(passport, organizations));
        return passportDto;
    }

    @Override
    public List<ShortPassportDto> getAll(Long typeId) {
        List<Passport> passports;
        if (typeId != null) {
            passports = new ArrayList<>(repository.findAllByTypeId(typeId));
        } else {
            passports = repository.findAll();
        }
        if (passports.isEmpty()) {
            throw new NotFoundException(String.format("Passports not found, passports=%s", passports));
        }
        return mapper.mapToShortPassportDto(passports);
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("Passports with id=%s not found for delete", id));
    }

    private PassportDto setValues(Passport passport, ObjectDataDto objectData) {
        PassportDto passportDto = mapper.mapToPassportDto(repository.save(passport));
        Map<Long, OrganizationDto> organizations = getOrganizations(passport);
        passportDto.setObjectData(objectData);
        passportDto.setRepairs(setOrganizationForRepair(passport, organizations));
        passportDto.setSurveys(setOrganizationForSurvey(passport, organizations));
        return passportDto;
    }

    private List<RepairDto> setOrganizationForRepair(Passport passport, Map<Long, OrganizationDto> organizations) {
        List<RepairDto> repairs = new ArrayList<>();
        for (Repair repair : passport.getRepairs()) {
            RepairDto repairDto = repairMapper.mapToRepairsDto(repair);
            repairDto.setOrganization(organizations.get(repair.getOrganizationId()));
            repairs.add(repairDto);
        }
        return repairs;
    }

    private  List<SurveyDto> setOrganizationForSurvey(Passport passport, Map<Long, OrganizationDto> organizations) {
        List<SurveyDto> surveys = new ArrayList<>();
        for (Survey survey : passport.getSurveys()) {
            SurveyDto surveyDto = surveyMapper.mapToSurveysDto(survey);
            surveyDto.setOrganization(organizations.get(survey.getOrganizationId()));
            surveys.add(surveyDto);
        }
        return surveys;
    }

    private Map<Long, OrganizationDto> getOrganizations(Passport passport) {
        List<Long> ids = new ArrayList<>(passport.getSurveys().stream().map(Survey::getOrganizationId).toList());
        ids.addAll(passport.getRepairs().stream().map(Repair::getOrganizationId).toList());
        Map<Long, OrganizationDto> organizations = client.getOrganizations(
                String.join(",", ids.stream().distinct().map(String::valueOf).toList()))
                                             .stream()
                                             .collect(Collectors.toMap(OrganizationDto::getId, o -> o));
        if (organizations.isEmpty()) {
            throw new NotFoundException("organizations for surveys and repairs not found");
        }
        return organizations;
    }

    private ObjectDataDto getObjectData(Long id) {
        return client.getObjectData(id);
    }
}
