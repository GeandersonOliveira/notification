pipeline {
    agent any

    stages {
        stage('Clonar Repositório') {
            steps {
                git 'https://github.com/GeandersonOliveira/notification.git'
            }
        }

        stage('Build Maven') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Construir Imagem Docker') {
            steps {
                script {
                    // Construir a imagem Docker
                    sh 'docker build -t listener-api:latest .'
                }
            }
        }

        stage('Deploy no Docker Host') {
            steps {
                // Parar e remover um contêiner existente no Docker host
                script {
                    sh 'docker stop listener-api || true'
                    sh 'docker rm listener-api || true'
                }

                // Executar o contêiner com a nova imagem no Docker host
                script {
                    sh 'docker run -d -p 8083:8083 --name listener-api -v /var/run/docker.sock:/var/run/docker.sock listener-api:latest'
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline bem-sucedido! Executar ações adicionais aqui, se necessário.'
        }

        failure {
            echo 'Pipeline falhou! Executar ações adicionais aqui, se necessário.'
        }
    }
}
