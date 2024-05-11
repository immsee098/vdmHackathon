package metlife.team01.application.acceptance;

import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.util.UUID;
import metlife.team01.application.adapter.in.controller.categoryDisplay.model.CategoryDisplayRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;

@Sql("/data.sql")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CategoryDisplayAcceptanceTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    @DisplayName("메인 카테고리를 조회한다.")
    void getCategoryByMenuLvl() {
        CategoryDisplayRequest request = new CategoryDisplayRequest(
                1,
                1,
                "보험",
                "chatResponse",
                "2024-03-23 20:47:19",
                "2024-03-23 20:47:19",
                null,
                null
        );

        RestAssured.given().log().all()
                .when()
                .header("UUID_per", UUID.randomUUID())
                .contentType(ContentType.JSON)
                .body(request)
                .post("/v1/api/availableCategory")
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value())
                .assertThat()
                .body("resultMessage", equalTo("정상 처리 되었습니다."))
                .rootPath("item")
                .body("[0].codeName", equalTo("보상"))
                .body("[1].codeName", equalTo("보험"))
                .body("[2].codeName", equalTo("대출"))
                .body("[3].codeName", equalTo("홈페이지"))
                .body("[4].codeName", equalTo("기타"));
    }
}
