# Passo 1: Use uma imagem base do Java. A 'slim' é mais leve.
FROM openjdk:17-jdk-slim

# Passo 2: Defina um diretório de trabalho dentro do container
WORKDIR /app

# Passo 3: Copie o arquivo .jar compilado do seu projeto para o container
# O Maven/Gradle geralmente gera o .jar na pasta 'target'
COPY target/*.jar app.jar

# Passo 4: Exponha a porta que a sua aplicação usa (padrão do Spring Boot é 8080)
EXPOSE 8080

# Passo 5: Comando para executar a aplicação quando o container iniciar
ENTRYPOINT ["java", "-jar", "app.jar"]