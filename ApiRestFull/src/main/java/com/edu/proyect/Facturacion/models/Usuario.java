package com.edu.proyect.Facturacion.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id_usuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "clave")
    private String clave;

    @Column(name = "email")
    private String email;

    @Column(name = "estado")
    private boolean estado;
}