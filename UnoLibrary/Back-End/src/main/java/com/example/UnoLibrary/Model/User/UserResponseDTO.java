package com.example.UnoLibrary.Model.User;

public record UserResponseDTO(Long id, String login,String nomeempresa,String cnpj,String razaosocial,String inscricaoestadual,String email,String site,String cep,String cidade,String uf,String rua,
                              String bairro,String numero,String complemento,String senha,String senhaconfirmada,String logotipoG,String logotipoP)
{
    public UserResponseDTO(User user)
    {
        this(user.getId(), user.getLogin(),user.getNomeempresa(),user.getCnpj(),user.getRazaosocial(),user.getInscricaoestadual(),user.getEmail(),user.getSite(),
                user.getCep(),user.getCidade(),user.getUf(),user.getRua(),user.getBairro(),user.getNumero(),user.getComplemento(),user.getSenha(),user.getSenhaconfirmada(),user.getLogotipog(),user.getLogotipop());
    }
}
