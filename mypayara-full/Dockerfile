FROM maven:3.5.2-jdk-8-alpine as builder

RUN mkdir -p /myapp

WORKDIR /myapp

COPY pom.xml .
COPY createDDL_ddlGeneration.sql .
COPY src .

RUN mvn package


FROM payara/server-full:5.183

#installs postgresql jdbc driver, jdbc connection pool and ressource are added in the src/main/webapp/WEB-INF/glassfish-resources.xml

ENV PATH="/opt/payara5/bin/:${PATH}"

COPY --from=build /myapp/database-connector.jar /opt/payara5/glassfish/domains/domain1/lib/

RUN asadmin start-domain && \
    asadmin --user admin \
    		--passwordfile=/opt/pwdfile \
    			      set-hazelcast-configuration --enabled=true --dynamic=true && \
    asadmin --user admin \
            --passwordfile=/opt/pwdfile \
			     create-jdbc-connection-pool \
			--datasourceclassname org.postgresql.ds.PGConnectionPoolDataSource  \
			--restype javax.sql.ConnectionPoolDataSource \
			--property portNumber=5432:password=glassfishdbpassword:user=glassfish:serverName=db:databaseName=glassfish \
				postgres-pool && \
    asadmin --user admin \
                   --passwordfile=/opt/pwdfile \
			       create-jdbc-resource --connectionpoolid postgres-pool jdbc/postgres-pool && \
    asadmin stop-domain

COPY --from=build /myapp/target/*.war $DEPLOY_DIR

FROM payara/server-full:163

RUN wget https://jdbc.postgresql.org/download/postgresql-9.4.1212.jar \
         -O /opt/payara41/glassfish/domains/domain1/lib/postgresql.jar && \
    /opt/payara41/bin/asadmin start-domain && \
    /opt/payara41/bin/asadmin --user admin \
    			      --passwordfile=/opt/pwdfile \
    			      set-hazelcast-configuration --enabled=true --dynamic=true

COPY --from=builder /home/project/target/*.war $DEPLOY_DIR

RUN ls $DEPLOY_DIR
RUN echo $DEPLOY_DIR

