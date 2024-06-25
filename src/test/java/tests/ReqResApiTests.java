package tests;

import models.UsersListResponseModel;
import models.UpdateUserResponseModel;
import models.UserBodyRequestModel;
import models.CreateUserResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.UserSpec.*;


public class ReqResApiTests extends TestBase {

    @DisplayName("Создание пользователя")
    @Test
    public void createUserTest() {
        UserBodyRequestModel userData = new UserBodyRequestModel();
        userData.setName("morpheus");
        userData.setJob("leader");

        CreateUserResponseModel response = step("Запрос на создание пользователя", () ->
                given(userRequestSpec)
                        .body(userData)
                        .when()
                        .post("/users")
                        .then()
                        .spec(userResponse201Spec)
                        .extract().as(CreateUserResponseModel.class)
        );

        step("Проверка созданного пользователя", () -> {
            assertThat(response.getName()).isEqualTo("morpheus");
            assertThat(response.getJob()).isEqualTo("leader");
            assertThat(response.getId()).isNotNull();
            assertThat(response.getCreatedAt()).isNotNull();
        });


    }

    @DisplayName("Редактирование пользователя")
    @Test
    public void updateUserTest() {
        UserBodyRequestModel userData = new UserBodyRequestModel();
        userData.setName("morpheus");
        userData.setJob("zion resident");

        UpdateUserResponseModel response = step("Запрос на полное обновление пользователя", () ->
                given(userRequestSpec)
                        .body(userData)
                        .when()
                        .put("/users/2")
                        .then()
                        .spec(userResponse200Spec)
                        .extract().as(UpdateUserResponseModel.class));

        step("Проверка обновленного пользователя", () -> {
            assertThat(response.getName()).isEqualTo("morpheus");
            assertThat(response.getJob()).isEqualTo("zion resident");
            assertThat(response.getUpdatedAt()).isNotNull();
        });
    }

    @DisplayName("Частичное редактирование пользователя")
    @Test
    public void partUpdateUserTest() {
        UserBodyRequestModel userData = new UserBodyRequestModel();
        userData.setName("morpheus");
        userData.setJob("zion resident");

        UpdateUserResponseModel response = step("Запрос на частичное обновление пользователя", () ->
                given(userRequestSpec)
                        .body(userData)
                        .when()
                        .patch("/users/2")
                        .then()
                        .spec(userResponse200Spec)
                        .extract().as(UpdateUserResponseModel.class));

        step("Проверка обновленного пользователя", () -> {
            assertThat(response.getName()).isEqualTo("morpheus");
            assertThat(response.getJob()).isEqualTo("zion resident");
            assertThat(response.getUpdatedAt()).isNotNull();
        });
    }

    @DisplayName("Удаление пользователя")
    @Test
    public void deleteUserTest() {
        step("Запрос на удаление пользователя", () ->
                given(userRequestSpec)
                        .when()
                        .delete("/users/2")
                        .then()
                        .spec(userResponse204Spec)
        );
    }


    @DisplayName("Список пользователей")
    @Test
    public void usersListTest() {
        UsersListResponseModel response = step("Запрос на получение списка пользователей", () ->
                given(userRequestSpec)
                        .when()
                        .queryParam("page", "2")
                        .get("/users")

                        .then()
                        .spec(userResponse200Spec)
                        .extract().as(UsersListResponseModel.class)
        );

        step("Проверка списка пользователей", () -> {
            assertThat(response.getPage()).isEqualTo(2);
            assertThat(response.getPer_page()).isEqualTo(6);
            assertThat(response.getTotal()).isEqualTo(12);
            assertThat(response.getTotal_pages()).isEqualTo(2);
            assertThat(response.getData()).hasSize(6);
        });
    }
}