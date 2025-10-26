 # Hotel Management API

 [![CircleCI](https://circleci.com/gh/rahulraogrr/hms/tree/main.svg?style=svg)](https://circleci.com/gh/rahulraogrr/hms/tree/main)
 [![Codacy Badge](https://app.codacy.com/project/badge/Grade/2b5cbf01886a4cbab07cdb9620ff31af)](https://www.codacy.com/gh/rahulraogrr/hms/dashboard?utm_source=github.com&utm_medium=referral&utm_content=rahulraogrr/hms&utm_campaign=Badge_Grade)
 ![Snyk Vulnerabilities for GitHub Repo](https://img.shields.io/snyk/vulnerabilities/github/rahulraogrr/hms)

A lightweight Spring Boot based Hotel Management API with two primary modules: an Admin module for managing hotel metadata and an HMS Portal for hotel staff operations.

---

## Quick overview

- Admin Module: manage Groups, Hotels, Floors, Rooms, Departments, Employees and Inventory.
- HMS Portal: staff-facing features such as login, check-in/check-out, bookings and room services.

Core entities and masters implemented:

- Group Master — create/modify/browse/delete groups
- Hotel Master — create hotels belonging to a group
- Floor Master — floors inside a hotel
- Room Master — rooms under a floor
- Department Master — departments per hotel
- Employee Master — employees assigned to departments
- Inventory Master — hotel inventory

## ER Diagram

![ER diagram](src/main/resources/static/images/er_diagram.png)

---

## Getting started (quick)

Prerequisites

- Java 17
- Maven (or use the included `./mvnw` wrapper)

Build and run (default profile uses PostgreSQL as configured in `application.yml`):

```bash
# build
./mvnw -DskipTests package

# run (using default datasource from application.yml)
./mvnw spring-boot:run
```

## Run with the in-memory H2 database (recommended for local dev/tests)

I added a lightweight H2 profile so you can run the app locally without installing Postgres.

Usage:

```bash
# build with the Maven profile that adds H2 to the classpath
./mvnw -Ph2 -DskipTests package

# run and activate the Spring profile 'h2' so the H2 datasource is used
./mvnw -Ph2 -Dspring-boot.run.profiles=h2 spring-boot:run

# alternatively set the SPRING_PROFILES_ACTIVE env var
export SPRING_PROFILES_ACTIVE=h2
./mvnw -Ph2 spring-boot:run
```

H2 console (when running with the `h2` profile):

- URL: http://localhost:8085/h2-console
- JDBC URL: jdbc:h2:mem:testdb
- User: sa
- Password: (leave blank)

Notes:

- The Maven profile `h2` adds the H2 dependency only when you explicitly enable it (`-Ph2`). This keeps production builds free of the H2 runtime.
- The JPA schema is configured to `create-drop` for the `h2` profile so data is ephemeral between runs.

---

## Development notes & tips

- The project targets Java 17. A Maven Enforcer rule and compiler plugin are configured to ensure reproducible builds.
- Lombok is used; if your IDE requires annotation-processing to be enabled, make sure it is turned on.
- Swagger/OpenAPI UI (springdoc) is available when the app runs; check `/swagger-ui.html` or `/swagger-ui/index.html` depending on the starter.

---

If you want, I can:

- Add a short CI step that runs the app with the `h2` profile and runs integration smoke tests.
- Remove the deprecated `application-local.yml` file (I already removed it from the repo).
- Add a short CONTRIBUTING section with local dev tips.

Follow me on Twitter ![Twitter Follow](https://img.shields.io/twitter/follow/rahulrao20?style=social)
