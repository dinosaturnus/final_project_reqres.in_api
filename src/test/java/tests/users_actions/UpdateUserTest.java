package tests.users_actions;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import models.update_user.UpdateUserRequestBodyModel;
import models.update_user.UpdateUserResponseBodyModel;
import tests.TestBase;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static helpers.CustomAllureListener.withCustomTemplates;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.UpdateUserSpecs.updateUserRequestSpec;
import static specs.UpdateUserSpecs.updateUserSuccessful200ResponseSpec;
import static data.TestData.*;

@Epic("Пользователь")
@Feature("Редактирование данных пользователя методом PUT")
public class UpdateUserTest extends TestBase {
    @Test
    @Tags({
            @Tag("Smoke"),
            @Tag("Regress")
    })
    @DisplayName("Передача валидного значения: работа")
    void successfulUpdateUserTest() {
        RestAssured.filters(withCustomTemplates());

        UpdateUserRequestBodyModel requestBody = new UpdateUserRequestBodyModel();
        requestBody.setName(userName);
        requestBody.setJob(userNewJob);

        UpdateUserResponseBodyModel updateUserResponseBodyModel = step("Запрос на редактирование пользователя", () ->
                given()
                        .spec(updateUserRequestSpec)
                        .body(requestBody)
                        .when()
                        .put("/users/" + ID_2)
                        .then()
                        .spec(updateUserSuccessful200ResponseSpec)
                        .extract().as(UpdateUserResponseBodyModel.class));

        step("Проверка ответа", () -> {
            assertEquals(userName, updateUserResponseBodyModel.getName());
            assertEquals(userNewJob, updateUserResponseBodyModel.getJob());
        });
    }
}
