package pro.pedritogonzalez.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pro.pedritogonzalez.sistema.models.Vacacion;

public interface VacacionRepository extends JpaRepository<Vacacion, Integer> {

}
