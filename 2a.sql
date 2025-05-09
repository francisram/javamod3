PGDMP         !    
            }            coopedev    15.3    15.3 �               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    19516    coopedev    DATABASE     {   CREATE DATABASE coopedev WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE coopedev;
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                pg_database_owner    false                       0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   pg_database_owner    false    4            �            1259    19518    barrios    TABLE     _  CREATE TABLE public.barrios (
    id integer NOT NULL,
    nombre character varying(100) NOT NULL,
    id_ciudad integer NOT NULL,
    id_usuario_creacion integer NOT NULL,
    fecha_hora_creacion timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    id_usuario_ult_modif integer,
    fecha_hora_ult_modif timestamp without time zone
);
    DROP TABLE public.barrios;
       public         heap    postgres    false    4            �            1259    19522    barrios_id_seq    SEQUENCE     �   CREATE SEQUENCE public.barrios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.barrios_id_seq;
       public          postgres    false    215    4                       0    0    barrios_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.barrios_id_seq OWNED BY public.barrios.id;
          public          postgres    false    216            �            1259    19523    caja_ahorro    TABLE     P  CREATE TABLE public.caja_ahorro (
    id integer NOT NULL,
    id_socio integer NOT NULL,
    saldo numeric(15,2) DEFAULT 0 NOT NULL,
    usuario_alta integer NOT NULL,
    fecha_alta timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    usuario_modificacion integer,
    fecha_modificacion timestamp without time zone
);
    DROP TABLE public.caja_ahorro;
       public         heap    postgres    false    4            �            1259    19528    caja_ahorro_id_seq    SEQUENCE     �   CREATE SEQUENCE public.caja_ahorro_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.caja_ahorro_id_seq;
       public          postgres    false    4    217                       0    0    caja_ahorro_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.caja_ahorro_id_seq OWNED BY public.caja_ahorro.id;
          public          postgres    false    218            �            1259    19529    ciudades    TABLE     f  CREATE TABLE public.ciudades (
    id integer NOT NULL,
    nombre character varying(100) NOT NULL,
    id_departamento integer NOT NULL,
    id_usuario_creacion integer NOT NULL,
    fecha_hora_creacion timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    id_usuario_ult_modif integer,
    fecha_hora_ult_modif timestamp without time zone
);
    DROP TABLE public.ciudades;
       public         heap    postgres    false    4            �            1259    19533    ciudades_id_seq    SEQUENCE     �   CREATE SEQUENCE public.ciudades_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.ciudades_id_seq;
       public          postgres    false    4    219                       0    0    ciudades_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.ciudades_id_seq OWNED BY public.ciudades.id;
          public          postgres    false    220            �            1259    19534    cuotas    TABLE     �  CREATE TABLE public.cuotas (
    id integer NOT NULL,
    id_prestamo integer NOT NULL,
    numero_cuota integer NOT NULL,
    fecha_vencimiento date NOT NULL,
    monto_capital numeric(15,2) NOT NULL,
    monto_interes numeric(15,2) NOT NULL,
    mora numeric(15,2) DEFAULT 0,
    estado character varying(20) NOT NULL,
    usuario_alta integer NOT NULL,
    fecha_alta timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    usuario_modificacion integer,
    fecha_modificacion timestamp without time zone,
    CONSTRAINT cuotas_estado_check CHECK (((estado)::text = ANY (ARRAY[('pendiente'::character varying)::text, ('pagada'::character varying)::text])))
);
    DROP TABLE public.cuotas;
       public         heap    postgres    false    4            �            1259    19540    cuotas_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cuotas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.cuotas_id_seq;
       public          postgres    false    4    221                       0    0    cuotas_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.cuotas_id_seq OWNED BY public.cuotas.id;
          public          postgres    false    222            �            1259    19541    departamentos    TABLE     E  CREATE TABLE public.departamentos (
    id integer NOT NULL,
    nombre character varying(100) NOT NULL,
    id_usuario_creacion integer NOT NULL,
    fecha_hora_creacion timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    id_usuario_ult_modif integer,
    fecha_hora_ult_modif timestamp without time zone
);
 !   DROP TABLE public.departamentos;
       public         heap    postgres    false    4            �            1259    19545    departamentos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.departamentos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.departamentos_id_seq;
       public          postgres    false    223    4                       0    0    departamentos_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.departamentos_id_seq OWNED BY public.departamentos.id;
          public          postgres    false    224            �            1259    19546    dominios    TABLE     �   CREATE TABLE public.dominios (
    id integer NOT NULL,
    codigo character varying(20) NOT NULL,
    descripcion character varying(255) NOT NULL,
    id_dominio_padre integer,
    estado character varying(1) DEFAULT 'A'::bpchar NOT NULL
);
    DROP TABLE public.dominios;
       public         heap    francis    false    4            �            1259    19550    dominios_id_seq    SEQUENCE     �   CREATE SEQUENCE public.dominios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.dominios_id_seq;
       public          francis    false    225    4                       0    0    dominios_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.dominios_id_seq OWNED BY public.dominios.id;
          public          francis    false    226            �            1259    19551    estado_civil    TABLE     6  CREATE TABLE public.estado_civil (
    id integer NOT NULL,
    descripcion character varying(50) NOT NULL,
    usuario_alta integer NOT NULL,
    fecha_alta timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    usuario_modificacion integer,
    fecha_modificacion timestamp without time zone
);
     DROP TABLE public.estado_civil;
       public         heap    postgres    false    4            �            1259    19555    estado_civil_id_seq    SEQUENCE     �   CREATE SEQUENCE public.estado_civil_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.estado_civil_id_seq;
       public          postgres    false    4    227                       0    0    estado_civil_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.estado_civil_id_seq OWNED BY public.estado_civil.id;
          public          postgres    false    228            �            1259    19556    extractos_caja    TABLE     |  CREATE TABLE public.extractos_caja (
    id integer NOT NULL,
    id_caja integer NOT NULL,
    fecha_movimiento date DEFAULT CURRENT_DATE NOT NULL,
    tipo_movimiento character varying(20) NOT NULL,
    monto numeric(15,2) NOT NULL,
    descripcion text,
    usuario_alta integer NOT NULL,
    fecha_alta timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    usuario_modificacion integer,
    fecha_modificacion timestamp without time zone,
    CONSTRAINT extractos_caja_tipo_movimiento_check CHECK (((tipo_movimiento)::text = ANY (ARRAY[('deposito'::character varying)::text, ('retiro'::character varying)::text])))
);
 "   DROP TABLE public.extractos_caja;
       public         heap    postgres    false    4            �            1259    19564    extractos_caja_id_seq    SEQUENCE     �   CREATE SEQUENCE public.extractos_caja_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.extractos_caja_id_seq;
       public          postgres    false    4    229                       0    0    extractos_caja_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.extractos_caja_id_seq OWNED BY public.extractos_caja.id;
          public          postgres    false    230            �            1259    19565    opciones    TABLE     5  CREATE TABLE public.opciones (
    id integer NOT NULL,
    id_dominio integer NOT NULL,
    codigo character varying(20) NOT NULL,
    descripcion character varying(255),
    estado character varying(1) DEFAULT 'A'::bpchar NOT NULL,
    id_opcion_padre integer,
    fecha_hora_creacion timestamp(6) without time zone DEFAULT now(),
    id_usuario_creacion bigint,
    fecha_hora_ult_modif timestamp(6) without time zone,
    id_usuario_ult_modif bigint,
    icono character varying(1024),
    por_defecto boolean DEFAULT false,
    orden_preferido numeric(4,0)
);
    DROP TABLE public.opciones;
       public         heap    francis    false    4            �            1259    19573    opciones_id_seq    SEQUENCE     �   CREATE SEQUENCE public.opciones_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.opciones_id_seq;
       public          francis    false    4    231                       0    0    opciones_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.opciones_id_seq OWNED BY public.opciones.id;
          public          francis    false    232            �            1259    19574    pagos    TABLE     z  CREATE TABLE public.pagos (
    id integer NOT NULL,
    id_cuota integer NOT NULL,
    fecha_pago date DEFAULT CURRENT_DATE NOT NULL,
    monto_pagado numeric(15,2) NOT NULL,
    usuario_alta integer NOT NULL,
    fecha_alta timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    usuario_modificacion integer,
    fecha_modificacion timestamp without time zone
);
    DROP TABLE public.pagos;
       public         heap    postgres    false    4            �            1259    19579    pagos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pagos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.pagos_id_seq;
       public          postgres    false    4    233                       0    0    pagos_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.pagos_id_seq OWNED BY public.pagos.id;
          public          postgres    false    234            �            1259    19580 	   prestamos    TABLE     �  CREATE TABLE public.prestamos (
    id integer NOT NULL,
    id_socio integer NOT NULL,
    monto numeric(15,2) NOT NULL,
    tasa_interes numeric(5,2) NOT NULL,
    plazo_meses integer NOT NULL,
    fecha_otorgamiento date DEFAULT CURRENT_DATE NOT NULL,
    estado character varying(20) NOT NULL,
    usuario_alta integer NOT NULL,
    fecha_alta timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    usuario_modificacion integer,
    fecha_modificacion timestamp without time zone,
    CONSTRAINT prestamos_estado_check CHECK (((estado)::text = ANY (ARRAY[('activo'::character varying)::text, ('cancelado'::character varying)::text, ('moroso'::character varying)::text])))
);
    DROP TABLE public.prestamos;
       public         heap    postgres    false    4            �            1259    19586    prestamos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.prestamos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.prestamos_id_seq;
       public          postgres    false    4    235                       0    0    prestamos_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.prestamos_id_seq OWNED BY public.prestamos.id;
          public          postgres    false    236            �            1259    19587    sexo    TABLE     .  CREATE TABLE public.sexo (
    id integer NOT NULL,
    descripcion character varying(50) NOT NULL,
    usuario_alta integer NOT NULL,
    fecha_alta timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    usuario_modificacion integer,
    fecha_modificacion timestamp without time zone
);
    DROP TABLE public.sexo;
       public         heap    postgres    false    4            �            1259    19591    sexo_id_seq    SEQUENCE     �   CREATE SEQUENCE public.sexo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.sexo_id_seq;
       public          postgres    false    237    4                       0    0    sexo_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.sexo_id_seq OWNED BY public.sexo.id;
          public          postgres    false    238            �            1259    19592    socios    TABLE     �  CREATE TABLE public.socios (
    id integer NOT NULL,
    nombre character varying(100) NOT NULL,
    apellido character varying(100) NOT NULL,
    tipo_documento integer NOT NULL,
    numero_documento character varying(50) NOT NULL,
    direccion text,
    telefono character varying(20),
    email character varying(100),
    id_barrio integer,
    sexo integer,
    estado_civil integer,
    fecha_ingreso date DEFAULT CURRENT_DATE NOT NULL,
    usuario_alta integer NOT NULL,
    fecha_alta timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    usuario_modificacion integer,
    fecha_modificacion timestamp without time zone
);
    DROP TABLE public.socios;
       public         heap    postgres    false    4            �            1259    19599    socios_id_seq    SEQUENCE     �   CREATE SEQUENCE public.socios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.socios_id_seq;
       public          postgres    false    239    4                       0    0    socios_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.socios_id_seq OWNED BY public.socios.id;
          public          postgres    false    240            �            1259    19600    tipo_documento    TABLE     8  CREATE TABLE public.tipo_documento (
    id integer NOT NULL,
    descripcion character varying(50) NOT NULL,
    usuario_alta integer NOT NULL,
    fecha_alta timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    usuario_modificacion integer,
    fecha_modificacion timestamp without time zone
);
 "   DROP TABLE public.tipo_documento;
       public         heap    postgres    false    4            �            1259    19604    tipo_documento_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tipo_documento_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.tipo_documento_id_seq;
       public          postgres    false    241    4                       0    0    tipo_documento_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.tipo_documento_id_seq OWNED BY public.tipo_documento.id;
          public          postgres    false    242            �            1259    19605    token    TABLE     +  CREATE TABLE public.token (
    id integer NOT NULL,
    expirado boolean NOT NULL,
    revocado boolean NOT NULL,
    tipo_token character varying(255),
    token character varying(255),
    id_usuario integer,
    CONSTRAINT token_tipo_token_check CHECK (((tipo_token)::text = 'BEARER'::text))
);
    DROP TABLE public.token;
       public         heap    postgres    false    4            �            1259    19611 	   token_seq    SEQUENCE     s   CREATE SEQUENCE public.token_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.token_seq;
       public          postgres    false    4            �           2604    19678 
   barrios id    DEFAULT     h   ALTER TABLE ONLY public.barrios ALTER COLUMN id SET DEFAULT nextval('public.barrios_id_seq'::regclass);
 9   ALTER TABLE public.barrios ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215            �           2604    19679    caja_ahorro id    DEFAULT     p   ALTER TABLE ONLY public.caja_ahorro ALTER COLUMN id SET DEFAULT nextval('public.caja_ahorro_id_seq'::regclass);
 =   ALTER TABLE public.caja_ahorro ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    217            �           2604    19680    ciudades id    DEFAULT     j   ALTER TABLE ONLY public.ciudades ALTER COLUMN id SET DEFAULT nextval('public.ciudades_id_seq'::regclass);
 :   ALTER TABLE public.ciudades ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    220    219            �           2604    19681 	   cuotas id    DEFAULT     f   ALTER TABLE ONLY public.cuotas ALTER COLUMN id SET DEFAULT nextval('public.cuotas_id_seq'::regclass);
 8   ALTER TABLE public.cuotas ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    221            �           2604    19682    departamentos id    DEFAULT     t   ALTER TABLE ONLY public.departamentos ALTER COLUMN id SET DEFAULT nextval('public.departamentos_id_seq'::regclass);
 ?   ALTER TABLE public.departamentos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    224    223            �           2604    19683    dominios id    DEFAULT     j   ALTER TABLE ONLY public.dominios ALTER COLUMN id SET DEFAULT nextval('public.dominios_id_seq'::regclass);
 :   ALTER TABLE public.dominios ALTER COLUMN id DROP DEFAULT;
       public          francis    false    226    225            �           2604    19684    estado_civil id    DEFAULT     r   ALTER TABLE ONLY public.estado_civil ALTER COLUMN id SET DEFAULT nextval('public.estado_civil_id_seq'::regclass);
 >   ALTER TABLE public.estado_civil ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    228    227            �           2604    19685    extractos_caja id    DEFAULT     v   ALTER TABLE ONLY public.extractos_caja ALTER COLUMN id SET DEFAULT nextval('public.extractos_caja_id_seq'::regclass);
 @   ALTER TABLE public.extractos_caja ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    230    229            �           2604    19686    opciones id    DEFAULT     j   ALTER TABLE ONLY public.opciones ALTER COLUMN id SET DEFAULT nextval('public.opciones_id_seq'::regclass);
 :   ALTER TABLE public.opciones ALTER COLUMN id DROP DEFAULT;
       public          francis    false    232    231            �           2604    19687    pagos id    DEFAULT     d   ALTER TABLE ONLY public.pagos ALTER COLUMN id SET DEFAULT nextval('public.pagos_id_seq'::regclass);
 7   ALTER TABLE public.pagos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    234    233            �           2604    19688    prestamos id    DEFAULT     l   ALTER TABLE ONLY public.prestamos ALTER COLUMN id SET DEFAULT nextval('public.prestamos_id_seq'::regclass);
 ;   ALTER TABLE public.prestamos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    236    235            �           2604    19689    sexo id    DEFAULT     b   ALTER TABLE ONLY public.sexo ALTER COLUMN id SET DEFAULT nextval('public.sexo_id_seq'::regclass);
 6   ALTER TABLE public.sexo ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    238    237            �           2604    19690 	   socios id    DEFAULT     f   ALTER TABLE ONLY public.socios ALTER COLUMN id SET DEFAULT nextval('public.socios_id_seq'::regclass);
 8   ALTER TABLE public.socios ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    240    239            �           2604    19691    tipo_documento id    DEFAULT     v   ALTER TABLE ONLY public.tipo_documento ALTER COLUMN id SET DEFAULT nextval('public.tipo_documento_id_seq'::regclass);
 @   ALTER TABLE public.tipo_documento ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    242    241            �          0    19518    barrios 
   TABLE DATA           �   COPY public.barrios (id, nombre, id_ciudad, id_usuario_creacion, fecha_hora_creacion, id_usuario_ult_modif, fecha_hora_ult_modif) FROM stdin;
    public          postgres    false    215   t�       �          0    19523    caja_ahorro 
   TABLE DATA           ~   COPY public.caja_ahorro (id, id_socio, saldo, usuario_alta, fecha_alta, usuario_modificacion, fecha_modificacion) FROM stdin;
    public          postgres    false    217   ��       �          0    19529    ciudades 
   TABLE DATA           �   COPY public.ciudades (id, nombre, id_departamento, id_usuario_creacion, fecha_hora_creacion, id_usuario_ult_modif, fecha_hora_ult_modif) FROM stdin;
    public          postgres    false    219   ��       �          0    19534    cuotas 
   TABLE DATA           �   COPY public.cuotas (id, id_prestamo, numero_cuota, fecha_vencimiento, monto_capital, monto_interes, mora, estado, usuario_alta, fecha_alta, usuario_modificacion, fecha_modificacion) FROM stdin;
    public          postgres    false    221   @�       �          0    19541    departamentos 
   TABLE DATA           �   COPY public.departamentos (id, nombre, id_usuario_creacion, fecha_hora_creacion, id_usuario_ult_modif, fecha_hora_ult_modif) FROM stdin;
    public          postgres    false    223   ]�       �          0    19546    dominios 
   TABLE DATA           U   COPY public.dominios (id, codigo, descripcion, id_dominio_padre, estado) FROM stdin;
    public          francis    false    225   ��       �          0    19551    estado_civil 
   TABLE DATA           {   COPY public.estado_civil (id, descripcion, usuario_alta, fecha_alta, usuario_modificacion, fecha_modificacion) FROM stdin;
    public          postgres    false    227   q�       �          0    19556    extractos_caja 
   TABLE DATA           �   COPY public.extractos_caja (id, id_caja, fecha_movimiento, tipo_movimiento, monto, descripcion, usuario_alta, fecha_alta, usuario_modificacion, fecha_modificacion) FROM stdin;
    public          postgres    false    229   ��       �          0    19565    opciones 
   TABLE DATA           �   COPY public.opciones (id, id_dominio, codigo, descripcion, estado, id_opcion_padre, fecha_hora_creacion, id_usuario_creacion, fecha_hora_ult_modif, id_usuario_ult_modif, icono, por_defecto, orden_preferido) FROM stdin;
    public          francis    false    231   ��       �          0    19574    pagos 
   TABLE DATA           �   COPY public.pagos (id, id_cuota, fecha_pago, monto_pagado, usuario_alta, fecha_alta, usuario_modificacion, fecha_modificacion) FROM stdin;
    public          postgres    false    233   dX                 0    19580 	   prestamos 
   TABLE DATA           �   COPY public.prestamos (id, id_socio, monto, tasa_interes, plazo_meses, fecha_otorgamiento, estado, usuario_alta, fecha_alta, usuario_modificacion, fecha_modificacion) FROM stdin;
    public          postgres    false    235   �X                0    19587    sexo 
   TABLE DATA           s   COPY public.sexo (id, descripcion, usuario_alta, fecha_alta, usuario_modificacion, fecha_modificacion) FROM stdin;
    public          postgres    false    237   �X                0    19592    socios 
   TABLE DATA           �   COPY public.socios (id, nombre, apellido, tipo_documento, numero_documento, direccion, telefono, email, id_barrio, sexo, estado_civil, fecha_ingreso, usuario_alta, fecha_alta, usuario_modificacion, fecha_modificacion) FROM stdin;
    public          postgres    false    239   �X                0    19600    tipo_documento 
   TABLE DATA           }   COPY public.tipo_documento (id, descripcion, usuario_alta, fecha_alta, usuario_modificacion, fecha_modificacion) FROM stdin;
    public          postgres    false    241   �X                0    19605    token 
   TABLE DATA           V   COPY public.token (id, expirado, revocado, tipo_token, token, id_usuario) FROM stdin;
    public          postgres    false    243   �X                 0    0    barrios_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.barrios_id_seq', 3, true);
          public          postgres    false    216                        0    0    caja_ahorro_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.caja_ahorro_id_seq', 1, false);
          public          postgres    false    218            !           0    0    ciudades_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.ciudades_id_seq', 14, true);
          public          postgres    false    220            "           0    0    cuotas_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.cuotas_id_seq', 1, false);
          public          postgres    false    222            #           0    0    departamentos_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.departamentos_id_seq', 31, true);
          public          postgres    false    224            $           0    0    dominios_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.dominios_id_seq', 1, false);
          public          francis    false    226            %           0    0    estado_civil_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.estado_civil_id_seq', 1, false);
          public          postgres    false    228            &           0    0    extractos_caja_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.extractos_caja_id_seq', 1, false);
          public          postgres    false    230            '           0    0    opciones_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.opciones_id_seq', 1, false);
          public          francis    false    232            (           0    0    pagos_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.pagos_id_seq', 1, false);
          public          postgres    false    234            )           0    0    prestamos_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.prestamos_id_seq', 1, false);
          public          postgres    false    236            *           0    0    sexo_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.sexo_id_seq', 1, false);
          public          postgres    false    238            +           0    0    socios_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.socios_id_seq', 1, false);
          public          postgres    false    240            ,           0    0    tipo_documento_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.tipo_documento_id_seq', 1, false);
          public          postgres    false    242            -           0    0 	   token_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.token_seq', 1651, true);
          public          postgres    false    244                       2606    19736 $   barrios barrios_nombre_id_ciudad_key 
   CONSTRAINT     l   ALTER TABLE ONLY public.barrios
    ADD CONSTRAINT barrios_nombre_id_ciudad_key UNIQUE (nombre, id_ciudad);
 N   ALTER TABLE ONLY public.barrios DROP CONSTRAINT barrios_nombre_id_ciudad_key;
       public            postgres    false    215    215                       2606    19738    barrios barrios_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.barrios
    ADD CONSTRAINT barrios_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.barrios DROP CONSTRAINT barrios_pkey;
       public            postgres    false    215                       2606    19740    caja_ahorro caja_ahorro_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.caja_ahorro
    ADD CONSTRAINT caja_ahorro_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.caja_ahorro DROP CONSTRAINT caja_ahorro_pkey;
       public            postgres    false    217            	           2606    19742 ,   ciudades ciudades_nombre_id_departamento_key 
   CONSTRAINT     z   ALTER TABLE ONLY public.ciudades
    ADD CONSTRAINT ciudades_nombre_id_departamento_key UNIQUE (nombre, id_departamento);
 V   ALTER TABLE ONLY public.ciudades DROP CONSTRAINT ciudades_nombre_id_departamento_key;
       public            postgres    false    219    219                       2606    19744    ciudades ciudades_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.ciudades
    ADD CONSTRAINT ciudades_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.ciudades DROP CONSTRAINT ciudades_pkey;
       public            postgres    false    219                       2606    19746    cuotas cuotas_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.cuotas
    ADD CONSTRAINT cuotas_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.cuotas DROP CONSTRAINT cuotas_pkey;
       public            postgres    false    221                       2606    19748 &   departamentos departamentos_nombre_key 
   CONSTRAINT     c   ALTER TABLE ONLY public.departamentos
    ADD CONSTRAINT departamentos_nombre_key UNIQUE (nombre);
 P   ALTER TABLE ONLY public.departamentos DROP CONSTRAINT departamentos_nombre_key;
       public            postgres    false    223                       2606    19750     departamentos departamentos_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.departamentos
    ADD CONSTRAINT departamentos_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.departamentos DROP CONSTRAINT departamentos_pkey;
       public            postgres    false    223                       2606    19752 )   estado_civil estado_civil_descripcion_key 
   CONSTRAINT     k   ALTER TABLE ONLY public.estado_civil
    ADD CONSTRAINT estado_civil_descripcion_key UNIQUE (descripcion);
 S   ALTER TABLE ONLY public.estado_civil DROP CONSTRAINT estado_civil_descripcion_key;
       public            postgres    false    227                       2606    19754    estado_civil estado_civil_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.estado_civil
    ADD CONSTRAINT estado_civil_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.estado_civil DROP CONSTRAINT estado_civil_pkey;
       public            postgres    false    227                       2606    19756 "   extractos_caja extractos_caja_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.extractos_caja
    ADD CONSTRAINT extractos_caja_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.extractos_caja DROP CONSTRAINT extractos_caja_pkey;
       public            postgres    false    229            !           2606    19758    pagos pagos_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.pagos
    ADD CONSTRAINT pagos_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.pagos DROP CONSTRAINT pagos_pkey;
       public            postgres    false    233                       2606    19760    dominios pk_dominios 
   CONSTRAINT     R   ALTER TABLE ONLY public.dominios
    ADD CONSTRAINT pk_dominios PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.dominios DROP CONSTRAINT pk_dominios;
       public            francis    false    225                       2606    19762    opciones pk_opciones 
   CONSTRAINT     R   ALTER TABLE ONLY public.opciones
    ADD CONSTRAINT pk_opciones PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.opciones DROP CONSTRAINT pk_opciones;
       public            francis    false    231            #           2606    19764    prestamos prestamos_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.prestamos
    ADD CONSTRAINT prestamos_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.prestamos DROP CONSTRAINT prestamos_pkey;
       public            postgres    false    235            %           2606    19766    sexo sexo_descripcion_key 
   CONSTRAINT     [   ALTER TABLE ONLY public.sexo
    ADD CONSTRAINT sexo_descripcion_key UNIQUE (descripcion);
 C   ALTER TABLE ONLY public.sexo DROP CONSTRAINT sexo_descripcion_key;
       public            postgres    false    237            '           2606    19768    sexo sexo_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.sexo
    ADD CONSTRAINT sexo_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.sexo DROP CONSTRAINT sexo_pkey;
       public            postgres    false    237            *           2606    19770    socios socios_email_key 
   CONSTRAINT     S   ALTER TABLE ONLY public.socios
    ADD CONSTRAINT socios_email_key UNIQUE (email);
 A   ALTER TABLE ONLY public.socios DROP CONSTRAINT socios_email_key;
       public            postgres    false    239            ,           2606    19772 "   socios socios_numero_documento_key 
   CONSTRAINT     i   ALTER TABLE ONLY public.socios
    ADD CONSTRAINT socios_numero_documento_key UNIQUE (numero_documento);
 L   ALTER TABLE ONLY public.socios DROP CONSTRAINT socios_numero_documento_key;
       public            postgres    false    239            .           2606    19774    socios socios_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.socios
    ADD CONSTRAINT socios_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.socios DROP CONSTRAINT socios_pkey;
       public            postgres    false    239            0           2606    19776 -   tipo_documento tipo_documento_descripcion_key 
   CONSTRAINT     o   ALTER TABLE ONLY public.tipo_documento
    ADD CONSTRAINT tipo_documento_descripcion_key UNIQUE (descripcion);
 W   ALTER TABLE ONLY public.tipo_documento DROP CONSTRAINT tipo_documento_descripcion_key;
       public            postgres    false    241            2           2606    19778 "   tipo_documento tipo_documento_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.tipo_documento
    ADD CONSTRAINT tipo_documento_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.tipo_documento DROP CONSTRAINT tipo_documento_pkey;
       public            postgres    false    241            4           2606    19780    token token_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.token
    ADD CONSTRAINT token_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.token DROP CONSTRAINT token_pkey;
       public            postgres    false    243                       2606    19782    dominios uk_dominios_codigo 
   CONSTRAINT     X   ALTER TABLE ONLY public.dominios
    ADD CONSTRAINT uk_dominios_codigo UNIQUE (codigo);
 E   ALTER TABLE ONLY public.dominios DROP CONSTRAINT uk_dominios_codigo;
       public            francis    false    225            6           2606    19784 "   token uk_pddrhgwxnms2aceeku9s2ewy5 
   CONSTRAINT     ^   ALTER TABLE ONLY public.token
    ADD CONSTRAINT uk_pddrhgwxnms2aceeku9s2ewy5 UNIQUE (token);
 L   ALTER TABLE ONLY public.token DROP CONSTRAINT uk_pddrhgwxnms2aceeku9s2ewy5;
       public            postgres    false    243                       2606    19786    opciones uq_dominio_codigo 
   CONSTRAINT     c   ALTER TABLE ONLY public.opciones
    ADD CONSTRAINT uq_dominio_codigo UNIQUE (id_dominio, codigo);
 D   ALTER TABLE ONLY public.opciones DROP CONSTRAINT uq_dominio_codigo;
       public            francis    false    231    231            (           1259    19813    idx_socio_documento    INDEX     i   CREATE UNIQUE INDEX idx_socio_documento ON public.socios USING btree (tipo_documento, numero_documento);
 '   DROP INDEX public.idx_socio_documento;
       public            postgres    false    239    239            7           2606    19814    barrios barrios_id_ciudad_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.barrios
    ADD CONSTRAINT barrios_id_ciudad_fkey FOREIGN KEY (id_ciudad) REFERENCES public.ciudades(id) ON DELETE CASCADE;
 H   ALTER TABLE ONLY public.barrios DROP CONSTRAINT barrios_id_ciudad_fkey;
       public          postgres    false    215    219    3339            8           2606    19819 !   barrios barrios_usuario_alta_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.barrios
    ADD CONSTRAINT barrios_usuario_alta_fkey FOREIGN KEY (id_usuario_creacion) REFERENCES usuarios.usu_usuarios(id);
 K   ALTER TABLE ONLY public.barrios DROP CONSTRAINT barrios_usuario_alta_fkey;
       public          postgres    false    215            9           2606    19824 )   barrios barrios_usuario_modificacion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.barrios
    ADD CONSTRAINT barrios_usuario_modificacion_fkey FOREIGN KEY (id_usuario_ult_modif) REFERENCES usuarios.usu_usuarios(id);
 S   ALTER TABLE ONLY public.barrios DROP CONSTRAINT barrios_usuario_modificacion_fkey;
       public          postgres    false    215            :           2606    19829 %   caja_ahorro caja_ahorro_id_socio_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.caja_ahorro
    ADD CONSTRAINT caja_ahorro_id_socio_fkey FOREIGN KEY (id_socio) REFERENCES public.socios(id) ON DELETE CASCADE;
 O   ALTER TABLE ONLY public.caja_ahorro DROP CONSTRAINT caja_ahorro_id_socio_fkey;
       public          postgres    false    217    3374    239            ;           2606    19834 )   caja_ahorro caja_ahorro_usuario_alta_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.caja_ahorro
    ADD CONSTRAINT caja_ahorro_usuario_alta_fkey FOREIGN KEY (usuario_alta) REFERENCES usuarios.usu_usuarios(id);
 S   ALTER TABLE ONLY public.caja_ahorro DROP CONSTRAINT caja_ahorro_usuario_alta_fkey;
       public          postgres    false    217            <           2606    19839 1   caja_ahorro caja_ahorro_usuario_modificacion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.caja_ahorro
    ADD CONSTRAINT caja_ahorro_usuario_modificacion_fkey FOREIGN KEY (usuario_modificacion) REFERENCES usuarios.usu_usuarios(id);
 [   ALTER TABLE ONLY public.caja_ahorro DROP CONSTRAINT caja_ahorro_usuario_modificacion_fkey;
       public          postgres    false    217            =           2606    19844 &   ciudades ciudades_id_departamento_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ciudades
    ADD CONSTRAINT ciudades_id_departamento_fkey FOREIGN KEY (id_departamento) REFERENCES public.departamentos(id) ON DELETE CASCADE;
 P   ALTER TABLE ONLY public.ciudades DROP CONSTRAINT ciudades_id_departamento_fkey;
       public          postgres    false    3345    219    223            >           2606    19849 #   ciudades ciudades_usuario_alta_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ciudades
    ADD CONSTRAINT ciudades_usuario_alta_fkey FOREIGN KEY (id_usuario_creacion) REFERENCES usuarios.usu_usuarios(id);
 M   ALTER TABLE ONLY public.ciudades DROP CONSTRAINT ciudades_usuario_alta_fkey;
       public          postgres    false    219            ?           2606    19854 +   ciudades ciudades_usuario_modificacion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ciudades
    ADD CONSTRAINT ciudades_usuario_modificacion_fkey FOREIGN KEY (id_usuario_ult_modif) REFERENCES usuarios.usu_usuarios(id);
 U   ALTER TABLE ONLY public.ciudades DROP CONSTRAINT ciudades_usuario_modificacion_fkey;
       public          postgres    false    219            @           2606    19859    cuotas cuotas_id_prestamo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.cuotas
    ADD CONSTRAINT cuotas_id_prestamo_fkey FOREIGN KEY (id_prestamo) REFERENCES public.prestamos(id) ON DELETE CASCADE;
 H   ALTER TABLE ONLY public.cuotas DROP CONSTRAINT cuotas_id_prestamo_fkey;
       public          postgres    false    221    235    3363            A           2606    19864    cuotas cuotas_usuario_alta_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.cuotas
    ADD CONSTRAINT cuotas_usuario_alta_fkey FOREIGN KEY (usuario_alta) REFERENCES usuarios.usu_usuarios(id);
 I   ALTER TABLE ONLY public.cuotas DROP CONSTRAINT cuotas_usuario_alta_fkey;
       public          postgres    false    221            B           2606    19869 '   cuotas cuotas_usuario_modificacion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.cuotas
    ADD CONSTRAINT cuotas_usuario_modificacion_fkey FOREIGN KEY (usuario_modificacion) REFERENCES usuarios.usu_usuarios(id);
 Q   ALTER TABLE ONLY public.cuotas DROP CONSTRAINT cuotas_usuario_modificacion_fkey;
       public          postgres    false    221            C           2606    19874 -   departamentos departamentos_usuario_alta_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.departamentos
    ADD CONSTRAINT departamentos_usuario_alta_fkey FOREIGN KEY (id_usuario_creacion) REFERENCES usuarios.usu_usuarios(id);
 W   ALTER TABLE ONLY public.departamentos DROP CONSTRAINT departamentos_usuario_alta_fkey;
       public          postgres    false    223            D           2606    19879 5   departamentos departamentos_usuario_modificacion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.departamentos
    ADD CONSTRAINT departamentos_usuario_modificacion_fkey FOREIGN KEY (id_usuario_ult_modif) REFERENCES usuarios.usu_usuarios(id);
 _   ALTER TABLE ONLY public.departamentos DROP CONSTRAINT departamentos_usuario_modificacion_fkey;
       public          postgres    false    223            F           2606    19884 +   estado_civil estado_civil_usuario_alta_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.estado_civil
    ADD CONSTRAINT estado_civil_usuario_alta_fkey FOREIGN KEY (usuario_alta) REFERENCES usuarios.usu_usuarios(id);
 U   ALTER TABLE ONLY public.estado_civil DROP CONSTRAINT estado_civil_usuario_alta_fkey;
       public          postgres    false    227            G           2606    19889 3   estado_civil estado_civil_usuario_modificacion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.estado_civil
    ADD CONSTRAINT estado_civil_usuario_modificacion_fkey FOREIGN KEY (usuario_modificacion) REFERENCES usuarios.usu_usuarios(id);
 ]   ALTER TABLE ONLY public.estado_civil DROP CONSTRAINT estado_civil_usuario_modificacion_fkey;
       public          postgres    false    227            H           2606    19894 *   extractos_caja extractos_caja_id_caja_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.extractos_caja
    ADD CONSTRAINT extractos_caja_id_caja_fkey FOREIGN KEY (id_caja) REFERENCES public.caja_ahorro(id) ON DELETE CASCADE;
 T   ALTER TABLE ONLY public.extractos_caja DROP CONSTRAINT extractos_caja_id_caja_fkey;
       public          postgres    false    217    3335    229            I           2606    19899 /   extractos_caja extractos_caja_usuario_alta_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.extractos_caja
    ADD CONSTRAINT extractos_caja_usuario_alta_fkey FOREIGN KEY (usuario_alta) REFERENCES usuarios.usu_usuarios(id);
 Y   ALTER TABLE ONLY public.extractos_caja DROP CONSTRAINT extractos_caja_usuario_alta_fkey;
       public          postgres    false    229            J           2606    19904 7   extractos_caja extractos_caja_usuario_modificacion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.extractos_caja
    ADD CONSTRAINT extractos_caja_usuario_modificacion_fkey FOREIGN KEY (usuario_modificacion) REFERENCES usuarios.usu_usuarios(id);
 a   ALTER TABLE ONLY public.extractos_caja DROP CONSTRAINT extractos_caja_usuario_modificacion_fkey;
       public          postgres    false    229            E           2606    19909 "   dominios fk_dominios_dominio_padre    FK CONSTRAINT     �   ALTER TABLE ONLY public.dominios
    ADD CONSTRAINT fk_dominios_dominio_padre FOREIGN KEY (id_dominio_padre) REFERENCES public.dominios(id);
 L   ALTER TABLE ONLY public.dominios DROP CONSTRAINT fk_dominios_dominio_padre;
       public          francis    false    225    225    3347            K           2606    19914    opciones fk_opciones_dominio    FK CONSTRAINT     �   ALTER TABLE ONLY public.opciones
    ADD CONSTRAINT fk_opciones_dominio FOREIGN KEY (id_dominio) REFERENCES public.dominios(id);
 F   ALTER TABLE ONLY public.opciones DROP CONSTRAINT fk_opciones_dominio;
       public          francis    false    225    231    3347            L           2606    19919 !   opciones fk_opciones_opcion_padre    FK CONSTRAINT     �   ALTER TABLE ONLY public.opciones
    ADD CONSTRAINT fk_opciones_opcion_padre FOREIGN KEY (id_opcion_padre) REFERENCES public.opciones(id);
 K   ALTER TABLE ONLY public.opciones DROP CONSTRAINT fk_opciones_opcion_padre;
       public          francis    false    231    231    3357            M           2606    19924    pagos pagos_id_cuota_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.pagos
    ADD CONSTRAINT pagos_id_cuota_fkey FOREIGN KEY (id_cuota) REFERENCES public.cuotas(id) ON DELETE CASCADE;
 C   ALTER TABLE ONLY public.pagos DROP CONSTRAINT pagos_id_cuota_fkey;
       public          postgres    false    221    3341    233            N           2606    19929    pagos pagos_usuario_alta_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.pagos
    ADD CONSTRAINT pagos_usuario_alta_fkey FOREIGN KEY (usuario_alta) REFERENCES usuarios.usu_usuarios(id);
 G   ALTER TABLE ONLY public.pagos DROP CONSTRAINT pagos_usuario_alta_fkey;
       public          postgres    false    233            O           2606    19934 %   pagos pagos_usuario_modificacion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.pagos
    ADD CONSTRAINT pagos_usuario_modificacion_fkey FOREIGN KEY (usuario_modificacion) REFERENCES usuarios.usu_usuarios(id);
 O   ALTER TABLE ONLY public.pagos DROP CONSTRAINT pagos_usuario_modificacion_fkey;
       public          postgres    false    233            P           2606    19939 !   prestamos prestamos_id_socio_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.prestamos
    ADD CONSTRAINT prestamos_id_socio_fkey FOREIGN KEY (id_socio) REFERENCES public.socios(id) ON DELETE CASCADE;
 K   ALTER TABLE ONLY public.prestamos DROP CONSTRAINT prestamos_id_socio_fkey;
       public          postgres    false    3374    239    235            Q           2606    19944 %   prestamos prestamos_usuario_alta_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.prestamos
    ADD CONSTRAINT prestamos_usuario_alta_fkey FOREIGN KEY (usuario_alta) REFERENCES usuarios.usu_usuarios(id);
 O   ALTER TABLE ONLY public.prestamos DROP CONSTRAINT prestamos_usuario_alta_fkey;
       public          postgres    false    235            R           2606    19949 -   prestamos prestamos_usuario_modificacion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.prestamos
    ADD CONSTRAINT prestamos_usuario_modificacion_fkey FOREIGN KEY (usuario_modificacion) REFERENCES usuarios.usu_usuarios(id);
 W   ALTER TABLE ONLY public.prestamos DROP CONSTRAINT prestamos_usuario_modificacion_fkey;
       public          postgres    false    235            S           2606    19954    sexo sexo_usuario_alta_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.sexo
    ADD CONSTRAINT sexo_usuario_alta_fkey FOREIGN KEY (usuario_alta) REFERENCES usuarios.usu_usuarios(id);
 E   ALTER TABLE ONLY public.sexo DROP CONSTRAINT sexo_usuario_alta_fkey;
       public          postgres    false    237            T           2606    19959 #   sexo sexo_usuario_modificacion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.sexo
    ADD CONSTRAINT sexo_usuario_modificacion_fkey FOREIGN KEY (usuario_modificacion) REFERENCES usuarios.usu_usuarios(id);
 M   ALTER TABLE ONLY public.sexo DROP CONSTRAINT sexo_usuario_modificacion_fkey;
       public          postgres    false    237            U           2606    19964    socios socios_estado_civil_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.socios
    ADD CONSTRAINT socios_estado_civil_fkey FOREIGN KEY (estado_civil) REFERENCES public.estado_civil(id) ON DELETE SET NULL;
 I   ALTER TABLE ONLY public.socios DROP CONSTRAINT socios_estado_civil_fkey;
       public          postgres    false    3353    239    227            V           2606    19969    socios socios_id_barrio_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.socios
    ADD CONSTRAINT socios_id_barrio_fkey FOREIGN KEY (id_barrio) REFERENCES public.barrios(id) ON DELETE SET NULL;
 F   ALTER TABLE ONLY public.socios DROP CONSTRAINT socios_id_barrio_fkey;
       public          postgres    false    239    3333    215            W           2606    19974    socios socios_sexo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.socios
    ADD CONSTRAINT socios_sexo_fkey FOREIGN KEY (sexo) REFERENCES public.sexo(id) ON DELETE SET NULL;
 A   ALTER TABLE ONLY public.socios DROP CONSTRAINT socios_sexo_fkey;
       public          postgres    false    3367    239    237            X           2606    19979 !   socios socios_tipo_documento_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.socios
    ADD CONSTRAINT socios_tipo_documento_fkey FOREIGN KEY (tipo_documento) REFERENCES public.tipo_documento(id) ON DELETE RESTRICT;
 K   ALTER TABLE ONLY public.socios DROP CONSTRAINT socios_tipo_documento_fkey;
       public          postgres    false    3378    239    241            Y           2606    19984    socios socios_usuario_alta_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.socios
    ADD CONSTRAINT socios_usuario_alta_fkey FOREIGN KEY (usuario_alta) REFERENCES usuarios.usu_usuarios(id);
 I   ALTER TABLE ONLY public.socios DROP CONSTRAINT socios_usuario_alta_fkey;
       public          postgres    false    239            Z           2606    19989 '   socios socios_usuario_modificacion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.socios
    ADD CONSTRAINT socios_usuario_modificacion_fkey FOREIGN KEY (usuario_modificacion) REFERENCES usuarios.usu_usuarios(id);
 Q   ALTER TABLE ONLY public.socios DROP CONSTRAINT socios_usuario_modificacion_fkey;
       public          postgres    false    239            [           2606    19994 /   tipo_documento tipo_documento_usuario_alta_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.tipo_documento
    ADD CONSTRAINT tipo_documento_usuario_alta_fkey FOREIGN KEY (usuario_alta) REFERENCES usuarios.usu_usuarios(id);
 Y   ALTER TABLE ONLY public.tipo_documento DROP CONSTRAINT tipo_documento_usuario_alta_fkey;
       public          postgres    false    241            \           2606    19999 7   tipo_documento tipo_documento_usuario_modificacion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.tipo_documento
    ADD CONSTRAINT tipo_documento_usuario_modificacion_fkey FOREIGN KEY (usuario_modificacion) REFERENCES usuarios.usu_usuarios(id);
 a   ALTER TABLE ONLY public.tipo_documento DROP CONSTRAINT tipo_documento_usuario_modificacion_fkey;
       public          postgres    false    241            ]           2606    20004    token token_id_usuario_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.token
    ADD CONSTRAINT token_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES usuarios.usu_usuarios(id);
 E   ALTER TABLE ONLY public.token DROP CONSTRAINT token_id_usuario_fkey;
       public          postgres    false    243            �   4   x�3�q�t�
