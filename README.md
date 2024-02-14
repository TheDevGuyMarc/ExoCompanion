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

- [ ] Implement Plant DB
- [ ] Testing
    - [ ] Unit Tests
    - [ ] Integration Tests
- [ ] Implement Land Animal DB
- [ ] Testing
    - [ ] Unit Tests
    - [ ] Integration Tests
- [ ] Implement Aquatic Animal DB
- [ ] Testing
    - [ ] Unit Tests
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

#### Single Container Commands

**PostgresSQL**

```shell
  docker run --name postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres
```

**[Redis](https://www.docker.com/blog/how-to-use-the-redis-docker-official-image/)**

```shell
docker run --name some-redis -d redis redis-server --save 60 1 --loglevel warning

docker network create some-network

​​docker run -it --network some-network --rm redis redis-cli -h some-redis
```

**[Mailhog]()**

```shell
docker run -d -e "MH_STORAGE=maildir" -v $PWD/maildir:/maildir -p 1025:1025 -p 8025:8025 mailhog/mailhog
```

### Run Local UAT Environment

```shell
  docker-compose -f docker-compose.test.yml up
```

## Tests

With ExoCompanion we test each module before release, that means we do unit and integration tests (automated) before new
features reach the customer. What do we test how ?

**Unit Tests**:

- Service

```java
// Example Unit test

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

    @Mock
    private MyRepository myRepository;

    @InjectMocks
    private MyService myService;

    @Test
    public void testCalculateSomething() {
        // Arrange
        when(myRepository.getData()).thenReturn(5);

        // Act
        int result = myService.calculateSomething();

        // Assert
        assertEquals(10, result);
    }
}
```

**Integration Tests**:

- Repository
- Controller

```java
// Example Integration Test for Repositories

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class MyRepositoryIntegrationTest {

    @Autowired
    private MyRepository myRepository;

    @Test
    public void testDataAccess() {
        // Save some data
        MyEntity entity = new MyEntity();
        entity.setData("Test");
        myRepository.save(entity);

        // Retrieve the saved data
        MyEntity savedEntity = myRepository.findById(entity.getId()).orElse(null);

        // Assert
        assertEquals("Test", savedEntity.getData());
    }
}
```

```java
// Example Integration Test for Controllers

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class MyControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/my-endpoint")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
```

**Performance Tests (Gatling)**:

- Application

```xml
<test>
    <dependencies>
        <!-- Gatling dependencies -->
        <dependency>
            <groupId>io.gatling</groupId>
            <artifactId>gatling-core</artifactId>
            <version>3.6.1</version> <!-- Adjust version as needed -->
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.gatling</groupId>
            <artifactId>gatling-http</artifactId>
            <version>3.6.1</version> <!-- Adjust version as needed -->
            <scope>test</scope>
        </dependency>
    </dependencies>
    
    
    <build>
    <plugins>
        <!-- Gatling Maven plugin -->
        <plugin>
            <groupId>io.gatling</groupId>
            <artifactId>gatling-maven-plugin</artifactId>
            <version>3.2.1</version> <!-- Adjust version as needed -->
            <executions>
                <execution>
                    <phase>test</phase>
                    <goals>
                        <goal>test</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
    </build>
</test>
```

```java
// Example Performance Test for Application

import io.gatling.core.scenario.Simulation;
import io.gatling.core.Predef.*;
import io.gatling.http.Predef.*;
import scala.concurrent.duration.*;

public class MyJavaPerformanceSimulation extends Simulation {

    private HttpProtocolBuilder httpProtocol = http()
            .baseUrl("http://localhost:8080") // Adjust port and URL as per your Spring Boot application
            .acceptHeader("application/json")
            .contentTypeHeader("application/json");

    private ScenarioBuilder scn = scenario("My Performance Test")
            .exec(http("My Request")
                    .get("/api/my-endpoint"));

    public MyJavaPerformanceSimulation() {
        setUp(
                scn.inject(
                        rampUsers(1000).during(10) // Adjust the number of users and duration as per your requirement
                )
        ).protocols(httpProtocol);
    }
}
```

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
                            <include>**/*Test.java</include>
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
                            <include>**/*IntegrationTest.java</include>
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

### Run Performance Tests

1. Make sure you have Gatling installed.
2. Save the simulation script in a .java file, for example, MyJavaPerformanceSimulation.java.
3. Compile the Java file using your preferred Java compiler.
4. Run Gatling and provide the path to the compiled class file containing the simulation.

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

## Requirements

- Aquarium Animal DB
    - Data:
        - [Sweet water Fish](https://www.flowgrow.de/db/fische)
        - [Sweet water Fish2](https://aquainfo.org/product-category/freshwater/fish/common-freshwater-fish-names/)
        - [Sweet water Invertebrates](https://www.flowgrow.de/db/wirbellose)
        - [Saltwater Fish](https://aquainfo.org/product-category/saltwater/fish-saltwater/common-fish-saltwater/)
        - Saltwater Invertebrates
            - [Slugs](https://aquainfo.org/product-category/saltwater/sea-slugs)
            - [Cuttlefish](https://aquainfo.org/product-category/saltwater/cuttlefish/)
            - [Crustaceans](https://aquainfo.org/product-category/saltwater/crustaceans-saltwater/)
    - Requirements:
        - Create (Admin)
        - Read
        - Update (Admin)
        - Delete (Admin)
        - List
        - Filter
    - Data Model:
        - [X] **Aquatic** **Animal**
            - name: ``String``
            - engName: ``String``
            - latName: ``String``
            - root: ``String``
            - subroot: ``String``
            - class: ``String``
            - subclass: ``String``
            - order: ``String``
            - subOrder: ``String``
            - family: ``String``
            - genus: ``String``
            - categories: ``List<Category>``
            - image: ``String``
            - sizeMaleMin: ``int``
            - sizeMaleMax: ``int``
            - sizeFemaleMin: ``int``
            - sizeFemaleMax: ``int``
            - sexDifference: ``String``
            - nanoTank: ``boolean``
            - speciesTank: ``boolean``
            - recommendedTankSize: ``int``
            - tempMin: ``int``
            - tempMax: ``int``
            - khMin: ``int``
            - khMax: ``int``
            - phMin: ``int``
            - phMax: ``int``
            - co2Min: ``int``
            - co2Max: ``int``
            - ghMin: ``int``
            - ghMax: ``int``
            - requirements: ``List<Requirement>``
            - foodOptions: ``List<Food>``
            - feedingTypes: ``List<FeedingType>``
            - plantsRecommended: ``boolean``
            - unfitPlants: ``List<Plant>``
            - plantBehaviour: ``List<Behavior``
            - breedingPossible: ``boolean``
            - breedingType: ``String``
        - [X] **Category**
            - name: ``String``
            - description: ``String``
        - [X] **Origin**
            - name: ``String``
            - description: ``String``
            - tempMin: ``int``
            - tempMax: ``int``
            - dayCycle: ``ìnt``
        - [X] **Food**
            - name: ``String``
            - description: ``String``
            - image: ``String``
            - manufacturer: ``String``
            - amount: ``double``
            - price: ``double``
        - [X] **FeedingType**
            - name: ``String``
            - description: ``String``
        - [X] **Requirement**
            - name: ``String``
            - description: ``String``
        - [X] **Behavior**
            - name: ``String``
            - description: ``String``
- Terrarium Animal DB
    - Data:
        - Reptiles
        - Invertebrates
        - Amphibians
    - Requirements:
        - Create (Admin)
        - Read
        - Update (Admin)
        - Delete (Admin)
        - List
        - Filter
    - Data Model:
        - [X] **Land Animal**
            - name: ``String``
            - engName: ``String``
            - latName: ``String``
            - class: ``String``
            - subclass: ``String``
            - order: ``String``
            - family: ``String``
            - categories: ``List<Category>``
            - image: ``String``
            - sizeMaleMin: ``int``
            - sizeMaleMax: ``int``
            - sizeFemaleMin: ``int``
            - sizeFemaleMax: ``int``
            - sexDifference: ``String``
            - speciesTank: ``boolean``
            - recommendedTankSize: ``int``
            - tempMin: ``int``
            - tempMax: ``int``
            - moistureMin: ``int``
            - moistureMax: ``int``
            - requirements: ``List<Requirement>``
            - foodOptions: ``List<Food>``
            - feedingTypes: ``List<FeedingType>``
            - plantsRecommended: ``boolean``
            - unfitPlants: ``List<Plant>``
            - plantBehaviour: ``List<Behavior``
            - breedingPossible: ``boolean``
            - breedingType: ``String``
    - [X] **Substrate**:
        - name: ``String``
        - description: ``String``
        - image: ``String``
        - manufacturer: ``String``
        - amount: ``double``
        - price: ``double``
- Plant DB
    - Data:
        - [Aquarium](https://www.flowgrow.de/db/wasserpflanzen)
            - [Anemones](https://aquainfo.org/product-category/saltwater/anemones/)
            - [Corals](https://reefs.com/coral/)
        - Terrarium
    - Requirements:
        - Create (Admin)
        - Read
        - Update (Admin)
        - Delete (Admin)
        - List
        - Filter
    - Data Model:
        - [X] **Plant**
            - name: ``String``
            - engName: ``String``
            - latName: ``String``
            - synonyms: ``List<String>``
            - group: ``String``
            - order: ``String``
            - family: ``String``
            - genus: ``String``
            - image: ``String``
            - categories: ``List<Category>``
            - plantType: ``List<PlantType>``
            - heightMin: ``int``
            - heightMax: ``int``
            - widthMin: ``int``
            - widthMax: ``int``
            - origins: ``List<Origin>``
            - culture: ``Culture``
            - aquariumSuitability: ``boolean``
            - difficulty: ``Difficulty``
            - locations: ``List<Location>``
            - rarity: ``Rarity``
        - [X] **Coloration**
            - name: ``String``
            - description: ``String``
        - [X] **Location**
            - name: ``String``
            - description: ``String``
        - [X] **PlantType**
            - name: ``String``
            - description: ``String``
            - image: ``byte[]``
        - [X] **Rarity**:
            - name: ``String``
            - description: ``String``
        - [X] **Difficulty**
            - name: ``String``
            - description: ``String``
        - [X] **Culture**:
            - lightDemand: ``String``
            - tempMin: ``double``
            - tempMax: ``double``
            - khMin: ``double``
            - khMax: ``double``
            - phMin: ``double``
            - phMax: ``double``
            - co2Min: ``double``
            - co2Max: ``double``
            - no3Min: ``double``
            - mo3Max: ``double``
            - po4Min: ``double``
            - po4Max: ``double``
            - kMin: ``double``
            - kMax: ``double``
            - feMin: ``double``
            - feMax: ``double``
            - growspeed: ``Growspeed``
            - cultivation: ``String``
            - canGrowEmerse: ``String``
            - winterDurability: ``boolean``
            - colorations: ``List<Coloration>``
        - [X] **Growspeed**:
            - name: ``String``
            - description: ``String``
- Technical Appliance DB
- Data:
  - CO²
    - Drop Checker
    - Pressure Regulator
    - Solenoid Valve
    - Bubble Counter
    - Counter Fluid
    - Controller
    - Pressure Resistance Tube
    - Cylinder
    - Diffusor
    - Back-flow Preventer
    - Washer
    - Reactor
    - Fitting
  - Filters
  - Lights
    - T5
    - T8
    - LED
    - LED-Background
    - Accessories
  - Heating
  - Reverse Osmosis
  - Cooling
  - Aeration
  - UV-Filters
  - Controllers
  - Pumps
  - Dosing Pumps
  - Skimmers
  - Smart Plugs
- Requirements:
  - Create (Admin)
  - Read
  - Update (Admin)
  - Delete (Admin)
  - List
  - Filter
- Model:
  - [ ] Article:
      - id: Long
      - name: String
      - description: String
      - image: byte[]
      - manual: byte[]
      - price: double
      - smart: boolean
      - app_download_ios: String
      - app_download_android: String
      - width: double
      - height: double
      - depth: double
      - weight: double
      - ean: Long
      - manufacturer: Manufacturer
      - guarantee: int
      - freshwater: boolean
      - seawater: boolean
      - cable_length: double
      - cable_type: String
      - power_supply_included: boolean
      - power_consumption: double
      - recommended_tank_size: double
      - voltage: double
      - input_power: double
      - battery: **BatteryType**[ENUM]
      - batteries_included: boolean
      - accessories: List<Accessoire>
      - protection_class: **ProtectionClass**[ENUM]
      - material: **Material**[ENUM]
  - [ ] CO²:
      - all data available for now !
  - [ ] Filters:
      - delivery_head_approx: double
      - heater: boolean
      - volume: double
      - prefilter_volume: double
      - container_volume: double
      - filter_type: **Type**[ENUM]
  - [ ] Lighting:
      - glass_thickness: double
      - led_quantity: int
      - luminous_flux: double
      - color_temp: double
      - led_colors: String
      - waterproof_level: String
      - color: String
      - energy_efficiency: String
      - min_energy_efficiency_class: String
      - max_energy_efficiency_class: String
      - light_type: String
      - wifi: String
  - [ ] Heating:
      - min_temp: double
      - max_temp: double
      - submersible: boolean
  - [ ] Reverse Osmosis:
      - gpd_output: double
      - retention_rate: double
      - pressure: double
      - connection: String
  - [ ] Cooling:
      - motor_revolution: double
      - op_temp: double
  - [ ] Aeration:
      - power: double
      - pump_head_approx: double
      - hose_size: **HoseSize**[ENUM]
      - max_flow_rate: double
  - [ ] UV-Filters:
      - hose_size: **HoseSize**[ENUM]
      - lamp_wattage: double
      - protection_class: String
      - max_op_pressure: double
      - water_temp_max: double
  - [ ] Pumps:
      - max_flowrate: double
      - max_headheight: double
      - hose_connection: String
      - installation: String
  - [ ] Dosing Pump:
      - dosing_heads: int
      - hose_connection: String
      - dose_flow: double
      - bpt: double
      - operating_temps: double
      - rel_humidity: double
  - [ ] Skimmers:
      - hose-pressure: double
      - hose_size: String
  - [ ] Smart Plugs:
      - installation: String
      - rating: String
      - setting time: double
      - operating temperatures: double
- Food & Supplements DB
    - Data:
        - Aquarium Food
        - Terrarium Food
        - Supplements
        - Medication
    - Requirements:
        - Create (Admin)
        - Read
        - Update (Admin)
        - Delete (Admin)
        - List
        - Filter
- Model:
    - [ ] Food:
        - id: Long
        - name: String
        - description: String
        - image: byte[]
        - price: double
        - fish_size: double
        - ingredients: List<Ingredient>
        - analytical_ingredients: List<AnalyticalIngredient>
        - supplements: List<AnalyticalIngredient>
        - packaging: String
        - size: double
        - ean: String
        - weight: double
        - manufacturer: String
        - sinking: boolean
        - type: **FoodType**[ENUM]
    - [ ] Supplement:
        - id: Long
        - name: String
        - description: String
        - image: byte[]
        - price: double
        - ingredients: List<Ingredient>
        - analytical_ingredients: List<AnalyticalIngredient>
        - supplements: List<AnalyticalIngredient>
        - packaging: String
        - ean: String
        - weight: double
        - manufacturer: String
- Water Chemistry DB
    - Data:
        - Water Supplements
    - Requirements:
        - Create (Admin)
        - Read
        - Update (Admin)
        - Delete (Admin)
        - List
        - Filter
- Calculators
    - Aquarium Dimension Calculator
        - Size:
            - Quader
            - Cube
            - Bowed Front
            - Bugfront
            - Cylinder
            - Half Cylinder
            - Quarter Cylinder
            - Triangular
            - Sphere
        - Volume + Netto Volume:
            - Quader
            - Cube
            - Bowed Front
            - Bugfront
            - Cylinder
            - Half Cylinder
            - Quarter Cylinder
            - Triangular
            - Sphere
    - Aquarium Water Calculator
        - Water Amount Calculation
        - CO² Concentration Calculation
        - Water Blending (GK / KH) Calculation
        - Water Blending Conductivity Calculation
        - Temp Change Water Calculation
        - Dilution Calculation
    - Terrarium Dimension Calculator (Size, Volume, Netto Volume)
        - Size:
            - Quader
            - Cube
            - Bowed Front
        - Volume + Netto Volume:
            - Quader
            - Cube
            - Bowed Front
    - Sealant Calculator
        - Sealant Amount Calculation
        - Sealant Cartridge Calculation
    - Substrate Calculator
        - Substrate Amount Calculation
        - Substrate Amount Sloped (Left/Right) Calculation
        - Substrate Amount Sloped (Front/Back) Calculation
    - Occupation Calculator
        - Calculate Aquarium Occupation Amount
          - Compatibility Checker:
          - [Sweet water](https://www.aquariumindustries.com.au/wp-content/uploads/2015/03/Freshwater-Fish-Compatibility-Chart.pdf)
          - [Saltwater](https://www.bulkreefsupply.com/content/post/md-2016-04-species-database)
        - Calculate Terrarium Occupation Amount
    - Running Cost Calculator
        - Energy Consumption Calculation (Per Day, Per Month, Per Year)
        - Energy Cost Calculation (Per Day, Per Month, Per Year)
        - Water Cost Calculation (Per Day, Per Month, Per Year)
        - Food Cost Calculation (Per Day, Per Month, Per Year)
    - Light Demand Calculator
        - Light Demand by Tank size & Tech Calculation
        - Light intensity calculation
    - [Fertilizer Calculator](https://www.flowgrow.de/db/calculator/dose)
- Services:
    - Custom Aquarium/Terrarium Service
    - Light Color Tester
    - Unit Conversion Service
        - Fahrenheit - Celsius
        - Celsius - Fahrenheit
        - Drops - ml
        - ml - Drops
        - gestr. Esslöffel - ml / g
        - Gallon (US) - Liter
        - Liter - Gallon (US)
        - Gallon (GB) - Liter
        - Liter - Gallon (GB)
        - cm - inch
        - inch - cm
        - mm - cm
        - cm - mm
        - watt - kilowatt
        - kilowatt - watt
        - Percentage
