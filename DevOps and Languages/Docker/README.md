# All about Docker
Containers are instances of Images

## Basic Commands
```
docker
docker --version
docker-compose --version
docker-machine --version
docker info
```

## Managing Containers and Images
```
docker images <--- shows all images
docker inspect <container id>
docker ps -a
docker container ls

docker pull <image name> <-- pulls only and does not run
$ docker pull nginx


docker run <image name>
docker run -d hello-world
docker run -d -p 80:80 --name webserver nginx  <-- this means use port 80 of the docker host ported to port 80 of the container
docker run -d -v /opt/datadir:/var/lib/mysql mysql
docker run -d -v <host> <container>
docker run -it <-- listens for inputs and automatically runs the terminal

docker rm <container id> <-- removes container
docker rmi <image name> <-- deletes docker image
```


## Running Commands on Containers
```
docker exec <container name> <applicable commands of the image>

```


## Creating Images
```
docker build . -t <docker-hub-name/imagename>
docker push <-- to docker hub

```

## Composing
requires a docker-compose.yml file
```
docker-compose up
docker-compose stop
docker-compose down   
```

Sample docker-compose.yml file
```
version: '3'
services:
  mysql:
      image: "mysql"
      environment:
        - MYSQL_ROOT_PASSWORD=password
      volumes:
        - "/data/mysql:/var/lib/mysql"
      deploy:
        replicas: 5
  web:
    image: "wordpress"
    ports:
      - "8080:80"
    environment:
            - WORDPRESS_DB_PASSWORD=password
```

## Docker Swarm
For high-availability. It's like multiple Docker Hosts in case 1 goes down.
Set-up has a Swarm Manager and the workers.
```
docker swarm init
docker swarm join
docker stack deploy -c docker-compose.yml
```

## Docker Networking
Bridge                  None      host
(docker run ubuntu)                (docker run ubuntu --network=host)

docker network ls 
