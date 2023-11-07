create table if not exists professor(
    id serial,
    name varchar(30) not null,
    escola_id int not null,
    constraint pk_professor primary key(id),
    constraint escola_professor_fk foreign key (escola_id) references escola(id)
);
