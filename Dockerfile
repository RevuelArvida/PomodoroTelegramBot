FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME = 0
ENV BOT_TOKEN = 0
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dbot.botName=${BOT_NAME}","-Dbot.botToken=${BOT_Token}","-jar","/app.jar"]