import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import java.util.ArrayList; 
import java.util.Map; 

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestClass {

  public static Response response;
  public static String jsonAsString;

  @Test
  public void Test_JSON_Array_Size_Checker_1(){
    response = given()
      .log().all()
      .get("http://jsonplaceholder.typicode.com/todos/")
      .then()
      .log()
      .all()
      .statusCode(200)
      .contentType(ContentType.JSON)
      .extract().response();

    jsonAsString = response.asString();

    ArrayList<Map<String,?>> jsonAsArrayList = from(jsonAsString).get("");
    assertThat(jsonAsArrayList.size(), equalTo(200));
  }

  @Test
  public void Test_JSON_Assert_1(){
    given()
      .log().all()
      .get("http://jsonplaceholder.typicode.com/todos/1")
      .then()
      .log()
      .all()
      .statusCode(200)
      .contentType(ContentType.JSON)
      .body("userId", is(1))
      .body("id", is(1))
      .body("title", is("delectus aut autem"))
      .body("completed", is(false));
  }
}
