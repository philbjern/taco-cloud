create table if not exists Ingredient (
    id varchar(4) not null PRIMARY KEY,
    name varchar(35) not null,
    type varchar(10) not null
);

create table if not exists Taco (
    id identity PRIMARY KEY,
    name varchar(50) not null,
    created_at timestamp not null
);

create table if not exists Taco_Ingredients (
    taco_id bigint not null,
    ingredients_id varchar(4) not null
);

alter table Taco_Ingredients
    add foreign key (taco_id) references Taco(id);

alter table Taco_Ingredients
    add foreign key (ingredients_id) references Ingredient(id);

create table if not exists Taco_Order (
    id identity,
    deliveryName varchar(50) not null,
    deliveryStreet varchar(50) not null,
    deliveryCity varchar(50) not null,
    deliveryState varchar(30) not null,
    deliveryZip varchar(10) not null,
    ccNumber varchar(16) not null,
    ccExpiration varchar(5) not null,
    ccCVV varchar(3) not null,
    created_at timestamp not null
);

create table if not exists Taco_Order_Tacos (
    tacoOrder bigint not null,
    taco bigint not null
);

alter table Taco_Order_Tacos
    add foreign key (tacoOrder) references Taco_Order(id);

alter table Taco_Order_Tacos
    add foreign key (taco) references Taco(id);

create table if not exists Taco_User (
    id varchar(4) not null PRIMARY KEY,
    username varchar(50) not null,
    password varchar(150) not null,
    fullname varchar(50) not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state varchar(20) not null,
    zip varchar(20) not null,
    phone_number varchar(13) not null
);