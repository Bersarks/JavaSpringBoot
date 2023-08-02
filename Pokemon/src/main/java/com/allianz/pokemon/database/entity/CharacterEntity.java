package com.allianz.pokemon.database.entity;

import com.allianz.pokemon.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "character")
@Data
public class CharacterEntity extends BaseEntity {
	@Column(name = "name", unique = true)
	private String name;
	@Column(name = "strategy")
	private String strategy;
	@Column(name= "bonus_damage")
	private int bonusDamage;
}
