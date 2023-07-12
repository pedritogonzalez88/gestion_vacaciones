package pro.pedritogonzalez.sistema.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.pedritogonzalez.sistema.models.Vacacion;
import pro.pedritogonzalez.sistema.service.FuncionarioService;
import pro.pedritogonzalez.sistema.service.VacacionService;

import java.util.List;

@CrossOrigin(value = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class VacacionController {

    VacacionService services;
    FuncionarioService funcionarioService;

    public VacacionController(VacacionService service, FuncionarioService _funcionarioService){
        services = service;
        funcionarioService = _funcionarioService;
    }

    @GetMapping("/vacaciones")
    public ResponseEntity<List<Vacacion>> getVacaciones(){
        List<Vacacion> vacaciones = services.listaVacaciones();
        return ResponseEntity.ok(vacaciones);
    }

    @PostMapping("/vacacion")
    public ResponseEntity<Vacacion> save(@RequestBody Vacacion vacacion){
         Vacacion guardarVacaciones = services.guardar(vacacion);
        return ResponseEntity.status(HttpStatus.OK).body(guardarVacaciones);
    }
}
