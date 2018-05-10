#!groovy

pipeline {
    agent any    
    stages {
        stage('Build') {
            steps {
                cd tippspiel;
                sh 'mvn clean install'
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
