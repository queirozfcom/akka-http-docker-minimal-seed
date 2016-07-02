# akka-http-docker-minimal-seed

Sample project showcasing some basic use cases for akka-http, as well as docker packaging via [sbt-native-packager](https://github.com/sbt/sbt-native-packager)

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/34021b48a56eb5ffe000)

### Dockerize app

clone the project and run: `$ sbt docker:publishLocal`

### Run container

After generating the container (step above), run the container:

`$ docker run -it -p 5000:5000 akka-http-docker-minimal-seed:1.0`

### Test app

open address on a web browser: **http://localhost:5000/healthcheck**

-----

## Several common use cases such as

- Async Http calls to external services

- How to convert your models to/from JSON and also validate input

- How to structure your akka-http application

- How to package your app with docker so you can run it on any platform or environment including e.g. AWS (EC2, Beanstalk, etc)

- How to extract values from the body of an Http Response and format it nicely

- How to deal with error conditions