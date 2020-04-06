# Spring Boot OAuth2

### About

This is an example project that illustrates creating a RESTful API in Spring Boot.

#### Runnning this project

`mvn spring-boot:run`

### Get token
```
curl -X POST --user 'hendisantika:secret' -d 'grant_type=password&username=hendisantika@example.com&password=password' http://localhost:8000/oauth/token
```

### Example commands

#### Getting all people from the API:

```
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -H "Authorization: Bearer $TOKEN" -X GET http://localhost:8000/oauth/people
```

LICENSE

The code is released under the Apache License 2.0. See LICENSE for details.