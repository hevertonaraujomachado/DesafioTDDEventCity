package com.devsuperior.bds02.dto;


import java.io.Serializable;
import java.time.LocalDate;

import com.devsuperior.bds02.entities.Event;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EventDTO implements Serializable {

	private Long id;
	private String name;
	private LocalDate date;
	private String url;
	private Long cityId;

	public EventDTO() {
	}
	public EventDTO(Long id, String name, LocalDate date, String url, Long cityId) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.url = url;
		this.cityId = cityId;
	}

	public EventDTO(Event entity) {
		id = entity.getId();
		name = entity.getName();
		date = entity.getDate();
		url = entity.getUrl();
		cityId = entity.getCity().getId();
	}

}