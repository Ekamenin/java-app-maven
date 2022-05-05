def gv

pipeline {
    agent any
    parameters {
        choice(name:'VERSION', choices: ['1.1.0','1.2.0','1.3.0'], description: '')
        booleanParam(name:'executeTests', defaultValue: true, description: '')
    }
    tools{
        maven 'maven-3.6.3' // Will make maven command available in your jenkinsfile
    }
    environment{
        NEW_VERSION = '1.3.0'
        DOCKER_HUB_CREDENTIAL = credentials('docker-hub-cred')
    }
    stages {
        stage("init") {
            steps {
                echo "the version of the app is ${NEW_VERSION}"
                script {
                    gv = load "script.groovy"

                }
            }
        }
         stage("test") {
            when{
                expression{
                    BRANCH_NAME == 'dev' //branch_name variable is provided out of the box. ||, && can also be added
                    params.executeTests == true
                }
            }
            steps {
                script {
                    echo "building jar"
                    //gv.buildJar()
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    echo "building jar"
                    //gv.buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building image"
                    //gv.buildImage()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying version ${params.VERSION}"
                    //gv.deployApp()
                }
            }
        }
        post{
            always{
                echo 'I will always be executed'
            }
            success{
                echo 'I will always be if the build succeeded'
            }
            failure{
                echo 'I will always be if the build failed'
            }
        }
    }   
}