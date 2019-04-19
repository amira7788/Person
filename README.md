# Person
Exemple d'un socle technique avec java 8 + docker + swagger + promotheuse

If you are using Maven, execute:

    $ mvn spring-boot:run
    $ ./mvnw package && java -jar target/gs-spring-boot-docker-0.1.0.jar
    $ ./mvnw install dockerfile:build

#### But du repository service-socle

Ce n'est pas un starter mais plutôt une doc par le code,
sentez vous libre d'utiliser des initialiseurs existants pour mettre en place le layout
et les dépendances spring boot.

Concernant les dépendances, il faudra penser à démarrer les nouveaux composants
en choisissant des versions plus récentes si cela est pertinent.

## Environnement local

### Lancement de l'application

    $ mvn spring-boot:run

### url

> Swagger : http://localhost:8080/swagger-ui.html
> Prometheus : http://localhost:8080/prometheus
> Version : http://localhost:8080/info = en cours
## Dockerization

### construction image docker

    $ mvn clean package

### Lancer Docker avec variables d'environnement

    $ docker run -p 8080:8080 service-person



