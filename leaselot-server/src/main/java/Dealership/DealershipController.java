package Dealership;

import Dealer.Dealer;
import Dealer.DealerController;
import Dealer.DealerType;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import io.javalin.http.Handler;
import org.bson.types.ObjectId;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

public class DealershipController {
  private MongoDatabase db;

  public DealershipController(MongoDatabase db) {
    this.db = db;
  }

  public Handler enrollDealership =
      ctx -> {
        JSONObject req = new JSONObject(ctx.body());
        String username = req.getString("username");
        String password = req.getString("password");
        String dealershipName = req.getString("dealershipName");

        if (DealershipController.dealershipIsEnrolled(db, dealershipName)) {
          ctx.json(DealershipResponse.DUPLICATE_DEALERSHIP.toJSON());
          return;
        }
        if (DealerController.usernameExists(db, username)) {
          ctx.json(DealershipResponse.DUPLICATE_DEALER.toJSON());
          return;
        }

        Argon2 argon2 = Argon2Factory.create();
        char[] passwordArr = password.toCharArray();
        String passwordHash;
        try {
          passwordHash = argon2.hash(10, 65536, 1, passwordArr);
          argon2.wipeArray(passwordArr);
        } catch (Exception e) {
          argon2.wipeArray(passwordArr);
          ctx.json(DealershipResponse.HASH_FAILURE.toJSON());
          return;
        }

        Dealer dealer =
            new Dealer()
                .setUsername(username)
                .setHashedPassword(passwordHash)
                .setDealerType(DealerType.ADMIN);

        Dealership dealership =
            new Dealership()
                .setAdminId(dealer.getId())
                .setName(dealershipName)
                .setEmployees(new ArrayList<ObjectId>());

        MongoCollection<Dealership> dealerships = db.getCollection("dealerships", Dealership.class);
        dealerships.insertOne(dealership);

        DealerController.insertDealer(db, dealer);

        ctx.json(DealershipResponse.SUCCESS.toJSON());
      };

  // Returns whether or not the dealership has been enrolled.
  public static boolean dealershipIsEnrolled(MongoDatabase db, String dealershipName) {
    MongoCollection<Dealership> dealerships = db.getCollection("dealerships", Dealership.class);
    Dealership enrolledDealership = dealerships.find(eq("name", dealershipName)).first();

    return enrolledDealership != null;
  }
}
