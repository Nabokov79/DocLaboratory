package ru.nabokov.docservice.service;

import ru.nabokov.docservice.model.Title;

public interface DocumentService {

    Title save(Long applicationId);
}
