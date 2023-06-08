package hotel.casanova.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity(name="Huesped")
@Table(name="huespedes")
@EqualsAndHashCode(of ="id")
public class Huesped {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date nacimiento;
	private String nacionalidad;
	private String telefono;
	
	private Integer codigo;
	
	public Huesped() {
		
	}

	public Huesped(Integer id, String nombre, String apellido, Date nacimiento, String nacionalidad, String telefono,
			Integer codigo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacimiento = nacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.codigo = codigo;
	}

	public Integer getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public Date getNacimiento() {
		return nacimiento;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public String getTelefono() {
		return telefono;
	}


	public Integer getCodigo() {
		return codigo;
	}

	
	
	
}
