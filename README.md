# Secret Santa Manager

API for generating a Secret Santa for a list of team members.
The list will be returned in readable String format or in JSON for use with other applications.

## Rules
* A person cannot be their own Secret Santa
* A person can only be the same other person’s Secret Santa once every three years (​​e.g. if in 2020 Martin was Julia's Secret Santa, Martin cannot again be  Julia's Secret Santa before 2023)
* Each person will be assigned to one Secret Santa

## Running the application

### Using JAR:

TODO: Use the package manager [pip](https://pip.pypa.io/en/stable/) to install foobar.

```bash
java .jar etc.
```

### Using Docker:

TODO: Use the package manager [pip](https://pip.pypa.io/en/stable/) to install foobar.

```bash
java .jar etc.
```
## Postman Collection

Availale in the following path: [secret-santa-manager\src\main\resources](https://github.com/darrenflannery/secret-santa-manager/tree/main/secret-santa-manager/src/main/resources)

Endpoints:

* Save Team Member
* Get All Team Members
* Delete Team Member
* Create Secret Santa List

## Create Secret Santa List

### Input
You pass a selected year to the endpoint.

The application applies a set of logic that does not 

### Output
The output is available as a readable list of Strings in the following format:

![Alt text](secret-santa-manager/src/main/resources/img/ReadableOutput.png?raw=true "Output")

It is also available in JSON format if you want to call the API from a different application.


## OpenAPI Specification
TODO: Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## Logic for generating Secret Santa List
TODO: Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## Future Development

1. Improve testing.
2. Make improvements in situations where a list cannot be gernerated because of too many contraints by removing the 3 year rule after a certain amount of retries.

### Testing
TODO
