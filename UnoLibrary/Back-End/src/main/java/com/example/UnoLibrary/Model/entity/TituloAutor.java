package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.*;

import java.io.Serializable;

public class TituloAutor  {
    private Long id;
    private Autor autor;
    private Titulo titulo;
}
