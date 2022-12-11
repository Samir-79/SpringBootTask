Installation requirements:
Java JDK 11+ (Recommended Java 17)
Maven
H2-Database
IDE (Recommend Jetbrains Intellij)
Rest Client (Recommend Postman)
--------------------------------

H2-Database:
Access URL: http://localhost:8080/h2
Login:
JDBC URL: jdbc:h2:mem:data
User Name: sa
Password: Leave empty field
Press connect

----------------------------------
Endpoints:
UserController:
1.POST:http://localhost:8080/userinfo/api/users
{
"persNum":188756779959,
"firstName": "John",
"lastName": "Smith",
"email": "jsmith@email.com",
"dateOfBirth":"1988-11-10"
}

2-PUT:http://localhost:8080/userinfo/api/users
{
"persNum":188756779959,
"firstName": "Johnny",
"lastName": "Smith",
"email": "jsmith@email.com",
"dateOfBirth":"1988-11-10"
}

3-GET:http://localhost:8080/userinfo/api/users
4.GET:http://localhost:8080/userinfo/api/users/getById/{id}
5.GET:http://localhost:8080/userinfo/api/users/getByPerNum/{persNum}
6.DELETE:http://localhost:8080/userinfo/api/users/{persNum}


