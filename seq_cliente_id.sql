-- SEQUENCE: public.clientes_id_seq

-- DROP SEQUENCE IF EXISTS public.clientes_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.clientes_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY clientes.id;

ALTER SEQUENCE public.clientes_id_seq
    OWNER TO postgres;