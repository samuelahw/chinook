DROP TABLE IF EXISTS public."superhero";

CREATE TABLE IF NOT EXISTS public."superhero"
(
    "id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "name" character varying(20) COLLATE pg_catalog."default",
    "alias" character varying(20) COLLATE pg_catalog."default",
    "origin" character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "Superhero_pkey" PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS public."assistant";

CREATE TABLE IF NOT EXISTS public."assistant"
(
    "id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "name" character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT "Assistant_pkey" PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS public."power";

CREATE TABLE IF NOT EXISTS public."power"
(
    "id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "name" character varying(20) COLLATE pg_catalog."default",
    "description" character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "Power_pkey" PRIMARY KEY ("id")
);
