# Use uma imagem base do OpenJDK 8
FROM openjdk:8

# Crie e defina o diretório de trabalho
WORKDIR /usr/src/app

# Copie o arquivo JAR da aplicação para o contêiner
COPY target/notificacao-0.0.1-SNAPSHOT.jar .

# Exponha a porta que a aplicação vai usar (se necessário)
EXPOSE 8083

# Comando para iniciar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "notificacao-0.0.1-SNAPSHOT.jar"]