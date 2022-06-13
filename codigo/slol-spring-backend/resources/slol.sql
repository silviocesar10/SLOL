--
-- PostgreSQL database dump
--

-- Dumped from database version 14.3
-- Dumped by pg_dump version 14.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: categoria_livro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categoria_livro (
    id_categoria integer NOT NULL,
    data_cadastro timestamp without time zone,
    desc_categoria character varying(50),
    nome_categoria character varying(50)
);


ALTER TABLE public.categoria_livro OWNER TO postgres;

--
-- Name: categoria_livro_id_categoria_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.categoria_livro ALTER COLUMN id_categoria ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.categoria_livro_id_categoria_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    id_pessoa integer NOT NULL,
    bairro character varying(50) NOT NULL,
    cidade character varying(50) NOT NULL,
    cpf character varying(50) NOT NULL,
    data_nascimento timestamp without time zone NOT NULL,
    nome character varying(50) NOT NULL,
    rua character varying(50) NOT NULL,
    telefone character varying(255) NOT NULL,
    tem_plano boolean
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- Name: cliente_id_pessoa_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.cliente ALTER COLUMN id_pessoa ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.cliente_id_pessoa_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: livro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.livro (
    id_livro integer NOT NULL,
    ano_publicacao timestamp without time zone,
    autor character varying(50),
    descricao character varying(200),
    numisbn character varying(255),
    titulo_livro character varying(50),
    id_categoria integer
);


ALTER TABLE public.livro OWNER TO postgres;

--
-- Name: livro_id_livro_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.livro ALTER COLUMN id_livro ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.livro_id_livro_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: reserva; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reserva (
    id_reserva integer NOT NULL,
    data_entrega timestamp without time zone,
    data_reserva timestamp without time zone,
    data_retirada timestamp without time zone,
    periodo_emprestimo integer,
    valor real,
    id_pessoa integer,
    id_livro integer
);


ALTER TABLE public.reserva OWNER TO postgres;

--
-- Name: reserva_id_reserva_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.reserva ALTER COLUMN id_reserva ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.reserva_id_reserva_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: categoria_livro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categoria_livro (id_categoria, data_cadastro, desc_categoria, nome_categoria) FROM stdin;
1	2022-05-18 00:00:00	Livros com historias de terror	Terror
2	2022-05-18 00:00:00	Livros com historias de fantasias	Fantasia
\.


--
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cliente (id_pessoa, bairro, cidade, cpf, data_nascimento, nome, rua, telefone, tem_plano) FROM stdin;
1	brasil1	br1	000.000.000-01	1999-07-06 00:00:00	Joao	Maria 1	(28)99999-9999	t
2	brasil1	br1	000.000.000-02	1994-03-06 00:00:00	Jose	Maria 1	(28)99999-9998	t
\.


--
-- Data for Name: livro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.livro (id_livro, ano_publicacao, autor, descricao, numisbn, titulo_livro, id_categoria) FROM stdin;
1	1999-10-14 00:00:00	J. K. Rowling	Harry Potter e a Pedra Filosofal é o primeiro dos sete livros da série de fantasia Harry Potter, escrita por J. K. Rowling.	972-23-2533-7	Harry Potter e a Pedra Filosofal	2
2	1977-01-28 00:00:00	Stephen King	The Shining é um romance de horror do escritor estadunidense Stephen King.	9788573022035	O Iluminado	1
\.


--
-- Data for Name: reserva; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reserva (id_reserva, data_entrega, data_reserva, data_retirada, periodo_emprestimo, valor, id_pessoa, id_livro) FROM stdin;
1	2022-06-24 00:00:00	2022-05-18 00:00:00	2022-05-25 00:00:00	12	0	1	1
2	2022-06-24 00:00:00	2022-05-18 00:00:00	2022-06-12 00:00:00	12	0	2	2
\.


--
-- Name: categoria_livro_id_categoria_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categoria_livro_id_categoria_seq', 2, true);


--
-- Name: cliente_id_pessoa_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_id_pessoa_seq', 2, true);


--
-- Name: livro_id_livro_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.livro_id_livro_seq', 2, true);


--
-- Name: reserva_id_reserva_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reserva_id_reserva_seq', 2, true);


--
-- Name: categoria_livro categoria_livro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria_livro
    ADD CONSTRAINT categoria_livro_pkey PRIMARY KEY (id_categoria);


--
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id_pessoa);


--
-- Name: livro livro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro
    ADD CONSTRAINT livro_pkey PRIMARY KEY (id_livro);


--
-- Name: reserva reserva_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reserva
    ADD CONSTRAINT reserva_pkey PRIMARY KEY (id_reserva);


--
-- Name: reserva fk80chrn017k4mwfl3oaeicq35t; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reserva
    ADD CONSTRAINT fk80chrn017k4mwfl3oaeicq35t FOREIGN KEY (id_livro) REFERENCES public.livro(id_livro);


--
-- PostgreSQL database dump complete
--

