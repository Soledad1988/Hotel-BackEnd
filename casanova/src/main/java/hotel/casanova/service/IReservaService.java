package hotel.casanova.service;

import java.util.List;

import hotel.casanova.model.Reserva;

public interface IReservaService {

	 public List<Reserva> verReserva();
	    public void crearReserva(Reserva reserva);
	    public void borrarReserva(Integer id);
	    public Reserva buscarReserva(Integer id);
	    public void actualizar(Reserva reserva);
}
