package hotel.casanova.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Entity(name ="Reserva")
@Table(name="reservas")
@Setter
@EqualsAndHashCode(of ="id")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date ingreso;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date salida;
	private String valor;
	private String pago;
	
	public Reserva() {
		
	}

	public Reserva(Integer id, Date ingreso, Date salida, String valor, String pago) {
		this.id = id;
		this.ingreso = ingreso;
		this.salida = salida;
		this.valor = valor;
		this.pago = pago;
	}

	public Integer getId() {
		return id;
	}

	public Date getIngreso() {
		return ingreso;
	}

	public Date getSalida() {
		return salida;
	}

	public String getValor() {
		return valor;
	}

	public String getPago() {
		return pago;
	}
	


}
