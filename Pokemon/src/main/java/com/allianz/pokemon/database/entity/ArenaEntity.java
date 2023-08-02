package com.allianz.pokemon.database.entity;

import com.allianz.pokemon.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "arena")
public class ArenaEntity extends BaseEntity {
	@Column(name = "name", unique = true)
	private String name;
	@Column(name = "location")
	private String location;
	@Column(name = "capacity")
	private int capacity;
	@Column(name = "weather_type")
	private String weatherType;
}
