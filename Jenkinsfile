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
                  gv.buildJar()
                }
            }
        }
        stage("build image") {
             when{
                expression{
                    env.BRANCH_NAME == 'master'
                }
            }
            steps {
                script{
                    gv.buildImage()
                }
            }
        }
        stage("deploy") {
            when{
                expression{
                    env.BRANCH_NAME == 'master'
                }
            }
            steps {
                script{
                  gv.deployApp()
                }
            }
        }
    }   
}