u8��i�ih�id`d�k`�kd�```F�1~@�����  %
m      �      x������ � �      �   [   x�3�tK-�K�K�WHIU�IT��/J�4�44�4202�50�5�P00�20�21׳�444��".K���<���Լ�|L-V`U���� �H�      �      x������ � �      �   %  x���=n�@���\ �?`/tE	E$�nư��`q(�-r� U:�\,��Ȓӌ4��};ofg<��e�p .A0�"�K�J%g��q��k3Zlo�(�g�T&)c�2CޛJ��f�2��M��{W)��l���/um{�u5lݴ��H#<N���&O G|��\I�`+p�3���P�N}��J��!�|�	Y;������w���TQێ!�;�L�oܔLcj=Sl��zhj�z��Y4N��wS#�K`׿M�RW2Ȇ��7���m������ָO���w=��'ڶ      �   �  x��WKr9]ӧ�ҩR������0�M*dS5I�2s���u|�y��(r�� ��KoEr�7m�iUk�l�F�tB=��`�>�D���
���}�_M���+��]�>d��Y�a2��T�CP.*�-:Y�(Zs|�?*�7.s|zN1ض32�ͺ��0q����2�Z>���w����v#���Z��@��V}ho/.�U8H.�6Z��қ�g}U�`.D��)����g	��C��"�ܥP2��:S1�Z�NE��4E3ێ�N�<C2��ρ��OfL��0��ITD����ױ�.Au��Qdr��.!-'6"���g*�P��z3�)2��m�&G����HY�^TDB6ԣ�4��T��S�f.����ݠ�M�%�#��ܨ�P���:�n��d8�0��%�*&�MqI���Ez�twt�������n�}Q�;b��8c#�ʢ~��]h���F�9����A����km�]뽨�I�P�܅��ؓ����_	�-!ɴ�I����G#�]�g�ue�54�Z�-��1I��T���졑?��o���,������c�:�,^��dڎU�\�3�Hn�`:��h%{ߦnTz��]~�YHղ4�����E��d�����.��FD�7��,k�k����*��	��8�J���a�dӰ�Q�}hg�0���s��(L���zT����u�x1�&��_Ca0��R�kn1_�)��9�Ӹ>�ME7K�[N#��� ζ�)�oȢ��#	+d9ڇb�^��G������͢���+�9~��G3"򟊉]�&T]�qrWo{ʚo���¬E��a��޺x5zf�`N^}��0�ƑP=�Oxbs-z�r��ulڢ�iG���U�����V�7cJ�E��ZW�͘և���Ԣ�����AI2u�K�JŇ������?�����v� h��9�3 ���<F"��Y�F~��O��֞M��s(��J�"�A����8�e�O��`��g���-��f��@hVs)�á<�1M��_Qc�Ƌ.�|��;u���w���8x����H���px��X��n߳�J��9��.]Ԭp�}]^�_Ӽ��%%��TG۱7d�r�c]���3��J������A�+?FC��ǆ��2UX�N�<%^�jm[�{��]�Q���z3��^^�D���f\17_ʔ?Cѩ�X�]uo/�j�H$2N�z��������k&      �      x������ � �      �      x������ � �      �      x���͒�:���f_��ݖ���?;J��3Bu(�O�[��uW�Xע�Ʋs�lvS��Z䢭vus�������%��'�����ԉ8�@�%�@��ظبf����K�����x:O�v�V��:�s�0N�����jt��]��T�R�J�[�I�Z�(��ǃ�����wƵ�|A�	�m��4�C�ʿ�O�t�WO��\�Y����O���o��Q�{�ݷ�w��D�/��|�q�}����X\�.�]������t�Ɣ��ͱ?u��������n�R�c:>���:���]�|�����G��q�w��]����a��m7�n��|�s7�����i�tr�n������|i��_:��5�{S�����П����V����O���M��>֤�N�T*�{�@X�
{9�4�ð���m�6���ӐAݔA��_c��lç�s�=�m	S��s��*�?�Y��?A@E@�x�g:X���i��p�O���p�l>�.�qz��)�ث>'�Lq����W�f3��ֹ���f8�<K<�|��M��#�Kaѹ(`�L8��\�C��֗o�@$O��+�锣]
֟6�)�ɩ�\�b�@�H�*��|��V����m�k����a�H��'�;���Dȿ�G6-�R~~�4�0�:�����n��i8�>��F\�,z��K�����Σ+�T���ˁ.Uf�Ui�I�h�]���s�ޡ|���e��Wܕ;)?��E��_r%<�;(ש�\3[�V�&]�-�S~�m���PR�u{�C���ԕ�E�e�O�3��ro��2N��\��4�v��.?�7rW#d_n���l���ˁn���0@����ѿ,��߭T\�?Ӧ�����r�hS��\�@�r�h�l��.7��$��>G��-�]Ɲ6��P��о�^���JN䩧�7tk�rk�p-���e��\���
ø�n����i�+7�N�cn
����z�$2��Z�Ӗ����ǜ�)��8��.uO�'1��(	;5YJ5�ʍct����z\��)v"��Ln���B5E>�3�P�cqCC�r���ݲ�,�;'wC�#��y��	����r��^Hw,�w��qE����r�����x'���o�=��"�$�ݴ� ^�]r��ۜsu�0b�+,ui�/7���'H��	�I[L������6,���k��;M�^��iIW��i�޿n��zj�:���-���q���Lw
�*7Fng_���e�/r�z=ݱ�����^��K�N�aס�rg�vEw��--v*wLng�G���5���N�ѝ�����O}�n�(^�hC�r�&w���͍�}T�r�fw}�B��Ǜ�S����?]�cGm�-�y�K��A�T�_����]���n*7Fn9w�|z�VQ1����!��|�i�̫��g�s?��)msU�M��<�����a���nO��_0������=DG��p֗��+��5�Gg�_s�0=�3m��_w�qF{>��+�R%깮ڜ�i�+U��6��jI6��;H��j��k�1�M�I�����F���_h���>��V��`Tx�
�]�)*���=�%��(��e+�-AyB9A�E�+jQ�"���̢R��Z,��ҥZV�\~	JTTZp������8�T����Β4�w=�:��Q%��:~I�tɻ��E�*��7)]p�%�:�g~�1��x=�4��y]s�~��D�Ԝ�\C଒y���g���:~~^��*�7���Y�*��O�n3�F%���i�pl���O֗N�{N�z۞l�>�����'e����XoJܕ�m��f�����F���{���������X��j��-˕�~��˭���>�ɧ�oo����������m?��NF�w/���ܼj��6�����O����nK�s��-����˘O6Y����d:��^5�ڷ��$󟔊6��S4�v�n?�[��ߗ�e�h?n/�2���N�0E��{�;=�7#K�TR>�iA��Z���>9��O�k��޵�NǕ.m>�6�\�̈BQt��]lJ3t�� ���(\��i�����	���p�	�|{�o��!�C]�idĕ��yD}ӝ;��U�����5�rV���dtN��72�Q����N0���ꛧ�y�7�nꋾ{��J[݇��Z��ύd�N��X���fj���'F�rsU��M�O�Ks��ݡ���Ͷ���j:��k���#�vt�]T��y��s,�L��(3q>�ɷVn�v�k��q<���}���nz���M��k���U��*W-���j1�+m��.��c'�;�ݽ���[���~[<K4O����M�ֿ�_�j��g�2�M�m%�g
�.�[��WK�/�6���y�x�m.`w[���ݯ���%i��x�bZf����bv�^N�Y�>�r!�_3#1s�R�����`�]�2���Om0>�%pP"!��󘳛��s��Z���r�̻�y���!?\��T�7�+���h߽����f�MS�� �I��1�}���8.�ؗ�K��{s~�J��:~6�����K~DD�Kw!�͌�F:w�6CGͧ��>�dx*��H�" %6�v�gx�s�2�Kw��ۑ��ʈ4ajȏ������?�3u�9�;a
�C���9l����<���/�=��B��|3ӄT�BGO��}��N�K~F�-�_�j���P�.$�y�s��W������Xf��x����۶��ZU����2w?�jU^:W)��ۃ��"O�j�2�Z��w���j�����*�=��ߕ
��J#�u5�km�_��f�S׼��n�~фQ�P��s�rӮm�o�&bhfh�Asmc�a0F�&�YjJ�p�o ��U���Wr�Z��f��r�w�K׺wc��a�\g��p�7�r�<ls�=
j�rc��bqr��ݻ �&PG�������{!������gk�D�ͮ[�S��aU�	�>�s?����;�{e�縿_�P��~~x���T:�!�������O?]~��ED���2�̻����Ƽ� ���8���3�P�~�B
��A�x�!�<��ꅼE�&���Єȧ�f,\�2C����g��1f�Ea	��ܯt�@�����VϹ�^.����S�7w��]L3/�&?�/�7�̝n��������-ǟ�@r�}����f�o�v�tZ��*���S��7�Ɵ���������u����{����\W���4����?����6�����ǿ����������q���ի���+���d:��͏��(�>~�5���Z�Х���e�&�s�D7T~��r�c����@����d:6ҝ�0�$�x"�-3����H��0�G�'Y��a�%���`!��I�8h]�n�N�z;e��LKm��8��Fqm��oy*<�i[x�Q0���+���ϊ�eoU|�|Te�\�<+��;��;�� ��l�'����߃�����f2�_��Z��FHn��W�B�����^!��钻��8!l���_�׋���&0OӠ%7/\y���SC��Pœi�J�y��Uy|��7'277�ks�f�zs�__o�^��>sG�>���>�����8�ns����D%�a8Ч��\�|�0.cr�8?>�������m��uX��eR��:7$LR�!�>�kXnNd�Z�N�|��W��=����O�{�%�#!��	1��e��2iZ�����-���x�����~0����v鷿�����[C�m%��$ȇ���Z.����OW��x�O����a7��Y�_�J�-����_iڶ�����e��a?��	Kꄚ�S��6��:��RfZ��ʬA�FK�����M�H<�l�M�T�+��U���4X�uC�2�x����A�7c��ln~n�)zS5�)�����ԇ�z�6�Y#i��cHJ��	V��<��a�%�i����Z��[�p�#�-(�fԩ;��8�p�@@O@�eK�rVx�هq�p�q!�s7��j;t/�l�h�������mn��6ݺC�����r!i����)W���+A�-�g�V˩���~��T�n�e�{���W\$#E�2��՘;tXK�r��ê?�ͼ��$�9m�����J��%Ӣu�m��_&���R}�+���@�2P    5���.�8i�|�t��=-aͱ����[u��p� ������Cs�4�o��1?{�(ʹ�VZ��v���G�O4ln�i�4��k�Cn_�S��,ϲ h�h��M�T�B��Z._H�BZp|��
�����"y��L�lӧ����Pl�DЍ3#�@���#e��n��Y�� #�+�y<øD���v������'�"�Le�̀�ʺ������BYG����Bi"����)Kqh��법}?�-D�?�<{eܔ5����j�Y~��I���S
N�;*m���[��>nٞ�ee�q7z�K}��͗о��j3L�_���~��oؾ=�n�*2�n���M����8�>��]�ɧs�+���/���o�R����|i�/}x�O#��Q� ݶ�m�oH�Oo#��%���p�^r��k�j���-�;��,Aȏ��tٔ[�o�}�sG7�)��v݄}���<����:��է�O����2���2�8����z��BS�2E����2�ix�8���矝��be�Z��ۨ4>A�F��ehD�m?cB2oNT���!7@w[�,T]�G0U����H�����M��չ��v@��H�p��KW��욏��@���P��h��_?��b�& �}v��\�>i���vp�ru)I�H�_G��˙?�.D؂����~V��w�1��e�m�LYx>͟_\�X(�NI"Ĳ�IeW���9�%��וN��2�7С:��۳��������������r�#mn��6���S��/T����E�4��f��ގ��ԲfyIT������K�'��]�q1�<
|A,=����YT�X��:������⻑�1����4���e_��r��ۭ�i�[_���e ���+��M���L���l�����$�?NQmYrC��e*��,:�K�)�4��ti� Ų���F;w�`~ir �&x����A��bF�Mgs���錀L)K�d���㠔[�T��}S�!����o��(�D��ǎ��������������s������l�8�q�l<C���gOu�����ph.�K���� � ���l$�!z��i��;]	����!>XZ%]P��4^A˟<p?���@s��mK�q�>~9���\sw�����rZ�{��Y�À���TH��H�-������YjMw����q��ח-p��,���xv���ڭ��!O��l9�{�@ϩ����s9#;zT�~��O;<r���Hge�NJ(��Nk���> R������(>�s�v?v�_�/�ͤ�;/���@(��u���,b������F~���I���?�J�aL��KO�i�ߠ���4��Y����|?��K�8>Cךf�4�iM�p���@�c���6#���OO ��b�����="�@sě�C׬/��|2V���iBh��L�{�Ж���'Z��4}����e�z;��\r{ �rF�J@q]���d�t��ݸ��� �$v�����D,pJ�䓑O(@(!�.h%��*" P��t�T�pb��9�����%��g�[�/���[�!�p�����<D�Xҹ��������!���ۥ!��B�6�:t���ʼ��Wy2l�R���\��f���u����T���}����f3>�F��@5H4���9]���eu3<��Wj�>�r�К�L����ۏCt9�/�~��f�O��E��
�{ɖ"��M%��
�PM�F�T�:rQ&�9�J\/k� ?^�y����#��a�\����O5OS�!ujlKN����%�%��Yw{�>����e��m�5����j��~�o��r���2�[J���k��!ͷ,t����k��������RT��ߞ���4̎ԇ�����}�q���D8��3B��j����ہ��P�O�M�Dw�lʔ����j��M����<���R�#}���!P���S�����eMfuS��.���|�<_�[FQ��uWP�nG}1�.R�ч������1@C1}�F)�C7�@�Fk���ݑr�y�ح��3�>
��>��\�ꢷ�~�B�8m�ZyȁPH��>�#t*(�����,�>t+�B AQTs�x�é��H}�]F�ǧ�>HM�)��Ú>���R�����.��oi�g󸧈A��hJFs��x��� �dtw�+��v�#p�����OR�=�h&	P�'�5�S�H�u�������������������?U�a�(hde⍀�,7Ѵɟ�NL1���z����Dۻ�h�!�y�<տ ���[�=]�sn���є��R{��˽uXK�����] N��.�j��qM�o��>��W_�? �^O��<��z���͖��}|5����鰥Bm�� �۞�����Jb�O�m���� �ˁ>����a{h��m(X����X��*�M0,Y6�<U���B1d�D�9ō�9�Snӆl�u����5����Lk ro��L~�w�r�ʟ�����a�'jB��b�e�$��%J�;1�v e�Kn�|�'��Rٗ\��Ou*���;���:�E�}9hO+�Y[����@� ň}}|i�S~J`>8'��iO�Y��7�G�KE2��>����(����>~��Ȗ�ذ���V�[� ��Yw���9�30� !v���2�Nq���L��-�a���fIQc_>7_/?�' (�e�ꌬM7��3��{�O�o�ԍ�.O�b����}��v�ŋ�6%24K鲁��E�톞>��s8�{@��b�v_sq�a���HY|9)S.˺G�e,zlw�W�?��'�RJw�K.���U�E��.��O�__&�[���v�]>p��8����M���N����n�.=��b�c�����gL�48���V�~�m�g�8(��C�	��oh�X�~��Oƶ{�Nd�����n`�NO�ho)���ͥ��[0���nȌ��+^l������=r6����؞��K�}:��?�D?� �a�����BR2z�JFO�����b��;*��&!���ёl�-\b�b��3a��eÿQr�s�e��Ǔ��	����u�?��䤢���N�H�4}u�M���j�T��a�kʒ�-��n�T,֡����??��QSQX���r3��ø�x�/�EW�Ǯ9���=���S��� �v�m�c��ϧ�z�/��-&]�G�$E����Gd�����t�)���?��%�Å>��b�/5�/=6�������A��e;�|1������T̗l���_���X�=4Ǒv��U�FR_���9~�׎�X�#���cns<����Tر�J����˧�>X=V������vi�^��C0R�a��A���p�=�	����㥟�#MG:ňO}>ɹ��xNE�i��տ<"uJ�b�����tP�61v���;E���Sn�оLE�M��>��H�bӘ�}w@�שX�Ӵ����<�ݐT�Ӕ�h���C�>M?w� ���[**g��e���v ����n]�וY��5����m�	��y�w�:�T<�i{hN�-T��t���B^0�tz<��F��`K�*��2"Կz��o��+��G2P?d��GS�o��m��	�-71s���꬘�Ӹ�4ܟ�������d �\��\�qu���8N��|��jO�v���v�gh"X*2��-� 5Ƌ�9����L�2�>&��R�/Ӧ�ב�ȐS*z��6����j6�ꥇ�vZɢ��W�fR�is~���"l�O]s��s]�����h�"ms��5#�pk�h���]>_s��msޝ���;j27R17��&��+-�C����rh����п ����@�+Y$M>��t�Z*�Ϝ�9���+[t~+�V"a-��|y�O�.oq4�����KR����\6��hr+�>Pc�(z��H�p��ٲ�N~@��S6�ܲ�7E
��eM�����y��s~{V��_iZ3�"n�7��\x6e3�o+z"��G��Zl�����SDN8e����T������ҸQ�[������a�5�c�3�##SL��a���?CM�₞/�|��������{h~�v���    �\a"GC7��uY/���o��>�����0���<u�z���� ]TE/��N��f�X�uA�dY�"����-պ��G�������m��-76Cݳ�c�%��)��wglOh���s�*��o��k�_�	CE�����e��,�$�J���.�����d#k�����?��l���4�^�6�x����)����y�A����4��)���3>��e�!�.7�bDb�.'��ݎH�Jj��Ӏh�ȿ���KTh<#�ӓ[o�uW�M٠���,%+&��d�?�����i{9�B��Z�ʿ�.�3��hCh�gt���B�D67�6T�AvD.�$��t��Ґ��=�S��^�h?�s�8B�i+;�������T���O��7���G�lʦ���AZ��l#��e)z�� �ˆT �����cX����+zS���~�7��%����3�v08�p�bN◺-�(z���]�?Iѫ*����Y������Q%�Fߠ�	xJeR	�1�C��g����k�rUDZTɳq7��u@m�I%���
%�t��to�~�ڶ�������Ї�J��Mġ�U��Dܶ�A�՟Z*�7�	���k�[�]C~�{""�r{rLfRɸ�f�&��[��x��@�����1��cy�9m.J�����c��L*w7��/P�JƝ^*	w7	�v�Ȥpw���
-TI��&���{ȿCP%�Fϥ.�t�K�RR�(��nû���A%�����^�ր)y�z!��ћ
B����L��7ж��)a��/w��Zɡ�9�? -�L(U���$���zL�˜d��<���@������)Q�i)ǖ$��8����ò%�A5`#��6�����`��/�������/���x��n�+f3%�f�3e�n7[�R�L�_�u%���� S3��3r8�#r%�Q6��v��/��q�JR��!�.-���ș��F2��7:):��A%�Q��~�Uë��@%ӑ3}��H%�1-.�/�N5��@A8%�IU��=|�v��>��Ȝ"��T�}���X�J����e�Mȼ�L*�Nn&���$ѾG����:I�aJ�t���1%�)-+L(iV�ę��b��R>�j��0�Z�	��9�Ve8�2�.'9&��A�Tü�H�Ia9)2).>�Ġt$��/Р���p��Z�H~��R���0�����q�����#ϱ��VNH��x�X+/���p��dz�m���@���s�\���U�R�rh���1,�Z��#N�V7���B�^ZT.��Y�� γ��zs������)�f8��vOi�ġ����<u�c�x��[�`?!k2�s�k��iK+v|ʴ1�k#�4��0s}	��(��14R����!����X��K�`�[������t��T�"�^"/��D�5Hl���L�$�bG/��k�b�z�z.��r�\�P���W�z�*Vp�J��ݴAVT)�NY7�N ��m%��~� �գ�7e�R�J��#6��X�)+���A�ޔk�8�N-<2o�I��p��Y��L;�ty�4��D;w���=+��M9�Pk'��i�J��S..�p��D��GvTQ�͝���S@)�v�K��ݰ�bs����ޠX�)on0Pq8�^��8�5�;�X�)/�~���P��͝�ҩÚ����e��Q������3�au�B���ⰻS"���p������$�Ƀ��9���N�h=��2̊O��+����X,_������ ��QЍζO��c8�G��Sb�
�4���)Q�\�y���SѼ*���ZUc�UV���'����OU��t��.�o5���ZJ��S��V��3��V)�}J�_� �}��̡mA!Ǻ
�/�00�X�)�}�;�U�J��S"���������v��y�b˧��C6PT���w��L)v|J$�ց`8����N�X>t����i�rx1H}8�W�TӇsxY���^"����|��iŎOWǷ�1q�~O�a��T��ﱊ�͞�fo��R)�zZ��l�DYҤb8�"��+=-J�p�����p�y0�\u��W�W0�x=��r'Y�[� Y�W��'��=!{�(U��7(�Tɪ�����8�b���8����ǧ30�V��*��ti�!�zOf]# θȽ��ɕ,��wO�{�?iV|Z:�^��Ӣ�V0��m$�xqd9�YXδ�Bt-�fU��*�1gQ���Qq�MXXN��7�{l��fS��
���4�Bm���PW]8� '�:Ù4�4;C-��~K�[K���Ѥ���#���pΫ9�1s[c�b8���F������PWqX@�}��PWo8�wU(��PWk�� �l�X��XC� m-��P�6��$�H��4��������E����{�i����#�u(��PWcX0�!�2Ԣ�C��fg����њ�����p���#횅����p��/�K��������Q�u�>��,�����P�v�a�0��6��H�����Yr����g0��j���l�PH�@��-'q��!�-!�v/7�FI�po�	�&q�=���A��Y!jQ�8�焃Nw41���q�dεhCp���P��[D1�V���E�J�W!i6����ӸC��S�ա��v�>_��C]���s*��Pץ�es��y��>Ԣ�]/4�C-��p��>$̈Z��OW��<�&'�e��E���-X���징*\駃��� p�f	h�\B�-�D�F���&��5��9ܚU��K����]5�@S��}g i����@�ÛiU�sx+�v�7:��Nдs��6-{A��l���(�ŕdck�5[A�t���T�f+h�i��yBde��`h��	]�q�V&��o�=��GqnUdԪ;<��` @��R@��
�m\�6rd�C-pWB���hS�b8�Z��c�%ƨC`�g�_��@k	4��d�gt�)�8�dd�N�V��Ȧ�F�|�����Ȇ�FW5.h�&-;�-i�ٱ���$ε�\/Y�jd�N�+_cjd�N�.aq�M���e�F��45�`�а�3����ˡ�&3���J���LH�ð�3�}�@������6�g�D4J���1�p[�Խ�����3�/�p�m���\����l��[sM�J�&����5�4����3���+t�a�g\M�����P�8ծ6F�����q�J��a�g\4��=���������׃B���~ƅ[�a�a�g\|M��Gڥ�(�Ʒ�Q������(A{����5ׇ��ި�[@�k��D#���7��8��-���5ޠ�6,��px��	4>�p0�aX�������(�+�&���u�\#�{��&�Dӻ��iǰ4���M�4� M��58FmX �P���+[���\�8���>+@ҌBO+@K����3��CƜ{?)��Ap�#97ſ@[\6~&R��}��A��u��9��f�!�U�}&��+�ɍaD����5��[�70,�Lj�Rw�BXڤ
y�a�g�8\f��d�c8��2f��?]�Sʆ�$�P���ਸ਼B0�b8�)6p��e$	GyI� �� ��#�^��W��f�_5��~�H+iE�V~��K�^�V2:�a�E��;�d�}��I]�	�a�gU�쪣�" ���E��a�g��Kr8����Iee��8��->Ik嗞$��
s�@�[�x�g����RA�ۅG�F��9����y��K2I^
5G�mڰ���q��]�hk7����5f�Z=G{=t�	�x�pâ���8�zN8�XcKh�q��Y����u���m���E!�]M&l�,�Bkjʗ���gs��yM�u�5���n�j|�5f�Z3�j�e�5sU�8�&}�rz9�e[hM�Y�0+���s}��8�V-'q��t8�?k���sc��u� �ܺ��[�
,��?��8�v�94���;�l���h-�C�怣��SK9n�o9Ti",�����xAN5�C��l?]zd������9ٰ<�l���w��l��s��v��l���Im    7�T`�C��k�vO����r����ac�����sW��e�Z?�P�,,D���8�X������ η��}ȭ^h����9�ִ��OKAlm��n��j1����C�j8v�6��^������թ�F�-KE�M�F��+�甃�ܲQ�a�n� �xHKA�mlo|h�Y�Q�
eqң�� �nY5�h�8�q�Ǒ��F�C�����!-9v�6��zd��e�h��iv�N^�o�ZebY?�8���G�Ҧ��;�ùNs�Qg:͙F�+H���q�����w{@�X��6��~���N��&�8]²��iN7:GŲ����ċ$����n���s�.�I7�I�H����R2�	�J7�JZ'
�[��n��H����]��M-+L7+�%���pE���,4�,4���}����BZ֙n֙�JH�>�]}&�Ҳ�tW�	O��4�2? �Q�R��~�s.F}���t�3�:�m�+6����}y-D�t��I��*`h�}�+>�@�C�]�g�,��tEif�~8 ����L9���c��̼�KN6�LWd�B����KΧ�GF��e��2�`8��d����4ǚ,�JG��ґ��[Jm�\:2�0ı�td-�|�w��#1�J�@��������c;��N��+9I��Q%�8�$ Q��#J�t�Ȅ�� 8�&1����d��\D�~�Y�&uI��c�謾)��ZS9;d�c�謽� ��c�謄]���*:+�E��c���Ԏ����c�,;��Φ� ��εs1�X+:��8�NW��P�jáv5��aq��[X���H��,�D��B���+���#:�n0@�ڱEt�V���F��yu[$lA�c��$�Z� :_�|�&`hձAt^¼�v~tl���3*��C�ks8ξ�]�X:�8ҾF��۱8t�Z=���͡�@��j��p��Y��H{s\�)rl]p7EBQ�� �����O{��.��6���P�M==pQ�cm�bM8<x�X��f��ec袞A�����f&�1gg�b��ԭ��5KCS~��Nw�;��]�(���B1阖aX��.:&ք�4�46����Б!�^r����rI�nБd������dT�	���{AG^P@J������{blY�8d�>БDl=������l=���$�$-$��	�d��,��-�C9F�z���{@O���rs�RNdN4ܺg���k�!��ϫn�����+u�w����ף��9�^�k�@g[�� N���X���+�`�:�~^�AVp�U* x8�����B�7
�Y�y��r8��^%����2����y�����1V{^���Dѱ��󻤪a��5�hX�y�j� �g���y��<��P���l��g��^F�S)_�-�<K?o(Ǉyo�g����x�l�ֶg���x�#������	Z�CK2���Ckc@���z�
�^�`8�V�`���{V���^��Y�yk�08��V��޳���-qz���2U��Y zf8H�� z�ÃIh���z�V�jn=[@�ԵP0����d����yv�ޙP,���N�A�e'蝻��6�g-��5�h3ʳ��u�yzփ�]Î�8�.-�!�~��
����z�9\���^_K���,�77���YzooA��gK�[N�t{���ۇרbq�}|�������&g�4���-��=kC椯�5�D=�C�QG��g{��5��P�g�]N⼇k�&qރU��|�Y�^�
dq�C�aa}?6�>��$��>^Îz?��G�z�я`8�b����h 8��
b��t�t<���*	�k��藓8ՑR=A���,}���S�o�@�ܬ}j����}R�(ݤ�Q8��\)pÖ�O����,}rW�$<�C��M��ڞ�O��Y"�o��b�蓤�	/a�ڒ��(v��-�>v��8]�5r��&�V3:(È�i3v;p	�g���G6��lC�S=�Z��ah=NLLX���K�C֢{�������S~D �b<[�Ц�v��
(?� gX)��$<� �`�]�k�V9�C����px���yΦ0(WPHpX҄�zB*���<�x�<�� Ϻ0�.��x���|!H`UH��+YB"�{�zք�4!���\���,a)��Ƴ$$	Ki@��0�%,����&YR����^���a ���A�c-9�w��
�ik��[�`$��@b`mLM5�:���0s�A���H��]`u��AcG��a0�l���"S�����`$��։��hc3���`%��ϟ��rh,�����}b��kx���R1X3���sm�����`9��>ȁ�b�~	��L2q�X�X#|���1�Ԡ�(�:�]���:� ��uZhfYg��U;��l-hf��\-~���Z��6�-�.�2�����>���rX_���+��&z����z0�m�bgA�Y�p�9����+��ݕ��}�o�6���~O+ڔ�p�}lr[�;����b+|jv�*0��y8�_��0�<�l2���/M�����\
�zf��m�	�*���
 �ځ5_�y܍�nG9�|E@��ǩ{�PR8�!.ap\C"�"��6/Ė	gz�!�kT�A2�/D������2��P�m%��Y�y!��>0����8�1T8�X�HP���H)����^H-��&8�I� n20��,��&W �n�C�tu!y�`�kVt!��.��0@�ሦ���1M�5	i����m�
u&�6u�U? ��!^����.�f9�2���M���x聑���.�5�ӹ�Cw
���ֈc�"vx���ØȘ��0�)��;���.�V.;H�D+N4�A{�����p����^�_��.*��1V�z�@�X��	Z�(?����*/�peݏ��e^T�gt ��^Ti��^ԒhÑ�RI��SV{QK�q�Z������.=��N`����Mv{QK�W0�ì���p�uM���X�E��q"+�h$˰�l���4o������^4z�@3/#;�h�R��H��wFvz�HSc�DÑ�f=��^4�� '�E�yф�N��Do�݀�#��hҕ�^D�yѶ�sX���}^��� ;��u^�5ӗuw��Ud���z;���{�#�hm�`�'�͋�-�p����8�3m%��f7OH5�j/ZIu�\�4r�m��c4�"��$�ȫ�";�褊.�:d8��NZ|{��Ȫ/:���e����y���#�le!+�"���$��(ld��$�����ũv��2�Y�E'���=2�/��.-ð苾��g$�,���H�^�	ɑ_���0���E/�h��q���j��ڋ^�GZ⑥^�~� �"{���2
��Ǚ5{Y�E��aX�� !�9㠖r8�A/<,�p07�b���ʽ��C�B�8����^m���nI��Ⱥ/��
�jtH�I,�bl_�����`��
9�,c�?����5ߗ�G��o�=��e`�pp9Td��}?Sd��/�;J�ag[T \�Q� ~v�F�xq8�bW�q�<��Fq��q��SdS�ޣ-U����Bt�qda�0�9��q'Y����(�.��9�
��B�#��ہ3�"k�$�pu�w[�&dG���oz�,S�0�1F�e���kq�ӸC6���S�����~0U?�ss�Ձ.	���8�γR�N[�$���p�E��HB��p��f��a���p��M�����T� >�7�LU. �L�8Ϣ�`�,	��7G�Qk]�hl�WdM��&�1�	a�Z��N���w݄L'��	S��@�*
3X!�X&ф�r����-a���K7���sbK��%�9��j	�d�%a���p��!D)eуpY8�b�W�'��I� \qu��a��L����s��'hR\b/�����8�U���0l����j0U5.2HlS5����f0U3c8�U�N�xA�i+Ș��rf&6���Ab�'��`    7��|r��p���ҲKl������ ����T� ����f0U3� ę�r~�Pb9�D
k�%����A���`�z^�X�*m��&����abA8��_P��X&ւ/2�^0�|�/7���f�e��f;��^�2�X&R�0��K^� �(��`"5H$�Z0�,�0,��B�g�$V�)����;t�kb7��ɜ�%�q�K9�����~�h0dBTb9��o�.=�f)�Bh���e`
� ���M`
����.0Ŷ62�3�LQ5�'�*Apr�n���UAic��H��h������e闢m���Ī/E�|�I,�R��'p�vbŗbhvv ��a �4� �b$�z)���A���Ta�a��4c���>/%ç�pJ�]F�&�G��*a���g�����R�7q~�<��8Ű�H,�T�r�q���r��+���@��{��^�P����N,�2�6��i�O���D$�y��2	,��o�e�`��}iAb��q#	#	\Y��X�B��(V��P�X�
B�4�(1V����2)J������DZ�P0ɶ�5�j�%��ע�[�|�ɷJ8#I�u+t�_Jm����v�HI���\"4�I���r�[�zt���Ml�f�.Kk��$�:�s�JI��k�W�#:I�uM7:>��VBnjȩ�p$�Fk|궕��9���uݶpS��u�J��]L�p���L��m+�6�aI�M�������;F��D�Ԩ�M�*��m��$�vN;�p׭��[}%!st�$�v�7ptM�J"o���J2o���9�VI�-E�tZ��Uu���o�˾���qu�$�6G��ʇ��d�挃5��l�GH��b�j�/��LZ2�t��Э�<;�,����p�B��99?Ȟ�Ւa�s�Z��(ʿϲ$���m-�u	g	�o���Guk$�^UXuɱ��}�n��ٛZ�%0ɴϙO�z�	�wK g�+�e�[#q�9��Zɳ�y������ˊuk$�>g�r�	��J�C۔5B��hD�V"T�.7ҭ�8�"1�B��J���YX�J�V�\EA���4�#Ia>0�
��+	�A�[+�i1�I�c;��dG�%��s��y��u�x9Z�9�x��Q��(�ϓ�<���f��D�ɘ`��,�GH�����q��.F�'�!iK�+x�E�z�[r��wnԭ��%�XR��PY�&Э�����#N�Sw L|�j%�؛�t+>P�ip�Z�bU�����L!/ҭh��[��@�т�߲��T�m�[у�!�k��v�^U�[��9�T`"3m.8� �0�GH�8JR���$��2�ItU��ԚH�*�f�=�nE*�0�}+�P�x�շ�q�T=lED*���D"*-q�M�HD�k���Pw�J�k��P�ET��݃K����;N1�J��HGB�C��P�\ǥ ɷN��L�=TF�}�r$�F-�bJ�25���I��Y
�X���$��6ӴzaI�Mm�����Z�6T�{7�O�T���Wđ\���;tG7�D*[kn�$鶵��ꦕ�Be�B��ۚ��0�d��*��M+Q�ʺ�ɵ�W�8Be�R����>&<�D*��D*W�Y(Q�ʩ� I���>�I��D{u�	�rb����:�J��r��F9�m�o��!ɶ�#0I����"I�]�9GH$���R�۫�C�\�����)ʒx{�X�po�A�f�(�ʻ�l� 	���� 	�KA�q?�����Z�PT���UT�]ȑ�����o��IԢ
��PhU'�Q�r&G�i�\T�-I�C�ğ/�H�|��P��o+xtH�eT!�0��"�Q���$�Q�v1I��L�1����ӥ�^����EEzq��x>���V������A+������`�M����7}���U+'��!c�U�Z��T1��oL�����/�R�@ŔXI�
��&M �#^R%�#iM�`N#��&W Л*��R�k��M1Wb"Uʁ��+q�*E� �M�9v�a;�m��u�6���Z�xԭZD�Bљ��E7��4���Z�iԭ�NGxAx�]�(���(щ�MLB��b�j�D(G"����5�E����U+1�����sD �]����dW9!�UGHvU`Ī{��;`��D��
\����A����#J�֭�h��WUbu���pG��j��N=v�Ejm*
{��V"��H�Ն�A�%�h�!vPk��#	�5��>WC��A�u�,	����v�u���io8@ĵHBmj�1M�Ej���i���H����.Z<�6��P�<-�P�X�r#)G�kq��H�QW��j��$�<7X�-��K�+Զf���wZ�-ԶƼl��$�V߂�:J�1��,GIЭ}�l�o�m�ɱa-�P�Z���{Z����D�Lrnk]�|�����M3
m�k��ڵ3\ע��c}E-�P;��"	wfE���LۆZġvnF��}��C�����$�.\�EI�]��к\�v��Bc)Q�vf݁5�xD��	�+��s·QQ��S��$)�GH���j��B��k���&�c'V���L�XQ��'!�S!��BZ9I�*�P%EZPI�,�!y�-�YkQ�:��(	u��:�g�u�Z�-�!G{<۲�"D��Br�'h�D�&�!0b�H�x�a*�P��?��>7H���b	u��L�ȡ� Ա]�\GU!�#H䠎��ൈA#V<���$��.&I��k����A=L�� $�1��lLʹ��uj�B��Iª�!����`A�A���B-@Il�-�E���&�%N�5���I�S���6��C�b��XgC,�NI.!��h�V��(�p��v�XD��#	x��p�p�B��D����-��/�!N�B��^�$��%�Ѩv��l4J�d I���I��Y
�x+�0Mb��|/8Ip�4�!�
� j+"0ɸ����z�!�J�8�!�n%(G��k��� ,������ɦ���݀4��?m**?i!�#��h��7��#[i�F;��˴(H���v��uZEB-�f���$���;p?-��h�6�/��h�T���p9lh����4F��1��Hݽ�$�6ox�Ɉ4�.I�����P��f��h���?��Fb�>#�~觩C6�5����g�#	7Ry?\zd�1#��XI�c.r�D;+���Af�����$I�����(�HGc�����h��'�H���g�H�mX��D�xŀ�<�FT���޵����$�Lوg4N���e3< �I#��8i��m�aG#��8S9Fb��2���I�х�F<�q~A��HF�B�`	��v68�ǈ\4.-�X4�]ȑ<{u�F�(E㥦�$q��@�>�F����x8�u�#������AD5/���^Q��K���$������vn/6�?��Fڅ	w�p��v�#�0H�LF�I��`�$��-=8Iv�϶�:��W_R�-�Hb�B�hF�ZL����o�/B�dG}C�ڍ(G�-ۛψu4��P�$�gRU��4" ��$�1�aA0I�X�+X�fDP��ꭼ�5�F4�M� $���r<m>��WYY�!�z���?�hJ#�ru���q�F%u��v�J#��4�&�~�hI3kI�$��b则��L�%�����o8��G`F`�z��YPF���r	�	�]EyA�� �9���C#�Ҋ�D'���V$%�Ci�����'m��}��$�URN�11�(�(�թ{B21�Ve朁�}k#�Ҋ�\�.�,1�'��I�#�;�:��0@���I���g�q���I$�9	sDNZ�����r��I+v/��Z䤬�i<L�-zR`�@�J+��`���dDQڪ(���y�k�Q��(�=�J[%��x���G1�'��Xѓ���o�@�1i���_�f�LZ1�DBZ�V��/�s$Ң%�M�"&m�KP��j&��$�UL�+���I+f�7LB8�j&��c'Vܤ�n~�;i��<!I+i�����b#1���h�S�NH    ��!mѐ',-� mq�(C�[$1�W�j+�YH`֊��E@��վ�"�3+���xB�[q�����c��G+����%Q.��P����e@�iX���������8�b �sh�t��h]:�`�=Z3������KM�e�;�YQ�ַɴ~��h�b�f�Ώ�G��2�ٛ�<���XQ���E	�w���o�zF�k��ϔծ{��ް��3���V���Q`��G+�����"�ц��<C �qP(@4�d+z��<���6XB��F�XE\#$����l8B�"����#����IiT�Xu�~8CK�hCue=^ �6��Im����Imt7�)�2��7�
�u����hB��D���$�1���D��6ס/le�Ch��,�w���]e�XB��g<t���Qh��,��[�6���w��|��w
7�����
m��Q�$�w���]+������i� #�ol��S�Z;�ltLL�k�r���9:��$���YQ�������$�Z��'�Щvi�D:U�(�q: ;�Z�N�|��L�NՌo���Y��N՜/xC�s�$}����C�j�7�q�ǔ�C�ju��v��"��9�s�n8�ȶ"�no@�N:V���j9Jr��
IεY
���9��\�b�:�nX�0��C�猏�>�4JB�C���5�V��s�'hΆ��t��Q���#:�.&I�M�9N����$17f��I�M�s.(��ܸŅ����q�"��"�|':љ0����ŉKt&�p�n���D(:S���PzB*'J�ٚt��r"��9G9�r[SHBn�R�d�څG&�p�ݮND��~��h۰�#Ѷ5�O=t��ht��z7 �'�ѹ��A�1�Ωгs���H�I����w�hq���d�l��2:��M0���5:�g�ö��\���*[��sq!Gr�j��rt��z�Ӷ�/�.7'��y5À5N�����A��hG��B����+�?D=:�r$���p�Dģ�a)HR�k�q��ڧ�$��.�N$���Il�z1I�jc>8�v�KA�%a��������FI�«|C�~pb+]��X��pb-]����r�/]l_��P��tQ� �D=��,�2��tѼa!�(�.�
<
��G��dH��j��_àM_E�
͉�t�&�Ƚ-v��9��}-rӥ9���!^�%u�д"%q��fF!gZ����&q�I�g�y�$���I����{��R��t��1��Yhf�a����k�_������� �Yl�o�R�PM5N�B�K��Ta�P�����&��L_e�
[i�De�Ye�+��L?�L$�����c�CQ�~V��}�ND��E��:Q�~V�P���d����ډ��Ub���g�I ��$޳��A��Y`�'���gI; ї~֗(Gr=�K���p$׳�Dg�:1�~6�8IR=��(	�l.�$ڳ��I��Y[�$	��-�4� I���D��xі~֖0H>[K�=�^����%�*_/��Wq��%9��r��������[����R�".�,.A���Z��Z��jx�~��8IB>KK$��Wcy�$�UY&��Wg	o��EZ�*-�"I�gi�o��E\z�~ K">��%,I�,0��$����b1�MA�1���r$1��/�伊L�H��d�X�Ec��1W�n ̪��g�y�����g�y&��^$��%���=�Ћ����<wO����c��13i :�^<��=f~���zV��P�ɋ������?A�%��&�k���g��o��Ee�Ye~��Nb3�l3���g��L�:�^FQ$��2�fl��f/6ӳ�d�M���Yg�W�a�q�v^��g�y�Ez���G@�r�4�TY���,4�4a$�9���4NS@� {q��\$֎��@��#yG� !$ݘ	����FO�1sP��E3zҌT����I1Ry�v�E/zҋC��a��ԑV�!R��N�!Z҈A'�{���$"���|^�'������DO�g���ЮJ�@��m^���y�j^�v�HC�4���&�@k={BC����� ��s��ܔ����bh��-���2�������U�{�,��|J�� oK6|)^tԟhJ �l+�VA�@���b��n	 !/͈�����K?�������ӱ�6���ĮmtR�M7�� ����.3����X�|)v��p���"�(��Os������m��r�i��q�e7 �ȳ�K�I��r�eȝqU�����Q%�Q�R!yЧ���XF��R�4�`Dɫne�gZ�9m�I힕5�Һ\u9y���j����En����"H�t�	�rzTC�f��s���~�lr���l��2�)��������`�ĥŋL.��<�h�Z&�m:�6���kx�f�8��O��o��H�-]��<�?p��7���v��,�|��?M�Ǳ�w�cw Nw`���t��{܍k�,�,�~V��~?�W??Ȓ���M����cDPܮ�W����j��t@������t�#��uկ�����-���(�|?��w�
��:[s�G��X��)y�ݥ_���#m���M+zmz�,�Vkyx�p;2�4�x1��T&�\���p,��|�ʢL(�Jb��;�b���fum=�]��	=�e+s�����!7�襘H�ٲ��>n����Z2�h�4�1����x�jmuB3�U��e�"������+Gy���5�s�#�NZ���U��3�QK�=#��NHbX�Y�$]���"�4O[��j���Y�\U���/��ߺÈ�9,�BL��XDb��[D��tS~� �}Z��u�r�J/l@6@	���+4��!wH�d������K��<��� D"ij�#W>��iJ�i1�s�3��A��������-Do���A��5��*kj��H�����7��}�`*F���a�C���y��-��c`����H�H;��l����)_?��lmv~No���p���+?�5O{�p}@�ҧᵂ�������{���ƍ$���˞s�h �Jh� 
�x�V/z1��?�e/f��1�^���c7")Q$]%|ڇ��T���������(���P1�0LmM�Q���,�@4T�D!4]�R�|*�cS3#U�w�
!��Mlw����Uk�����.-܃FgG��S�!A�L��vt@Y��e�Mz��zi�3�_@!�,v�a\&Rg��Wi4�@�����ph��P��2������/?�o��!t�a m��7Tl��TH�����B݅�y)�sp%�pFr�}�$�^��!{�Ӕ)��KY'!b��;��{�z���n/3��UoQkU�&�wL��C7��Ye	
�G6n��Vc��!ُ�Me�B�?�c&�����)�
�U�X	��(*����U�Brٔ�i����Z������a�U�T�����t�+�`�'�{ػ���Q��m�Z��ЀH����J�8���`�*!�28�����y�BҦ�|,wt�u(�abb�޹�UL�h��.��@wټ1C��a�6���Yq�;��������K���ƧP�9���4i���d����6��Љ% �~��zmr��T �߸Y����"���4ƅL��>=5ԩ�ְQ�I�7둗b��^E�]F�&�yT�~�2��\�AG��O�c��~Di����ba鴶^4bvXP'�CDw�'Б,���w�R�:y�4\E���c�RN�X�޶�W�I�1$��c��C��g6:�#>�9g��99u�M�t���w+J���[&d�>�U����&[����x6�,ZN��L�u�B|{�G�s�F^�i�]��Di�T,�B��mӫ�C+�b���:O��4���I�Z��
�X��㌼�aRͰ�q��~�-�VG[!MlԎ�b��	�N�`=݆,��8$�C�;������ꬋ]��!N�U��z�	k��ޑ���6ul�
���xW�zYaS� ��>
g�X4�s����_�}LN=iRE+�b���Eݙ�hU��ώ��3BgeX�ҴX���&W/��Q�v떝�Z��L+I�xmL�F�5��M|:�    �����i�G$,i��};��+�b�rw�$�u�W���θq�Mz2�VS��
�HӞ5|�{r�f8@*1� ��_X�W,d���G���I��|+dc�瘷�5(ތ�����A� .����kv����	����M=�bs��ȅ��,i�'�3�p�5^;D?4ޘ�Tb����G��^���I�p��zh5�+<���}��?>5�r��FL ��#�i���VX�,~����'�Hdvt%-t�ն�dbL��L�.��T"n\Kv[S�x�V����^T�B)��WN�x��|��[�=��(������S�����V�V��\�0��}U;���O��9)b�L��°D6|��UUBڒ��V���䞝&S��ޘ&��o����ܴӴΞ��aJS5}��r� e���=q����a֤[!ML�^��d�;�p�7�^��*\amxEZCo�E4�5p�9���
��qh�mӫ�d�1I/	֠ȕ-t�����:�
/�|Mjn�4ѡ���8;:E�ݠ:e
�}Z�ݫ��X!�RL��@r�Hv��'�d���ts�K|�����21|�쏵~�i`�pp_4)���1����Xd��Ի��x.+~����6�Z)�ߋ��A���a�K��<{U�������M�+�o@9�\�D^|^Px��$����Bd)9�����0X����zb�z�
�_��d)�U����g��R���?nii�R���x"�(�n���_�U�4.��*�Τ�J᭲Ԑƒ�h@$Q7��@ķ6&
�^u�v��[��a�d����[�oYlaK�S	�8�&��I�>��[m|���ɵRU��oF2L5`^���[=9 k����P�q]�x),U�D��QT�(��*��wC���J!�
h����.='�0�V_���}>��3�mG;��ݬ��P���J���y�q��k�^
9ŵL*��.���K㳼h{+�(K!�RC�T���*�/�d!�lq�+���ʓ�m4lI���&ၜ�iƅt�m���L�C�������]��x���1�=�r?��m*�T�;�>�j˗ �� �2��Y��`	f�6�zU��R$C� ��<Tm�+&V�F��Ԫ#�\Hj�"zrT��TMm�
���<m���OK��&s�`L	
)B�"W]�y�$�����T��(
������͊2e&�`qX5]GX�cCb4��ę��Q��GA�c����	U�,�q���z3���&�}���ʔ���aj����N��)K0�H�˸�j���6��'Iqdf�T8,�r�����k%m�tdW�M����c3*.'1-{�S�k8|�|�8��}���c{��w�ݐ�����_{�d����F6�\��}�ȹ��/a͝�<g�L���sX!�P�_��k�
�+/!��o�b��M��|3�eD�UU�pa��-��M�[�9P�d�d�`C�_�h���ʸ�hM��v��~��0P�t��~�R��q��I㒄�qq��� �훂��aD�b�����t����4"��f k��������:��9H閛AX�(h���ﴷ�t��d�ODuĖ&Jր�,�D�n��y /z;�F��ܓIEV<=�L���ؓ9�b�7�%��f �{��i�Gno�`q'�}�;(+���Y�S0�#M�R�r�evu�`A&ۇ��!�m��G�
�,�����87C��I��õ�����e6I�HAj0Xj�@��A��E3'K-H3�zOJ�_��ҁ��udVM-C��,��L,X`�z98�ϳ���f���:2NU3�R�	�}�s۱m4ڠ`��c��:��K��-�)2���Ĳ�f���/
��|A���Xxs\��B����]�!�ۇ_\羸Q7:a<.�V��ʝ`Y�s�Fۙ���X��TT,��%ԩ,�"M��|�/_��W������4,̤�;Zu~�pR��%�4:��`
��E������r��?g���v���S�0#��|��iAX�I��l_F�.Y�I��ոêAa��F�����K\��/|^7�'��VɒK�}xnp�F9�,��� �&�%S�����p��n<V(��(6��X|I��E�44O�_+�"�C�U�"�c��{����D,ĤܫWW(s�m ����wK>M�P���|�����4<����\[w$ܽj�X�Q�ɻ�k�e�����������BN
��7�jq��,ݤ�q�e���Y�ICC���'Ոb��L�[�1����tE�헅��=�v�]�p��~5���K3)꣩۹���;l7c�H��}�F+L��L:�ix�)V���t,��zZ�Va/�H"kQN���zط�N#�&D:��B��3�
�t�$"��-�-��7Q���Ԯ�@H0���5����1��N@%�Bܔv`�U��H�"K�	�ێt�v��a7�I��4�q�U�Q�����@5��V���u���D�������t���Euh�!��0��NI��L/����@H�d��<�����w���XV�r9�ܽ�͎��ψ�nK�C����2�m���L�iq���&�kR!�2 �R5?-�<x3�H�a��_�&+7x;�,�,OOތ&�md�uK��"�nҿ/�t��NI�Ƞ}E�u�vt�jL"ᤄ1�CSkB�F1�`��~j��
G��U�Ь�t�9>�Y�6G"�������4Xt)�� ��tXrE�uZ�sb�u�äѵ��"}�R���4�._w�z��N2BwA'�r��.|��Xk�g#L���M(��f���@�����Q0��M_�5l0�������`_f�(�6�p*�ŧ���d�9(�M���7{*
�,��j��Y��)�?��c0a���aߌ��f9$ow?�Ȑ�#��]��C�v5�3��"�-�:�s���5r�B�n��E�)L�'$#ܷ�擻o{Β:�C�	��ܓ�����@��+��3L3jJ��ۄ��06��ͬl�%�߮?oS�ꆣ7�F*������G'e�7�^i�k���O�R��J6����[��[�1qVM�و�=�R��q����e�7��a7c��f���y\*�M4-[n��~���2��sp-�����pj���[�ڲߝd�nI��8Ć���y�wn�׊�f������K���Vx�MeH���ݦ[��o�MB���y�f�(T��T�~�	�͍�7/!~��d��r�����j����Zf���MѲ���:*K}�XF �g�s�4~lzmˬ��̷̥���Dì������ڭk;V�z�e=>�X}<�ބ(:e[��P��[m���-VLx&�qm�m�*o��q�k�4�½YղMGg�U�^ϙ�1�l"�&��֯�ffױF���
�5�[�-{���NA�s�������-��-�%p�Q��<�-R|n��)~�o�U�_�	����o+��5-����+o-���_�~���Xl#T�^��3.ճt~���z�W�-�R�_��m�m���EV�"�
.�x'@"=�Dv6����vC>j�T@V,��^��fn������T�ukIk3X�����SK��x�B�D)zǜ���M���K��^8����(��o����JG��d�����V��2��A-�C+W�������w��/j%���7en	���M\����>h��;�k_�Q���m��oS���v��Fkԭh��3�5JJ?`R�q�� �5���B�M0ܷ�F4�o^��M�.9�����l�JÉox��+K�"Ko$Q~Dc�:��� *ZK-���l+Y��@s��E9�$�;�"��j*�NTx�c�t��KK"�Y/���N!/�_ֲߩ.Kh�LJ�+�����YB��PLMM��yn��n��#Ro��R6�w3�Og���~i��WnI��6��g���Z�'P$֒�<�������+����{Q�"�G{i�~ܹo:�f�t�r�^/)�.|��y�q�U0�k{����YJ�NɎ9����P@<`:'	_��8
��.2wq�I�M������9ּ�ٯ�(�L��Kߠ=o��$jY���U�`{��� �
  K���D4���FWl����W���Z|��բ��p_�d�"h�Ng�&����x?��
��+�z�̝1.@z��ke��K5�3�&o�gP�.�6��X^�t�`MАx�X~
�����$䯁)f
&�-��2ƌ�,�+��A*�T7��{H�W�K�b�e�j���L�TË�U��8Jh��3C�Z! +�P�}��ԔР���}��D� ,�m�z<m�V=&�}K�_��R�7�͡�Kv���5����2���{�����f�\&,�SK��%,��!���Y�<<Ti�X���W8%�����j1X��>��S/V�������1J��픢}��c��?^�nc:��de%�)ך)p�v�#K��,X�8J�Jq�(8
��[�;N	#8Ӳ]��%�D�]��n�ʘ�E"tWӖ��O���Ӻܯ`ɝ)�L����N��:ٍ���ݑ�}����7 ��l�}Ӛᤷ6]�f�"2��M�ؖ�ZK����Y���]8C�a%Y�j��d@�{7�1���3���nE@V�	� ���#�\"I��.Lz}�1�Ąf�̑{|�p!�l����&��J�x�:�}�G��n���QP	�|�?0�WP�G�������28��_	L��F(��,���
$�섂����}l�L&L�Ė��}S����P-{6���U���xSyY�o^\���� ��)X|��x�kGIZ��rU1 ���	��W"�Mʰ� "����'N�q�t(P�i]ӝ(�QVt&���q4�M5��;�J"�S��4���*G!H��a$��I�B���W��R���n`�׻f�g��!��H ��-�?,3� ^7K�B��w�)���܎�;=��n�Ȁ���c����B́��!�n��yn��"8�$>�b�b���e;�6x^�N9�p���}7lj�5�i4�"~äB�-�ܣG�{M��W��Q�H���)rI~�XFǂ`pzW;&�U�lt@ɥ8��];O���k���#�9P}�����OW�Z�+��ۑ ]�pn�I�}��v�(�#$��� ����Ĺ��"$�cX`\DHn�)�sӸ(�X�O"����]�v�s��v�ɾ:�H�+���iĄ|��\I�L��s�ܼ𾝪�k��������D���x��䳱�!~>���?��s��~6Kd�h�t��ql`F����%jI�����Q_A��D`V��J���=}pEI�c�3�\��|��8�٤}.A��'3�5&g��D������ z6g���<�I�l%ξw((9����n�&!���o�O��m+�%ޅ	'f�*6�23�ջif�g$�M��1\��\ !g�J��CB�{�0�tcK�C�!�%Df7����=��L���'��ۡ,V+��r~͇��V�܃�[jw�L^��Xq0N�w�I¾y{��6H�!�3Ȫ�@�͐�w��.���O_�򨷭Cy7ʗ�Է�=r�Ĭ� \B}1W˼"�9P�r���� D$K��W��f��Z�h����y�\�T��C�x��J�y�����d�����:o�>�Qgr���*
ܘq�`"�)���0�	�nx������DJ�H)��m�4�N��2^l�^���1�q:����QP�@E��g�'�f�<Y`�gސ%]�^�̍���43'x��1e�%���[t[�2�<�"~[5ڔ�0'}[9X[r�_��K�W�2�8�x��+�-Śr(�j(��Kq���
��Ԯ d@8���=> ��}(P��7��0B��D��h@,.g�A�y޸�W���\��}e���>D�kX%�L�|�������ʸ�f"ݢ^�R���t��� K_�h��PPA��æ�H�� JҠ�=M���-R
����?�f�"e@����.��1��w̄� ���O[�;�\@u�3�
�!��*aP��a�����(9������3Қe�3H��r)nGˁָ�Y=>�D���֌���{w��v���,���U�=.X�w�5���`����v�U�5=���p�㇕=�"��<>��B|,S>�)��*������,2 }:�6GX�P�&��Np���+�Y��y�c��� � ܿ�
�}�6��I�Qzf�.����4�di�n\�( a<פ@H�Y�f��=s^;��oA��B9u�\T��<���(8W7���������LȾ������p���Wѕ<��3�wQ�1yYDWg��FJ�����6�w/����g��%��2�;R�#�j�ɭ����>U�v@<���ͭ�d$|����7�Q�j:������(��j�3p\���4e�0� ���n�/�ul(�6�pSɟ6e�c�Rn���<n�t�ծ���h|��'�S�0�d�v�z�o���Ϲ��#m�I'��FY�Я|T������V��_����ϔ����_���3@~dn���z|VI������DX��N;]	�����#����w`u��5`^�q�n�.��褅�Jq����(.������j �#������@6�_������ׂ��v�ٷr�8�ޓl�l_F��п����"� '��ok��}�y��/������y�OC��i�t������Hp�n�	�s9?;���u��?�?J�3m      �      x������ � �             x������ � �            x������ � �            x������ � �            x������ � �         �  x���Y��H��{��E�d�JV3��}qAe����y�K��LO��89�� h���ǃXC0>�~�G.�����z����/�sh�l��1�4�|]�<�Nľ�Y�����C�Щ�M����h3.��j	�N��'�Щo�,��w�5��?W�[A@m4���Z�����9k�x�gGH\j�:q� �'�i���hO(���s��B��N�X����������c�j�z��s�������EW�O⼤��v��Vd�sw�\㥠����\"�O2�_��9���JZ��'�&Ԝ&��C�:���A[Ba4��Xײa�4C��R16�9��/g���M����w��D���hJ"E�,!P�zhG9��s�r�7��N��У��#����n�2,���*m����X}Y�yjbd��-��"�*��	۝9�Yz~�J*���A�WXW&6]�%�c�0���V�e��H�o8�g�{�D��׃�g��4*W1��b%�i�k+�6����3���t�k�3��a>��p�!ez�yYTɎ�Xoy���0~�>�L�nteY���W�S3}����� Y5	W�IJ��Y�e��,aU�A}bxT�:J�q�P�o8=\;ޞ�8�4wt8.8������w"��|и��}�gi�n�Y��$����
�I�%e��D�}�H��l���21d�L�9��3p{�ə�����#<���3���z���y�䛈o9_�x?��!��5�����6uZ�����#\��	�n�&'�Ag-N�s�}Q�ⱳü���au��A��)
o�,=�����>>�0	����[�/]�y�n�Agq��tv��yU����8���Yf�n���銇}�%���*5���S�B���ee�C�.�{��}���s�*>&���������(�Q��L�P�<�a�P�9�mi�k��$	˯ �cVy��ې��[���E�,Mb��7�ZufDz�!/��,�UŞ�>���)_�cV�7�U��T��W4�`rwu�1e�-tM�}�4�84zg�
k�@���o�D���ӭr�AR)vY����q�mA�
�S���5cZ,v�}�o��?o��o���[�t��,�F���A�����=��P�K��%�|��u��5�������'�˪�     