package Dealership;

import org.json.JSONObject;

public enum DealershipResponse {
  HASH_FAILURE("HASH_FAILURE", "There was an error hashing the password."),
  DUPLICATE_DEALERSHIP("DUPLICATE_DEALERSHIP", "The provided dealership name already exists."),
  DUPLICATE_DEALER("DUPLICATE_DEALER", "The provided dealer username already exists."),
  SUCCESS("SUCCESS", "Success.");

  private String status;
  private String message;

  DealershipResponse(String status, String message) {
    this.status = status;
    this.message = message;
  }

  public DealershipResponse setStatus(String status) {
    this.status = status;
    return this;
  }

  public DealershipResponse setMessage(String message) {
    this.message = message;
    return this;
  }

  public String toJSON() {
    JSONObject json = new JSONObject();
    json.put("status", this.status);
    json.put("message", this.message);
    return json.toString();
  }
}
