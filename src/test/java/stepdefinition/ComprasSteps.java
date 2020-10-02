package stepdefinition;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import serverest.DELETE.DeleteCarrinho;
import serverest.DELETE.DeleteUsuario;
import serverest.GETs.GetProdutos;
import serverest.POSTs.PostCarrinho;
import serverest.POSTs.PostLogin;
import serverest.POSTs.PostUsuario;
import serverets.test.ValidacaoMensagens;

public class ComprasSteps {
	
	
	@Dado("^que realizo o cadastro de um usuario admin na API com nome: \"([^\"]*)\", email:\"([^\"]*)\", senha: \"([^\"]*)\"\\.$")
	public void queRealizoOCadastroDeUmUsuarioAdminNaAPIComNomeEmailSenha(String nome, String email, String senha) throws Throwable {

		PostUsuario.adicionaUsuario(nome, email, senha);
		
	}

	@Dado("^efetuo o login com email:\"([^\"]*)\", senha: \"([^\"]*)\"\\.$")
	public void efetuoOLogin(String email, String senha) throws Throwable {
		
		PostLogin.usuarioLogin(email, senha);

	}

	@E("^realizo a compra\\.$")
	public void realizoACompra() throws Throwable {
		
		GetProdutos.listarProdutos();
		PostCarrinho.adicionarCarrinho();
		DeleteCarrinho.concluirCompra();
	}

	@E("^excluo o usuario$")
	public void excluoOUsuario() throws Throwable {
		
		DeleteUsuario.excluirUsuario();

	}

	@Entao("^valido as mensagens de cadastro de usuario e de carrinho: \"([^\"]*)\"\\.$")
	public void validoAsMensagensDeCadastroDeUsuarioEDeCarrinho(String mensagensCadastro) throws Throwable {
		
		ValidacaoMensagens.mensagemCadastroUsuario(mensagensCadastro);
		ValidacaoMensagens.mensagemCadastroCarrinho(mensagensCadastro);

	}

	@Entao("^valido as mensagens de exclusão de usuario e de carrinho: \"([^\"]*)\"\\.$")
	public void validoAsMensagensDeExclusãoDeUsuarioEDeCarrinho(String mensagensExclusao) throws Throwable {
		
		ValidacaoMensagens.mensagemFinalizaCarrinho(mensagensExclusao);
		ValidacaoMensagens.mensagemExclusaoUsuario(mensagensExclusao);

	}

}
