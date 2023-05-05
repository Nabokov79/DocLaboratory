package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.DocumentationDto;
import ru.nabokov.docservice.dto.SubheadingDto;
import ru.nabokov.docservice.dto.title.BranchDto;
import ru.nabokov.docservice.mapper.SectionMapper;
import ru.nabokov.docservice.model.DataFirstSection;
import ru.nabokov.docservice.model.FirstSection;
import ru.nabokov.docservice.repository.DataFirstSectionRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataFirstSectionServiceImpl implements DataFirstSectionService {

    private final DataFirstSectionRepository repository;
    private final SectionMapper mapper;

    @Override
    public void save(FirstSection section, List<SubheadingDto> subheadings, BranchDto branch) {
        List<DataFirstSection> dataSection = mapper.mapToDataFirstSection(subheadings);
        List<DocumentationDto> documentations = subheadings.stream().filter(d -> !d.getDocumentations().isEmpty()).map(SubheadingDto::getDocumentations).toList();
    }
}
