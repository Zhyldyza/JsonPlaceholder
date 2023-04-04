import config.Testconfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;


import static constans.Constans.Actions.PLACEHOLDER_GET2;
import static constans.Constans.Actions.PLACEHOLDER_GET4;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Assert extends Testconfig {

    public String baseURI = "https://jsonplaceholder.typicode.com/";
    @Test
    public void getAllElements(){
                given().queryParam("postId", 1).contentType(ContentType.JSON).log().uri().
                        when().get(baseURI + PLACEHOLDER_GET4).
                        then().
                        body("[0].id", is(1),
                                "[0].name" , containsString("id"),
                                   "[0].email", is("Eliseo@gardner.biz"));

                given().queryParam("postId", 1).contentType(ContentType.JSON).log().uri().
                        when().get(baseURI + PLACEHOLDER_GET4).
                        then().
                        body("[1].id", notNullValue(),
                                "[1].name", endsWith("m"),
                                "[1].email",not("Eliseo@gardner.biz"),
                                "[1].body",notNullValue());

                given().queryParam("postId", 1).contentType(ContentType.JSON).log().uri().
                        when().get(baseURI + PLACEHOLDER_GET4).
                        then().
                        body("[2].id", notNullValue(),
                                "[2].name", endsWith("i"),
                                "[2].email",notNullValue(),
                                "[2].body",startsWith("q"));

               given().queryParam("postId", 1).contentType(ContentType.JSON).log().uri().
                        when().get(baseURI + PLACEHOLDER_GET4).
                        then().
                        body("[3].id", greaterThan(2),
                                "[3].name",containsStringIgnoringCase("ALIAS"),
                                "[3].email",endsWith("v"),
                                "[3].body",startsWithIgnoringCase("Non"));

                given().queryParam("postId", 1).contentType(ContentType.JSON).log().uri().//login uri
                    when().get(baseURI + PLACEHOLDER_GET4).
                    then().
                    body("[4].id", lessThanOrEqualTo(5),                         //validate fields
                                "[4].name", containsString("vero"),
                                "[4].email",containsStringIgnoringCase("hayden@althea.biz"),
                                "[4].body",notNullValue()).log().body();
        }

    }
