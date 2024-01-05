--delete from Ingredient_Ref;
--delete from Taco;
--delete from Ingredient;
--delete from Taco_User;

--insert into Ingredient (id, name, type)
--    values ('FLTO', 'Flour Tortilla', 'WRAP');
--
--insert into Ingredient (id, name, type)
--    values ('COTO', 'Corn Tortilla', 'WRAP');
--
--insert into Ingredient (id, name, type)
--    values ('GRBF', 'Ground Beef', 'PROTEIN');
--
--insert into Ingredient (id, name, type)
--    values ('CARN', 'Carnitas', 'PROTEIN');
--
--insert into Ingredient (id, name, type)
--    values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
--
--insert into Ingredient (id, name, type)
--    values ('LETC', 'Lettuce', 'VEGGIES');
--
--insert into Ingredient (id, name, type)
--    values ('CHED', 'Cheddar', 'CHEESE');
--
--insert into Ingredient (id, name, type)
--    values ('JACK', 'Monterey Jack', 'CHEESE');
--
--insert into Ingredient (id, name, type)
--    values ('SLSA', 'Salsa', 'SAUCE');
--
--insert into Ingredient (id, name, type)
--    values ('SRCR', 'Sour Cream', 'SAUCE');

insert into Taco_User (id, username, password, fullname, street, city, state, zip, phone_number)
    values ('1', 'user' , '$2a$10$ROojOvHLrHFNWlmuaM90VuwUhlunQpLyn.7ZokCx1y9Q3wNFBQHky',
        'Bob Krasinsky', 'Sunny Blvd. 25', 'Los Angeles', 'California', 'CA', '123456789');
