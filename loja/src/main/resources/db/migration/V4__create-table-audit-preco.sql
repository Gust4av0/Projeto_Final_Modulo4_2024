--create table audit_preco_item (
--	audit_id int primary key not null,
--	produto_id int not null,
--	categoria_id int not null,
--	data_auditoria TIMESTAMP default CURRENT_TIMESTAMP,
--	preco_antigo decimal (10, 2) not null,
--	preco_novo decimal (10, 2) not null,
--	motivo varchar(255) not null,
--	foreign key (produto_id, categoria_id) references item_produto(produto_id, categoria_id)
--)
