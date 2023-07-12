package pro.pedritogonzalez.sistema.models;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "vacaciones")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Vacacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int periodo;
	private int correspondiente;
	private int utilizado;
	private int pendiente;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaInicio;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaFin;
	private boolean acumulado;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "funcionario_id" , foreignKey = @ForeignKey(name = "FK_Funcionario_Vacaciones"))
	@ToString.Exclude
	private Funcionario funcionario;
}
