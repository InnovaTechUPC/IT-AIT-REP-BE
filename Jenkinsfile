pipeline {
    agent any

    tools {
        jdk 'jdk-17'
        maven 'maven-3.6.3'
    }

    environment {
        PROJECT_VERSION = readMavenPom().getVersion()
        DOCKER_IMAGE_NAME = "rickcbs/asit-core-service:${PROJECT_VERSION}"
        DOCKER_CREDENTIALS = "rkz-docker-hub"
    }

    stages {
        stage('Build Project') {
          steps {
            sh 'mvn clean install -DskipTests'
          }
        }

        stage('Build Docker Image') {
          steps {
            script {
              app = docker.build("${DOCKER_IMAGE_NAME}")
            }
          }
        }

        stage('Push Docker Image') {
          steps {
            script {
              docker.withRegistry('https://registry.hub.docker.com', DOCKER_CREDENTIALS ) {
                app.push()
              }
            }
          }
        }
    }
}
