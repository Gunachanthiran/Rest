package pack;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

public class Sample {
@Test(enabled = false)
public void getAllUser() {
	io.restassured.response.Response a = RestAssured.get("https://reqres.in/api/users?page=2");
	System.out.println(a.getBody()); //to get Response body
	int act = a.getStatusCode(); // to get Status code
	Assert.assertEquals(act, 200);
	System.out.println(a.time()); // to get Response time
	System.out.println(a.asString()); // to get response body date in the form of string
}
@Test(enabled = false)
public void getUsers() {
//	given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
	given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]", equalTo(7));
	System.out.println(given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all());
}
@Test(enabled = false)
public void getSingleUser() {
	given().get("https://reqres.in/api/users/7").then().statusCode(200).log().all();
	
}
@Test(enabled = false)
public void createUser() {
	JSONObject js = new JSONObject();
	js.put("name", "Guna");
	js.put("job", "Tester");
	System.out.println(js.toJSONString());
	given().body(js.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
	
	
}
@Test(enabled = false)
public void UpdateUser() {
	JSONObject js = new JSONObject();
	js.put("name", "Jhony");
	js.put("job", "Developer");
	System.out.println(js.toJSONString());
	given().body(js.toJSONString()).when().put("https://reqres.in/api/users/7").then().statusCode(200).log().all();
}
@Test(enabled = true)
public void Delete() {
	given().delete("https://reqres.in/api/users/7").then().statusCode(204).log().all();
}
}
