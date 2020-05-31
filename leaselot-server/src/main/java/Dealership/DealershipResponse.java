package Dealership;

import org.json.JSONObject;

public enum DealershipResponse {
  HASH_FAILURE("HASH_FAILURE"),
  DUPLICATE_DEALERSHIP("DUPLICATE_DEALERSHIP"),
  DUPLICATE_DEALER("DUPLICATE_DEALER"),
  SUCCESS("SUCCESS");

  private String status;

  DealershipResponse(String status) {
    this.status = status;
  }

  public String toJSON() {
    JSONObject json = new JSONObject();
    json.put("status", this.status);
    return json.toString();
  }
}
