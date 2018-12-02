#!groovy
pipeline {
    agent any    
    stages {
	
		stage('NPM Install') {
			withEnv(["NPM_CONFIG_LOGLEVEL=warn"]) {
				sh 'npm install'
			}
		}
	
	
        stage('Build') {
            steps {
                withMaven()  {
                    sh 'mvn compile -f tippspiel/pom.xml'
                }
				milestone()
				sh 'cd tippspielClient'
				sh 'ng build --prod --aot --sm --progress=false'
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
    }
}
