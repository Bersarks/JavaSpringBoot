package com.allianz.pokemon.database.entity;

import com.allianz.pokemon.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "pokemon")
@Data
public class PokemonEntity extends BaseEntity {
	@Column(name = "name", unique = true)
	private String name;
	@Column(name = "type")
	private String type;
	@Column(name = "weakness")
	private String weakness;
	@Column(name = "ability")
	private String ability;
	@Column(name = "damage")
	private int damage;
}