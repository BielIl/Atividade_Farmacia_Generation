package br.gen.farmacia.security;

import java.util.Optional;

import org.generation.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.gen.farmacia.model.Usuario;

@Service
public class UserDetailsServiceImplement implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetailsImp loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> user = repository.findByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username + "Not_Found"));

		return user.map(UserDetailsImp::new).get();
	}

}
