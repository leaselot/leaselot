package Dealership;

import Dealer.Dealer;
import Dealer.DealerController;
import Dealer.DealerType;
import Security.PasswordUtils;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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

        String passwordHash;
        try {
          passwordHash = PasswordUtils.hashPassword(password);
        } catch (Exception e) {
          e.printStackTrace();
          ctx.json(DealershipResponse.HASH_FAILURE.toJSON());
          return;
        }

        Dealer dealer =
            new Dealer()
                .setUsername(username)
                .setHashedPassword(passwordHash)
                .setDealerType(DealerType.ADMIN);

        Dealership dealership = null;
        try {
          dealership = new Dealership(dealershipName, dealer.getId(), new ArrayList<ObjectId>());
        } catch (DealershipValidationException dve) {
          ctx.json(DealershipResponse.INVALID_PARAMETER.setMessage(dve.getMessage()).toJSON());
          return;
        }

        MongoCollection<Dealership> dealerships = db.getCollection("dealerships", Dealership.class);
        dealerships.insertOne(dealership);

        DealerController.insertDealer(db, dealer);

        dealer.setDealerSession(ctx);

        ctx.json(DealershipResponse.SUCCESS.toJSON());
      };

  // Returns whether or not the dealership has been enrolled.
  public static boolean dealershipIsEnrolled(MongoDatabase db, String dealershipName) {
    MongoCollection<Dealership> dealerships = db.getCollection("dealerships", Dealership.class);
    Dealership enrolledDealership = dealerships.find(eq("name", dealershipName)).first();

    return enrolledDealership != null;
  }
}
