# Use a imagem base do OpenJDK 17
FROM openjdk:17

# Define uma variável de ambiente para o diretório de trabalho
ENV APP_DIR /app

# Define o diretório de trabalho dentro do container
WORKDIR $APP_DIR

# Copia o script wait-for-it.sh para o diretório de trabalho dentro do container
COPY wait-for-it.sh $APP_DIR/

# Dá permissão de execução ao script wait-for-it.sh
RUN chmod +x $APP_DIR/wait-for-it.sh

# Copia o arquivo app.jar para o diretório de trabalho dentro do container
COPY ./target/supermerkat-0.0.1-SNAPSHOT.jar $APP_DIR/app.jar

# Define a porta exposta pelo container
EXPOSE 3000

# Define o comando de entrada para executar o script wait-for-it.sh seguido do arquivo JAR
CMD ["./wait-for-it.sh", "meu-mysql:3306", "--timeout=60", "--", "java", "-jar", "app.jar"]
