package Dealer;

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
    return this.dealershipId;
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

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Dealer {");
    sb.append("id=").append(id);
    sb.append(", username=").append(username);
    sb.append(", hashedpassword=").append(hashedPassword);
    sb.append(", dealerType=").append(dealerType);
    sb.append(", dealership_id=").append(dealershipId);
    sb.append("}");
    return sb.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Dealer dealer = (Dealer) o;
    return Objects.equals(id, dealer.id)
        && Objects.equals(username, dealer.username)
        && Objects.equals(hashedPassword, dealer.hashedPassword)
        && Objects.equals(dealerType, dealer.dealerType)
        && Objects.equals(dealershipId, dealer.dealershipId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, hashedPassword, dealerType, dealershipId);
  }
}
