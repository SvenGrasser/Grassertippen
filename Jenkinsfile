#!groovy
pipeline {
    agent any    
    stages {
        stage('Build') {
            steps {                
				mavenBuild([goals: '-U test', opts: '-Ddepcheck.scope=extern -Dmaven.test.failure.ignore']) 
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
