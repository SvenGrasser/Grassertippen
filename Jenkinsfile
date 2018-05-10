#!groovy
pipeline {
    agent any    
    stages {
        stage('Build') {
            steps { 
		withMaven() {
		    sh 'mvn clean verify -B -U -e -fae -V -Dmaven.test.failure.ignore=true tippspiel/pom.xml'
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
