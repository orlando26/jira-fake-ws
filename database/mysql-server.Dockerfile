# Server environment
FROM mysql/mysql-server:8.0.23

# MySQL config file
COPY ./client-config/my.cnf-host /etc/my.cnf

# Mount DDL and DML scripts to execute them automatically on startup
COPY ./*.sql /docker-entrypoint-initdb.d/
 