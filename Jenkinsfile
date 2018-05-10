#!groovy

pipeline {
    agent any    
    stages {
        stage('Build') {
            node('linux1') {
                checkout scm
                def mvnHome = tool 'maven-3'
                sh "${mvnHome}/bin/mvn clean install -DskipTests"
                stash 'working-copy'
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
