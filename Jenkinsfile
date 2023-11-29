pipeline {
    agent any

    stages {
        stage('Clonar Repositório') {
            steps {
                // Clonar o repositório do GitHub
                git 'https://github.com/seu-usuario/seu-repositorio.git'
            }
        }

        stage('Instalar Maven') {
            steps {
                // Instalar Maven
                script {
                    sh 'apt-get update && apt-get install -y maven'
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
                    dockerImage = docker.build('sua-api-imagem:latest', '.')
                }
            }
        }

        stage('Deploy no Docker Local') {
            steps {
                // Parar e remover um contêiner existente
                script {
                    docker.stop('sua-api-container') || true
                    docker.remove('sua-api-container') || true
                }

                // Executar o contêiner com a nova imagem
                script {
                    docker.run('-p 8080:80 --name sua-api-container sua-api-imagem:latest')
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
