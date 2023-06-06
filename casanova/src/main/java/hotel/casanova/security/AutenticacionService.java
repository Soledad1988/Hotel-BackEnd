package hotel.casanova.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hotel.casanova.repository.UsuarioRepository;



@Service
public class AutenticacionService implements UserDetailsService{

	@Autowired
	private UsuarioRepository ususarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return ususarioRepository.findByLogin(username);
	}



}
