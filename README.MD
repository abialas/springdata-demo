# Spring Data Demo

This project shows usage of Spring Data mainly for JPA Data Store. There is also some code regarding Mongo Data Store but
this data store will be fully covered in another repository.

## Getting Started

Just clone repository and check out how Spring Data JPA can be used to simplify your DAO layer.

## Remarks

Below is a list of problems and solutions which have been detected during implementation

### 1. Problem with loading @Configuration in JUnit
 
Using @DataJpaTest will not load additional @Configuration. To load it in JUnit you have to use @SpringBootTest annotation.
 
```
@Configuration
@EnableJpaRepositories(basePackages = "com.dn.springdata.repo.jpa", namedQueriesLocation = "classpath:jpa-named-queries.properties")
@EnableMongoRepositories(basePackages = "com.dn.springdata.repo.mongo")
public class RepoConf {
}
```
```
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Sql("/data/developers.sql")
public class DeveloperRepositoryTest {

...

}
```

### Create new database structure before each junit

To recreate database structure (slows downs JUnits but before each method clear, new instance of database is used) class or test annotation can be used (along with setting set in application.properties):

```
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
```

and in application.properties add the following line:

```
spring.jpa.hibernate.ddl-auto=create-drop
```

### Not embedded database (like Postgres) and database recreation in JUnits

For embedded database (like H2) default option is set to:
``` 
spring.jpa.hibernate.ddl-auto=create-drop
```
This causes that when DirtiesContext is set to:

```
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
```
	
it recreates database before each test.
For database like Postgres the default option is set to
```
spring.jpa.hibernate.ddl-auto=none
```
This causes that when DirtiesContext is set as above it does not recreate database before each test.
To fix it you have to set it to
```
spring.jpa.hibernate.ddl-auto=create-drop
``` 

### Database

By default Spring Data uses H2 DB (if included in pom.xml). If not and there is no other database then tests will fail 
because Spring cannot create DataSource. Even if we add H2 dependency to pom.xml it can be easily overwritten by e.g. 
Postgres - just add Postgres dependency and set the connection in application.properties (or in profile properties file e.g. test-postgres.properties and set this profile to active).

### NamedQuery missing parameter

When NamedQuery is defined in *.properties file with parameter and in Repository the parameter is missing then exception 
is thrown during Runtime: 

```
in org.hibernate.QueryException: Not all named parameters have been set
```

Same exception occurs when query is defined in Entity NamedQueries and parameter is also missing.

### Query result type and return type of repository method 

The result type must be known because otherwise during Runtime ClassCastException may be thrown
Example:
```
developerRepository.findAverageSalaryForExperienceLevel(ExperienceLevelEnum.SENIOR);
```
In SQL it returns Double but if it is defined in repository like:
```
Iterable<Developer> findAverageSalaryForExperienceLevel(ExperienceLevelEnum experienceLevel);
```
then ClassCastException during Runtime will be thrown:
```
Iterable<Developer> iterable = developerRepository.findAverageSalaryForExperienceLevel(ExperienceLevelEnum.SENIOR);
iterable.iterator().next().getSalary() -> is defined as it returns Developer instance so code compiles without problem
iterable.iterator().next() -> during Runtime this is a Double instance so in above line ClassCastException will be thrown
```

### Check library version Spring Boot

To check which libraries version are used for current Spring Boot Application below command should be executed:
```
mvn dependency:tree -Dverbose
```

### Precedence of query definition
Precedence of query definition (the least important is the first one)
```
1. query from Entity 
2. query from *.properties file 
3. query from @Query annotation
```
It is important to use proper @Query annotation (same exists for Mongo and JPA and compiles without any problem).