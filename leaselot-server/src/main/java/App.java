import Config.MongoConfig;
import com.mongodb.client.MongoDatabase;
import io.javalin.Javalin;

import java.util.Objects;

public class App {

  public static void main(String[] args) {
    MongoDatabase db =
        MongoConfig.getMongoClient()
            .getDatabase(Objects.requireNonNull(System.getenv("MONGO_DB_NAME")));

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
