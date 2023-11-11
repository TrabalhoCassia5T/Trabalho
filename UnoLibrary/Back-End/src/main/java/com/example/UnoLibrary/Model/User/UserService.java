package com.example.UnoLibrary.Model.User;
import com.example.UnoLibrary.Model.entity.User;
import com.example.UnoLibrary.Model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserRepository repository;
//    public void save(User user)
//    {
//        this.repository.save(user);
//    }
//    public void save(String bairro, String cep,
//    String cidade,String cnpj,
//    String complemento,String email,
//     String inscricaoestadual, String login,
//    String logotipog,String logotipop,
//    String nomeempresa,String numero,
//    String razaosocial,String rua,
//    String senha,String senhaconfirmada,
//    String site,String uf))
//    {
//        this.repository.save(bairro,cep,cidade,cnpj,complemento,email,inscricaoestadual,login,logotipog,logotipop,nomeempresa,numero,razaosocial,rua,senha,senhaconfirmada,site,uf);
//
//    }
    public void save(User dados)
    {
        this.repository.save(dados);

    }
}
