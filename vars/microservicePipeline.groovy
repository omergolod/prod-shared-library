def call(Map config = [:]) {
    pipeline {
        agent any
        
        stages {
            stage('Checkout') {
                steps {
                    echo "Cloning source code..."
                }
            }
            
            stage('Security Scan') {
                steps {
                    script {
                        def scanTarget = config.get('scanTarget', '.')
                        def failThreshold = config.get('failThreshold', 'HIGH')
                        
                        scanSecurity(scanTarget: scanTarget, failThreshold: failThreshold)
                    }
                }
            }
            
            stage('Publish Artifact') {
                steps {
                    script {
                        def artifactName = config.get('artifactName', 'my-app')
                        def version = config.get('version', '1.0.0-SNAPSHOT')
                        
                        pushArtifact(artifactName: artifactName, version: version)
                    }
                }
            }
        }
        
        post {
            always {
                echo "Cleaning up workspace..."
                cleanWs()
            }
        }
    }
}
