import Config.SessionConfig;
import io.javalin.Javalin;

public class App {

  public static void main(String[] args) {
    //    MongoDatabase db =
    //        MongoConfig.getMongoClient()
    //            .getDatabase(Objects.requireNonNull(System.getenv("MONGO_DB_NAME")));
    //
    //    /** ******************** CONTROLLERS *************************** */
    //    DealershipController dealershipController = new DealershipController(db);

    Javalin app =
        Javalin.create(
                config -> {
                  // Enable CORS for all origins.
                  config.enableCorsForAllOrigins();
                  // Enable extensive development logging for HTTP and websocket requests.
                  config.enableDevLogging();
                  // Set session handler to link to Mongo db.
                  config.sessionHandler(
                      () -> {
                        try {
                          return SessionConfig.getSessionHandlerInstance();
                        } catch (Exception e) {
                          System.err.println("Unable to establish session store.");
                          e.printStackTrace();
                          System.exit(1);
                          return null;
                        }
                      });
                })
            .start(Integer.parseInt(System.getenv("SERVER_PORT")));

    /** *************** Dealership Controller Routes *************** */
    //    app.post("/enroll-dealership", dealershipController.enrollDealership);
  }
}
