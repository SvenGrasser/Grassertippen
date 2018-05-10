#!groovy
pipeline {
    agent any      
    stages {	
        stage('Build') {
            steps {
		deleteDir()
		withMaven()  {
		    sh 'mvn compile -f tippspiel/pom.xml'
		}
	    }
	}
        stage('Test') {
		withMaven()  {
		    sh 'mvn test -f tippspiel/pom.xml'
		}
        }
        stage('Deploy') {
		withMaven()  {
		    sh 'mvn install -f tippspiel/pom.xml'
		}
        }
    }
}

