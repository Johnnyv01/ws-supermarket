FROM maven:3.8.5-openjdk-17 as build

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17

# Definindo uma variável de ambiente para o diretório de trabalho
ENV APP_DIR /app

# Definindo o diretório de trabalho dentro do container
WORKDIR $APP_DIR

# Copia o script wait-for-it.sh para o diretório de trabalho dentro do container
COPY wait-for-it.sh $APP_DIR/

RUN chmod +x $APP_DIR/wait-for-it.sh

# Copiar o arquivo app.jar para o diretório de trabalho dentro do container
COPY --from=build ./app/target/*.jar ./app.jar

# Define a porta exposta pelo container
EXPOSE 3000

# Define o comando de entrada para executar o script wait-for-it.sh seguido do arquivo JAR
CMD ["./wait-for-it.sh", "meu-mysql:3306", "--timeout=60", "--", "java", "-jar", "app.jar"]
