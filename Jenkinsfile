pipeline{
        agent any
        tools {
		    maven 'M3'
		  }
        stages{
           stage("Deployment to Development EC2 (Spring)"){
	            steps{
	                withCredentials([file(credentialsId: 'SSHKey', variable: 'SSHKeyPair')]) {
	                     sh '''
	                        ssh -i ${SSHKeyPair} ubuntu@3.249.167.211 -oStrictHostKeyChecking=no  << EOF
	                        sudo apt-get update
				            rm -rf ./FinalProjectRepo
	                        git clone --single-branch --branch Docker https://github.com/HShanks19/FinalProjectRepo
	                        cd ~/FinalProjectRepo/FinalProjectCitizenRepo
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
	                        ssh -i ${SSHKeyPair} ubuntu@34.241.123.167 -oStrictHostKeyChecking=no  << EOF
	                        sudo apt-get update
				            rm -rf ./FinalProjectRepo
	                        git clone --single-branch --branch Docker https://github.com/HShanks19/FinalProjectRepo
	                        cd ~/FinalProjectRepo/FinalProjectCitizenRepo
	                        docker-compose build --parallel
	                        docker-compose up -d
	                    '''
	                }
	            }
        	}
        }
}