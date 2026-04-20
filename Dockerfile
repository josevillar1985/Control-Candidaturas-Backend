# Usamos una imagen de Java 21 (que es la que suele usar Spring Boot 3)
FROM eclipse-temurin:21-jdk-jammy

# Directorio de trabajo
WORKDIR /app

# Copiamos el archivo pom y el wrapper de maven
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

# Copiamos el código fuente y generamos el jar
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Exponemos el puerto 8080
EXPOSE 8080

# Ejecutamos la aplicación
ENTRYPOINT ["java", "-jar", "target/*.jar"]