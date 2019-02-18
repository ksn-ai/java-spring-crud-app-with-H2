# Spring-boot Angular 7 and H2 Database CRUD Operation Demo App for CISCO

After staring application open http://localhost:8888/ link in browser.
  
```
server.port = 8888

```


Use below User Name and Password :

```


security.user.name=test
security.user.password=test

```

In this app we used H2 in memory database for demo purpose. 



```
spring.datasource.url=jdbc:h2:mem:TEST;MVCC=true;DB_CLOSE_DELAY=-1;MODE=Oracle
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.platform=h2
spring.jpa.hibernate.ddl-auto=none
```

#Available Rest Endpoints

'''
1)-  @RequestMapping(value = "/user/{uid}", method = RequestMethod.GET)
2)-  @RequestMapping(value = "/users", method = RequestMethod.GET)
3)-  @RequestMapping(value = "/user", method = RequestMethod.POST)
4)-  @RequestMapping(value = "user/{uid}", method = RequestMethod.PUT)
5)-  @RequestMapping(value = "user/{uid}", method = RequestMethod.DELETE)
'''
