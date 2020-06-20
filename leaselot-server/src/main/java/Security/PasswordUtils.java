package Security;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class PasswordUtils {

  public static String hashPassword(String password) throws Exception {
    Argon2 argon2 = Argon2Factory.create();
    char[] passwordArr = password.toCharArray();
    String passwordHash = argon2.hash(10, 65536, 1, passwordArr);
    argon2.wipeArray(passwordArr);

    return passwordHash;
  }
}
