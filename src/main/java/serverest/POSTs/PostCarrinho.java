package serverest.POSTs;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONArray;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import serverest.resources.VarsCarrinho;
import serverest.resources.VarsProduto;

@Getter
@Setter
public class PostCarrinho {

	public static String URI = "http://localhost:3000";
	public static String message;

	@SuppressWarnings("unchecked")
	public static void adicionarCarrinho() {

		VarsProduto item = new VarsProduto();
		VarsCarrinho carrinho = new VarsCarrinho();

		item.setIdProduto("BeeJh5lz3k6kSIzA");
		item.setQuantidade(10);
		JSONArray produto = new JSONArray();
		produto.add(item);
		carrinho.setProdutos(produto);

		RestAssured.defaultParser = Parser.JSON;

		Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON).relaxedHTTPSValidation()
				.header("Authorization", PostLogin.authorization).body(carrinho).when().post(URI + "/carrinhos").then()
				.contentType(ContentType.JSON).extract().response();
		JsonPath jsonPathEvaluator = response.jsonPath();
		message = jsonPathEvaluator.get("message");

	}
}