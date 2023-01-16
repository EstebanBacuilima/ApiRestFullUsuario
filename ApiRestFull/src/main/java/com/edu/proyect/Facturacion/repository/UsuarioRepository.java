package com.edu.proyect.Facturacion.repository;

import com.edu.proyect.Facturacion.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
