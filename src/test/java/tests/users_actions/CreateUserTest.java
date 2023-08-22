package tests.users_actions;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import models.create_user.CreateUserRequestBodyModel;
import models.create_user.CreateUserResponseBodyModel;
import tests.TestBase;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.CreateUserSpecs.createUserRequestSpec;
import static specs.CreateUserSpecs.*;
import static data.TestData.userJob;
import static data.TestData.userName;

@Epic("Пользователь")
@Feature("Создание пользователя")
public class CreateUserTest extends TestBase {
    @Test
    @Tags({
            @Tag("Smoke"),
            @Tag("Regress")
    })
    @DisplayName("Создание нового пользователя с валидными данными")
    void successfulCreateNewUserTest() {
        RestAssured.filters(withCustomTemplates());

        CreateUserRequestBodyModel requestBody = new CreateUserRequestBodyModel();
        requestBody.setName(userName);
        requestBody.setJob(userJob);

        CreateUserResponseBodyModel createUserResponseBodyModel =
                step("Запрос на создание пользователя", () ->
                        given()
                                .spec(createUserRequestSpec)
                                .body(requestBody)
                                .when()
                                .post("/users")
                                .then()
                                .spec(createUserSuccessful201ResponseSpec)
                                .extract().as(CreateUserResponseBodyModel.class));

        step("Проверка ответа", () -> {
            assertEquals(userName, createUserResponseBodyModel.getName());
            assertEquals(userJob, createUserResponseBodyModel.getJob());
        });
    }
}
