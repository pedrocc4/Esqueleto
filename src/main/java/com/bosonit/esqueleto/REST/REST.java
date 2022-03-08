package com.bosonit.esqueleto.REST;

import com.bosonit.esqueleto.entidades.Prueba;
import com.bosonit.esqueleto.excepciones.PruebaNoEncontrada;
import com.bosonit.esqueleto.servicios.Servicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class REST {
    @Autowired
    Servicio servicio;

    Logger logger = LoggerFactory.getLogger(REST.class);

    @PostMapping("/pruebas")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Void> crearPrueba(@RequestBody Prueba prueba) {
        logger.info("Prueba creada " +  servicio.crearPrueba(prueba.getNombre()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/pruebas/{id}")
    ResponseEntity<Prueba> verRastreador(@PathVariable long id) {
        Prueba p = servicio.verPrueba(id).orElseThrow(PruebaNoEncontrada::new);
        logger.info("Datos prueba: " + p.getId());
        return ResponseEntity.status(HttpStatus.OK).body(p);
    }

}
