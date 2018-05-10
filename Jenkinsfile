#!groovy

pipeline {
    deleteDir()
    agent any    
    stages {
        stage('Build') {
            steps {                
            withMaven(){
              // Run the maven build
              mvn clean install
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
