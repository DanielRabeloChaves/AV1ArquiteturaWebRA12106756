package com.newton.prova.av.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prova")
public class ProvaArquiteturaWeb {

    @GetMapping()
    public String prova(){
        return "Pouquissimo tempo para a prova!!";
    }
    
}
