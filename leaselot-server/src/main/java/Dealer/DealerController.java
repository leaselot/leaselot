package Dealer;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.eq;

public class DealerController {
  private MongoDatabase db;

  public DealerController(MongoDatabase db) {
    this.db = db;
  }

  public static boolean usernameExists(MongoDatabase db, String username) {
    MongoCollection<Dealer> dealers = db.getCollection("dealers", Dealer.class);
    Dealer dealer = dealers.find(eq("username", username)).first();

    return dealer != null;
  }

  public static void insertDealer(MongoDatabase db, Dealer dealer) {
    MongoCollection<Dealer> dealers = db.getCollection("dealers", Dealer.class);
    dealers.insertOne(dealer);
  }
}
