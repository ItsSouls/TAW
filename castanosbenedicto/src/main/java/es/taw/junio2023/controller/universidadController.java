package es.taw.junio2023.controller;

import es.taw.junio2023.entity.AsignaturaEntity;
import es.taw.junio2023.entity.CentroEntity;
import es.taw.junio2023.entity.TitulacionEntity;
import es.taw.junio2023.repositories.AsignaturaRepository;
import es.taw.junio2023.repositories.centroRepository;
import es.taw.junio2023.repositories.titulacionRepository;
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
public class universidadController {
    @Autowired
    protected centroRepository centroRepository;

    @Autowired
    protected titulacionRepository titulacionRepository;

    @Autowired
    protected AsignaturaRepository asignaturaRepository;

    @GetMapping("/")
    public String doListar(Model model){
        List<CentroEntity> listacentros = this.centroRepository.findAll();
        model.addAttribute("listacentros",listacentros);
        return "listacentros";
    }
   @PostMapping("/enviar")
   public String doEnviar(@RequestParam("radios")Short radios, Model model){
       List<CentroEntity> listacentros = this.centroRepository.findAll();
       List<TitulacionEntity> listatitulaciones = this.titulacionRepository.listatitulacionesordenada();
       List<TitulacionEntity> listatitulacionesporcentro = new ArrayList<>();
       for (CentroEntity c:listacentros) {
           if(c.getIdcentro() == radios){
               for (TitulacionEntity t:listatitulaciones) {
                   if(t.getCentroByCentro().getIdcentro().equals(c.getIdcentro())){
                        listatitulacionesporcentro.add(t);
                   }
               }
           }
       }

       model.addAttribute("listatitulacionesporcentro",listatitulacionesporcentro);
       return "titulaciones";
   }
   @GetMapping("/editar")
    public String doEditar(@RequestParam("id")Short id, Model model){
        TitulacionEntity titulacionbyid = this.titulacionRepository.findById(id).orElse(null);
        //List<AsignaturaEntity> listaasig = titulacionbyid.getAsignaturaByAsignatura();
        List<AsignaturaEntity> listaasig = this.asignaturaRepository.findAll();
        if(listaasig.size() > 0){
            List<AsignaturaEntity> listaasigordena = this.titulacionRepository.listaasignaturasordenada(listaasig);
            model.addAttribute("asignaturalist", listaasigordena);
        }else{
            model.addAttribute("asignaturalist", listaasig);
        }
        model.addAttribute("titulacion", titulacionbyid);
        return "edicion";
   }
   @PostMapping("/guardar")
    public String doGuardar(@ModelAttribute("titulacion")TitulacionEntity titulacion){
        this.titulacionRepository.save(titulacion);
        return "redirect:/";
   }
}
