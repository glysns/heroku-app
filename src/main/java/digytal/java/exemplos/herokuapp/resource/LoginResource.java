package digytal.java.exemplos.herokuapp.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digytal.java.exemplos.herokuapp.model.Login;
import digytal.java.exemplos.herokuapp.model.Sessao;
import digytal.java.exemplos.herokuapp.service.UsuarioService;

@RestController
@RequestMapping("/login")
public class LoginResource {
	@Autowired
	private UsuarioService service;
	
	@PostMapping
	public Sessao logar(@RequestBody Login login) throws Exception {
		return service.autenticar(login);
	}
	
}
