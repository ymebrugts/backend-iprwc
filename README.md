# Api

How to start the Api application
---
Needs Java 8

1. Run `mvn clean install` to build your application
2. Set up the required environment variables:
   ```
   export DB_USER=postgres
   export DB_PASSWORD=your_secure_password
   export DB_URL=jdbc:postgresql://localhost:5432/postgres
   ```
   (Use `set` instead of `export` on Windows)
3. Start application with `java -jar target/backend-1.0-SNAPSHOT.jar server config.yml`
4. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

How to start the Api application
---

1. Run `mvn clean install` to build your application
2. Start application with `java -jar target/backend-1.0-SNAPSHOT.jar server config.yml`
3. To check that your application is running enter url `http://localhost:8080`
