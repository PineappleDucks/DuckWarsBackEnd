FROM jboss/wildfly
COPY solutions/ear-deployment/target/DuckWarsBackEnd.ear /opt/jboss/wildfly/standalone/deployments/
COPY standalone-full.xml /opt/jboss/wildfly/standalone/configuration/standalone-full.xml
RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#70365 --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-c", "standalone-full.xml", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]