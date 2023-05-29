package hotel.casanova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hotel.casanova.model.Reserva;
import hotel.casanova.service.ReservaService;

@RestController
@CrossOrigin(origins="https://localhost:4200")
@RequestMapping("/reservas")
public class ReservaController {
	
	@Autowired
	private ReservaService reservaService;
	//private ReservaRepository reservaRepository;

	
	@PostMapping("")
    public void agregarReserva(@RequestBody Reserva reserva){
		reservaService.crearReserva(reserva);
		System.out.println("reserva generada con n° id "+reserva.getId());
    }
    
    @GetMapping("")
    @ResponseBody
    public List<Reserva> verReserva (){
       return reservaService.verReserva();
    }
	
    //obtiene
    @GetMapping("/{id}")
     public Reserva get(@PathVariable("id") Integer id){
        return reservaService.buscarReserva(id);
     }
     
     @DeleteMapping("/{id}")
      void borrarReserva(@PathVariable Integer id){
    	 reservaService.borrarReserva(id);
     }
     
     
    @PutMapping("")
     public void actualizar(@RequestBody Reserva reserva){
    	reservaService.actualizar(reserva);
     }
		

	

}