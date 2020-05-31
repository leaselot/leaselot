package Dealership;

import Dealer.Dealer;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Objects;

public class Dealership {

  private ObjectId id;

  @BsonProperty(value = "name")
  private String name;

  @BsonProperty(value = "admin")
  private Dealer admin;

  @BsonProperty(value = "employees")
  private List<ObjectId> employees;

  /** **************** GETTERS ********************* */
  public ObjectId getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public Dealer getAdmin() {
    return this.admin;
  }

  public List<ObjectId> getEmployees() {
    return this.employees;
  }

  /** **************** SETTERS ********************* */
  public Dealership setId(ObjectId id) {
    this.id = id;
    return this;
  }

  public Dealership setName(String name) {
    this.name = name;
    return this;
  }

  public Dealership setAdmin(Dealer admin) {
    this.admin = admin;
    return this;
  }

  public Dealership setEmployees(List<ObjectId> employees) {
    this.employees = employees;
    return this;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Dealer {");
    sb.append("id=").append(this.id);
    sb.append(", name=").append(this.name);
    sb.append(", admin=").append(this.admin);
    sb.append(", employees=").append(this.employees);
    sb.append("}");
    return sb.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Dealership dealership = (Dealership) o;
    return Objects.equals(this.id, dealership.id)
        && Objects.equals(this.name, dealership.name)
        && Objects.equals(this.admin, dealership.admin)
        && Objects.equals(this.employees, dealership.employees);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.admin, this.employees);
  }
}
