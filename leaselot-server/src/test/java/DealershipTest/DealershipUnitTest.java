package DealershipTest;

import Dealership.Dealership;
import Dealership.DealershipValidationException;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DealershipUnitTest {

  @Test
  public void nullDealershipNameThrowsExceptionTest() {
    DealershipValidationException dve =
        assertThrows(
            DealershipValidationException.class,
            () -> {
              Dealership dealership =
                  new Dealership(null, new ObjectId(), new ArrayList<ObjectId>());
            });

    String expectedMessage = "Dealership name is null.";
    assertEquals(expectedMessage, dve.getMessage());
  }

  @Test
  public void nullObjectIdThrowsExceptionTest() {
    DealershipValidationException dve =
        assertThrows(
            DealershipValidationException.class,
            () -> {
              Dealership dealership = new Dealership("name", null, new ArrayList<ObjectId>());
            });

    String expectedMessage = "Admin ID is null..";
    assertEquals(expectedMessage, dve.getMessage());
  }

  @Test
  public void nullEmployeeListThrowsExceptionTest() {
    DealershipValidationException dve =
        assertThrows(
            DealershipValidationException.class,
            () -> {
              Dealership dealership = new Dealership("name", new ObjectId(), null);
            });

    String expectedMessage = "Employee list is null.";
    assertEquals(expectedMessage, dve.getMessage());
  }

  @Test
  public void oneNullEmployeeThrowsExceptionTest() {
    DealershipValidationException dve =
        assertThrows(
            DealershipValidationException.class,
            () -> {
              List<ObjectId> employees = new ArrayList<ObjectId>();
              employees.add(new ObjectId());
              employees.add(null);
              employees.add(new ObjectId());
              Dealership dealership = new Dealership("name", new ObjectId(), employees);
            });

    String expectedMessage = "Employee list contains null employee.";
    assertEquals(expectedMessage, dve.getMessage());
  }

  @Test
  public void validDealershipDoesNotThrowException() {
    assertDoesNotThrow(
        () -> {
          List<ObjectId> employees = new ArrayList<ObjectId>();
          employees.add(new ObjectId());
          employees.add(new ObjectId());
          Dealership dealership = new Dealership("name", new ObjectId(), employees);
        });
  }
}
