# Secret Santa Manager

API for generating a Secret Santa for a list of team members.
The list will be returned in readable String format or in JSON for use with other applications.

## Rules
* A person cannot be their own Secret Santa
* A person can only be the same other person’s Secret Santa once every three years (​​e.g. if in 2020 Martin was Julia's Secret Santa, Martin cannot again be  Julia's Secret Santa before 2023)
* Each person will be assigned to one Secret Santa

## Running the application

### Using Docker:

From the directory secret-santa-manager/ where Dockerfile is located run the following command:

```bash
docker build -t secret-santa-docker .
```

The to run the application:

```bash
docker run -p 9090:8080 secret-santa-docker
```

The application will then be running on port 9090.

### As a Spring Boot App:

Download the project to your local machine and run as a Spring Boot app using your favourite IDE. The application runs on port 8080.

### Using JAR:

The JAR file is available in the target folder. The JAR must be run using Java 11. 

```bash
java -jar secret-santa.jar
```

The application runs on port 8080.


## Postman Collection

Availale in the following path: [secret-santa-manager\src\main\resources](https://github.com/darrenflannery/secret-santa-manager/tree/main/secret-santa-manager/src/main/resources)

Endpoints:

* Save Team Member (/secretsanta/save)
* Get All Team Members (/secretsanta/getall)
* Delete Team Member (/secretsanta/delete/{1})
* Create Secret Santa List (/secretsanta/workmagic/{year})

## Create Secret Santa List

### Input
You pass a selected year to the endpoint.

The application applies a set of logic that does not allow a Team Member to have the same Secret Santa they have had in the last 3 years.

### Output
The output is available as a readable list of Strings in the following format:

![Alt text](secret-santa-manager/src/main/resources/img/ReadableOutput.png?raw=true "Output")

It is also available in JSON format if you want to call the API from a different application.

## Data
The data is stored in a H2 relational database. When the application is started up there is sample data loaded from a script (data.sql).

## OpenAPI Specification

http://localhost:8080/swagger-ui/index.html

## Future Development

1. Improve testing.
2. Make improvements in situations where a list cannot be gernerated because of too many contraints by removing the 3 year rule after a certain amount of retries.

