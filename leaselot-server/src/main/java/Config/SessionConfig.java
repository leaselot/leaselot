package Config;

import com.mongodb.MongoClientURI;
import org.eclipse.jetty.nosql.mongodb.MongoSessionDataStoreFactory;
import org.eclipse.jetty.server.session.DefaultSessionCache;
import org.eclipse.jetty.server.session.SessionCache;
import org.eclipse.jetty.server.session.SessionHandler;

import java.util.Objects;

public class SessionConfig {
  private static SessionHandler sessionHandler;

  public static SessionHandler getSessionHandlerInstance() throws Exception {
    if (sessionHandler != null) return sessionHandler;
    sessionHandler = new SessionHandler();

    SessionCache sessionCache = new DefaultSessionCache(sessionHandler);
    sessionCache.setSessionDataStore(
        mongoDataStoreFactory(
                Objects.requireNonNull(System.getenv("MONGO_URI")),
                Objects.requireNonNull(System.getenv("MONGO_DB_NAME")),
                "session")
            .getSessionDataStore(sessionHandler));

    sessionHandler.setSessionCache(sessionCache);
    sessionHandler.setHttpOnly(true);
    sessionHandler.setMaxInactiveInterval(60); // 30 minutes

    return sessionHandler;
  }

  private static MongoSessionDataStoreFactory mongoDataStoreFactory(
      String url, String dbName, String collectionName) {
    MongoSessionDataStoreFactory mongoSessionDataStoreFactory = new MongoSessionDataStoreFactory();
    System.out.println("URI: " + new MongoClientURI(url).getURI());
    mongoSessionDataStoreFactory.setConnectionString(new MongoClientURI(url).getURI());
    mongoSessionDataStoreFactory.setDbName(dbName);
    mongoSessionDataStoreFactory.setCollectionName(collectionName);
    return mongoSessionDataStoreFactory;
  }
}
