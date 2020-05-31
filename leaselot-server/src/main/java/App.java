import Config.MongoConfig;
import Dealership.DealershipController;
import com.mongodb.client.MongoDatabase;
import io.javalin.Javalin;

import java.util.Objects;

public class App {

  public static void main(String[] args) {
    MongoDatabase db =
        MongoConfig.getMongoClient()
            .getDatabase(Objects.requireNonNull(System.getenv("MONGO_DB_NAME")));

    /** ******************** CONTROLLERS *************************** */
    DealershipController dealershipController = new DealershipController(db);

    Javalin app =
        Javalin.create(
                config -> {
                  // Enable CORS for all origins.
                  config.enableCorsForAllOrigins();
                  // Enable extensive development logging for HTTP and websocket requests.
                  config.enableDevLogging();
                })
            .start(Integer.parseInt(System.getenv("SERVER_PORT")));

    /** *************** Dealership Controller Routes *************** */
    app.post("/enroll-dealership", dealershipController.enrollDealership);
  }
}
