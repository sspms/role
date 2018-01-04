FROM registry.docker-cn.com/library/java:alpine
MAINTAINER david.du
EXPOSE 8080
COPY role.jar /var/lib/shanshui/role/role.jar
CMD java -jar /var/lib/shanshui/role/role.jar --spring.profiles.active=test