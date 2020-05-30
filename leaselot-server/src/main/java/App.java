import io.javalin.Javalin;

public class App {

  public static void main(String[] args) {
    Javalin app =
        Javalin.create(
                config -> {
                  // Enable CORS for all origins.
                  config.enableCorsForAllOrigins();
                  // Enable extensive development logging for HTTP and websocket requests.
                  config.enableDevLogging();
                })
            .start(Integer.parseInt(System.getenv("SERVER_PORT")));
  }
}
