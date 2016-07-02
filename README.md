# akka-http-docker-minimal-seed

Sample project showcasing some basic use cases for akka-http, as well as docker packaging via [sbt-native-packager](https://github.com/sbt/sbt-native-packager)

### Dockerize app

clone the project and run: `$ sbt docker:publishLocal`

### Run container

After generating the container (step above), run the container:

`$ docker run -dit -p 5000:5000 --name akka-minimal-seed akka-http-docker-minimal-seed:1.0`

You will get a response like this:

```
$ docker run -dit -p 5000:5000 --name akka-minimal-seed akka-http-docker-minimal-seed:1.0
6c3ceda8b0a4dc67633c577bb57dd949e17afbc101fd1b190c2e67efba9c9b7f
```

### Test app

 - Open address on a web browser: **http://localhost:5000/healthcheck**

 - To test using **Postman**, use this link: 

    [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/34021b48a56eb5ffe000)

### Stop the container

To stop the container, run:

`$ docker stop akka-minimal-seed`

-----

## Several common use cases such as

- Async Http calls to external services

- How to convert your models to/from JSON and also validate input

- How to structure your akka-http application

- How to package your app with docker so you can run it on any platform or environment including e.g. AWS (EC2, Beanstalk, etc)

- How to extract values from the body of an Http Response and format it nicely

- How to deal with error conditions