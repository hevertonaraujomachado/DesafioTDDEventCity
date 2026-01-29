package com.devsuperior.bds02.services;

import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.services.exceptions.DatabaseException;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public List <City> findAll() {
        return repository.findAll(Sort.by("name"));
    }
    public City insert(City obj) {
        return  repository.save(obj);

    }
    public void delete(Long id) {
        try {
            if (!repository.existsById(id)) {
                throw new ResourceNotFoundException("Id not found");
            }
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
            }
        }
    }

