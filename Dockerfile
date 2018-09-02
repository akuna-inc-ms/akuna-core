MAINTAINER AKUNA Team
ADD target/akuna-core.jar /app/akuna-core.jar

EXPOSE 8080
EXPOSE 5005

ENTRYPOINT [ "java", "-Xms256m", "-Xmx512m", "-Djava.security.egd=file:/dev/./urandom", "-Dfile.encoding=UTF-8", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005", "-jar", "/app/akuna-core.jar" ]
