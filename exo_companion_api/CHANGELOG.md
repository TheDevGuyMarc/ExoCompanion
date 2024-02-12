# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [0.3.4] - 2024-02-09

### Changed

- Image Saving in database for Aquatic Animal Endpoint
- Image Saving in database for Land Animal Endpoint
- Image Saving in database for Food Endpoint
- Image Saving in database for Substrate Endpoint

## [0.3.3] - 2024-02-09

### Added

- ERD Diagram for Application
- Class Diagram for Application

## [0.3.2] - 2024-02-09

### Changed

- Adding relation between Aquatic Animal Endpoint and Behavior Endpoint
- Adding relation between Aquatic Animal Endpoint and Category Endpoint
- Adding relation between Aquatic Animal Endpoint and Coloration Endpoint
- Adding relation between Aquatic Animal Endpoint and FeedingType Endpoint
- Adding relation between Aquatic Animal Endpoint and Food Endpoint
- Adding relation between Aquatic Animal Endpoint and Origin Endpoint
- Adding relation between Aquatic Animal Endpoint and Plant Endpoint
- Adding relation between Aquatic Animal Endpoint and Requirement Endpoint
- Adding relation between Aquatic Animal Endpoint and Rarity Endpoint

### Fixed

- Missing relation between Land Animal Endpoint and Origin Endpoint
- Missing relation between Land Animal Endpoint and Category Endpoint

### Removed

- Database dialect definition from application.yml because for PostgresSQL it is not needed 

## [0.3.1] - 2024-02-09

### Added

- Implementing AquaticAnimal Endpoint


## [0.2.10] - 2024-02-09

### Changed

- Adding name flag to requirement and substrate entity
- Checking module parts in README of from the roadmap

### Fixed

- Relation Mapping bug between LandAnimal Endpoint and Plant Endpoint


## [0.2.9] - 2024-02-09

### Added

- Implementing LandAnimal Endpoint + all relations to endpoints


## [0.2.8] - 2024-02-09

### Added

- Implementing Plant relation to land animal endpoint


## [0.2.7] - 2024-02-09

### Added

- Implementing Rarity Endpoint + relations


## [0.2.6] - 2024-02-09

### Added

- Implementing Requirement Endpoint + relations


## [0.2.5] - 2024-02-09

### Added

- Implementing Substrate Endpoint + relations


## [0.2.4] - 2024-02-09

### Added

- Implementing FeedingType Endpoint + relations


## [0.2.3] - 2024-02-09

### Added

- Implementing FeedingType Endpoint + relations


## [0.2.2] - 2024-02-09

### Changed

- Adding a relation to the coloration endpoint for land animals


## [0.2.1] - 2024-02-09

### Added

- Implementing Behavior Endpoint


## [0.1.23] - 2024-02-07

### Added

- Implementing CategoryRepository Test (Unit ?) might be not the best but helps to grasp some concepts for now, will write more later in development


## [0.1.22] - 2024-02-07

### Changed

- Adding profiles to pom.xml to have two commands for testing that allow executing only Unit or only Integration tests
- Adding AllArgsConstructor Annotation to all entities for easy object creation while testing


## [0.1.21] - 2024-02-07

### Added

- Implementing Scaffolding's for Unit and Integration tests for the plant module


## [0.1.20] - 2024-02-07

### Added

- spring-boot-starter-oauth2-resource-server because we intend to implement OAuth2 with Keycloak
- Implementing WebSecurityConfig to configure HTTP/HTTPS request authentication, CORS, JWT handling and CSRF handling

### Removed

- jsonwebtoken dependency because it is unnecessary when we implement Keycloak later on


## [0.1.19] - 2024-02-07

### Changed

- Changing table names from endpointName_entity to endpointName format with flag in Entity files

### Fixed

- Ignore patterns in .gitignore file where not grabbing all files


## [0.1.18] - 2024-02-07

### Changed

- Naming of order property to plantOrder,it caused a database bug because order is a reserved SQL Keyword

### Fixed

- Repository of Culture had a findByName method implemented that caused errors because of not existing name property


## [0.1.17] - 2024-02-07

### Fixed

- Relations between Plant Endpoint and Culture Endpoint where broken because of mismatching 1-1 relation


## [0.1.16] - 2024-02-07

### Added

- Implemented multiple stage environments with docker-compose locally (DEV, UAT)

### Fixed

- Repairing local docker-compose files, some services didn't have correct configurations
- Database config was wrong in application.yml


## [0.1.15] - 2024-02-06

### Added

- Adding a second application.yml file for configuring the Unit and Integration testing process
- Added jsonwebtoken dependency for security

### Changed

- Switching application.properties to YAML format for more readability and ease of use


## [0.1.14] - 2024-02-06

### Changed

- README's got changes in format to make it more readable and fill it with more valuable content


## [0.1.13] - 2024-02-05

### Added

- H2 came in as static in memory database for testing


## [0.1.12] - 2024-02-05

### Fixed

- Missing Mappings in Entities
- Missing final keyword in some DTO's

### Changed

- Removing unused imports
- Naming of variables in some modules wasn't correct 


## [0.1.11] - 2024-02-05

### Added

- Implemented database relations between Plant Endpoint and all dependency Endpoints


## [0.1.10] - 2024-02-05

### Added

- Implemented Origin Endpoint


## [0.1.9] - 2024-02-05

### Added

- Implemented Category Endpoint


## [0.1.8] - 2024-02-05

### Added

- Implemented Plant Endpoint


## [0.1.7] - 2024-02-05

### Added

- Implemented Coloration Endpoint


## [0.1.6] - 2024-02-05

### Added

- Implemented Culture Endpoint


## [0.1.5] - 2024-02-05

### Added

- Implemented Plant Type Endpoint


## [0.1.4] - 2024-02-05

### Added

- Implemented Rarity Endpoint


## [0.1.3] - 2024-02-05

### Added

- Implemented Location Endpoint


## [0.1.2] - 2024-02-05

### Added

- Implemented Growspeed Endpoint


## [0.1.1] - 2024-02-05

### Added

- Implemented Difficulty Endpoint


## [0.0.1] - 2024-02-05

### Added

- Project Scaffold API (Springboot)
- Project Scaffold Scraper (Springboot)
- Project Scaffold UI (React-Typescript)
