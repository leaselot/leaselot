package Dealership;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Objects;

public class Dealership {

  private ObjectId id;

  @BsonProperty(value = "name")
  private String name;

  @BsonProperty(value = "admin_id")
  private ObjectId adminId;

  @BsonProperty(value = "employees")
  private List<ObjectId> employees;

  public Dealership(String name, ObjectId adminId, List<ObjectId> employees)
      throws DealershipValidationException {
    validateDealershipInputs(name, adminId, employees);
    this.name = name;
    this.adminId = adminId;
    this.employees = employees;
  }

  private static void validateDealershipInputs(
      String name, ObjectId adminId, List<ObjectId> employees)
      throws DealershipValidationException {

    if (name == null) throw new DealershipValidationException("Dealership name is null.");
    if (adminId == null) throw new DealershipValidationException("Admin ID is null.");
    if (employees == null) throw new DealershipValidationException("Employee list is null.");

    for (ObjectId employee : employees) {
      if (employee == null)
        throw new DealershipValidationException("Employee list contains null employee.");
    }
  }

  /** **************** GETTERS ********************* */
  public ObjectId getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public ObjectId getAdminId() {
    return this.adminId;
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

  public Dealership setAdminId(ObjectId adminId) {
    this.adminId = adminId;
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
    sb.append(", admin=").append(this.adminId);
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
        && Objects.equals(this.adminId, dealership.adminId)
        && Objects.equals(this.employees, dealership.employees);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.adminId, this.employees);
  }
}
