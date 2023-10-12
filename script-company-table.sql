-- Table: public.empresas

-- DROP TABLE IF EXISTS public.empresas;

CREATE TABLE IF NOT EXISTS public.empresas
(
    id integer NOT NULL,
    login character varying(30) COLLATE pg_catalog."default",
    nomeempresa character varying(30) COLLATE pg_catalog."default",
    cnpj character varying(30) COLLATE pg_catalog."default",
    razaosocial character varying(30) COLLATE pg_catalog."default",
    inscricaoestadual character varying(30) COLLATE pg_catalog."default",
    email character varying(30) COLLATE pg_catalog."default",
    site character varying(30) COLLATE pg_catalog."default",
    cep character varying(30) COLLATE pg_catalog."default",
    cidade character varying(30) COLLATE pg_catalog."default",
    uf character varying(30) COLLATE pg_catalog."default",
    rua character varying(30) COLLATE pg_catalog."default",
    bairro character varying(30) COLLATE pg_catalog."default",
    numero character varying(30) COLLATE pg_catalog."default",
    complemento character varying(30) COLLATE pg_catalog."default",
    senha character varying(30) COLLATE pg_catalog."default",
    senhaconfirmada character varying(30) COLLATE pg_catalog."default",
    logotipog character varying(30) COLLATE pg_catalog."default",
    logotipop character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT clientes_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.empresas
    OWNER to postgres;