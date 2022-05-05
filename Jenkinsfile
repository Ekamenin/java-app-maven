def gv

pipeline {
    agent any
    tools{
        maven 'maven-3.6.3'
    }
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "building the application....."
                    sh 'mvn package'
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building the docker image"
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-cred', passwordVariable: 'PWD', usernameVariable: 'USER')]){
                        sh '082013/demo-app:class-jma-2.0 . '
                        sh 'docker login -u $USER -p $PWD'
                        sh 'docker push 082013/demo-app:class-jma-2.0'
                    }
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying the application..."
                }
            }
        }
    }   
}