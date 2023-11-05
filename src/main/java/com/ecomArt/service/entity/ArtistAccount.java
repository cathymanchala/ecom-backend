package com.ecomArt.service.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;



@Table(name = "artist_account")
@Entity
@Data
public class ArtistAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id")
    private Long artId;

    @Column(name = "artist_password")
    private String password;

    @Column(name = "artist_name")
    private String name;

    @Column(name = "artist_email")
    private String email;
}
