# Database: `jira_fake`
- [Database: `jira_fake`](#database-jira_fake)
  - [ER Diagram](#er-diagram)
  - [Setup MySQL server](#setup-mysql-server)
    - [Build](#build)
    - [Run](#run)
    - [Connect](#connect)
      - [MySQL Client](#mysql-client)
      - [MyCli](#mycli)

## ER Diagram
![jira-fake EER](./jira-fake-db.png)

## Setup MySQL server
### Build
```zsh
docker build -t jira-fake:mysql . -f mysql-server.Dockerfile
```

### Run
Setup the password as an environment variable.
```zsh
MYSQL_PWD=changeMePleaseIBegYou     # change this

[ -z "$(grep "MYSQL_PWD" ~/.bashrc)" ] && echo >> ~/.bashrc && \
echo "export MYSQL_PWD=${MYSQL_PWD}" >> ~/.bashrc
```

Run the container
```zsh
docker run --name jira-fake-db -e MYSQL_ROOT_PASSWORD=${MYSQL_PWD} -e MYSQL_ROOT_HOST=% -d jira-fake:mysql
```

### Connect

Store the container IP in an environment variable.
```zsh
MYSQL_HOST_IP=$(docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' jira-fake-db)

[ -z "$(grep "MYSQL_HOST_IP" ~/.bashrc)" ] && echo >> ~/.bashrc && \
echo "export MYSQL_HOST_IP=${MYSQL_HOST_IP}" >> ~/.bashrc
```

#### MySQL Client
**Connect** with `mysql client`.
```zsh
mysql -h ${MYSQL_HOST_IP} -u root -p${MYSQL_PWD} -D jira-fake
```

#### MyCli
I like `mycli` with `pspg` pager better.
```zsh
# Dependencies and config files
sudo apt-get install pspg
ln -sr clienf-config/my.cnf-local ~/.my.cnf
ln -sr clienf-config/myclirc ~/.myclirc

# Connect
mycli -h ${MYSQL_HOST_IP} -u root -p${MYSQL_PWD} -D jira-fake

# Create an alias if feeling lazy
echo >> ~/.bashrc
echo "alias jira-fake-db='mycli -h ${MYSQL_HOST_IP} -u root -p${MYSQL_PWD} -D jira-fake'" >> ~/.bashrc
source ~/.bashrc

# Then connect with
jira-fake-db
```
[*Up*](#database-jira_fake)
