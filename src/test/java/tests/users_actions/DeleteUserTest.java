package tests.users_actions;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.DeleteUserSpecs.deleteUserSuccessful204ResponseSpec;
import static specs.DeleteUserSpecs.deleteUserRequestSpec;
import static data.TestData.ID_2;


public class DeleteUserTest extends TestBase {

    @Epic("Удаление пользователя")
    @Story("Позитивный сценарий")
    @DisplayName("Успешное удаление пользователя")
    @Test
    void successfulDeleteUser204() {
        RestAssured.filters(withCustomTemplates());

        step("Запрос на удаление пользователя", () ->
                given()
                        .spec(deleteUserRequestSpec)
                        .when()
                        .delete("/users/" + ID_2)
                        .then()
                        .spec(deleteUserSuccessful204ResponseSpec)
        );
    }
}
