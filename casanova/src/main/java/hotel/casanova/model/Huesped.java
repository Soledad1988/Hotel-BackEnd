package hotel.casanova.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import hotel.casanova.dto.HuespedDTO;
import hotel.casanova.dto.ListadoHuesped;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity(name="Huesped")
@Table(name="huespedes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "codigo") //prueba
	private Integer codigo;
	
	public Huesped(HuespedDTO datosRegistroHuesped) {
		this.nombre = datosRegistroHuesped.nombre();
		this.apellido = datosRegistroHuesped.apellido();
		this.nacimiento = datosRegistroHuesped.nacimiento();
		this.nacionalidad = datosRegistroHuesped.nacionalidad();
		this.telefono = datosRegistroHuesped.telefono();
		this.codigo = datosRegistroHuesped.reserva();
		
	}

	public void actualizarDatos(ListadoHuesped listadoHuesped) {
		if(listadoHuesped.nombre()!=null) {
			this.nombre = listadoHuesped.nombre();
		}
		if(listadoHuesped.apellido()!=null) {
			this.apellido = listadoHuesped.apellido();
		}
		
	}
	
}
