#!groovy
pipeline {
    agent any    
    stages {
        stage('Build') {
            steps {
		withMaven()  {
		    sh 'mvn test -f tippspiel/pom.xml'
		}
	    }
	}
        stage('Test') {
            steps {
                withMaven()  {
		    sh 'mvn test -f tippspiel/pom.xml'
		}
            }
        }
        stage('Deploy') {
            steps {
                withMaven()  {
		    sh 'mvn test -f tippspiel/pom.xml'
		}
            }
        }
    }
}
