**call SOAP webservice where action has to be passed using xml file from w3schools :  https://www.w3schools.com/xml/tempconvert.asmx?wsdl

1/copy xml file into src/ressources/wsdl then do mvn update or mvn clean install to bind xml into java objects (specify the path of package which gonna contains all java classes into pom.xml)

2/ import wsdl (copy url) into soap UI :

![image](https://github.com/user-attachments/assets/31461bcb-afb4-4b74-9265-925385f2c745)

3/test api using postman :

![image](https://github.com/user-attachments/assets/5ddb075f-b701-47a5-8575-44f06011976f)

