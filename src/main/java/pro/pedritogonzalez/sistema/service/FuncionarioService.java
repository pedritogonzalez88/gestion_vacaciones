package pro.pedritogonzalez.sistema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pro.pedritogonzalez.sistema.models.Funcionario;
import pro.pedritogonzalez.sistema.models.Vacacion;
import pro.pedritogonzalez.sistema.repository.FuncionarioRepository;


@Service
@Transactional
public class FuncionarioService {

	
	FuncionarioRepository repository;
	
	public FuncionarioService(FuncionarioRepository _repository) {
		repository = _repository;
	}
	
	@Transactional(readOnly = true)
	public List<Funcionario> listaFuncionarios(){
		return (List<Funcionario>) repository.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<Funcionario> getFuncionarioById(int id){
		return repository.findById(id);
	}

	@Transactional
	public Funcionario guardar(Funcionario funcionario) {
		return repository.save(funcionario);
	}

	@Transactional
	public void delete(Funcionario funcionario){
		Funcionario funcionarioId = repository.findById(funcionario.getId()).get();
		repository.deleteById(funcionarioId.getId());
	}
}
