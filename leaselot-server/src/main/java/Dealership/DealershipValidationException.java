package Dealership;

public class DealershipValidationException extends Exception {
  private String message;

  public DealershipValidationException(String message) {
    super(message);
    this.message = message;
  }
}
