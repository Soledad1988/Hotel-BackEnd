package hotel.casanova.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import hotel.casanova.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component //es el mas generar de todas las notaciones
public class SecurityFilter extends OncePerRequestFilter{
	
	//@Autowired
	//private TokenService tokenService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//System.out.println("el filtro esta siendo llamado");
		//aqui debo obtener el token del header
		var authHeader = request.getHeader("Authorization");//.replace("Bearer ", "");
		/*if(token == null || token=="") {
			throw new RuntimeException("el token enviado no es valido");
		}*/
		
		/*if(authHeader != null) {
			var token = authHeader.replace("Bearer ", "");
			//System.out.println(tokenService.getSubjet(token));//este usuario tiene sesion?
		
			var nombreUsuario = tokenService.getSubjet(token);
			if(nombreUsuario != null) {
				//token valido
				var usuario = usuarioRepository.findByLogin(nombreUsuario);
				var authentication = new UsernamePasswordAuthenticationToken(usuario,
						null, usuario.getAuthorities()); //forzamos un inicio de sesion
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}*/
		filterChain.doFilter(request, response);
		
	}

}
