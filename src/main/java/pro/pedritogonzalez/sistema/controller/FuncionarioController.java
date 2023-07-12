package pro.pedritogonzalez.sistema.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pro.pedritogonzalez.sistema.models.Funcionario;
import pro.pedritogonzalez.sistema.service.FuncionarioService;

@CrossOrigin(value = "http://localhost:5173")
@RestController
@RequestMapping(value="/api")
public class FuncionarioController {

	FuncionarioService services;
	
	public FuncionarioController(FuncionarioService _service) {
		services = _service;
	}
	
	
	@GetMapping("/funcionarios")
	public ResponseEntity<List<Funcionario>> funcionarios (){
		List<Funcionario> listafuncionario = services.listaFuncionarios();
		return ResponseEntity.ok(listafuncionario);
	}

	@PostMapping("/funcionario")
	public ResponseEntity<Funcionario> save (@RequestBody Funcionario funcionario){
		Funcionario func = services.guardar(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(func);
	}

	@PutMapping("/funcionario/{id}")
	public ResponseEntity<Funcionario> update(@PathVariable int id, @RequestBody Funcionario funcionario){
		Funcionario funcionarioExistente = services.getFuncionarioById(id).get();
		funcionarioExistente.setNombre(funcionario.getNombre());
		funcionarioExistente.setApellido(funcionario.getApellido());
		funcionarioExistente.setCedula(funcionario.getCedula());
		funcionarioExistente.setDireccion(funcionario.getDireccion());
		funcionarioExistente.setTelefono(funcionario.getTelefono());
		funcionarioExistente.setFechaIngreso(funcionario.getFechaIngreso());
		funcionarioExistente.setFechaNacimiento(funcionario.getFechaNacimiento());
		Funcionario funcionarioAcutlizado = services.guardar(funcionarioExistente);
	return ResponseEntity.ok(funcionarioAcutlizado);
	}

	@DeleteMapping("/funcionario/{id}")
	public ResponseEntity<Funcionario> delete(Funcionario funcionario){
		services.delete(funcionario);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
