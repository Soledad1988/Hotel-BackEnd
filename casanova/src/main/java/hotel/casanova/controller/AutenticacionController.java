package hotel.casanova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hotel.casanova.controller.dto.DatosAutenticacionUsuario;
import hotel.casanova.model.Usuario;
import hotel.casanova.service.DatosJWTtoken;
import hotel.casanova.service.TokenService;


@RestController
@RequestMapping("/login")
public class AutenticacionController {

	@Autowired
	private AuthenticationManager autenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity autenticarUsuario(@RequestBody DatosAutenticacionUsuario datosAutenticacionUsuario) {
		Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(), 
				datosAutenticacionUsuario.clave());
		var usuarioAuthenticado = autenticationManager.authenticate(authToken);
		var JWTtoken = tokenService.generarToken((Usuario) usuarioAuthenticado.getPrincipal());
		return ResponseEntity.ok(new DatosJWTtoken(JWTtoken));
	}
}
