pipeline {
    agent any

    stages {
        stage('Clonar Repositório') {
            steps {
                // Clonar o repositório do GitHub
                git 'https://github.com/GeandersonOliveira/notification.git'
            }
        }

        stage('Instalar Maven') {
            steps {
                // Instalar Maven
                script {
                    sh 'sudo apt-get update && apt-get install -y maven'
                }
            }
        }

        stage('Build Maven') {
            steps {
                // Construir o projeto Maven
                script {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Construir Imagem Docker') {
            steps {
                // Construir a imagem Docker
                script {
                    dockerImage = docker.build('notificacao:latest', '.')
                }
            }
        }

        stage('Deploy no Docker Local') {
            steps {
                // Parar e remover um contêiner existente
                script {
                    docker.stop('notificacao') || true
                    docker.remove('notificacao') || true
                }

                // Executar o contêiner com a nova imagem
                script {
                    docker.run('-p 8083:8083 --name notificacao notificacao:latest')
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
