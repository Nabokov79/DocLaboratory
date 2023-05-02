package ru.nabokov.patternservice.service.title;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.client.PatternClient;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.TitlePageDataMapper;
import ru.nabokov.patternservice.model.TitlePageData;
import ru.nabokov.patternservice.model.QTitlePageData;
import ru.nabokov.patternservice.repository.TitlePageDataRepository;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TitlePageDataServiceImpl implements TitlePageDataService {

    private final TitlePageDataRepository repository;
    private final EntityManager entityManager;
    private final PatternClient client;

    @Override
    public TitlePageData save() {
        QTitlePageData titlePage = QTitlePageData.titlePageData;
        JPAQueryFactory qf = new JPAQueryFactory(entityManager);
        TitlePageData titlePageDataDb = qf.from(titlePage)
                .select(titlePage)
                .where(titlePage.date.before(LocalDate.now()))
                .fetchOne();
        return Objects.requireNonNullElseGet(titlePageDataDb,
                () -> repository.save(TitlePageDataMapper.toTitlePageData(client.getDivision())));
    }

    @Override
    public TitlePageData get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Title page data witch id=%s not found", id)));
    }
}
