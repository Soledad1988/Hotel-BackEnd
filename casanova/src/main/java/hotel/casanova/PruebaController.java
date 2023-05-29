package hotel.casanova;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prueba")
public class PruebaController {

	@PostMapping
	public String prueba() {
		return "se logra conexión";
	}
}
