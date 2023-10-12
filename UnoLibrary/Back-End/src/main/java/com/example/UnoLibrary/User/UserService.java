<<<<<<< Updated upstream
package com.example.UnoLibrary.User;

import com.example.UnoLibrary.User.User;
import com.example.UnoLibrary.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
=======
package com.example.TelaLogin.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
>>>>>>> Stashed changes

@Service
public class UserService
{
    @Autowired
    private UserRepository repository;
<<<<<<< Updated upstream
    public void save(User user)
    {
        this.repository.save(user);
    }
    /*
    public void save(String bairro, String cep,
    String cidade,String cnpj,
    String complemento,String email,
     String inscricaoestadual, String login,
    String logotipog,String logotipop,
    String nomeempresa,String numero,
    String razaosocial,String rua,
    String senha,String senhaconfirmada,
    String site,String uf))
    {
        this.repository.save(bairro,cep,cidade,cnpj,complemento,email,inscricaoestadual,login,logotipog,logotipop,nomeempresa,numero,razaosocial,rua,senha,senhaconfirmada,site,uf);

    }

     */
=======
    public void save(User dados)
    {
        this.repository.save(dados);

    }
>>>>>>> Stashed changes
}
