package serverest.GETs;

import static io.restassured.RestAssured.given;

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
public class GetProdutos {

	public static String URI = "http://localhost:3000";
	public static String produtos;

	@Test
	public static void listarProdutos() {

		RestAssured.defaultParser = Parser.JSON;

		Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON).relaxedHTTPSValidation()
				.when().get(URI + "/produtos").then().contentType(ContentType.JSON).extract().response();
		JsonPath jsonPathEvaluator = response.jsonPath();
		produtos = jsonPathEvaluator.get("produtos").toString();

	}
}
