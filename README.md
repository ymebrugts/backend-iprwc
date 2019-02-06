# Api

How to start the Api application
---
## Prerequisites
Needs Java 8
Use database_script.sql to create database first

## Instructions
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

## Running in IntelliJ IDEA

To run the API directly from IntelliJ instead of the terminal:

1. Open **Run → Edit Configurations…**.
2. Click **`+` → Application** and create a new configuration:
   - **Name**: `ApiApplication`
   - **Main class**: `nl.iprwc.ApiApplication`
   - **Program arguments**:
     ```
     server config.yml
     ```
   - **Use classpath of module**: `backend` (or your main module name).
   - **JRE**: Select **Java 8 (JDK, not JRE)**.
3. Set up the required **environment variables**:
   - Click the `...` button next to *Environment variables*.
   - Add each variable separately:
     ```
     DB_USER=postgres; DB_PASSWORD=postgres; DB_URL=jdbc:postgresql://localhost:5432/postgres
     ```
4. Apply the configuration and click **Run** ▶️.
5. Verify the application is running:
   - API: <http://localhost:8080/api/>
   - Health check: <http://localhost:8081/healthcheck>  
