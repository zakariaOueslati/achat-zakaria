FROM adoptopenjdk:17-jdk-hotspot
EXPOSE 8089
ADD target/achat-devops-1.0.jar achat-devops-1.0.jar
ENTRYPOINT ["java","-jar","/achat-devops-1.0.jar"]