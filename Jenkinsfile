#!groovy

pipeline {
    agent any    
    stages {
        stage('Build') {
            steps {
                git url: 'https://github.com/cyrille-leclerc/multi-module-maven-project'
 
                withMaven(
                    // Maven installation declared in the Jenkins "Global Tool Configuration"
                    maven: 'M3') {
                  // Run the maven build
                  sh "mvn clean install"
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
