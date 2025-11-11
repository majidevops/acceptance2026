pipeline {
    agent any
    stages {
        stage("Package") {
    steps {
        sh "./gradlew build"
        
    }
}
stage("Docker build") {
            steps {
                sh "docker build -t localhost:5000/calculatrice ."
            }
        }
stage("Docker push") {
    steps {
        sh "docker push localhost:5000/calculatrice"
        }
        }
stage("Deploy to staging ou Déployer en préproduction") {
    steps {
        sh "docker run -d --rm -p 8769:8080 --name calculatrice localhost:5000/calculatrice"
    }
}
stage("Acceptance test") {
    steps {
        sleep 60
        sh "chmod +x acceptance_test.sh && ./acceptance_test.sh"
    }
}
}
post {
    always {
        sh "docker stop calculatrice"
    }
}
        
}

