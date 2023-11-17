package com.example.UnoLibrary.Model.Corporacao;
import com.example.UnoLibrary.Model.entity.Corporacao;
import com.example.UnoLibrary.Model.repository.CorporacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorporacaoService
{
    @Autowired
    private CorporacaoRepository repository;

    public void save(Corporacao dados)
    {
        this.repository.save(dados);

    }
}
