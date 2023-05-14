package com.cb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users_phone_number")
public class Users_Phone_Number {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user", nullable = false)
    private Integer id_user;

    @Column(name = "user_name", length = 50)
    private String user_name;

    @Column(name = "user_phone", length = 50)
    private String user_phone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tariff")
    private Tariff_Name id_tariff;
    @Column(name = "deleted", length = 50)
    private boolean delete=false;

    public Users_Phone_Number(String user_name, String user_phone, Tariff_Name id_tariff,boolean delete) {
        this.user_name = user_name;
        this.user_phone = user_phone;
        this.id_tariff = id_tariff;
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "Users_Phone_Number{" +
                "id_user=" + id_user +
                ", user_name='" + user_name + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", id_tariff=" + id_tariff.getId_tariff() +
                ", delete=" + delete +
                '}';
    }
}