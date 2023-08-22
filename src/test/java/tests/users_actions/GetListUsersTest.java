package tests.users_actions;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.TestBase;
import models.get_list_users.GetListUsersResponseModel;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.GetListUsersSpecs.getListUsersRequestSpec;
import static specs.GetListUsersSpecs.getListUsersResponseSuccessful200Spec;
import static data.TestData.*;

@Epic("Пользователь")
@Feature("Получение списка пользователей")
public class GetListUsersTest extends TestBase {
    @Test
    @Tags({
            @Tag("Smoke"),
            @Tag("Regress")
    })
    @DisplayName("Получение списка на заданной странице и проверка данных одного из пользователей из списка")
    void successfulListUsersTest() {
        RestAssured.filters(withCustomTemplates());

        GetListUsersResponseModel getListUsersResponseModel = step("Запрос на получение списка пользователей", () ->
                given()
                        .spec(getListUsersRequestSpec)
                        .when()
                        .get("/users?page=" + PAGE_2)
                        .then()
                        .spec(getListUsersResponseSuccessful200Spec)
                        .extract().as(GetListUsersResponseModel.class));

        step("Проверка ответа", () -> {
            assertEquals(PAGE_2, getListUsersResponseModel.getPage());
            assertEquals(TOTAL_USERS, getListUsersResponseModel.getTotal());
            assertEquals(ID_9, getListUsersResponseModel.getData().get(2).getId());
            assertEquals(USER_ID_9_EMAIL, getListUsersResponseModel.getData().get(2).getEmail());
            assertEquals(USER_ID_9_FIRST_NAME, getListUsersResponseModel.getData().get(2).getFirstName());
            assertEquals(USER_ID_9_LAST_NAME, getListUsersResponseModel.getData().get(2).getLastName());
            assertEquals(USER_ID_9_IMAGE_PATH,
                    getListUsersResponseModel.getData().get(2).getAvatar());
        });
    }
}
