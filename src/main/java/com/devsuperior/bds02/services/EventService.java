package com.devsuperior.bds02.services;

import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.EventRepository;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private EventRepository repository;

    public Event update (Long id, Event obj) {
        try {
            Event entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found");
        }
    }
    private void updateData (Event entity, Event obj) {
        entity.setName(obj.getName());
        entity.setDate(obj.getDate());
        entity.setUrl(obj.getUrl());
        entity.setCity(obj.getCity());
    }
}
