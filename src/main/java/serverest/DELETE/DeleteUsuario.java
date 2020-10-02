package serverest.DELETE;

import static io.restassured.RestAssured.given;
import serverest.POSTs.PostUsuario;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteUsuario {
	public static String URI = "http://localhost:3000";
	public static String message;

	@Test
	public static void excluirUsuario() {

		RestAssured.defaultParser = Parser.JSON;

		Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON).relaxedHTTPSValidation()
				.when().delete(URI + "/usuarios/" + PostUsuario._id).then().contentType(ContentType.JSON).extract()
				.response();
		JsonPath jsonPathEvaluator = response.jsonPath();
		message = jsonPathEvaluator.get("message");

	}
}