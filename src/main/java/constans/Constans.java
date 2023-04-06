
package constans;
import static constans.Constans.Server.PLACEHOLDER_URL;
public class Constans  {
    //Add path/url/endpoints неизменяемые константы
     public static class RunVariable{
         public static String server = Server.PLACEHOLDER_URL;
         public static String path = "";
    }

    public static class Server{
         public static String PLACEHOLDER_URL = "https://jsonplaceholder.typicode.com/";
    }

    public static class Path{
         public static String PLACEHOLDER_PATH;
    }

    public static class Actions{
         public static String PLACEHOLDER_GET = "posts";
        public static String PLACEHOLDER_GET2 = "posts/1";
        public static String PLACEHOLDER_GET3 = "posts/1/comments";
        public static String PLACEHOLDER_GET4 = "comments/";
        public static String PLACEHOLDER_DELETE= "posts/1";
        public static String PLACEHOLDER_PUT= "posts/1";
        public static String PLACEHOLDER_POST= "posts";

        public static String PLACEHOLDER_GET_NULL = "nullresponse";


    }
}
