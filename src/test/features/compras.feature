#language: pt
#utf-8

@serverest
Funcionalidade: Compra de item.
 
  Objetivo: 
  			Realizar o  cadastro de um usuario na API Serverest, fazer a compra de um item, excluir o usuario apos a finalização da compra, 
  			e validar as mensagens de retorno.
  			
  @serverest
  Esquema do Cenário: Mensagens amigavéis do motor de regras do cancelamento.
    Dado que realizo o cadastro de um usuario admin na API com nome: "<nome>", email:"<email>", senha: "<senha>".
    E efetuo o login com email:"<email>", senha: "<senha>".
    E realizo a compra.
    E excluo o usuario
    Entao valido as mensagens de cadastro de usuario e de carrinho: "<mensagensCadastro>".
    Entao valido as mensagens de exclusão de usuario e de carrinho: "<mensagensExclusao>".
   
    Exemplos: 
      | nome      		| email  									| senha 		| mensagensCadastro 							| mensagensExclusao 						| 
      | Raimundo Lima | serverest@serverest.com | serverest | Cadastro realizado com sucesso 	| Registro excluído com sucesso	|