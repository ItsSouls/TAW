package es.taw.sampletaw.Controller;

import es.taw.sampletaw.Repositories.CuentaRepository;
import es.taw.sampletaw.Repositories.cuentaClienteRepository;
import es.taw.sampletaw.Repositories.tipoComisionRepository;
import es.taw.sampletaw.entity.*;
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
public class cuentaController {

    @Autowired
    protected CuentaRepository cuentaRepository;
    @Autowired
    protected cuentaClienteRepository cuentaClienteRepository;
    @Autowired
    protected tipoComisionRepository tipoComisionRepository;

    @GetMapping("/")
    public String doListar(Model model){
        return gestorfiltro(null,model);
    }

    @GetMapping("/info")
    public String doInfo(Model model, @RequestParam("id")Integer id){
        CuentaEntity cuenta = this.cuentaRepository.findById(id).get();
        if(cuenta.getCuentaclientesByCuentaid().size() == 1){
            for (CuentaclienteEntity cuentacliente :cuenta.getCuentaclientesByCuentaid()) {
                cuentacliente.getRolclienteByRolid().setDescripcion("Titular");
            }
        }
        model.addAttribute("cuenta", cuenta);
        return "info";
    }

    @GetMapping("/cambiorol")
    public String doCambio(Model model, @RequestParam("id")Integer id){
        CuentaclienteEntity cuentacliente = this.cuentaClienteRepository.findById(id).get();

        if(cuentacliente.getRolclienteByRolid().getDescripcion().equals("Titular") && cuentacliente.getCuentaByCuentaid().getCuentaclientesByCuentaid().size() != 1){
            cuentaClienteRepository.cuentaactualizadaAutorizado(id);
        }else if(cuentacliente.getRolclienteByRolid().getDescripcion().equals("Autorizado") && cuentacliente.getCuentaByCuentaid().getCuentaclientesByCuentaid().size() != 1){
            cuentaClienteRepository.cuentaactualizadaTitular(id);
        }
        cuentaClienteRepository.save(cuentacliente);
        return "redirect:/info?id=" + cuentacliente.getCuentaByCuentaid().getCuentaid();
    }

    @GetMapping("/relacion")
    public String doRelacion(Model model, @RequestParam("id")Integer id){
        CuentaclienteEntity cuentacliente = this.cuentaClienteRepository.findById(id).get();
        if(cuentacliente.getCuentaByCuentaid().getCuentaclientesByCuentaid().size() > 1){
            cuentaClienteRepository.delete(cuentacliente);
        }
        return "redirect:/info?id=" + cuentacliente.getCuentaByCuentaid().getCuentaid();
    }

    @PostMapping("/filtrar")
    public String doFiltro(@ModelAttribute("filtro") Filtro filtro, Model model){
        return gestorfiltro(filtro,model);
    }

    public String gestorfiltro(Filtro filtro, Model model){
        List<TipocomisionEntity> listacomision = this.tipoComisionRepository.findAll();
        List<CuentaEntity>listacuentas = new ArrayList<CuentaEntity>();
        if (filtro == null || filtro.getComision() == null && filtro.getSaldo() == null) {
            listacuentas = this.cuentaRepository.findAll();
            filtro = new Filtro();
        }else if(filtro.getComision()!= null && filtro.getSaldo() == null){
            listacuentas = this.cuentaRepository.filtroporcomision(filtro.getComision());
        } else if (filtro.getComision() == null && filtro.getSaldo() != null) {
            listacuentas = this.cuentaRepository.filtroporsaldo(filtro.getSaldo());
        } else if (filtro.getComision() != null && filtro.getSaldo() != null) {
            listacuentas = this.cuentaRepository.filtroporsaldocomision(filtro.getSaldo(), filtro.getComision());
        }
        model.addAttribute("filtro", filtro);
        model.addAttribute("listacuentas",listacuentas);
        model.addAttribute("listacomision",listacomision);
        return "listar";
    }

    @GetMapping("/reset")
    public String doReset(Model model){
        List<CuentaEntity>listacuentas = this.cuentaRepository.findAll();
        Filtro filtro = new Filtro();
        model.addAttribute("filtro", filtro);
        model.addAttribute("listacuentas",listacuentas);
        return "redirect:/";
    }
}
