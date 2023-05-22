package com.projeto.casadocodigo.controller;

import com.projeto.casadocodigo.model.Autor;
import com.projeto.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RestController
@RequestMapping(value = "/casadocodigo/api")
public class IndexController {
    @Autowired
    AutorRepository autorRepository;

    @PostMapping(value="/cadastrar", produces = "application/json")
    public ResponseEntity<Autor> novoAutor(@RequestBody Autor autor){
        Autor novoAutor = autorRepository.save(autor);
        return ResponseEntity.ok(novoAutor);
    }
}
