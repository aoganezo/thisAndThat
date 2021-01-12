# thisAndThat /document API

1. Run a `./gradlew clean build`
2. Run the service either via `./gradlew bR`, or however you start your Java applications. It will start on port 8080 by default.
3. Test via postman, or your preferred method of testing APIs. The url is `http://localhost:8080/document`. 
4. Once running you can check available data by connecting to the [h2 console](http://localhost:8080/h2-console/). No password is needed, just hit connect.
5. NOTE: Besides Springboot, this project uses Lombok to make writing getters and setters unnecessary, as well as adds slf4j for access to easy logging.

### Adding a document
1. Use a POST call to `http://localhost:8080/document`
2. Use a JSON body. Sample:
```
{
	"id":1,
	"title":"Document Title",
	"content": "Any content you like."
}
```

### Reading a document
1. Use a GET call to `http://localhost:8080/document/{documentId}`
2. No body is accepted. You can use an id from a created document, or use one of my precreated ones - 10, 20, 30. E.g. you can try [localhost:8080/document/30](http://localhost:8080/document/30) right at startup.


### Assumptions Made
1. Documents are json based with a title and content.
2. No database persistence is required.
3. Requirement of "allow(ing) many callers to read and write documents at the same time without issue." does not imply a need for hosting this. If hosted, there is no reason calls can't be made async.

