#!groovy
pipeline {
    agent any  
    deleteDir()
    stages {
        stage('Build') {
            steps {
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

