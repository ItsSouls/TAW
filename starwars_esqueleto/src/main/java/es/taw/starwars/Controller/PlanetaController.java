package es.taw.starwars.Controller;

import es.taw.starwars.Repository.EspecieRepository;
import es.taw.starwars.Repository.FamiliaRepository;
import es.taw.starwars.Repository.PlanetaRepository;
import es.taw.starwars.entity.Especie;
import es.taw.starwars.entity.FamiliaEspecie;
import es.taw.starwars.entity.Planeta;
import es.taw.starwars.ui.Filtro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PlanetaController {

    @Autowired
    protected PlanetaRepository planetaRepository;

    @Autowired
    protected EspecieRepository especieRepository;
    @Autowired
    protected FamiliaRepository familiaRepository;
    @GetMapping("/")
    public String doListar(Model model){
        return filtrado(null,model);
    }
    @GetMapping("/editar")
    public String doEditar(@RequestParam("id")Integer id, Model model){
        Especie especie = this.especieRepository.findById(id).get();
        List<FamiliaEspecie> familiaEspecieList = this.familiaRepository.findAll();
        model.addAttribute("especies",especie);
        model.addAttribute("familias", familiaEspecieList);
        return("Planeta");
    }

    @PostMapping("/guardar")
    public String doGuardar(@ModelAttribute("especies") Especie especie){
        Planeta planeta = this.especieRepository.buscarplaneta(especie.getEspecieId());
        especie.setPlaneta(planeta);
        this.especieRepository.save(especie);
        return "redirect:/";
    }

    @PostMapping("/filtrar")
    public String doFiltrar(@ModelAttribute("filtro") Filtro filtro, Model model){
        return filtrado(filtro,model);
    }

    public String filtrado(Filtro filtrar, Model model){
        List<Planeta> planetaList = this.planetaRepository.findAll();

        List<String> climas = new ArrayList<>();
        for (Planeta p: planetaList){
            if(!climas.contains(p.getClima()) && p.getClima() != null){
                climas.add(p.getClima());
            }
        }

        if(filtrar == null){
            filtrar = new Filtro();
        }else{
            if(filtrar.getFiltrar() != ""){
                planetaList = this.planetaRepository.filtraclima(filtrar.getFiltrar());
            }else{
                planetaList = this.planetaRepository.filtrardefault();
            }
        }
        model.addAttribute("climas", climas);
        model.addAttribute("filtro", filtrar);
        model.addAttribute("planetas", planetaList);
        return "Planetas";
    }
}
