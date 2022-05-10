def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-cred', passwordVariable: 'PWD', usernameVariable: 'USER')]) {

        sh 'docker build -t 082013/demo-app:my-app-5.0 . '
        sh "echo $PWD | docker login -u $USER --password-stdin"
        sh 'docker push 082013/demo-app:my-app-5.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this