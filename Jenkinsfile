pipeline{
        agent any
		environment {
			SSHKEY = credentials("SSHKey")
		}
        tools {
		    maven 'M3'
		  }
        stages{
           stage("Deployment to Development EC2 (Spring)"){
	            steps{
	                withCredentials([file(credentialsId: 'SSHKey', variable: 'SSHKeyPair')]) {
	                     sh '''
	                        ssh -i ${SSHKeyPair} ubuntu@54.74.11.52 -oStrictHostKeyChecking=no  << EOF
	                        sudo apt-get update
			        		rm -rf ./FinalProjectRepo
	                        git clone --single-branch --branch dev https://github.com/HShanks19/FinalProjectRepo
	                        cd ~/FinalProjectRepo
	                        docker-compose build --parallel
	                        docker-compose up -d
	                    '''
	                }
	            }
        	}
        	stage("Deployment to Production EC2 (Spring)"){
	            steps{
	                withCredentials([file(credentialsId: 'SSHKey', variable: 'SSHKeyPair')]) {
	                     sh '''
	                        ssh -i ${SSHKeyPair} ubuntu@52.211.82.10 -oStrictHostKeyChecking=no  << EOF
	                        sudo apt-get update
							rm -rf ./FinalProjectRepo
	                        git clone --single-branch --branch dev https://github.com/HShanks19/FinalProjectRepo
	                        cd ~/FinalProjectRepo
	                        docker-compose build --parallel
	                        docker-compose up -d
	                    '''
	                }
	            }
			}
        	
        }
}