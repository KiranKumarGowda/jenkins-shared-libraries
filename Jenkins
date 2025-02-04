@Library('shared') _
pipeline {
    agent { label 'kiran' }
 
    stages {
        stage('Hello'){
            steps{
                script{
                    hello()
                }
            }
        }
        stage ('Code') {
            steps {
                  script{
                clone ('https://github.com/KiranKumarGowda/django-notes-app.git', 'main')
                         }
                  }
        }
 
        stage ('Build') {
            steps {
                script{
                    build('kirankumargowda','latest','django-notes')
                       }
                  }
        }
 
        stage ('Push to Docker Hub') {
            steps {
                echo "Logging in and pushing image to Docker Hub"
                withCredentials([usernamePassword(credentialsId: "dockerhubcred", passwordVariable: 'DOCKERHUB_PASS', usernameVariable: 'DOCKERHUB_USER')]) {
                    sh '''
                        echo "$DOCKERHUB_PASS" | docker login --username "$DOCKERHUB_USER" --password-stdin
                        docker image tag django-notes:latest "$DOCKERHUB_USER/django-notes:latest"
                        docker push "$DOCKERHUB_USER/django-notes:latest"
                    '''
                }
            }
        }
 
        stage ('Deploy') {
            steps {
                echo "Deploying the container"
                sh "docker run -d -p 8000:8000 django-notes:latest"
            }
        }
    }
}
