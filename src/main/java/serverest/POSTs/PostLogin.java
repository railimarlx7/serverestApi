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
import serverest.resources.VarsLogin;

@Getter
@Setter
public class PostLogin {

	public static String URI = "http://localhost:3000";
	public static String message;
	public static String authorization;

	@Test
	public static void usuarioLogin(String email, String senha) {

		VarsLogin login = new VarsLogin();

		login.setEmail(email);
		login.setPassword(senha);

		RestAssured.defaultParser = Parser.JSON;

		Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON).relaxedHTTPSValidation()
				.body(login).when().post(URI + "/login").then().contentType(ContentType.JSON).extract().response();
		JsonPath jsonPathEvaluator = response.jsonPath();
		message = jsonPathEvaluator.get("message");
		authorization = jsonPathEvaluator.get("authorization");

	}
}