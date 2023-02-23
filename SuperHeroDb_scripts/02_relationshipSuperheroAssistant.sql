ALTER TABLE public."assistant" ADD hero_id integer;

ALTER TABLE public."assistant" ADD CONSTRAINT fk_assistant_hero_id
FOREIGN KEY (hero_id) REFERENCES public."superhero" ("id") ON DELETE CASCADE ON UPDATE NO ACTION;
