# Quarkus-Learning-Apps
Quarkus
Quarkus is supersonics and Subatomic
Supersonic: Executable JAR is fast to run, only compile required class
Subatomic: Executable JAR is small
-It takes less memory and faster startup time as compared to Spring Boot.
-Live reload is feature of quarkus faster than spring boot.
-It is developed by RedHat, and it is open source.
-We can create both Imperative and Reactive Programming.
-Quarkus was created to enable Java developers to create applications for a modern, cloud-native world. 
-Quarkus is a Kubernetes-native Java framework tailored for GraalVM and HotSpot, crafted from best-of-breed Java libraries and standards.

Quarkus Application
-Contains Docker Container ready files folder already.
To Run:
•	mvn quarkus:dev  (Maven Installed)
•	.\mvnw quarkus:dev (Maven Not Installed)
To Add Dependency with Command:
•	.\mvnw quarkus:list-extensions (list of all extensions)
•	.\mvnw quarkus:add-extension -Dextensions="quarkus-smallrye-openapi" (to add a extension from list)
-Resource act as a Controller

Sample code:
@GET
@Produces(MediaType.TEXT_PLAIN) //Type of data returned
public Response getMobile(){
    return Response.ok(mobileList).build();
}

@POST
@Consumes(MediaType.TEXT_PLAIN) //Accept data as text
@Produces(MediaType.TEXT_PLAIN)
public Response addMobile(String mobileName){
    mobileList.add(mobileName);
    return Response.ok(mobileName).build();
}

Path Parameter:
@Path("/{mobileName}")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public Response editMobile(@PathParam("mobileName") String mobileName){
    return Response.ok(mobileName).build();
}
Localhost:8080/v1/vivo
Query Parameter:
@Path("/{mobileName}")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public Response editMobile@QueryParam("newMobileName") String newMobileName){
    return Response.ok(newMobileName).build();
}
Localhost:8080/v1?oppo
RestClient:
to use the REST Client to interact with REST APIs. REST Client is the REST Client implementation compatible with Quarkus REST
•	Add dependency in POM “quarkus-rest-client”
•	Consider which External API is required
•	Create Resource related to our reequipments to fetch details by using 3rd party API i.e. External API
•	Create Interface for the requirements of Methods.
•	Create Implementation Class and declare in Interface. This Class needs to be registered with RegisterRestClient.
•	Artifact id used for rest client, quarkus-resteasy-client


CORS (Cross-Origin Resource Sharing):
Example CORS configuration
The following example shows a complete CORS filter configuration, including a regular expression to define one of the origins.
quarkus.http.cors=true 
quarkus.http.cors.origins=http://example.com,http://www.example.io,/https://([a-z0-9\\-_]+)\\\\.app\\\\.mydomain\\\\.com/ 
quarkus.http.cors.methods=GET,PUT,POST 
quarkus.http.cors.headers=X-Custom 
quarkus.http.cors.exposed-headers=Content-Disposition 
quarkus.http.cors.access-control-max-age=24H 
quarkus.http.cors.access-control-allow-credentials=true 


















