-- Table: public.clientes

-- DROP TABLE IF EXISTS public.clientes;

CREATE TABLE IF NOT EXISTS public.clientes
(
    id integer NOT NULL,
    nome character varying(30) COLLATE pg_catalog."default",
    sobrenome character varying(30) COLLATE pg_catalog."default",
    telefone character varying(30) COLLATE pg_catalog."default",
    cpf character varying(30) COLLATE pg_catalog."default",
    endereco character varying(30) COLLATE pg_catalog."default",
    cidade character varying(30) COLLATE pg_catalog."default",
    "dataNasc" character varying(30) COLLATE pg_catalog."default",
    email character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT clientes_pkey1 PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.clientes
    OWNER to postgres;