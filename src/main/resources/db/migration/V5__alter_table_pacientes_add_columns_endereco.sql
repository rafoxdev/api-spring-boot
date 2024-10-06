alter table pacientes add(
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    numero varchar(20),
    complemento varchar(100),
    cidade varchar(100) not null,
    uf char(2) not null
);