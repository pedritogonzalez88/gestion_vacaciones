package pro.pedritogonzalez.sistema.repository;


import org.springframework.data.repository.CrudRepository;
import pro.pedritogonzalez.sistema.models.Funcionario;


public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
}
