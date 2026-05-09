package br.com.fiap.api_rest.controller;

import br.com.fiap.api_rest.dto.AuthDTO;
import br.com.fiap.api_rest.dto.LoginResponseDTO;
import br.com.fiap.api_rest.dto.RegisterDTO;
import br.com.fiap.api_rest.model.Usuario;
import br.com.fiap.api_rest.repository.UsuarioRepository;
import br.com.fiap.api_rest.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private final UsuarioRepository usuarioRepository;
    @Autowired
    private final TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthController(UsuarioRepository usuarioRepository, TokenService tokenService) {
        this.usuarioRepository = usuarioRepository;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthDTO authDTO){
        //Gera um token do usuario e senha
        var usuarioSenha = new UsernamePasswordAuthenticationToken(authDTO.login(), authDTO.senha());
        //Autentica esse token
        var auth = this.authenticationManager.authenticate(usuarioSenha);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO) {
        if (usuarioRepository.findByLogin(registerDTO.login()) != null) {
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.senha());
        Usuario novoUsuario = new Usuario(registerDTO.login(), encryptedPassword, registerDTO.role());
        usuarioRepository.save(novoUsuario);
        return ResponseEntity.ok().build();


    }

}
