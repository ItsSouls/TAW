package com.mac.musicdb.controller;

import com.mac.musicdb.Entity.CancionEntity;
import com.mac.musicdb.Entity.DiscoEntity;
import com.mac.musicdb.Entity.InterpreteEntity;
import com.mac.musicdb.repositories.interpreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.mac.musicdb.repositories.discoRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class musicController {
    @Autowired
    protected discoRepository discoRepository;

    @Autowired
    protected interpreteRepository interpreteRepository;

    @GetMapping("/")
    public String doListar(Model model) {
        List<DiscoEntity> discos = this.discoRepository.findAll();
        model.addAttribute("discos", discos);
        return "index";
    }
    @GetMapping("/canciones")
    public String doCanciones(Model model, @RequestParam("id") Integer id) {
        DiscoEntity disco = this.discoRepository.findById(id).orElse(null);
        List<CancionEntity> canciones = new ArrayList<>();
        List<InterpreteEntity> intepretes = this.interpreteRepository.findAll();

        if(disco.getCancionsById() != null){
            canciones = disco.getCancionsById();
        }
        model.addAttribute("canciones", canciones);
        model.addAttribute("disco", disco);
        model.addAttribute("interpretes", intepretes);
        return "canciones";
    }

}
