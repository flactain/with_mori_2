FROM tomcat:9.0.86-jre17
ENV DB_URL jdbc:mysql://db:3306/
ENV DB_PROPATIES ?characterEncoding=UTF-8
ENV DB_NAME sample
ENV DB_USER root
ENV DB_PASS rootroot
COPY ./target/with_mori.war /usr/local/tomcat/webapps/with_mori.war