package es.taw.starwars.controller;


import es.taw.starwars.entity.FraseCelebre;
import es.taw.starwars.entity.Pelicula;
import es.taw.starwars.entity.Personaje;
import es.taw.starwars.repository.FraseCelebreRespository;
import es.taw.starwars.repository.PeliculaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class FraseCelebreController {
    @Autowired
    FraseCelebreRespository fraseRespository;

    @Autowired
    PeliculaRespository peliculaRespository;

    @GetMapping("/")
    public String doListar(Model model){
        List<FraseCelebre> frases = fraseRespository.findAll();
        model.addAttribute("ListaFrases", frases);

        return "frases";
    }

    @GetMapping("/pelicula")
    public String doPelicula(Model model, @RequestParam("id") Integer id){
        Optional<Pelicula> p = peliculaRespository.findById(id);
        List<Personaje> personajes = p.get().getPersonajeList();
        model.addAttribute("ListaPersonajes", personajes);
        model.addAttribute("pelicula", p.get());
        return "pelicula";
    }
}
