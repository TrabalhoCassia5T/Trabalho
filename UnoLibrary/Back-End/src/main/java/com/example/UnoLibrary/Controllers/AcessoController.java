package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.entity.Usuario;
import com.example.UnoLibrary.Model.repository.UsuarioRepository;
import com.example.UnoLibrary.Seguranca.JWTTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security")
@CrossOrigin(origins = "http://127.0.0.1:5500/UnoLibrary/Front-End")
public class AcessoController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("login/{usuario}/{senha}")
    public ResponseEntity<Object> login(@PathVariable("usuario") String usuario,
                                        @PathVariable("senha") String senha) {

        Usuario usuarioAutenticado = autenticarUsuario(usuario, senha);

        if (usuarioAutenticado != null) {
            String token = JWTTokenProvider.getToken(usuarioAutenticado);
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("ACESSO NAO PERMITIDO",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    private Usuario autenticarUsuario(String usu_login, String usu_senha) {
        return usuarioRepository.findByUsuLoginAndUsuSenha(usu_login, usu_senha);
    }

    @PostMapping("/validar-token")
    public ResponseEntity<Object> validarToken(@RequestHeader("Authorization") String token) {
        if (JWTTokenProvider.verifyToken(token)) {
            return ResponseEntity.ok("Token válido");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido");
        }
    }

    private String determinarNivelDoUsuario(String usuario) {
        if (usuario.startsWith("admin")) {
            return "admin";
        }
        else
            if (usuario.startsWith("func")) {
                return "func";
            }
        return "default";
    }

    @GetMapping("userInfo")
    public ResponseEntity<Object> getUserInfo(@RequestHeader("Authorization") String token) {
        Usuario usuario = JWTTokenProvider.getUsuarioFromToken(token);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        else {
            return ResponseEntity.badRequest().body("Usuário não encontrado");
        }
    }
}