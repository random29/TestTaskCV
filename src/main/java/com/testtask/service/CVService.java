package com.testtask.service;

import com.testtask.entity.CVEntity;
import com.testtask.exception.ProductNotFoundException;
import com.testtask.repository.CVRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CVService {
    private final CVRepository cvRepository;

    public CVService(CVRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    public List<CVEntity> findAll() {
        return cvRepository.findAll();
    }

    public CVEntity findByIdOrEmpty(UUID id) {
        return cvRepository.findById(id).orElse(new CVEntity());
    }

    public void add(CVEntity cvEntity) {
        cvRepository.save(cvEntity);
    }

    public void removeById(UUID id) {
        cvRepository.deleteById(id);
    }
}
