package hotel.casanova.service;

import java.util.List;

import hotel.casanova.model.Huesped;

public interface IHuespedService {

	 public List<Huesped> verHuesped();
	    public void crearHuesped(Huesped huesped);
	    public void borrarHuesped(Integer id);
	    public Huesped buscarHuesped(Integer id);
	    public void actualizar(Huesped huesped);
}
