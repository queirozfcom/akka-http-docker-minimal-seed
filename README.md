# akka-http-docker-minimal-seed

### Dockerize app

`$ sbt docker:publishLocal`

### Run container

`$ docker run -it -p 5000:5000 akka-http-docker-minimal-seed:1.0`

### Test app

open address on a web browser: **http://localhost:5000/healthcheck**

-----

## Several common use cases such as

- Async Http calls to external services

- Automatic validation of body contents for POST methods

- Automatic conversion of domain classes to Json

- How to structure your akka-http application

- How to package your app with docker so you can run it on any platform or environment including e.g. AWS (EC2, Beanstalk, etc)

- How to extract values from the body of an Http Response and format it nicely

- How to deal with error conditions