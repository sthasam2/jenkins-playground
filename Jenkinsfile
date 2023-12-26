def gv

pipeline {
    agent any

    environment {
        // Add environment variables here
        HELLOWORLD = 'Hello World!'
    }

    stages {
        stage('Initialize') {
                steps {
                    script {
                        gv = load 'scripts/scripts.groovy'
                    }
                }
        }

        stage('Build') {
            steps {
                script {
                    echo "${env.HELLOWORLD}"
                }
            // Add build steps here
            }
        }

        stage('Test') {
            steps {
                // Add test steps here
                script {
                    gv.testFunction()
                }
            }
        }

        stage('Deploy') {
            steps {
            // Add deployment steps here
            }
        }
    }
}
