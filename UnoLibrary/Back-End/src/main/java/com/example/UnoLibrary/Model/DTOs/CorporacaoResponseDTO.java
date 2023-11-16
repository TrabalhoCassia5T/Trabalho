package com.example.UnoLibrary.Model.DTOs;

import com.example.UnoLibrary.Model.entity.Corporacao;

public record CorporacaoResponseDTO(Long pam_id, String pam_login, String pam_nome_fantasia, String pam_cnpj, String pam_razao_social, String pam_insc_estadual,
                                    String pam_email, String pam_site,
                                    String pam_senha, String pam_logotipo_grande, String pam_logotipo_peq)
{
    public CorporacaoResponseDTO(Corporacao corporacao)
    {
        this(corporacao.getPam_id(), corporacao.getPam_login(), corporacao.getPam_nome_fantasia(), corporacao.getPam_cnpj(), corporacao.getPam_razao_social(),
                corporacao.getPam_insc_estadual(), corporacao.getPam_email(), corporacao.getPam_site(),
               corporacao.getPam_senha(), corporacao.getPam_logotipo_grande(), corporacao.getPam_logotipo_peq());
    }
}
