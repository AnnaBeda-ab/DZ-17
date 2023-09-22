## DZ-17
robot_dreams school / QA automation course / SummaryProject

## GOALS:
* to practice Java in API testing, in Web testing, making connection with Data Base
* to practice JMeter as a tool for performance testing:

  ***JDBC connection configuration***

  ***JDBC request and assertions***

  ***http(s) requests and assertions***

  ***use User Defined variables, Random Defined variables, Authorization manager***
   
  ***generate script and make report from CLI***

  
* to use frameworks and libraries:  

     ***rest-assured***  

     ***jackson-databind***

     ***lombok***

     ***hamcrest-all***

     ***jdbi***

     ***mariadb-java-client***

     ***allure-testng***


* to config CI via Jenkins 

## PREPARED STEPS:
1. Documentation:

   https://docs.kanboard.org/v1/api/

   https://kanboard.org/
2. Run application in Docker local:

     >  Use docker-compose.yml file with settings

     >  In CLI:  > docker compose up -d
3. Set up the database connection (according to settings stated in docker-compose.yml)
4. In browser:  **http://localhost**

## DESCRIPTION:
Project structure:
   - api 

*src/test/java/api/methods* - methods according to the documentation were described;

*src/test/java/api/models* - models of the bodies of the requests/response were described
(make use of jackson-databind library);

*src/test/java/api/steps* - operations/actions which can be done with certain fitures were described;

  - JMeter

*src/jmeter/Kanboard.jmx* - Test Plan for JMeter

*src/jmeter/report* - reports

*src/jmeter/results.csv* - log file


  - dataBase 
---
  
Also were used: 
- DataProvider, Enums, .properties file to set up instance values.
---
[Check lists](https://docs.google.com/spreadsheets/d/1dEFOxDdhsESWJs13W222L29Cau8j4bGsqRF6ycRWqeY/edit?usp=sharing)

---
[Screenshots of the reports](https://github.com/AnnaBeda-ab/DZ-17/blob/88a286e16dd0ff441649e5741a195585120298e8/src/images)

---
[JMeter report](https://github.com/AnnaBeda-ab/DZ-17/blob/78cab8ca1c08e1b5b1dbc3493fa39bc6e0a3af8d/src/jmeter/report/index.html)

## RUNS AND REPORTS:
In CLI: 

> > mvn clean test
> 
> > mvn clean test -Papi_testng
>

> > allure generate allure-results
> 
> > allure serve allure-results 

> > jmeter -n -t "Kanboard.jmx" -l "results.csv" -f -e -o  "report" -f
>
> > jmeter -g "results.csv"  -o  "report" -f
> > 
> > N.B. File "Kanboard.jmx" is in the directory ../jmeter/bin and run the command from here
