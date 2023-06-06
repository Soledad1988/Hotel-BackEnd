package hotel.casanova.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import hotel.casanova.repository.UsuarioRepository;
import hotel.casanova.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class SecurityFilter extends OncePerRequestFilter{
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("el filtro esta siendo llamado");
		//aqui debo obtener el token del header
		
		var authHeader = request.getHeader("Authorization");
		
		if(authHeader != null) {
			var token = authHeader.replace("Bearer ", "");
		
			var nombreUsuario = tokenService.getSubjet(token);
			if(nombreUsuario != null) {
				var usuario = usuarioRepository.findByLogin(nombreUsuario);
				var authentication = new UsernamePasswordAuthenticationToken(usuario,
						null, usuario.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		filterChain.doFilter(request, response);
		
	}

}
