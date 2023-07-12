package pro.pedritogonzalez.sistema.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pro.pedritogonzalez.sistema.models.Funcionario;
import pro.pedritogonzalez.sistema.models.Vacacion;
import pro.pedritogonzalez.sistema.repository.FuncionarioRepository;
import pro.pedritogonzalez.sistema.repository.VacacionRepository;

@Service
@Transactional
public class VacacionService {

	
	VacacionRepository repository;
	FuncionarioRepository funcionarioRepository;

	public VacacionService(VacacionRepository _repository, FuncionarioRepository _funcionarioRepository) {
		repository = _repository;
		funcionarioRepository = _funcionarioRepository;

	}
	
	@Transactional(readOnly = true)
	public List<Vacacion> listaVacaciones(){
		return repository.findAll();
	}

	private int obtenerPeriodo(int funcionarioId) {
		Funcionario funcionario = funcionarioRepository.findById(funcionarioId).get();
		Vacacion vacacion = repository.findById(funcionarioId).get();
		int periodo = funcionario.getFechaIngreso().getYear() - vacacion.getPeriodo();
		return obtenerPeriodo(periodo);
	}

	private int obtenerDias(int periodo) {
		int correspondiente = 0;

		if(periodo > 1 && periodo <= 5){
			correspondiente = 12;
		}else if(periodo > 5 && periodo <= 10){
			correspondiente = 18;
		}else if (periodo > 10){
			correspondiente = 30;
		}
		return correspondiente;
	}

	@Transactional
	public Vacacion guardar(Vacacion vacacion) {
		int funcionarioId = vacacion.getFuncionario().getId();
		int periodo = obtenerPeriodo(funcionarioId);
		int correspondiente = obtenerDias(periodo);
		int pendiente = correspondiente - vacacion.getUtilizado();
		vacacion.setCorrespondiente(correspondiente);
		vacacion.setPendiente(pendiente);
		return repository.save(vacacion);
	}
}
