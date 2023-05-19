package ru.nabokov.docservice.service.title;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.client.title.BranchDto;
import ru.nabokov.docservice.mapper.TitleMapper;
import ru.nabokov.docservice.model.title.TitleHeader;
import ru.nabokov.docservice.repository.TitleHeaderRepository;

@Service
@RequiredArgsConstructor
public class TitleHeaderServiceImpl implements TitleHeaderService {

    private final TitleHeaderRepository repository;
    private final TitleMapper mapper;

    @Override
    public TitleHeader save(BranchDto branch) {
        if (branch != null) {
            TitleHeader header = mapper.mapToTitleHeader(branch.getOrganization());
            header.setBranch(branch.getBranch());
            return repository.save(header);
        }
        return null;
    }
}
