@Library('Jenkins-shared-libs')
def gv

pipeline {
    agent any
    tools{
        maven 'maven-3.6.3'
    }
    stages {
        stage("init"){
         steps{
            script{
                gv = load "script.groovy"
            }
         }
        }

        stage("build jar") {
            steps {
                echo "Executing build for branch $env.BRANCH_NAME"
                script{
                  buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                script{
                    buildImage()
                }
            }
        }
        stage("deploy") {
            steps {
                script{
                  gv.deployApp()
                }
            }
        }
    }   
}