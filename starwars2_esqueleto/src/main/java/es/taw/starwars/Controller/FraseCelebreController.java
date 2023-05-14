package es.taw.starwars.Controller;

import es.taw.starwars.Repository.FraseCelebreRepository;
import es.taw.starwars.Repository.PeliculaRepository;
import es.taw.starwars.Repository.PersonajesRepository;
import es.taw.starwars.entity.FraseCelebre;
import es.taw.starwars.entity.Pelicula;
import es.taw.starwars.entity.Personaje;
import es.taw.starwars.ui.Filtro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FraseCelebreController {
    @Autowired
    protected FraseCelebreRepository fraseCelebreRepository;

    @Autowired
    protected PeliculaRepository peliculaRepository;
    @Autowired
    protected PersonajesRepository personajesRepository;

    @GetMapping("/")
    public String doListar(Model model){
        return filtrado(null, model);
    }

    @GetMapping("/editar")
    public String doEditar(@RequestParam("id")Integer id, Model model){
        List<Personaje> personajeList = this.personajesRepository.findAll();
        Pelicula pelicula = this.peliculaRepository.findById(id).get();
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("listapersonaje", personajeList);
        return "Pelicula";
    }

    @PostMapping("/guardar")
    public String doGuardar(@ModelAttribute("pelicula")Pelicula pelicula, Model model){
        this.peliculaRepository.save(pelicula);
        return "redirect:/";
    }

    @PostMapping("/filtrar")
    public String doFiltrar(@ModelAttribute("filtro")Filtro filtro, Model model){
        return filtrado(filtro,model);
    }

    public String filtrado(Filtro filtro, Model model){
        List<FraseCelebre> fraseCelebreList = this.fraseCelebreRepository.findAll();
        if(filtro == null){
            filtro = new Filtro();
        }else{
            if(filtro.getCheckpelicula() && filtro.getCheckpersonaje()){
                fraseCelebreList = this.fraseCelebreRepository.orderbypersonajepelicula();
            }else if(filtro.getCheckpersonaje() && !filtro.getCheckpelicula()){
                fraseCelebreList = this.fraseCelebreRepository.orderbypersonaje();
            }else if(filtro.getCheckpelicula() && !filtro.getCheckpersonaje()){
                fraseCelebreList = this.fraseCelebreRepository.orderbypelicula();
            }
        }
        model.addAttribute("filtro",filtro);
        model.addAttribute("frasescelebres", fraseCelebreList);
        return "FrasesCelebres";
    }
}
