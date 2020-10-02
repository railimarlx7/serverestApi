package serverest.POSTs;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import serverest.resources.VarsNovoUsuario;

@Getter
@Setter
public class PostUsuario {
	public static String URI = "http://localhost:3000";
	public static String message;
	public static String _id;

	@Test
	public static void adicionaUsuario(String nome, String email, String senha) {

		VarsNovoUsuario novoUsuario = new VarsNovoUsuario();

		novoUsuario.setNome(nome);
		novoUsuario.setEmail(email);
		novoUsuario.setPassword(senha);
		novoUsuario.setAdministrador("true");

		RestAssured.defaultParser = Parser.JSON;

		Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON).relaxedHTTPSValidation()
				.body(novoUsuario).when().post(URI + "/usuarios").then().contentType(ContentType.JSON).extract()
				.response();
		JsonPath jsonPathEvaluator = response.jsonPath();
		message = jsonPathEvaluator.get("message");
		_id = jsonPathEvaluator.get("_id");

	}
}