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
        
        stage("Deploy to staging") {
            steps {
                sh "docker run -d --rm -p 8769:8080 --name calculatrice localhost:5000/calculatrice"
            }
        }
        
        stage("Acceptance test") {
            steps {
                sleep 60  // Attendre que l'app soit démarrée
                
                script {
                    // 1. TEST SIMPLE AVEC CURL (ton script existant)
                    echo "🔍 Test simple avec curl..."
                    sh "chmod +x acceptance_test.sh && ./acceptance_test.sh"
                    
                    // 2. TESTS CUCUMBER AVEC RAPPORTS
                    echo "🧪 Tests Cucumber avec rapports..."
                    sh "./gradlew acceptanceTest -Dcalculator.url=http://localhost:8769/api --rerun-tasks"
                }
            }
        }
    }
    
    post {
        always {
            // 📊 PUBLIER LES RAPPORTS CUCUMBER DANS JENKINS
            cucumber reportTitle: 'Rapport Tests d\'Acceptation Cucumber',
                     fileIncludePattern: '**/cucumber.json',
                     jsonReportDirectory: 'target/cucumber-reports'
            
            // 📊 RAPPORT JUnit POUR JENKINS
            junit 'target/cucumber-reports/cucumber.xml'
            
            // 🔗 CRÉER UN LIEN VERS LE RAPPORT HTML
            script {
                // Archiver le rapport HTML pour accès direct
                archiveArtifacts artifacts: 'target/cucumber-reports/cucumber.html', fingerprint: false
                
                // Afficher le lien dans les logs
                echo "📊 RAPPORT CUCUMBER DISPONIBLE:"
                echo "📎 ${env.BUILD_URL}artifact/target/cucumber-reports/cucumber.html"
            }
            
            // 🧹 NETTOYAGE
            sh "docker stop calculatrice || true"
            sh "docker rm calculatrice || true"
        }
        
        success {
            echo "🎉 TOUS LES TESTS D'ACCEPTATION ONT RÉUSSI!"
            echo "📊 Consultez le rapport Cucumber: ${env.BUILD_URL}artifact/target/cucumber-reports/cucumber.html"
        }
        
        failure {
            echo "❌ CERTAINS TESTS ONT ÉCHOUÉ"
            echo "📊 Consultez le rapport détaillé: ${env.BUILD_URL}artifact/target/cucumber-reports/cucumber.html"
        }
    }
}
