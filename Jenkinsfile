#!groovy
pipeline {
    agent any    
    stages {
        stage('Build') {
            steps {
                withMaven()  {
                    sh 'mvn compile -f tippspiel/pom.xml'
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
                    sh 'mvn install -f tippspiel/pom.xml'
                }
            }
        }
		
		if(env.BRANCH_NAME == "develop") {
		stage('Release') {
			steps {
				def userInput = false
				timeout(time: 60, unit: 'SECONDS') {
					userInput = input(
					id: 'Proceed1', message: 'Release?', parameters: [
					[$class: 'BooleanParameterDefinition', defaultValue: false, description: '', name: 'Check if you want to release!']
					])
				}
				if(userInput == true) {
                    sh 'mvn mvn release:prepare -Dresume=false -f tippspiel/pom.xml'			      
				}		
			}		
		}
    }
}
