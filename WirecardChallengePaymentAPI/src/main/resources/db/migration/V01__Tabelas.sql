create table clientes (

	id_cliente bigserial not null,
	nome varchar(80) not null,
	cnpj varchar(30) not null,
	
	constraint clientes_pkey primary key(id_cliente)

);

create table vendas(

	id_venda bigserial not null,
	status varchar(80) not null,
	datadavenda date not null,
	
	constraint vendas_pkey primary key(id_venda)

);

create table cartoesdecredito (

	id bigserial not null,
	nomeNoCartao varchar(50) not null,
	bandeira varchar(20) not null,
	numero varchar(20) not null,
	validade date not null,
	limite decimal(10, 2) not null,
	limiteUtilizado decimal(10, 2) not null,
	limiteDisponivel decimal(10, 2) not null,
	cvv int not null,
	status varchar(50) not null,
	
	primary key(id)

);

create table compradores(

	id_comprador bigserial not null,
	nome varchar(50) not null,
	cpf varchar(20) not null,
	email varchar(80) not null,
	id_venda integer,
	
	primary key(id_comprador),
	constraint vendas_pkey foreign key(id_venda) REFERENCES vendas

);

create table contas (

	id_conta bigserial not null,
	codbanco integer not null,
	tipo integer not null,
	agencia varchar(20) not null,
	numero varchar(20) not null,
	id_cliente bigserial,

	primary key(id_conta),
	constraint clientes_pkey foreign key(id_cliente) REFERENCES clientes

);

create table contatosclientes (

	id_contato_cliente bigserial not null,
	email varchar(80) not null,
	telefonefixo varchar(20) not null,
	telefonemovel varchar(80) not null,
	id_cliente bigserial,
	
	primary key(id_contato_cliente),
	constraint clientes_pkey foreign key(id_cliente) REFERENCES clientes

);


create table enderecosclientes (

	id_endereco_cliente bigserial not null,
	rua varchar(80) not null,
	cidade varchar(30) not null,
	uf varchar(2) not null,
	pais varchar(30) not null,
	numero integer not null,
	complemento varchar(200) not null,
	id_cliente bigserial,
	
	primary key(id_endereco_cliente),
	constraint clientes_pkey foreign key(id_cliente) REFERENCES clientes

);

create table pagamentos(

	id_pagamento bigserial not null,
	tipo integer not null,
	status varchar(50) not null,
	valor decimal(10,2) not null,
	id_venda integer,
	id_cartao integer,
	
	primary key(id_pagamento),
	constraint vendas_pkey foreign key(id_venda) REFERENCES vendas,
	constraint cartoes_pkey foreign key(id_cartao) REFERENCES cartoesdecredito

);





