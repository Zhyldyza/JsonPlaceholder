import config.Testconfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static constans.Constans.Actions.PLACEHOLDER_GET3;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;

import static constans.Constans.Actions.PLACEHOLDER_GET4;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Assertion extends Testconfig {

    public String baseURI = "https://jsonplaceholder.typicode.com/";
    @Test
     public void stringAssertionGetSingleElements() {
        Response response =
                given().queryParam("postId", 1).log().uri().//check name
                        when().get(baseURI + PLACEHOLDER_GET4);
        //System.out.println("response --->" + response.asString());

        Map<String, ?> someObject = response.
                path("find{it.name = 'id labore ex et quam laborum'}");
        System.out.println("some object --->" + someObject);
    }

    @Test
    public void getAllElements(){
        Response response =
                given().queryParam("postId", 1).log().uri().//check name
                        when().get(baseURI + PLACEHOLDER_GET4);
        System.out.println(response);
        // List users = response.
         //       path("find{it.id = '1'} ");
        //System.out.println("some object --->" + users);
    }

        /**given().queryParam("postId",1).contentType(ContentType.JSON). //check postId
                when().get(baseURI+PLACEHOLDER_GET4).
                then().body("id",equalTo(1));

        given().queryParam("postId",1).contentType(ContentType.JSON).//check email
                when().get(baseURI+PLACEHOLDER_GET4).
                then().body("email",equalTo("Eliseo@gardner.biz"));

        given().queryParam("postId").contentType(ContentType.JSON).//check body
                when().get(baseURI+PLACEHOLDER_GET4).
              then().body("body", equalTo("laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium"));
**/

  }
}
