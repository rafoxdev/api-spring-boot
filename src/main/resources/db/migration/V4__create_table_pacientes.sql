create table pacientes (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    sobrenome varchar(100) not null unique,
    cpf varchar(11) not null unique,
    email varchar(100) not null,
    telefone varchar(100) not null,
    sexo varchar(1) not null,

    primary key(id)
)