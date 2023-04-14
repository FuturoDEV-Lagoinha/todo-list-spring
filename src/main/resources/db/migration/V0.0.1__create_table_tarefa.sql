create table tarefa(
    id serial,
    nome varchar(20) not null,
    descricao varchar(100),
    data varchar(10) not null,
    hora varchar(5) not null
);