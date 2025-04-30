# Weather Information Service Implementation

## Assumptions

- This is a service created only to retrieve weather information (updating or adding weather information is not supported as the requirement stated is to "provide current weather data for different cities (upto 3)").
- It is stated in the guidelines that the weather data can be stored in-memory. So the weather data of 3 cities are hardcoded in the WeatherProviderImpl class, hence will be loaded into memory in the run-time.
- Since it is instructed that it is possible to mock the external weather info REST api request and response, I have mocked the response of that call. (request is implemented writing relevant httpClient implementation code making a request to online available weather API. Authentication of that REST API is not deone, hence the request fails always with 401 error, hence I have mocked a response when the response status code is 401).

## Special Notes

- Only few REST API resources are defined as this is a prototype REST API implementation
- Only single REST API resource (GET /weahther/current/city) is implemented fully too. (others can be implemented if needed)
- Only integration test is written. It tests the implemented REST API operation.
- Java project of the implementation is in "WeatherInfoService" directory in the repository root. (it will be introduced as <PROJECT_ROOT>)

## Abstract Design of the Implementation

![Weather API Diagram](./abstract-design.png)

## Technologies Used

- Java with JAX-RS : This project is an implementation of a JAX-RS REST API.
- Apache CXF: Apache CXF is the web service framework used to implement JAX-RS (REST) APIs
- Spring Dependencies : To configure JAX-RS configurations, Spring libraries are used. Apach CSF is well integrated with Spring and it is using Spring internally.
- Maven : The build automation and dependency management tool (for compiling, testing, packaging, and managing libraries)

## How to Build and Deploy

1. To build the project, run below command from within the <PROJECT_ROOT> dir.

```shell
mvn clean install
```

A war file named WeatherInfoService.war file is created by above build operation in ```target/``` dir

2. Deploy this WeatherInfoService.war file in a preferred web server.
   (I'm testing this in a local tomcat server. The shell scrip used to copy the .war file is uploaded in this git repository. i.e. <REPO_ROOT>/deploy_weatherinfo.sh )

## API Endpoints Invocation

The API Resources exposed by this service are listed below


| HTTP Method | HTTP Request Path            | Description                                          | Query Params                                                  |
| ----------- | ---------------------------- | ---------------------------------------------------- | ------------------------------------------------------------- |
| GET         | /weather/current             | Get current weather by city or coordinates           | 'city' (string) or 'longitude' (string) & 'latitude' (string) |
| GET         | /weather/current/temperature | Get temperature by city or coordinates               | 'city' (string) or 'longitude' (string) & 'latitude' (string) |
| GET         | /weather/forecast            | Get weather forecast by date and city or coordinates | 'city' (string) or 'longitude' (string) & 'latitude' (string) |

- **GET** /weather/current Endpoint is implemented fully with the Query Param 'city' only and can be invoked by a http client as below.

#### Sample Request: (CURL Command)

*Format:*

```js
curl -X GET "http://localhost:8080/WeatherInfoService/weather/current?city=<CITY_NAME>" 
```

*Sample Command:*

```js
curl -X GET "http://localhost:8080/WeatherInfoService/weather/current?city=Auckland" 
```

*Sample Response:*

```json
{"cityName":"Auckland","temperature":15,"precipitation":43,"humidity":33,"windSpeed":26,"dateTime":"2025-01-01T10:00:00Z","longitude":"54","latitude":"43"}
```

### Endpoints Authorization

Endpoints exposed are not protected with any authentication/authorization mechanism.

## Automation Tests

- Integration tests are implemented with the use of Testng
- The maven-surefire-plugin is used to run integration tests during the build process.
  i.e. ```mvn test``` command will run the integration tests on the service deployed in a server and exposed on "https://localhost:8080/"
- So make sure to deploy the server before running tests. (local Tomcat server can be used for this).
- Starting an embedded server when running the tests is also possible, but it is not implemented at this phase.
