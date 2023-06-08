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

import hotel.casanova.model.Huesped;
import hotel.casanova.service.HuespedService;
import jakarta.validation.Valid;


@RestController
@CrossOrigin(origins="https://localhost:4200")
@RequestMapping("/huespedes")
public class HuespedController {

	@Autowired
	private HuespedService huespedService;

	@PostMapping("")
    public void agregarHuesped(@RequestBody Huesped huesped){
		huespedService.crearHuesped(huesped);
    }
    
    @GetMapping
    @ResponseBody
    public List<Huesped> verHuesped (){
       return huespedService.verHuesped();
    }
    
    @GetMapping("/{id}")
    public Huesped get(@PathVariable("id") Integer id){
       return huespedService.buscarHuesped(id);
    }
   
	 @DeleteMapping("/{id}")
	 void borrarHuesped(@PathVariable Integer id){
		   huespedService.borrarHuesped(id);
	 }
  
  
	  @PutMapping("")
	  public void actualizar(@RequestBody Huesped huesped){
		   huespedService.actualizar(huesped);
	  }
	
	
}
