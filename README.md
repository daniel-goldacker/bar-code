# bar-code

The project bar-code implemente of an API in Java using the Quarkus framework of a QR Code generator that uses the zxing library to create and encode the QR Code, and returns a BufferedImage that represents the code generated as an API response.

**Obs I:**The QR Code (Quick Response Code) is a type of two-dimensional barcode that can be read by a QR Code reader or by a smartphone application with a camera.

**Obs II:** This project uses Quarkus, the Supersonic Subatomic Java Framework. If you want to learn more about Quarkus, please visit its website: https://quarkus.io/.

## Project premise
- Install jdk 11.0.17
- Install apache maven 3.8.3

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```script
mvn compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```script
mvn clean package -DskipTests
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar ./target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```script
mvn clean package -Dquarkus.package.type=uber-jar -DskipTests
```
The application, packaged as an _über-jar_, is now runnable using `java -jar ./target/bar-code-1.0-runner.jar`.

## Access API specifications
After running bar-code go to the URL [http://localhost:8080/q/swagger-ui/](http://localhost:8080/q/swagger-ui/)