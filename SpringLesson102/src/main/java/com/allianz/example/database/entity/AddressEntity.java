package com.allianz.example.database.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@AttributeOverride(name="uuid", column = @Column(name = "address_uuid"))
@Data
public class AddressEntity extends BaseEntity{

    @Column
    private String title;

    @Column(length = 500)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    private PersonEntity personEntity;
}
