DROP TABLE IF EXISTS public.superhero_power;

CREATE TABLE IF NOT EXISTS public.superhero_power
(
    superhero_id integer NOT NULL,
    power_id integer NOT NULL,
    PRIMARY KEY(superhero_id, power_id),
    CONSTRAINT fk_power_id FOREIGN KEY (power_id)
        REFERENCES public."power" ("id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_superhero_id FOREIGN KEY (superhero_id)
        REFERENCES public."superhero" ("id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)