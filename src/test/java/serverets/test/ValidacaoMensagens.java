package serverets.test;

import static org.junit.Assert.assertEquals;

import serverest.DELETE.DeleteCarrinho;
import serverest.POSTs.PostCarrinho;
import serverest.POSTs.PostUsuario;

public class ValidacaoMensagens {
	
	public static void mensagemCadastroUsuario(String mensagensCadastro) {
		
		assertEquals(mensagensCadastro, PostUsuario.message);
		
	}
	
	public static void mensagemCadastroCarrinho(String mensagensCadastro) {
		
		assertEquals(mensagensCadastro, PostCarrinho.message);
		
	}
	
	public static void mensagemFinalizaCarrinho(String mensagensExclusao) {
		
		assertEquals(mensagensExclusao, DeleteCarrinho.message);
		
	}
	
	public static void mensagemExclusaoUsuario(String mensagensExclusao) {
		
		assertEquals(mensagensExclusao, DeleteCarrinho.message);
		
	}

}
