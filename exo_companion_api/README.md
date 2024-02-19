![Logo](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/th5xamgrr6se0x5ro4g6.png)

# ExoCompanion

ExoCompanion is a tool to aid aquaristics and terraristics fans to be even better with their hobbies. It provides large
databases regarding animals, plants and much more, as well as tools to calculate and check various metrics.

## Tech Stack

- Java 21
- Springboot
- Spring Security
- PostgresSQL
- Redis
- GSON
- Lombok
- Tinylog

## Features

### ExoCompanion API

- PlantDB (CRUDL)
- LandAnimalDB (CRUDL)
- AquaticAnimalDB (CRUDL)
- TechnicalApplianceDB (CRUDL)
- FoodSupplementsDB (CRUDL)
- Water Chemistry DB (CRUDL)
- Calculators
  - Tank Dimension Calculators
  - Tank Volume Calculators
  - Water Calculators (Water Chemistry)
  - Sealant Calculators
  - Substrate Calculators
  - Occupation Calculators
  - Running Cost Calculators
  - Light Demand Calculators
- Custom Tank Builder
- Light Color Tester
- Unit Conversions
- Showroom Creator

### ExoCompanion Scraper

- Web-scraping
  - Wikipedia
  - ReptileDB
  - Reef
  - InterAquaristik
  - etc.
- Formatting Data to JSON

## Roadmap

Keep in mind that this is the overall Roadmap, for the specific Roadmap look in the Roadmap.md file in each subproject.

- [X] Implement Plant DB
- [ ] Testing
  - [X] Unit Tests
  - [ ] Integration Tests
- [X] Implement Land Animal DB
- [ ] Testing
  - [X] Unit Tests
  - [ ] Integration Tests
- [X] Implement Aquatic Animal DB
- [ ] Testing
  - [X] Unit Tests
  - [ ] Integration Tests
- [ ] Implement Technical Appliance DB
- [ ] Testing
  - [ ] Unit Tests
  - [ ] Integration Tests
- [ ] Implement Food & Supplements DB
- [ ] Testing
  - [ ] Unit Tests
  - [ ] Integration Tests
- [ ] Implement Water Chemistry DB
- [ ] Testing
  - [ ] Unit Tests
  - [ ] Integration Tests
- [ ] Implement Tank Dimension Calculators
  - [ ] Size
  - [ ] Volume
  - [ ] Netto Volume
- [ ] Testing
  - [ ] Unit Tests
  - [ ] Integration Tests
- [ ] Implement Tank Water Calculators
  - [ ] Water Amount
  - [ ] CO² Concentration
  - [ ] Water Blending (GH/KH)
  - [ ] Water Blending (Conductivity)
  - [ ] Temp Change Water Calculation
  - [ ] Dilutions
- [ ] Testing
  - [ ] Unit Tests
  - [ ] Integration Tests
- [ ] Implement Sealant Calculators
  - [ ] Sealant Amount
  - [ ] Sealant Cartridge Amount
- [ ] Testing
  - [ ] Unit Tests
  - [ ] Integration Tests
- [ ] Implement Substrate Calculators
  - [ ] Substrate Amount
  - [ ] Substrate Amount Sloped
- [ ] Testing
  - [ ] Unit Tests
  - [ ] Integration Tests
- [ ] Implement Occupation Calculators
  - [ ] Aquarium Occupation
  - [ ] Compatibility Checker
  - [ ] Terrarium Occupation
- [ ] Testing
  - [ ] Unit Tests
  - [ ] Integration Tests
- [ ] Implement Running Cost Calculators
  - [ ] Energy Consumption (Day, Week, Month, Year)
  - [ ] Energy Cost (Day, Week, Month, Year)
  - [ ] Water Cost (Day, Week, Month, Year)
  - [ ] Food Cost (Day, Week, Month, Year)
- [ ] Testing
  - [ ] Unit Tests
  - [ ] Integration Tests
- [ ] Implement Light Demand Calculators
  - [ ] Light Demand by Dimensions
  - [ ] Light Intensity
- [ ] Testing
  - [ ] Unit Tests
  - [ ] Integration Tests
- [ ] Implement Fertilizer Calculators
- [ ] Testing
  - [ ] Unit Tests
  - [ ] Integration Tests

## Installation

If you want to install ExoCompanion Locally you need some prerequisites to make this work.

### Docker Way

- Install Docker & Docker Compose

### Installation Way

- Install Node 20.x.x
- Install Java 21.x.x
- Install Maven latest
- Install Docker & Docker Compose

## Development

### Run Local DEV Environment

```shell
  docker-compose -f docker-compose.dev.yml up
```

### Run Local UAT Environment

```shell
  docker-compose -f docker-compose.test.yml up
```

## Tests

With ExoCompanion we test each module before release, that means we do unit and integration tests (automated) before new
features reach the customer. What do we test how ?

**Unit Tests**:

- Repository
- Service

**Integration Tests**:

- Controller

### Run Tests

**Maven Profiles:**

```xml

<profiles>
  <profile>
    <id>unit-test</id>
    <build>
      <plugins>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-surefire-plugin</artifactId>
          <configuration>
            <includes>
              <include>**/Test*.java</include>
            </includes>
          </configuration>
        </plugin>
      </plugins>
    </build>
  </profile>
  <profile>
    <id>integration-test</id>
    <build>
      <plugins>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-surefire-plugin</artifactId>
          <configuration>
            <includes>
              <include>**/IntegrationTest*.java</include>
            </includes>
          </configuration>
        </plugin>
      </plugins>
    </build>
  </profile>

</profiles>
```

```bash
  mvn test -Punit-test // profile name is unit-test for unit tests
  mvn test -Pintegration-test //// profile name is integration-test for integration tests
```

## Screenshots

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)

## Usage/Examples

## Documentation

You can find the [official documentation](#) on our website for usage examples and tutorials.

## FAQ

#### Is ExoCompanion Free ?

Yes for now ExoCompanion is totally free, that might change at a later point though but don't worry if you made a free
account you will be free forever.

#### Is ExoCompanion for Aquariums and Terrariums ?

Yes it is and also for Paludariums and Vivariums if you want, we do all animals in tanks.

#### What do I do if my animal/plant/tech is not in the DB ?

No worries you can simply contact us, and we will try to add the data as fast as we can.

#### What do I do if I see errors in the data ?

You can write an email to us with a correction proposal, we will cross-check this then and if this is really an error we
will change the dataset.

## Support

If you need any technical or functional support don't hesitate to write us an email we will reach back to you as fast as
we can.

## License

[AGPLv3](https://https://choosealicense.com/licenses/agpl-3.0/)

