package com.example.consumingrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/pokemon")
    public String getPokemon(@RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        String pokemonData = pokemonService.getPokemon(name);
        model.addAttribute("pokemonData", pokemonData);
        return "pokemon"; // Suponiendo que tienes una plantilla llamada "pokemon.html" en tus recursos de plantillas
    }

}
