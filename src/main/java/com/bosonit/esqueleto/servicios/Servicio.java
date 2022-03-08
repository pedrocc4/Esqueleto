package com.bosonit.esqueleto.servicios;

import com.bosonit.esqueleto.entidades.Prueba;
import com.bosonit.esqueleto.repositorios.RepositorioPrueba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
@Validated
public class Servicio {
    @Autowired
    RepositorioPrueba pruebas;

    public Servicio() {
    }

    public long crearPrueba(@NotNull @Valid String nombre) {
        Prueba prueba = new Prueba();
        prueba.setNombre(nombre);
        pruebas.guardar(prueba);
        return prueba.getId();
    }

    public Optional<Prueba> verPrueba(long id) {
        return pruebas.buscar(id);
    }
}
