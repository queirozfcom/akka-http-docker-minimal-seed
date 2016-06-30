# akka-http-docker-minimal-seed

### Dockerize app

`$ sbt docker:publishLocal`

### Run container

`$ docker run -it -p000:5000 akka-http-docker-minimal-seed:1.0`

### Test app

open address on a web browser: **http://localhost:5000/healthcheck**