create table item_produto (
	produto_id int not null,
	categoria_id int not null,
	nome varchar(100) not null,
	descricao text not null,
	preco decimal(10, 2) not null,
	estoque int not null,
	primary key (produto_id, categoria_id),
	foreign key (categoria_id) references categoria(categoria_id)
);
