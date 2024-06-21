package swift.sandbox.bg.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.List;
import java.util.Optional;

import swift.sandbox.bg.player.model.BgPlayer;
import swift.sandbox.bg.player.model.BgPlayerRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class ServiceConnectionIntegrationTest {

    private static final String TEST_USER_BASIC_PASS = "work";

    private static final String TEST_USER_BASIC_NAME = "temporary";

    @Container
    @ServiceConnection
    static MySQLContainer<?> container = new MySQLContainer<>("mysql:latest");

    @Autowired
    private BgPlayerRepository repository;

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void whenRequestingHobbits_thenReturnFrodoAndSam() {
        repository.saveAll(List.of(
                new BgPlayer("FirstTestAgain", "SurTest"),
                new BgPlayer("TwoTest", "SurTestTwo")));
        
        Optional<BgPlayer> byId = repository.findById(1);
        BgPlayer bgPlayer = byId.get();

        given().log().all()
        .auth().basic(TEST_USER_BASIC_NAME, TEST_USER_BASIC_PASS)
        .when()
        .get("/player?playerId=1")
                .then().log().all().statusCode(200);
    }

}
