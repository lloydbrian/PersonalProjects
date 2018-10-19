# All about Docker
Containers are instances of Images


```
docker
docker --version
docker-compose --version
docker-machine --version

docker info

docker images <--- shows all images
docker ps -a
docker container ls

docker run <image name>
docker run -d hello-world
docker run -d -p 80:80 --name webserver nginx  <-- this means use port 80 of the docker host ported to port 80 of the container
docker run -d -v /opt/datadir:/var/lib/mysql mysql
docker run -i <-- listens for inputs

docker rm <container id> <-- removes container
docker rmi <image name> <-- deletes docker image

docker pull <image name> <-- pulls only and does not run
$ docker pull nginx
$ docker exec <container name> <applicable commands of the image>

```
