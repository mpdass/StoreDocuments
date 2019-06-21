Follow the instructions below to build and run this application by following the steps below:

   1. This project assumes that the gradle, and spring boot setup is available along with the necessary JDK installed.
   2. Run 'gradle -v' in the terminal command prompt to ensure that the setup is ready to use
   3. Either clone the git repository running 'git clone https://github.com/mpdass/StoreDocuments.git' to a convenient work directory
   4. Change directory to 'springboot-documents-store' and perform the following steps
      a. You may be able to run the 'java -jar build/libs/springboot-documents-store-0.0.1-SNAPSHOT.jar' from this directory.
         For some reason if this step fails, then you can build and run the newly generated '*.jar" file as below
      b. gradle build
      c. java -jar build/libs/springboot-documents-store-0.0.1-SNAPSHOT.jar
   5. Run the following curl commands from an another terminal window
      a. curl --header "Content-Type: plain/text" --request POST http://localhost:8080/storage/documents/ --data "Hello World"
201 Created
Content-Type: text/plain; charset=us-ascii Content-Length: 11
FSVI4OPP4O7K4N9CC4J2

      b. curl --request GET http://localhost:8080/storage/documents/FSVI4OPP4O7K4N9CC4J2
200 OK
Content-Length: 11
Hello World

      c. curl --header "Content-Type: plain/text" --request PUT http://localhost:8080/storage/documents/FSVI4OPP4O7K4N9CC4J2 --data "New World O
rder"
204 No Content

      d. curl --request DELETE http://localhost:8080/storage/documents/FSVI4OPP4O7K4N9CC4J2
204 No Content

   6. In its current state only the 'plain/text' data are implemented and tested (for want of time).

====================================================================================================================================================

ASSIGNMENT
==========

INSTRUCTIONS: Please have them deliver the assignment by Tuesday EOD via BOX / attache. Client interviews will be based on the code submitted.

==========================================
Programming Challenge - 

Task Description
• Implement a Java Web Application that meets the specification of the "Document Storage REST Web Service" below.
• Limit the scope to the specification. The only error cases to be aware of are those outlined in the specification.
• The web application should be packaged as a WAR and should run in Tomcat and Java 1.8.
• Documents don't need to be persisted across server shutdown.
• Documents metadata (like file name and size) should be stored in a 'in memory DB'

Implement the below service using Spring Boot & Java 8.

Document Storage REST Web Service Specification
The Document Storage Service is a simple RESTful web service that allows clients to create, update, query, and delete documents.
A document can be anything - text, image, pdf, etc.
POST:
  Request:
    A document can be created by sending a POST request with document contents to /storage/documents.
    The document is simply the HTTP request payload.
    All content types are supported.
  Response:
    The content of the POST response is a unique alphanumeric document ID with a length of 20 characters.
    The HTTP response has a 201 Created status code.
GET:
  Request:
    A document can be queried by sending a GET request to /storage/documents/{docId}, where {docId} is the document ID issued during creation.
  Response:
    The content of the GET response is the document exactly as it was created or last updated.
    On success, a 200 OK response is sent.
    A 404 Not Found HTTP response is returned if the document ID is invalid.
PUT(UPDATE):
  Request:
    A document can be updated by sending a PUT request with document contents to /storage/documents/{docId}, where {docId} is the document ID issued during creation.
    The document is simply the HTTP request payload.
  Response:
    On success, a 204 No Content response is sent.
    A 404 Not Found HTTP response is returned if the document ID is invalid.
DELETE:
  Request:
    A document can be deleted by sending a DELETE request with no content to /storage/documents/{docId}, where {docId} is the document ID issued during creation.
  Response:
    On success, a 204 No Content HTTP response is sent. A 404 Not Found HTTP response is returned if the document ID is invalid.

Summary
Create - POST /storage/documents
Query - GET /storage/documents/{docId} 
Update - PUT /storage/documents/{docId} 
Delete - DELETE /storage/documents/{docId}
 
Examples:

Create

Request:

POST /storage/documents
Content-Length: 11
hello world

Response:
201 Created
Content-Type: text/plain; charset=us-ascii Content-Length: 20
ONWZ4UUVV8S31JCB662P

Query

Request:
GET /storage/documents/ONWZ4UUVV8S31JCB662P

Response:
200 OK
Content-Length: 11
hello world

Update

Request:
PUT /storage/documents/ONWZ4UUVV8S31JCB662P Content-Length: 13
goodbye world

Response:
204 No Content

Delete
Request:
DELETE /storage/documents/ONWZ4UUVV8S31JCB662P

Response:
204 No Content
