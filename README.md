# Final Group Project

## Team 1: Scenario 1

### Contents

* Overview
* Technology Stack
* Jira
* GitHub
* Dev-Ops CI/CD Pipeline
* Spring Boot
* Testing
* React Application
* Achievements
* Improvements
* Acknowledgements

### Overview

As our final group project, we were tasked to create and deploy an application that met a minimum viable product for a hypothetical client. We utilised a range of technologies, learnt throughout our time with QA, to build the back and front end of the application as well as a functioning DevOps Pipeline for deployment.

### Brief

We chose to answer the MVP for Scenario 1. (EXPAND)

### Technology Stack

* Jira
* Github
* Terraform
* AWS: RDS, EC2
* Ansible
* Jenkins
* Docker
* Spring Boot
* JUnit, Selenium, Mockito
* React

### Jira

### Github

### Dev-Ops CI/CD Pipeline

To build the Pipeline, a variety of technologies were used in conjunction with one another. The DevOps technology stack:
* Terraform- Used to configure the environment including the created of all AWS infrastructure and the set-up of the bastion host to allow Ansible to be used immediately once the User was connected.
* AWS: RDS, EC2 - AWS was used to host our development and production EC2 instances along with our Jenkins machine. The RDS database was configured in a private subnet that only the instances could access for security reasons. The set-up of the data structure within the RDS database is shown in the below ERD:
![rds ERD image](/readmeImages/dataStructure.png)
* Ansible- Used to configure the production and development environments as well as the Jenkins instance.
* Jenkins- Within Jenkins, 2 pipelines were created to deploy the application. The first deployed the code on the dev branch of GitHub onto the development EC2 instance using the Jenkinsfile in the development file. The second deployed the code on the main branch onto the production environment. Jenkins was also used to track tests that were passed on the development instance to avoid broken code being sent to the main branch.
Development Pipeline:
![jenkins development image](/readmeImages/jenkins-development.png)
Production Pipeline:
![jenkins production image](/readmeImages/jenkins-production.png)
* Docker- Within the EC2 instances, 3 Docker instances were built containing the backend Spring Boot Application, the frontend React Application, and an NGINX container which was used as a reverse proxy.

### Front-end

We used React to build our front-end, whilst using Bootstrap and a few other open-source NPM packages to provide styling.

![image](https://user-images.githubusercontent.com/10779091/119632671-f0914480-be08-11eb-9c69-65d3ddd9c1c2.png)

![image](https://user-images.githubusercontent.com/10779091/119632727-fd159d00-be08-11eb-917c-e9715788d619.png)


### Spring Boot

### Testing

### React Application

### Achievements

* For this project we chose to do scenario 1:
* “A suspect has been detained and they need to know background information on the suspect, including: Biological Information, Associates, Financial transactions and Whereabouts.” 

* We took into consideration what needs to be done in order to create a minimum viable product and how we wanted it to look.

### Improvements/ Stretch Goals

* Fix bugs
* Sorting CSS
* Unpublished back-end container
* Use docker network
* Finish whereabouts functionality

### Future prospects

* A map showing locations of interest
* Scenario 2 – an incident has occurred
* Scenario 3 – Tracking a known suspect using ANPR cameras

### Reflections
* We’ve all...
* Learnt a lot about collaboration using agile methodologies, using tools such as Git, Github and Jira.
* Strengthened our overall software engineering skills.
* Improved our soft skills.
* Learnt a lot from working together as a team and from my teammates.


### Acknowledgements

* We would like to acknowledge:
* Jordan for being constant support throughout the project, helping us with aspects we struggled.
* Geoff for being supportive throughout the project, helping us to stay on track and for bringing up anything we should be focusing on at that time.
