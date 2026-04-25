package br.com.fiap.api_rest.repository;

import br.com.fiap.api_rest.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    //SELECT * FROM USUARIO WHERE LOGIN = LOGIN
    UserDetails findByLogin(String login);

}
