#importando java
FROM openjdk:17-jdk-slim 

#Definir diretório no contênier
WORKDIR /app

#Copia o .jar para o contêiner
COPY  target/course-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

#Endponit para rodar api
ENTRYPOINT ["java", "-jar", "app.jar"]