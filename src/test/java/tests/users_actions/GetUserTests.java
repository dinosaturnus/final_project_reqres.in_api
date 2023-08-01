package tests.users_actions;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import models.get_user.GetUserResponseModel;
import tests.TestBase;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static helpers.CustomAllureListener.withCustomTemplates;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.GetUserSpecs.*;
import static data.TestData.*;

public class GetUserTests extends TestBase {

    @Epic("Получение информации о пользователе")
    @Story("Позитивный сценарий")
    @DisplayName("Получение информации о существующем пользователе")
    @Test
    void successfulSingleUser200() {
        RestAssured.filters(withCustomTemplates());

        GetUserResponseModel getUserResponseModel = step("Запрос на получение информации о пользователе", () ->
                given()
                        .spec(getUserRequestSpec)
                        .when()
                        .get("/users/" + ID_2)
                        .then()
                        .spec(getUserSuccessful200ResponseSpec)
                        .extract().as(GetUserResponseModel.class));

        step("Проверка ответа", () -> {
            assertEquals(ID_2, getUserResponseModel.getData().getId());
            assertEquals(USER_ID_2_EMAIL, getUserResponseModel.getData().getEmail());
            assertEquals(USER_ID_2_FIRST_NAME, getUserResponseModel.getData().getFirstName());
            assertEquals(USER_ID_2_LAST_NAME, getUserResponseModel.getData().getLastName());
            assertEquals(USER_ID_2_IMAGE_PATH, getUserResponseModel.getData().getAvatar());
        });
    }

    @Epic("Получение информации о пользователе")
    @Story("Негативные сценарии")
    @Tag("GET")
    @DisplayName("Получение информации о несуществующем пользователе")
    @Test
    void unsuccessfulSingleUserDoesNotExist404() {
        RestAssured.filters(withCustomTemplates());

        step("Запрос на получение информации о пользователе", () ->
                given()
                        .spec(getUserRequestSpec)
                        .when()
                        .get("/users/" + ID_0)
                        .then()
                        .spec(getUserUnsuccessful404ResponseSpec)
        );
    }
}

