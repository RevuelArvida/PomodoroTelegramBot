FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME = superpuperdupertestbot
ENV BOT_TOKEN = 1678049372:AAFV6gkA281z4Z7HX95k2NfbWOaktsyBGak
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dbot.botName=${BOT_NAME}","-Dbot.botToken=${BOT_TOKEN}","-jar","/app.jar"]