import config.Testconfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.regex.MatchResult;

import static constans.Constans.Actions.*;
import static io.restassured.RestAssured.*;
import static java.util.concurrent.CompletableFuture.anyOf;

public class FirstTest extends Testconfig {

    @Test
    public void GetPostId(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        given().queryParam("postId",1).log().uri().//логирование запроса
                when().get(baseURI+PLACEHOLDER_GET4).// find way how to set variable instead of https address?
                then().log().all().statusCode(200);//логирование ответа
    }

    @Test
    public void GetPostComment(){
        given().log().uri().
                when().get("https://jsonplaceholder.typicode.com/"+PLACEHOLDER_GET3).
                then().statusLine("HTTP/1.1 200 OK") ;
    }

    @Test
    public void GetPost(){
        given().
                when().get("https://jsonplaceholder.typicode.com/"+PLACEHOLDER_GET2).
                then().log().body().statusCode(200);
    }

    @Test
    public void Get(){
        given().
                when().get("https://jsonplaceholder.typicode.com/" +PLACEHOLDER_GET).
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
                when().put("https://jsonplaceholder.typicode.com/"+PLACEHOLDER_PUT).
                then().log().body().statusCode(200 );
    }

    @Test
    public void Delete(){
        given().log().uri().
                when().delete("https://jsonplaceholder.typicode.com/"+PLACEHOLDER_DELETE).
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
                when().post("https://jsonplaceholder.typicode.com/"+PLACEHOLDER_POST).
                then().log().body().statusCode(201);
    }
}

