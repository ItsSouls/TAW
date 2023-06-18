package es.taw.sampletaw.controller;

import es.taw.sampletaw.entity.ClienteEntity;
import es.taw.sampletaw.entity.CuentaEntity;
import es.taw.sampletaw.entity.MovimientoEntity;
import es.taw.sampletaw.entity.TipooperacionEntity;
import es.taw.sampletaw.repositories.clienteRepository;
import es.taw.sampletaw.repositories.cuentaRepository;
import es.taw.sampletaw.repositories.movimientoRepository;
import es.taw.sampletaw.repositories.tipooperacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class bancoController {

    @Autowired
    protected clienteRepository clienteRepository;
    @Autowired
    protected cuentaRepository cuentaRepository;
    @Autowired
    protected movimientoRepository movimientoRepository;
    @Autowired
    protected tipooperacionRepository tipooperacionRepository;

    @GetMapping("/")
    public String doListar(Model model){
        List<ClienteEntity> listaclientes = this.clienteRepository.findAll();
        model.addAttribute("listaclientes",listaclientes);
        return "inicio";
    }
    @GetMapping("/activar")
    public String doActivar(Model model, @RequestParam("id") Integer id){
        List<ClienteEntity> listaclientes = this.clienteRepository.findAll();
        CuentaEntity cuentacliente= this.cuentaRepository.findById(id).get();
        short tipocuenta = 0;
        if(cuentacliente.getActiva() == 0){
            tipocuenta = 1;
            cuentacliente.setActiva(tipocuenta);
        }else{
            cuentacliente.setActiva(tipocuenta);
        }
        cuentaRepository.save(cuentacliente);
        model.addAttribute("listaclientes",listaclientes);
        return "redirect:/";
    }

    @GetMapping("/transferencia")
    public String doTransferencia(Model model, @RequestParam("id") Integer id){
        List<CuentaEntity> todasmenosyo = cuentaRepository.todasmenosyo(id);
        MovimientoEntity movimiento = new MovimientoEntity();
        CuentaEntity cuenta = cuentaRepository.findById(id).get();
        movimiento.setCuentaByCuentaorigen(cuenta);
        model.addAttribute("todasmenosyo", todasmenosyo);
        model.addAttribute("movimiento", movimiento);
        model.addAttribute("cuenta", cuenta);
        return "transferencia";
    }

    @PostMapping("/guardar")
    public String doGuardar(@ModelAttribute("movimiento")MovimientoEntity movimiento){
        MovimientoEntity movimientoDestino = new MovimientoEntity();
        TipooperacionEntity tipooperacion = this.tipooperacionRepository.getById(2);
        Timestamp fecha = new Timestamp(System.currentTimeMillis());
        movimientoDestino.setFecha(fecha);
        movimiento.setFecha(fecha);
        movimientoDestino.setCuentaByCuentadestinatario(movimiento.getCuentaByCuentaorigen());
        movimientoDestino.setCuentaByCuentaorigen(movimiento.getCuentaByCuentadestinatario());
        movimiento.setTipooperacionByTipooperacion(tipooperacion);
        movimientoDestino.setTipooperacionByTipooperacion(tipooperacion);
        movimiento.setCantidad(-movimiento.getCantidad());
        movimientoDestino.setCantidad(movimiento.getCantidad());
        movimientoDestino.setDescripcion(movimiento.getDescripcion());
        movimientoRepository.save(movimiento);
        movimientoRepository.save(movimientoDestino);
        CuentaEntity cuentaOrigen = this.cuentaRepository.findById(movimiento.getCuentaByCuentaorigen().getCuentaid()).get();
        CuentaEntity cuentaDestino = this.cuentaRepository.findById(movimientoDestino.getCuentaByCuentaorigen().getCuentaid()).get();
        cuentaOrigen.setSaldoactual(cuentaOrigen.getSaldoactual()-movimiento.getCantidad());
        cuentaDestino.setSaldoactual(cuentaDestino.getSaldoactual()+movimiento.getCantidad());
        cuentaRepository.save(cuentaDestino);
        cuentaRepository.save(cuentaOrigen);
        return "redirect:/";
    }
}
