# zhangbu-java-1


```bash
docker run -d --name dbforzhangbujava \
    -v /tmp/mysql/log:/var/log/mysql \
    -v /tmp/mysql/data:/var/lib/mysql \
    -v /tmp/mysql/conf:/etc/mysql/conf.d \
    -p 3306:3306 \
    -e MYSQL_ROOT_PASSWORD=$DBPW \
    arm64v8/mysql:latest
# test
docker exec -it dbforzhangbujava mysql -uroot -p
```