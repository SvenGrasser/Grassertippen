#!groovy
pipeline {
    agent any    
    stages {
        stage('Build') {
            steps { 
		with maven() {
		    sh 'mvn compile'
		}
	    }	
	}
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
