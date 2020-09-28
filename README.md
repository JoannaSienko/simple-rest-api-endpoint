# Simple REST API endpoint


### Requirements
- Java 11
- Maven
- Docker


### How to run
1. Clone the project
2. Start MySql database using docker:<br>
 ```docker run -p 3306:3306 --name my-sql-db -e MYSQL_ROOT_PASSWORD=abcabc -d mysql```
3. Run the application:<br>
 ```mvn spring-boot:run```


### How to test *
1. Check if there is no record at the beggining:<br>
```curl localhost:8080/demo/viewAll```
2. Add new action*:<br>
```curl localhost:8080/demo/add -X POST -H "Content-Type: application/json" -d "{"userId":1,"gameId":111,"actionDescription":"auth"}"```
3. Add another action*:<br>
```curl localhost:8080/demo/add -X POST -H "Content-Type: application/json" -d "{"userId":1,"gameId":111,"actionDescription":"spin"}"```
4. Check if records appear on the list:<br>
```curl localhost:8080/demo/viewAll```
5. If you want to check the database, start mysql client (password: abcabc):<br>
```docker exec -it my-sql-db mysql -uroot -p```<br>
and then:<br>
```use mysql;```<br>
```select * from action;```

*when using Windows cmd line, escape ```"``` by ```\ ``` in json part of curl, e.g.:<br>
```curl localhost:8080/demo/add -X POST -H "Content-Type: application/json" -d "{\"userId\":1,\"gameId\":111,\"actionDescription\":\"auth\"}"```

### Tutorials used:
1. https://spring.io/guides/gs/accessing-data-mysql/#initial
2. https://springframework.guru/using-docker-to-run-mysql-server-in-your-development-environment/
3.  https://dev.mysql.com/doc/mysql-linuxunix-excerpt/5.6/en/docker-mysql-getting-started.html
