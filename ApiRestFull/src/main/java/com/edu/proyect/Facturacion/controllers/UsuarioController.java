package com.edu.proyect.Facturacion.controllers;

import com.edu.proyect.Facturacion.models.Usuario;
import com.edu.proyect.Facturacion.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> obtenerLista() {
        return new ResponseEntity<>(usuarioService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario c) {
        return new ResponseEntity<>(usuarioService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        usuarioService.delete(id);
    }


    @PutMapping("actualizar/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable Integer id, @RequestBody Usuario c) {
        if (usuarioService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        c.setNombre(c.getNombre());
        c.setClave(c.getClave());
        c.setEmail(c.getEmail());
        c.setEstado(c.isEstado());

        Usuario newObjeto = usuarioService.save(c);
        return ResponseEntity.ok(newObjeto);
    }

}
