package com.devsuperior.bds02.services;

import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.services.exceptions.DatabaseException;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public List<City> findAll() {
        return repository.findAll(Sort.by("name"));
    }

    public City insert(City obj) {
        return repository.save(obj);

    }

    @Transactional
    public void delete(Long id) {

        // ✅ 1) Verifica se existe
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Id not found " + id);
        }

        try {
            // ✅ 2) Tenta deletar
            repository.deleteById(id);
            repository.flush(); // importante para capturar erro de FK
        }
        catch (DataIntegrityViolationException e) {
            // ✅ 3) FK -> 400
            throw new DatabaseException("Integrity violation");
        }
    } }