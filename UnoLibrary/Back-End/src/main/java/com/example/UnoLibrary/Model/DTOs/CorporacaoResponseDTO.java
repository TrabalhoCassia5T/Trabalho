package com.example.UnoLibrary.Model.DTOs;

import com.example.UnoLibrary.Model.entity.Corporacao;

public record CorporacaoResponseDTO(Long id, String login, String nomeempresa, String cnpj, String razaosocial, String inscricaoestadual, String email, String site, String cep, String cidade, String uf, String rua,
                                    String bairro, String numero, String complemento, String senha, String senhaconfirmada, String logotipoG, String logotipoP)
{
    public CorporacaoResponseDTO(Corporacao corporacao)
    {
        this(corporacao.getId(), corporacao.getLogin(), corporacao.getNomeempresa(), corporacao.getCnpj(), corporacao.getRazaosocial(), corporacao.getInscricaoestadual(), corporacao.getEmail(), corporacao.getSite(),
                corporacao.getCep(), corporacao.getCidade(), corporacao.getUf(), corporacao.getRua(), corporacao.getBairro(), corporacao.getNumero(), corporacao.getComplemento(), corporacao.getSenha(), corporacao.getSenhaconfirmada(), corporacao.getLogotipog(), corporacao.getLogotipop());
    }
}
