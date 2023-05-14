package com.cb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tariff_name")
public class Tariff_Name {
    @Id
    @Column(name = "id_tariff", nullable = false)
    private Integer id_tariff;

    @Column(name = "name_tariff", length = 50)
    private String name_tariff;


    public Tariff_Name(String name_tariff) {
        this.name_tariff = name_tariff;

    }
}