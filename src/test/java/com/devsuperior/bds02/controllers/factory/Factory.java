package com.devsuperior.bds02.controllers.factory;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;

import java.time.LocalDate;

public class Factory {

    public static Event createEvent() {
        City city = new City(1L, "Belém");

        Event event = new Event();
        event.setId(1L);
        event.setName("Feira do Software");
        event.setDate(LocalDate.parse("2021-05-16"));
        event.setUrl("https://feiradosoftware.com");
        event.setCity(city);

        return event;
    }

    public static EventDTO createEventDTO() {
        return new EventDTO(
                1L,
                "Expo XP",
                LocalDate.parse("2022-01-01"),
                "https://expoxp.com",
                1L
        );
    }
}


