package hotel.casanova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.casanova.model.Huesped;
import hotel.casanova.repository.HuespedRepository;

@Service
public class HuespedService implements IHuespedService{
	
	@Autowired
	private HuespedRepository huespedRepository;

	@Override
	public List<Huesped> verHuesped() {
		return huespedRepository.findAll();
	}

	@Override
	public void crearHuesped(Huesped huesped) {
		huespedRepository.save(huesped);
		
	}

	@Override
	public void borrarHuesped(Integer id) {
		huespedRepository.deleteById(id);
		
	}

	@Override
	public Huesped buscarHuesped(Integer id) {
		return huespedRepository.findById(id).orElse(null);
	}

	@Override
	public void actualizar(Huesped huesped) {
		huespedRepository.save(huesped);
		
	}

}
