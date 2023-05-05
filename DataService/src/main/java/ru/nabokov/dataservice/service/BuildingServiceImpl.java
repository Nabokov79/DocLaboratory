package ru.nabokov.dataservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.building.BuildingDto;
import ru.nabokov.dataservice.dto.building.NewBuildingDto;
import ru.nabokov.dataservice.dto.building.UpdateBuildingDto;
import ru.nabokov.dataservice.exceptions.BadRequestException;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.BuildingMapper;
import ru.nabokov.dataservice.model.Building;
import ru.nabokov.dataservice.repository.BuildingRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository repository;
    private final BuildingMapper mapper;
    private final AddressService addressService;

    @Override
    public BuildingDto save(NewBuildingDto buildingDto) {
        Building building = mapper.mapToNewBuilding(buildingDto);
        building.setAddress(addressService.get(buildingDto.getAddressId()));
        return mapper.mapToBuildingDto(repository.save(building));
    }

    @Override
    public BuildingDto update(UpdateBuildingDto buildingDto) {
        if (!repository.existsById(buildingDto.getId())) {
            throw new BadRequestException(String.format("building with id=%s not found for update",buildingDto.getId()));
        }
        Building building = mapper.mapToUpdateBuilding(buildingDto);
        building.setAddress(addressService.get(buildingDto.getAddressId()));
        return mapper.mapToBuildingDto(repository.save(building));
    }

    @Override
    public Building get(Long id) {
        log.info(String.format("ID=%s", id));
        return repository.findById(id)
                         .orElseThrow(() -> new NotFoundException(String.format("building with id=%s not found", id)));
    }

    @Override
    public List<BuildingDto> getAll() {
        List<Building> buildings = repository.findAll();
        if (buildings.isEmpty()) {
            throw new NotFoundException(String.format("buildings not found, buildings=%s", buildings));
        }
        return mapper.mapToBuildingsDto(buildings);
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new BadRequestException(String.format("building with id=%s not found for delete", id));

    }
}
