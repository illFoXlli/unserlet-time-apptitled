# Time Servlet App

Simple Java Servlet application that shows the current time for UTC or for a timezone passed in a query parameter.

## Features

- `GET /time` returns the current UTC time.
- `GET /time?timezone=UTC+2` returns the current time for the provided timezone.
- Invalid timezone values return `400 Bad Request` with `Invalid timezone`.
- The time page updates every second in the browser without sending a new request to the server.
- `GET /` opens a simple page with a form for choosing a UTC offset.

## Technologies

- Java 17
- Maven
- Java Servlet API
- JSP
- Apache Tomcat 9

## Project Structure

```text
src/main/java/org/fox/servlet/TimeServlet.java
src/main/java/org/fox/filter/TimezoneValidateFilter.java
src/main/java/org/fox/service/TimeService.java
src/main/webapp/index.jsp
src/main/webapp/time.jsp
```

## How to Build

```bash
mvn package
```

The WAR file will be created in:

```text
target/time-1.0-SNAPSHOT.war
```

## How to Run

Deploy the generated WAR file to Apache Tomcat 9.

After deployment, open:

```text
http://localhost:8080/time
```

Examples:

```text
http://localhost:8080/time
http://localhost:8080/time?timezone=UTC+2
http://localhost:8080/time?timezone=Europe/Kiev
```

Invalid timezone example:

```text
http://localhost:8080/time?timezone=test
```

Expected response:

```text
Invalid timezone
```

with HTTP status code `400`.
