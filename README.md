# Fundamental Project

_README file for QA fundamental project_

---

## _*Contents:*_
1. *Introduction*
    * Objective
    * Requirements
    * My project overview
2. *Architecture*
    * Overview
    * Frontend
    * Backend 
    * Database
3. *Project Planning*
    * Overview
    * Jira
4. Risk Assessment
5. Testing
6. Known Issues
7. Future Improvements
8. Links and Resources
9. Authors 

#

<br/>
<br/>

## _1. Introduction_
---

<br/>

### Objective
#

The objective for this project was to create a CRUD application utilising all the tools, methodologies and technologies covered in the first 5 weeks of of training, the core of which include:

* Project Management
* Databases
* Java SE
* Spring Boot
* Front-End Development
* Testing
* Cloud Fundamentals

<br/>

### Requirements
#

The minimum requirements for this project are listed below:

* Scrum Board: Jira
* Database: GCP Managed SQL Server
* Backend Programming language: Java
* Frontend Stack: HTML, CSS, Javascript
* Unit and Integration testing: JUnit, Mockito, Spring (MockMvc)
* Version Control: Git

<br/>

### Project Overview
#
For this project I chose to develop a web application which is acts a phonebook. The user is able to store contact information and retrieve the information when needed. The information stored for each contact consists of: their first name, last name, phone number and email address. 

With this app, the user is able to create a new contact, view all contacts, read the information of any particular contact (or group of contacts matching the search parameters), update any field of information pertaining to a contact and delete a contact. The app therefore satisfies all basic CRUD criteria.

<br/>
<br/>
<br/>

## _2. Architecture_
---

<br/>

### Overview
#

The project implements a three-tier architecture, consisting of the presentation layer (the frontend of the application), the business layer (the backend of the application) and the data layer (the database). 

The user interacts with the frontend of the application which means the frontend needs to be able to interact with the backend of the application and the backend needs to be able to interact with the data layer of the application, Spring provides a framework for simplifying these connections from within the backend.

![architecture](https://drive.google.com/uc?export=view&id=1L0nQu4mI3VrpcnTzg_yme4tt7oi7113u)

### Frontend
#
The frontend was implemented using HTML, CSS (Bootstrap) and Javascript. It consists of one page where the user has five input boxes (ID, first name, last name, phone number and email address) and five buttons (Create, view all, search, update and delete) available which allows them to interact with the app. 

The contacts are displayed as 'contact cards', which display all the information available about each contact. 

The appearance is very basic at this stage as the project focused more on functionality, it was built almost entirely using bootstrap templates, the header, buttons, forms and cards are all bootstrap templates.

<br/>

### Backend
#

The backend was built in Java using the Spring framework. Spring Boot allows for easy implementaion of a REST API which was used for communication between the front end and backend of the application.  

The backend of the application is separated into 3 parts: the controller (which acts as the REST layer), the service (which handles all the business logic of the application) and the persistence layer (containing the repository and domain - which act together to interact with the database).

When the user interacts with the application the controller receives data from the frontend in JSON format and transforms it into a Java Object before passing it on to the service layer.

The service layer then implements the CRUD funcctionality the user has requested on this object and passes the object on to the persistence layer for the changes to be persisted in the database (if there are changes).

Once the data has been persisted in the database, the database then needs to send data back so the user can see the changes or data requested in the front end. The data takes the same route back to the frontend, with the persistence layer passing data on to the service layer which passes it onto the controller (where it is converted back into the JSON format that the front end can use) which finally passes it back to the frontend.
<br/>
<br/>

### Database
#

The database  is a MySQL database consisting of a single table, with the fields: ID, first_name, last_name, phone_number and email. It is hosted by Google Cloud Platform and is connected to the backend using the Spring framework.

<br/>
<br/>
<br/>

## _3. Project Planning_
---
<br/>

### Overview
#
A Jira board was used to track the development of this project. I created four epics, one for each CRUD operation, then expanded on them individually using user stories and tasks.

<br/>

### Jira
Below are some of the user stories from the Jira board used during the project:

![user stories](https://drive.google.com/uc?export=view&id=1P94CI9kmjj19KS-NN2ZDesKH4H3KEyQb)

<br/>

It was difficult to plan sprints with this project as new technologies were learnt after the project had been planned and begun which meant tasks which had been considered done had to be redone, however one sprint was managed:

![user stories](https://drive.google.com/uc?export=view&id=171M7tRUFnROKibvHHpxSzbGVR39XGuYW)

#
<br/>
<br/>
<br/>

### _4. Risk Assessment_
---

Below is the risk assessment which was carried out before the project began, since it was a small project there were few risks identified, each of which were of low risk level. 

![Risk assessment](https://drive.google.com/uc?export=view&id=1j4pC3mHrNsdDaoEuS7Aq8cOMqxxHKg9f)

<br/>
<br/>
<br/>

### _5. Testing_
---

Backend testing was implemented using Spring's MockMVC, JUnit and Mockito. JUnit and Mockito were used for unit testing of each package, before MockMVC was used for integration tests. Below shows the coverage of the code covered by the tests: 

![Testing coverage](https://drive.google.com/uc?export=view&id=1UvXgrxQOWaEZFlA4q5UwVNMDLmWg89v1)

The domain coverage is low due to the lombok @Data annotation which auto-generates methods which are not excluded from the test coverage.

<br/>
<br/>

### _6. Known issues_
---

* The user is unable to update multiple fields for a contact at the same time, updates must be done one by one.
* The application is case-sensitive, the results of searching for a contact by name or email address depend on the case in which the information was entered when the contact was created.

<br/>

### _7. Future Improvements_
---

Further functionality that could be added are:
* Delete all contacts
* Update multiple fields at once
* sort results in alphabetical order
* Make the application case-insensitive

Other improvements include:
* Improving the look of the front end

<br/>

### _8. Links and Resources_
---

[Github](https://github.com/Tayopaseda/fundamentalProject)

### _9. Authors_
---

Tayo Paseda









