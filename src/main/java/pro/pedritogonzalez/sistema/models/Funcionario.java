package pro.pedritogonzalez.sistema.models;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "funcionarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String apellido;
	private int cedula;
	private String direccion;
	private String telefono;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaNacimiento;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaIngreso;
	
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@ToString.Exclude
	private List<Vacacion> vacaciones = new ArrayList<>();
}
