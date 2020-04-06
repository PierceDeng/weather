FROM williamyeh/java8:latest
MAINTAINER dpz  prsandd@gmail.com
ADD /core/target/weather-server.jar weather-server.jar
EXPOSE 10001
ENTRYPOINT ["java","-jar","weather-server.jar"]