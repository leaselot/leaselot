package Dealer;

import io.javalin.http.Context;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.Objects;

public class Dealer {
  private ObjectId id;

  @BsonProperty(value = "username")
  private String username;

  @BsonProperty(value = "hashedpassword")
  private String hashedPassword;

  @BsonProperty(value = "dealertype")
  private DealerType dealerType;

  @BsonProperty(value = "dealership_id")
  private ObjectId dealershipId;

  /** **************** GETTERS ********************* */
  public ObjectId getId() {
    return this.id;
  }

  public String getUsername() {
    return this.username;
  }

  public String getHashedPassword() {
    return this.hashedPassword;
  }

  public DealerType getDealerType() {
    return this.dealerType;
  }

  public ObjectId getDealershipId() {
    int x = 5;
    return this.dealershipId;
  }

  public Dealer() {
    this.id = new ObjectId();
  }

  /** **************** SETTERS ********************* */
  public Dealer setId(ObjectId id) {
    this.id = id;
    return this;
  }

  public Dealer setUsername(String username) {
    this.username = username;
    return this;
  }

  public Dealer setHashedPassword(String hashedPassword) {
    this.hashedPassword = hashedPassword;
    return this;
  }

  public Dealer setDealerType(DealerType dealerType) {
    this.dealerType = dealerType;
    return this;
  }

  public Dealer setDealershipId(ObjectId dealershipId) {
    this.dealershipId = dealershipId;
    return this;
  }

  // Sets the session token for this dealer.
  public void setDealerSession(Context ctx) {
    ctx.sessionAttribute("username", this.username);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Dealer {");
    sb.append("id=").append(this.id);
    sb.append(", username=").append(this.username);
    sb.append(", hashedpassword=").append(this.hashedPassword);
    sb.append(", dealerType=").append(this.dealerType);
    sb.append(", dealership_id=").append(this.dealershipId);
    sb.append("}");
    return sb.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Dealer dealer = (Dealer) o;
    return Objects.equals(this.id, dealer.id)
        && Objects.equals(this.username, dealer.username)
        && Objects.equals(this.hashedPassword, dealer.hashedPassword)
        && Objects.equals(this.dealerType, dealer.dealerType)
        && Objects.equals(this.dealershipId, dealer.dealershipId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        this.id, this.username, this.hashedPassword, this.dealerType, this.dealershipId);
  }
}
