package pack;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

public class Trelloboard {
	String id;
@Test(enabled = true, priority = 1)
public void Createboard() {
	RestAssured.baseURI = "https://trello.com/";
	Response rep = given().queryParam("name", "ggboard")
			.queryParam("key", "3fb66ca94e444a1b6cbd0171c19d0e71")
			.queryParam("token", "ATTAcf514e1cb953930a6291ed33641fdc51c03fc63a6fda6f4134911949f0506a808B409B42")
			.header("Content-type", "json/application")
			.when().post("/1/boards/").then().statusCode(200).contentType(ContentType.JSON).extract().response();
	JsonPath jpath = new JsonPath(rep.asString()); // get response as string
	System.out.println(jpath);
	id = jpath.get("id");
	System.out.println(id);
}
@Test(enabled = true, priority = 2)
public void DeleteBoard() {
	RestAssured.baseURI = "https://trello.com/";
	given().queryParam("name", "ggboard")
	.queryParam("key", "3fb66ca94e444a1b6cbd0171c19d0e71")
	.queryParam("token", "ATTAcf514e1cb953930a6291ed33641fdc51c03fc63a6fda6f4134911949f0506a808B409B42")
	.header("Content-type", "json/application")
	.when().delete("/1/boards/"+id).then().statusCode(200).contentType(ContentType.JSON).log().all();
}
}
