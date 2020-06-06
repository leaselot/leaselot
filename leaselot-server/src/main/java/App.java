import Config.SessionConfig;
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
                  // Session handler
                  config.sessionHandler(
                      () -> {
                        try {
                          return SessionConfig.getSessionHandlerInstance();
                        } catch (Exception e) {
                          e.printStackTrace();
                          return null;
                        }
                      });
                })
            .start(Integer.parseInt(System.getenv("SERVER_PORT")));

    app.get(
        "/",
        ctx -> {
          ctx.sessionAttribute("first", "sessionItem");
          ctx.result("DONE");
        });

    app.get(
        "/sess",
        ctx -> {
          String s = ctx.sessionAttribute("first");
          ctx.json(s);
        });
  }
}
