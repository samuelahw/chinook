-- Table: public.superhero

-- DROP TABLE IF EXISTS public."superhero";

CREATE TABLE IF NOT EXISTS public."superhero"
(
    "id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "name" character varying(20) COLLATE pg_catalog."default",
    "alias" character varying(20) COLLATE pg_catalog."default",
    "origin" character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "Superhero_pkey" PRIMARY KEY ("id")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."superhero"
    OWNER to postgres;


-- Table: public.assistant

-- DROP TABLE IF EXISTS public."assistant";

CREATE TABLE IF NOT EXISTS public."assistant"
(
    "id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "name" character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT "Assistant_pkey" PRIMARY KEY ("id")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."assistant"
    OWNER to postgres;

-- Table: public.power

-- DROP TABLE IF EXISTS public."power";

CREATE TABLE IF NOT EXISTS public."power"
(
    "id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "name" character varying(20) COLLATE pg_catalog."default",
    "description" character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "Power_pkey" PRIMARY KEY ("id")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."power"
    OWNER to postgres;

