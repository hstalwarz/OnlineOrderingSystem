# OnlineOrderingSystem

This codebase simulates a REST API, part of a hypothetical online ordering system - CaptainGrub, created as part of a __Zappos__ recruitment challenge with 3 primary entities:
* Restaurant
* Menu
* Menu Item

The relationships are defined as follows
* Restaurant : Menu -> One to Many
* Menu : Menu Item -> One to Many

The code supports GET, POST and DELETE operations on each of these

### Technologies Used:
* Spring Boot
* JPA (Entity Relationship Management)
* MySQL
* Maven (Dependency Management)
* JUnit/Mockito (Unit Testing)
* Swagger (API Docs)

### Getting Started:
##### Prerequisites:
1. JDK
1. Maven
1. MySQL

##### Set up instructions:
1. Create the MySQL database from the file DBDump.sql present in the root.
1. Update database configuration, in `/captaingrub-restaurant-service/src/main/resources/application.yml`
1. In the command prompt execute `mvn clean package` from inside the `/captaingrub-restaurant-service` directory
1. Navigate to the `/captaingrub-restaurant-service/target` directory.
1. Run `java -jar captain-grub-0.0.1-SNAPSHOT.jar`
1. Try testing an endpoint with the context base /captaingrub. Example: http://localhost:8080/captaingrub/restaurant/location/98105
1. To view the different API contract details, navigate to http://localhost:8080/captaingrub/v2/api-docs (it is recommended to have a JSON Viewer extension in your browser). Alternatively, the contracts can be seen on the Swagger online editor as well: https://editor.swagger.io/ by pasting the contents from the api-docs URL or the contents of the swagger.yml file present at `/captaingrub-restaurant-service/src/main/resources/swagger.yml`.

