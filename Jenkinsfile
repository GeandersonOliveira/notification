pipeline {
    agent any

    stages {
        stage('Clonar Repositorio') {
            steps {
                git 'https://github.com/GeandersonOliveira/notification.git'
            }
        }

         

        stage('Sonar') {
            steps {
                script {
                    // Comandos para analise do sonar
                    echo 'Configurar Sonar'
                    
                }
            }
        }

        stage('Build Maven') {
            steps {
                script {
                    // Use o comando mvn do Windows, ajuste o caminho conforme necessário
                    bat 'mvn clean package'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Comandos para executar testes (por exemplo, JUnit)
                    //testes ainda nao implementados
                    echo 'Execução dos Testes da app (sh mvn test)'
                    
                }
            }
        }

        stage('Construir Imagem Docker') {
            steps {
                script {
                    // Use o comando docker do Windows para construir a imagem
                    bat 'docker build -t listener-api:latest .'
                }
            }
        }

        stage('Deploy no Docker Host') {
    steps {
        // Parar e remover um contêiner existente no Docker host
        script {
            bat 'docker stop listener-api 2>NUL || exit 0' // Suprime a mensagem de erro se o contêiner não existir
            bat 'docker rm listener-api 2>NUL || exit 0'   // Suprime a mensagem de erro se o contêiner não existir
        }

        // Executar o contêiner com a nova imagem no Docker host
        script {
            bat 'docker run -d -p 8083:8083 --name listener-api listener-api:latest'
        }
    }
}
        
        stage('Testes de Integraçao') {
            steps {
                script {
                    // Comandos para executar testes de integração com MYSQL, RABBITMQ, REDIS, Keyclock
                     echo 'executar testes de integraçao'
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
