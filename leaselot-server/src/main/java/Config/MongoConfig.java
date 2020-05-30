package Config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.Objects;

/*
A Singleton class that establishes one MongoClient with a connection to the Leaselot cluster.
*/
public class MongoConfig {

  private static MongoClient client;

  // Establish a connection to the client. Use a POJO codec that can read into and write from Java
  // classes.
  private static void startConnection() {
    if (System.getenv("MONGO_URI") == null) {
      throw new NullPointerException(
          "Please use https://github.com/Ashald/EnvFile to configure the .env file");
    }

    ConnectionString connectionString =
        new ConnectionString(Objects.requireNonNull(System.getenv("MONGO_URI")));

    // CodecRegistry needs to be configured to to include a codec to handle the translation to and
    // from BSON.
    CodecRegistry pojoCodecRegistry =
        CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());

    // Add the default codec registry, which contains all of the default codecs, as well as the POJO
    // codec registry.
    CodecRegistry codecRegistry =
        CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

    MongoClientSettings clientSettings =
        MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .codecRegistry(codecRegistry)
            .build();

    client = MongoClients.create(clientSettings);
  }

  // Returns the MongoClient. Establishes a connection if there currently is not one.
  public static MongoClient getMongoClient() {
    if (client == null) {
      startConnection();
    }
    return client;
  }

  // Closes the MongoClient connection to the cluster and destroys the client.
  public static void closeConnection() {
    client.close();
    client = null;
  }
}
