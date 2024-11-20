-- Criação da tabela Categoria
create table categoria (
    categoria_id int primary key not null,
    nome varchar(50) not null,
    descricao varchar(255) not null
);

-- Criação da tabela Item Produto
create table item_produto (
    produto_id int not null,
    categoria_id int not null,
    nome varchar(100) not null,
    descricao text not null,
    preco decimal(10, 2) not null,
    estoque int not null,
    imagem varchar(255),
    primary key (produto_id, categoria_id),
    foreign key (categoria_id) references categoria(categoria_id)
);

-- Criação da tabela Audit Preço Item
create table audit_preco_item (
    audit_id int primary key auto_increment not null,
    produto_id int not null,
    categoria_id int not null,
    data_auditoria TIMESTAMP default CURRENT_TIMESTAMP,
    preco_antigo decimal(10, 2) not null,
    preco_novo decimal(10, 2) not null,
    motivo varchar(255) not null,
    foreign key (produto_id, categoria_id) references item_produto(produto_id, categoria_id)
);

-- Criação da tabela Usuários
create table usuarios (
    usuario_id int primary key auto_increment not null,
    nome varchar(100),
    email varchar(100) unique not null,
    senha varchar(100) not null,
    endereco varchar(255) not null,
    telefone varchar(20) not null,
    data_criacao TIMESTAMP default CURRENT_TIMESTAMP
);

-- Criação da tabela Forma de Pagamento
create table forma_pagamento (
    forma_pagamento_id int primary key not null,
    descricao varchar(50) not null
);

-- Criação da tabela Pedidos
create table pedidos (
    pedido_id int primary key auto_increment not null,
    usuario_id int not null,
    data_pedido TIMESTAMP default CURRENT_TIMESTAMP,
    forma_pagamento_id int not null,
    valor_total decimal(10, 2) not null,
    foreign key (forma_pagamento_id) references forma_pagamento(forma_pagamento_id),
    foreign key (usuario_id) references usuarios(usuario_id)
);

-- Criação da tabela Itens Pedido
create table itens_pedido (
    item_pedido int primary key auto_increment not null,
    pedido_id int not null,
    produto_id int not null,
    categoria_id int not null,
    quantidade int not null,
    preco_unitario decimal(10, 2) not null,
    total decimal(10, 2) not null,
    foreign key (pedido_id) references pedidos(pedido_id),
    foreign key (produto_id, categoria_id) references item_produto(produto_id, categoria_id)
);
