package com.fencepro.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpaController {

    // Captura cualquier ruta que no sea un archivo (ej: /login, /admin)
    // y la manda al index.html para que React se encargue.
    @GetMapping(value = "/{path:[^\\.]*}")
    public String redirect() {
        return "forward:/index.html";
    }
}