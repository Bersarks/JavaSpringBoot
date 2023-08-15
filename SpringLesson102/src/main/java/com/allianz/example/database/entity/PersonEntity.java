package com.allianz.example.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "person_uuid"
        )
) // İsmini günceller.
@Data
public class PersonEntity extends BaseEntity {
    @Column()
    private String name;

    @Column
    private String surname;

    @Column
    private int birthYear;

    @Column
    private String tc;

    @OneToMany(mappedBy = "personEntity", fetch = FetchType.EAGER) // Mapped by genellikle OnToMany verdiğimiz yerde kullanılır.
    private List<AddressEntity> addressEntityList;
}
