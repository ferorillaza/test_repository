import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestClass {

  @Test
  public void Test1(){
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
