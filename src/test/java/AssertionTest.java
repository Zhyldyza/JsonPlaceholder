import config.Testconfig;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;


import static constans.Constans.Actions.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AssertionTest extends Testconfig {

    public String baseURI = "https://jsonplaceholder.typicode.com/";
    public String baseURI2 = "https://3f306ecd-38e6-443b-99d6-bc43a002e08c.mock.pstmn.io/"; //mock api postman

        @Test
        public void getAllElements(){
            given().queryParam("postId", 1).contentType(ContentType.JSON).log().uri().
                        when().get(baseURI + PLACEHOLDER_GET4).
                        then().
                        body(   "[0].id", is(1),
                                "[0].name" , containsString("id"),
                                "[0].email", is("Eliseo@gardner.biz"),

                                "[1].id", notNullValue(),
                                "[1].name", endsWith("m"),
                                "[1].email",not("Eliseo@gardner.biz"),
                                "[1].body",notNullValue(),

                                "[2].id", notNullValue(),
                                "[2].name", endsWith("i"),
                                "[2].email",notNullValue(),
                                "[2].body",startsWith("q"),

                                "[3].id", greaterThan(2),
                                "[3].name",containsStringIgnoringCase("ALIAS"),
                                "[3].email",endsWith("v"),
                                "[3].body",startsWithIgnoringCase("Non"),

                                "[4].id", lessThanOrEqualTo(5),                         //validate fields
                                "[4].name", containsString("vero"),
                                "[4].email",containsStringIgnoringCase("hayden@althea.biz"),
                                "[4].body",notNullValue()).log().body();

        }

        @Test
        public void getNullResponse(){

            given().contentType(ContentType.JSON).log().uri().
                    when().get(baseURI2+PLACEHOLDER_GET_NULL).
                    then().statusCode(200).log().all().
                    body(isEmptyString()).log().all();
        }

    }
