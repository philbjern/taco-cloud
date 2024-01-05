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

create table if not exists Taco (
    id identity,
    name varchar(50) not null,
    taco_order bigint not null,
    taco_order_key bigint not null,
    created_at timestamp not null
);


create table if not exists Ingredient_Ref (
    ingredient varchar(4) not null,
    taco bigint not null,
    taco_key bigint not null
);

create table if not exists Ingredient (
    id varchar(4) not null,
    name varchar(25) not null,
    type varchar(10) not null
);




create table if not exists Taco_User (
    id identity not null PRIMARY KEY,
    username varchar(50) not null,
    password varchar(150) not null,
    fullname varchar(50) not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state varchar(20) not null,
    zip varchar(20) not null,
    phone_number varchar(13) not null
);