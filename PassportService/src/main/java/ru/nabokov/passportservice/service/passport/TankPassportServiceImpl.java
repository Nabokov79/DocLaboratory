package ru.nabokov.passportservice.service.passport;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.client.PassportClient;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.dto.client.OrganizationDto;
import ru.nabokov.passportservice.dto.passport.tank.NewTankPassportDto;
import ru.nabokov.passportservice.dto.passport.ShortPassportDto;
import ru.nabokov.passportservice.dto.passport.tank.TankPassportDto;
import ru.nabokov.passportservice.dto.passport.tank.UpdateTankPassportDto;
import ru.nabokov.passportservice.dto.repair.RepairDto;
import ru.nabokov.passportservice.dto.survey.SurveyDto;
import ru.nabokov.passportservice.exceptions.BadRequestException;
import ru.nabokov.passportservice.exceptions.NotFoundException;
import ru.nabokov.passportservice.mapper.PassportMapper;
import ru.nabokov.passportservice.mapper.RepairMapper;
import ru.nabokov.passportservice.mapper.SurveyMapper;
import ru.nabokov.passportservice.model.passport.Passport;
import ru.nabokov.passportservice.model.passport.Repair;
import ru.nabokov.passportservice.model.passport.Survey;
import ru.nabokov.passportservice.repository.PassportRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TankPassportServiceImpl implements TankPassportService {

    private final PassportRepository repository;
    private final PassportMapper mapper;
    private final SurveyMapper surveyMapper;
    private final RepairMapper repairMapper;
    private final PassportClient client;
    private final ObjectCharacteristicsService characteristicService;
    private final SurveyService surveyService;
    private final RepairService repairService;
    private final BeltService beltService;
    private final BottomService bottomService;

    @Override
    public TankPassportDto save(NewTankPassportDto passportDto) {
        if (repository.existsByObjectDataId(passportDto.getObjectDataId())) {
            throw new BadRequestException((String.format("Passport for object data with id=%s found",
                                                                                       passportDto.getObjectDataId())));
        }
        Passport passport = mapper.mapFromNewPassportDto(passportDto);
        ObjectDataDto objectData = getObjectData(passportDto.getObjectDataId());
        passport.setObjectDataId(objectData.getId());
        passport.setRepairs(repairService.save(passportDto.getRepairs()));
        passport.setSurveys(surveyService.save(passportDto.getSurveys()));
        passport.setBelts(beltService.getAllById(passportDto.getBeltsIds()));
        passport.setBottoms(bottomService.getAllById(passportDto.getBottomsIds()));
        passport = repository.save(passport);
        passport.setCharacteristics(characteristicService.save(passport, passportDto.getCharacteristics()));
        TankPassportDto tankPassport =  mapper.mapToTankPassportDto(passport);
        tankPassport.setObjectData(objectData);
        return tankPassport;
    }

    @Override
    public TankPassportDto update(UpdateTankPassportDto passportDto) {
        if (repository.existsById(passportDto.getId())) {
            throw new NotFoundException((String.format("Passport with id=%s not found for save", passportDto.getId())));
        }
        Passport passport = mapper.mapFromUpdatePassportDto(passportDto);
        ObjectDataDto objectData = getObjectData(passportDto.getObjectDataId());
        passport.setObjectDataId(objectData.getId());
        passport.setRepairs(repairService.update(passportDto.getRepairs()));
        passport.setSurveys(surveyService.update(passportDto.getSurveys()));
        passport.setBelts(beltService.getAllById(passportDto.getBeltsIds()));
        passport.setBottoms(bottomService.getAllById(passportDto.getBottomsIds()));
        passport = repository.save(passport);
        passport.setCharacteristics(characteristicService.update(passport, passportDto.getCharacteristics()));
        TankPassportDto tankPassport =  mapper.mapToTankPassportDto(passport);
        tankPassport.setObjectData(objectData);
        return tankPassport;
    }

    @Override
    public TankPassportDto get(Long id) {
        Passport passport = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Passport with id=%s not found for save", id)));
        TankPassportDto passportDto = mapper.mapToTankPassportDto(passport);
        passportDto.setObjectData(getObjectData(passport.getObjectDataId()));
        Map<Long, OrganizationDto> organizations = getOrganizations(passport);
        passportDto.setRepairs(setOrganizationForRepair(passport, organizations));
        passportDto.setSurveys(setOrganizationForSurvey(passport, organizations));
        return passportDto;
    }

    @Override
    public List<ShortPassportDto> getAll() {
        return mapper.mapToShortPassportDto(repository.findAll());
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("Passports with id=%s not found for delete", id));
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
