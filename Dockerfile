#Etapa 1: Build do JAR usando Maven
FROM maven:3.9.0-amazoncorretto-17 AS build

#Definir o diretório de trabalho
WORKDIR /app

#Copiar o arquivo pom.xml para o container e baixar dependências
COPY pom.xml .

#Baixar as dependências do projeto
RUN mvn dependency:go-offline

#Copiar o código-fonte do projeto para o container
COPY src /app/src

#Construir o JAR
RUN mvn clean package -DskipTests

#Etapa 2: Rodar o aplicativo Java
FROM openjdk:17-jdk-slim 

#Definir o diretório de trabalho
WORKDIR /app

#Copiar o JAR gerado da etapa de build para a imagem final
COPY --from=build /app/target/course-0.0.1-SNAPSHOT.jar app.jar

#Expor a porta que o aplicativo vai rodar
EXPOSE 8080

#Definir o comando para rodar o aplicativo
CMD ["java", "-jar", "app.jar"]