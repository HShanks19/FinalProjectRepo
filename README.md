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
![rds ERD image](/readmeImages/dataStructure.PNG)
* Ansible- Used to configure the production and development environments as well as the Jenkins instance.
* Jenkins- Within Jenkins, 2 pipelines were created to deploy the application. The first deployed the code on the dev branch of GitHub onto the development EC2 instance using the Jenkinsfile in the development file. The second deployed the code on the main branch onto the production environment. Jenkins was also used to track tests that were passed on the development instance to avoid broken code being sent to the main branch.
Development Pipeline:
![jenkins development image](/readmeImages/jenkins-development.PNG)
Production Pipeline:
![jenkins production image](/readmeImages/jenkins-production.PNG)
* Docker- Within the EC2 instances, 3 Docker instances were built containing the backend Spring Boot Application, the frontend React Application, and an NGINX container which was used as a reverse proxy.

### Spring Boot

### Testing

### React Application

### Achievements

*

### Improvements

* 

### Future prospects

* 

### Acknowledgements

