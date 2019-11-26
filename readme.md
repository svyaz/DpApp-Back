## README

### Data base
Запустить в докере этот образ:

`https://hub.docker.com/r/epiclabs/docker-oracle-xe-11g/`

`docker run -d -p 1521:1521 -e ORACLE_ALLOW_REMOTE=true epiclabs/docker-oracle-xe-11g`

Создать пользователя:

`user: DP_APP`

`pwd:  password`

### Проинсталлировать oracle ojdbc7 локально если нету:

`mvn install:install-file -Dfile=ojdbc7.jar -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.2 -Dpackaging=jar`
