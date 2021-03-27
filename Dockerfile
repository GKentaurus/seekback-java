FROM payara/server-full
EXPOSE 8080
COPY target/seekback-java-1.0-SNAPSHOT.war $DEPLOY_DIR
ENV DEPLOY_PROPS=--contextroot=/
4
