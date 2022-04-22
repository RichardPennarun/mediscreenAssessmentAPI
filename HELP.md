## MediscreenAssessmentApi

An API service that will return the patient assessment
 
Input is a patient with its notes fullfilled.
Out put is the same patient with its attribute assessment filled

API exposed port : 8083


##### Prerequisites
- Java 11
- SpringBoot 2.5.5
- Docker


##### Running App
Please download : 
https://github.com/RichardPennarun/mediscreenAssessmentAPI/archive/refs/heads/main.zip

Open a terminal window, go to the root folder and run this 2 lines in this order :
- docker build -t mediscreenassessmentapi .
- docker run --name mediscreenassessmentapi -d -p 8083:8083 mediscreenassessmentapi


##### Testing
The app has a Jacoco test coverage of 96 %