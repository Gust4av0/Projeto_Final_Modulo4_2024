-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 20/11/2024 às 14:59
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `mestredagrelhafinal`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `audit_preco_item`
--

CREATE TABLE `audit_preco_item` (
  `audit_id` int(11) NOT NULL,
  `produto_id` int(11) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  `data_auditoria` timestamp NOT NULL DEFAULT current_timestamp(),
  `preco_antigo` decimal(10,2) NOT NULL,
  `preco_novo` decimal(10,2) NOT NULL,
  `motivo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `audit_preco_item`
--

INSERT INTO `audit_preco_item` (`audit_id`, `produto_id`, `categoria_id`, `data_auditoria`, `preco_antigo`, `preco_novo`, `motivo`) VALUES
(1, 1, 1, '2024-11-20 13:53:19', 14.90, 35.00, 'Alteração no Preço do Produto'),
(2, 1, 1, '2024-11-20 13:55:45', 35.00, 14.90, 'Alteração no Preço do Produto'),
(3, 1, 1, '2024-11-20 13:57:59', 14.90, 35.00, 'Alteração no Preço do Produto'),
(4, 1, 1, '2024-11-20 13:58:12', 35.00, 14.90, 'Alteração no Preço do Produto');

-- --------------------------------------------------------

--
-- Estrutura para tabela `categoria`
--

CREATE TABLE `categoria` (
  `categoria_id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `categoria`
--

INSERT INTO `categoria` (`categoria_id`, `nome`, `descricao`) VALUES
(1, 'Sal de Parrilha', 'O sal de parrilla é ideal para temperar carnes antes ou durante o preparo na grelha.'),
(2, 'Farofas', 'Farofas ideais para acompanhar o seu delicioso churrasco.'),
(3, 'Molhos Especiais', 'Molhos preparados para acompanhar o seu delicioso churassco.'),
(4, 'Temperos e Especiarias', 'Temperos e Especiarias para temperar as suas deliciosas peças de carne para seu Churrasco.');

-- --------------------------------------------------------

--
-- Estrutura para tabela `flyway_schema_history`
--

CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `flyway_schema_history`
--

INSERT INTO `flyway_schema_history` (`installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) VALUES
(1, '1', 'create tables', 'SQL', 'V1__create_tables.sql', -50070593, 'root', '2024-11-20 13:24:02', 105, 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `forma_pagamento`
--

CREATE TABLE `forma_pagamento` (
  `forma_pagamento_id` int(11) NOT NULL,
  `descricao` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `item_produto`
--

CREATE TABLE `item_produto` (
  `produto_id` int(11) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `descricao` text NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  `estoque` int(11) NOT NULL,
  `imagem` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `item_produto`
--

INSERT INTO `item_produto` (`produto_id`, `categoria_id`, `nome`, `descricao`, `preco`, `estoque`, `imagem`) VALUES
(1, 1, 'Sal de Parrilha Original Canta Galo', 'Sal de Parrilla, também conhecido como sal entrefino, é muito utilizado nos churrascos argentinos e uruguaios.', 14.90, 10, 'https://images.tcdn.com.br/img/img_prod/1163458/sal_de_parrilla_original_cantagallo_250g_401_1_f2f973da8466dc150dedca51d38a83a3.jpg'),
(2, 1, 'Sal de Parrilla e Chimichurri CantaGallo', 'Traz toda a originalidade e tradição da culinária argentina, que pode ser utilizado tanto no churrasco ou nos preparos do dia a dia.', 15.90, 10, 'https://images.tcdn.com.br/img/img_prod/1163458/sal_de_parrilla_e_chimichurri_cantagallo_250g_639_1_e690732ff60cc83795e40437cc27f591.jpg'),
(3, 2, 'Farofa Crocante Costelinha com Limão', 'A textura crocante é o grande destaque deste produto, proporcionando uma experiência gastronômica única.', 13.90, 10, 'https://images.tcdn.com.br/img/img_prod/1163458/farofa_crocante_costelinha_com_limao_cantagallo_200g_617_1_99a10cd17182ce704e4b83d4cc34a391.jpg'),
(4, 2, 'Farofa Crocante de Costela', 'Nossa farofa é cuidadosamente preparada, combinando pedacinhos crocantes sabor costela, com uma mistura de temperos especiais.', 13.90, 10, 'https://images.tcdn.com.br/img/img_prod/1163458/farofa_crocante_de_costela_cantagallo_200g_621_1_78773b00b6a0faa4fe08eb636e87be8d.jpg'),
(5, 3, 'Molho Barbecue Original', 'O Molho Barbecue Original CantaGallo é ideal para pork ribs (costelinha suína), brisket (peito bonivo), pulled pork (carne de porco desfiada). Pode ser utilizado também como acompanhamento de burgers, fritas e pizzas.', 17.90, 10, 'https://images.tcdn.com.br/img/img_prod/1163458/molho_barbecue_original_cantagallo_200g_489_1_21e920fc5d69a660fc8727928a169d36.jpg'),
(6, 3, 'Molho Chimichurri Tradicional', 'O molho mais tradicional da Argentina também é o melhor amigo do churrasqueiro: o molho chimichurri.', 29.90, 10, 'https://images.tcdn.com.br/img/img_prod/1163458/molho_chimichurri_tradicional_cantagallo_200g_503_1_59f2381187ff5dc1cbe1302e2319901f.jpg'),
(7, 4, 'Alho Frito', 'É feito a partir de dentes de alho frescos e disponibilizados em pequenos flocos fritos, crocantes e dourados.', 12.90, 10, 'https://images.tcdn.com.br/img/img_prod/1163458/alho_frito_cantagallo_50g_471_1_2a4c7704ecc82daf7741fb6d1dec52df.png'),
(8, 4, 'Lemon Pepper', 'O Lemon Pepper CantaGallo 80g é originário dos Estados Unidos, sendo o mais apreciado dos temperos pelos americanos, tendo como base limão e sal, como o próprio nome diz.', 14.90, 10, 'https://images.tcdn.com.br/img/img_prod/1163458/lemon_pepper_cantagallo_80g_479_1_407e616e7e9b53e56214857ac7bd352d.jpg');

--
-- Acionadores `item_produto`
--
DELIMITER $$
CREATE TRIGGER `audit_preco_item` AFTER UPDATE ON `item_produto` FOR EACH ROW begin 
		-- Verifica se o preço foi alterado
		if old.preco <> new.preco then 
		-- insere os dados na tabela de auditoria
		insert into audit_preco_item (
		audit_id,
		produto_id,
		categoria_id,
		data_auditoria,
		preco_antigo,
		preco_novo,
		motivo
		)
		values (
		null,
		new.produto_id,
		new.categoria_id,
		current_timestamp,
		old.preco,
		new.preco,
		'Alteração no Preço do Produto'
		);
		end if;
	end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura para tabela `itens_pedido`
--

CREATE TABLE `itens_pedido` (
  `item_pedido` int(11) NOT NULL,
  `pedido_id` int(11) NOT NULL,
  `produto_id` int(11) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `preco_unitario` decimal(10,2) NOT NULL,
  `total` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `pedidos`
--

CREATE TABLE `pedidos` (
  `pedido_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `data_pedido` timestamp NOT NULL DEFAULT current_timestamp(),
  `forma_pagamento_id` int(11) NOT NULL,
  `valor_total` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `usuario_id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `data_criacao` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `usuarios`
--

INSERT INTO `usuarios` (`usuario_id`, `nome`, `email`, `senha`, `endereco`, `telefone`, `data_criacao`) VALUES
(1, 'Gustavo', 'gustavomarcolin2005@gmail.com', 'f14tomcat', 'Rua José Francisco da Silva 376', '(44) 99880-0700', '2024-11-20 13:46:35'),
(2, 'João da Silva', 'joaosilva@gmail.com', 'ah64apache2012', 'Vila Maria de Jesus', '(44) 99654-0365', '2024-11-20 13:50:11');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `audit_preco_item`
--
ALTER TABLE `audit_preco_item`
  ADD PRIMARY KEY (`audit_id`),
  ADD KEY `produto_id` (`produto_id`,`categoria_id`);

--
-- Índices de tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`categoria_id`);

--
-- Índices de tabela `flyway_schema_history`
--
ALTER TABLE `flyway_schema_history`
  ADD PRIMARY KEY (`installed_rank`),
  ADD KEY `flyway_schema_history_s_idx` (`success`);

--
-- Índices de tabela `forma_pagamento`
--
ALTER TABLE `forma_pagamento`
  ADD PRIMARY KEY (`forma_pagamento_id`);

--
-- Índices de tabela `item_produto`
--
ALTER TABLE `item_produto`
  ADD PRIMARY KEY (`produto_id`,`categoria_id`),
  ADD KEY `categoria_id` (`categoria_id`);

--
-- Índices de tabela `itens_pedido`
--
ALTER TABLE `itens_pedido`
  ADD PRIMARY KEY (`item_pedido`),
  ADD KEY `pedido_id` (`pedido_id`),
  ADD KEY `produto_id` (`produto_id`,`categoria_id`);

--
-- Índices de tabela `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`pedido_id`),
  ADD KEY `forma_pagamento_id` (`forma_pagamento_id`),
  ADD KEY `usuario_id` (`usuario_id`);

--
-- Índices de tabela `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`usuario_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `audit_preco_item`
--
ALTER TABLE `audit_preco_item`
  MODIFY `audit_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `itens_pedido`
--
ALTER TABLE `itens_pedido`
  MODIFY `item_pedido` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `pedido_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `usuario_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `audit_preco_item`
--
ALTER TABLE `audit_preco_item`
  ADD CONSTRAINT `audit_preco_item_ibfk_1` FOREIGN KEY (`produto_id`,`categoria_id`) REFERENCES `item_produto` (`produto_id`, `categoria_id`);

--
-- Restrições para tabelas `item_produto`
--
ALTER TABLE `item_produto`
  ADD CONSTRAINT `item_produto_ibfk_1` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`categoria_id`);

--
-- Restrições para tabelas `itens_pedido`
--
ALTER TABLE `itens_pedido`
  ADD CONSTRAINT `itens_pedido_ibfk_1` FOREIGN KEY (`pedido_id`) REFERENCES `pedidos` (`pedido_id`),
  ADD CONSTRAINT `itens_pedido_ibfk_2` FOREIGN KEY (`produto_id`,`categoria_id`) REFERENCES `item_produto` (`produto_id`, `categoria_id`);

--
-- Restrições para tabelas `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`forma_pagamento_id`) REFERENCES `forma_pagamento` (`forma_pagamento_id`),
  ADD CONSTRAINT `pedidos_ibfk_2` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`usuario_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
