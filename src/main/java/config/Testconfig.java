package config;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.BeforeClass;

import java.awt.geom.RectangularShape;

import static constans.Constans.RunVariable.server;
import static constans.Constans.RunVariable.path;
public class Testconfig  {
    // предустановка необходимых действий(задается базовы url, path)
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = server ;
        RestAssured.basePath = path;
    }

}
