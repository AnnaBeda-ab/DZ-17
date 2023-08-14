# DZ-17
robot_dreams school / QA automation course / SummaryProject

TASK:
<link>

PREPARED STEPS:
1. Documentation:
   https://docs.kanboard.org/v1/api/
   https://kanboard.org/
2. Run application in Docker local:
       Use docker-compose.yml file with settings
       In CLI:  > docker compose up -d
3. Set up the database connection (according to settings stated in docker-compose.yml)
4. In browser: http://localhost/dashboard

DESCRIPTION:
Project structure:
   -api
methods src/test/java/api/methods - methods according to the documentation were described;
models src/test/java/api/models - bodies of the requests/response were described
(make use of jackson-databind library);
steps src/test/java/api/steps - operatoins which can be done with certain fitures were described;

  -dataBase 
  
Also were used - dataprovider, enums, .properties file to setup instanse values.

REPORTS:
In CLI:  > allure serve allure-results 

