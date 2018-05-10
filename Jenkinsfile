#!groovy
pipeline {
    agent any    
    stages {
        stage('Build') {
            steps { 
		with maven() {
		    sh 'mvn clean verify -B -U -e -fae -V -Dmaven.test.failure.ignore=true'
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
