FROM maven:3.6.0-jdk-8-alpine as builder

RUN mkdir -p /myapp

WORKDIR /myapp

RUN wget https://jdbc.postgresql.org/download/postgresql-42.2.5.jar \
            -O database-connector.jar

COPY pom.xml .
COPY createDDL_ddlGeneration.sql .
COPY src .

RUN mvn package


FROM payara/server-full:5.183

#installs postgresql jdbc driver, jdbc connection pool and ressource are added in the src/main/webapp/WEB-INF/glassfish-resources.xml

ENV PATH="/opt/payara5/bin/:${PATH}"

COPY --from=builder /myapp/database-connector.jar /opt/payara5/glassfish/domains/domain1/lib/

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

COPY --from=builder /myapp/target/*.war $DEPLOY_DIR
COPY mypayara-full/com.txt /opt/payara5/
RUN ls $DEPLOY_DIR
