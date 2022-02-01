package br.gen.farmacia.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.gen.farmacia.model.Usuario;
import br.gen.farmacia.model.UsuarioLogin;
import br.gen.farmacia.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Usuario cadastrarUsuario(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaEncoder = encoder.encode(usuario.getPassword());
		usuario.setPassword(senhaEncoder);

		return repository.save(usuario);
	}

	public Optional<UsuarioLogin> logar(Optional<UsuarioLogin> email) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByEmail(email.get().getEmail());

		if (usuario.isPresent()) {
			if (encoder.matches(email.get().getPassword(), usuario.get().getPassword())) {
				String auth = email.get().getEmail() + ":" + email.get().getPassword();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				email.get().setToken(authHeader);
				email.get().setName(usuario.get().getName());

				return email;
				}
			}
		return null;
		}
			
	public Optional<UsuarioLogin> logar1(Optional<UsuarioLogin> nome) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByNome(nome.get().getName());

		if (usuario.isPresent()) {
			if (encoder.matches(nome.get().getPassword(), usuario.get().getPassword())) {
				String auth = nome.get().getEmail() + ":" + nome.get().getPassword();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic" + new String(encodedAuth);

				nome.get().setToken(authHeader);
				nome.get().setName(usuario.get().getName());

				return nome;
			}
		}
		return null;
	}

}
