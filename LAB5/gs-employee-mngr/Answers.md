# TQS LAB5
### 1 a) Identify a couple of examples on the use of AssertJ expressive methods chaining.

We can identify an example of the use of AssertJ expressive methods chaining in the file `EmployeeRepositoryTest.java` in the method `givenSetOfEmployees_whenFindAll_thenReturnAllEmployees`:
```
assertThat(allEmployees).hasSize(3).extracting(Employee::getName).containsOnly(alex.getName(), ron.getName(), bob.getName());
```
We can also identify the use of expressive methods chaining in the file `EmployeeServiceImplUnitTest` in the method `given3Employees_whengetAll_thenReturn3Records`:
```
assertThat(allEmployees).hasSize(3).extracting(Employee::getName).contains(alex.getName(), john.getName(), bob.getName());
```
### 1 b) Identify an example in which you mock the behaviour of the repository (and avoid involving a database).

We can identify an example in which we mock the behaviour of the repository (and avoid involving a database) in the file `EmployeeServiceImplUnitTest.java`. In the method `setUp` we can see that we instruct the employee repository mock to return a certain value when a specific operation is called, not involving the database:
```
Mockito.when(employeeRepository.findByName(john.getName())).thenReturn(john);
Mockito.when(employeeRepository.findByName(alex.getName())).thenReturn(alex);
```

### 1 c) What is the difference between standard @Mock and @MockBean?

The standard @Mock anotation is used in test classes to mock the behaviour of a certain class so we can use the mock stub to return values for its methods and verify if they were called.

The @MockBean anotation is used by Spring Boot to add mock objects to the application context. The mock will replace any existing bean of the same type in the application context.This annotation is useful in integration tests where a particular bean – for example, an external service – needs to be mocked. 

### 1 d) What is the role of the file “application-integrationtest.properties”? In which conditions will it be used?

This file defines all the properties necessary for the integration test to work, like the datasource url, username, password and other important information. This file will be used by integration tests in this case to connect to the database involved int this test.