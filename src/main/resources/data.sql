delete from Taco_Order_Tacos;
delete from Taco_Ingredients;
delete from Taco;
delete from Taco_Order;
delete from Ingredient;
delete from Taco_User;

insert into Ingredient (id, name, type)
    values ('FLTO', 'pszenna', 'WRAP');

insert into Ingredient (id, name, type)
    values ('COTO', 'kukurydziana', 'WRAP');

insert into Ingredient (id, name, type)
    values ('GRBF', 'mielona wołowina', 'PROTEIN');

insert into Ingredient (id, name, type)
    values ('CARN', 'kawałki mięsa', 'PROTEIN');

insert into Ingredient (id, name, type)
    values ('TMTO', 'pomidory pokrojone w kostkę', 'VEGGIES');

insert into Ingredient (id, name, type)
    values ('LETC', 'sałata', 'VEGGIES');

insert into Ingredient (id, name, type)
    values ('CHED', 'cheddar', 'CHEESE');

insert into Ingredient (id, name, type)
    values ('JACK', 'Monterey Jack', 'CHEESE');

insert into Ingredient (id, name, type)
    values ('SLSA', 'pikantny sos pomidorowy', 'SAUCE');

insert into Ingredient (id, name, type)
    values ('SRCR', 'śmietana', 'SAUCE');

insert into Taco_User (id, username, password, fullname, street, city, state, zip, phone_number)
    values ('1', 'user' , '$2a$10$ROojOvHLrHFNWlmuaM90VuwUhlunQpLyn.7ZokCx1y9Q3wNFBQHky',
        'Bob Krasinsky', 'Sunny Blvd. 25', 'Los Angeles', 'California', 'CA', '123456789');
