import config.Testconfig;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static constans.Constans.Actions.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class FirstTest extends Testconfig {

    public String baseURI = "https://jsonplaceholder.typicode.com/";
    @Test
    public void GetPostId(){

        given().queryParam("postId",1).log().uri().//логирование запроса
                when().get(baseURI+PLACEHOLDER_GET4).
                then().log().all().statusCode(200);//логирование ответа
    }


    @Test
    public void GetPostComment(){
        given().log().uri().
                when().get(baseURI+PLACEHOLDER_GET3).
                then().statusLine("HTTP/1.1 200 OK") ;
    }

    @Test
    public void GetPost(){
        given().
                when().get(baseURI+PLACEHOLDER_GET2).
                then().log().body().statusCode(200);
    }

    @Test
    public void Get(){
        given().
                when().get(baseURI +PLACEHOLDER_GET).
                then().log().body().statusCode(200);
    }

    @Test
    public void Put(){

        String putBodyJSON = "{\n" +
                "  \"id\"    : 1,\n" +
                "  \"title\" : \"foo\" ,\n" +
                "  \"body\"  : \"bar\",\n" +
                "  \"userId\": 1\n" +
                "}";

        given().body(putBodyJSON).log().uri().
                when().put(baseURI+PLACEHOLDER_PUT).
                then().log().body().statusCode(200 );
    }

    @Test
    public void Delete(){
        given().log().uri().
                when().delete(baseURI+PLACEHOLDER_DELETE).
                then().log().body().statusCode(200);
    }

    @Test
    public void Post(){

        String postBodyJSON = "{\n" +
                "  \"id\"    : 1,\n" +
                "  \"title\" : \"foo\" ,\n" +
                "  \"body\"  : \"bar\",\n" +
                "  \"userId\": 1\n" +
                "}"
                ;
        given().body(postBodyJSON).log().uri().
                when().post(baseURI+PLACEHOLDER_POST).
                then().log().body().statusCode(201);
    }
}

