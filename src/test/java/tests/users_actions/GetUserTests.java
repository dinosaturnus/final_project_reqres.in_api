package tests.users_actions;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import models.get_user.GetUserResponseModel;
import tests.TestBase;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static helpers.CustomAllureListener.withCustomTemplates;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.GetUserSpecs.*;
import static data.TestData.*;

@Epic("Пользователь")
@Feature("Получение данных пользователя")
public class GetUserTests extends TestBase {
    @Test
    @Tags({
            @Tag("Smoke"),
            @Tag("Regress")
    })
    @DisplayName("Получение информации о существующем пользователе")
    void successfulSingleUserTest() {
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

    @Test
    @Tag("Regress")
    @DisplayName("Получение информации о несуществующем пользователе")
    void unsuccessfulSingleUserDoesNotExistTest() {
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

