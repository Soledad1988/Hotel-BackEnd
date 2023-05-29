package hotel.casanova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.casanova.model.Reserva;
import hotel.casanova.repository.ReservaRepository;

@Service
public class ReservaService implements IReservaService{

	@Autowired
	private ReservaRepository reservaRepository;
	
	@Override
	public List<Reserva> verReserva() {
		return reservaRepository.findAll();
	}

	@Override
	public void crearReserva(Reserva reserva) {
		reservaRepository.save(reserva);
		
	}

	@Override
	public void borrarReserva(Integer id) {
		reservaRepository.deleteById(id);
	}

	@Override
	public Reserva buscarReserva(Integer id) {
		return reservaRepository.findById(id).orElse(null);
	}

	@Override
	public void actualizar(Reserva reserva) {
		reservaRepository.save(reserva);
		
	}

}
