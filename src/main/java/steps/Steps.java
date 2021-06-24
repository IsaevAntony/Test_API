package steps;

import data.classes.Data;
import data.classes.People;
import data.classes.PeopleCreated;
import data.classes.Resource;
import io.qameta.allure.Step;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class Steps {
    @Step("Проверяем Json Resource на отсутствие нулевых полей")
    public static void checkNotNull(Resource resource){
        Assert.assertNotNull(resource.getPage(), "Поле номер страницы пустое");
        Assert.assertNotNull(resource.getPer_page(), "Поле колличество объектов на странице пустое");
        Assert.assertNotNull(resource.getTotal(), "Поле Total пустое");
        Assert.assertNotNull(resource.getTotal_pages(), "Поле колличество страниц пустое");
        for (Data data : resource.getData()){
            Assert.assertNotNull(data.getLast_name(), "Поле фамилия пустое");
            Assert.assertNotNull(data.getAvatar(),"Поле аватар пустое");
            Assert.assertNotNull(data.getEmail(),"Поле email пустое");
            Assert.assertNotNull(data.getId(),"Поле id пустое");
            Assert.assertNotNull(data.getFirst_name(),"Поле имя пустое");
        }
        Assert.assertNotNull(resource.getSupport().getUrl(), "Поле URL пустое");
        Assert.assertNotNull(resource.getSupport().getText(), "Поле text пустое");
    }

    @Step("Получаем данные со страницы")
    public static Resource getUserDataFromPage(){
        Resource resource = given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().body()
                .extract().body().as(Resource.class);
        return resource;
    }

    @Step("Проверяем дынные при создании нового пользователя")
    public static void checkNewUser(People people, PeopleCreated peopleCreated){
        Assert.assertEquals(people.getJob(), peopleCreated.getJob());
        Assert.assertEquals(people.getName(), peopleCreated.getName());
    }

    @Step("Создаем нового пользователя")
    public static PeopleCreated getDataNewUser(){
        People people = new People("morpheus", "leader");
        PeopleCreated peopleCreated = given()
                .contentType("application/json")
                .body(people)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().all()
                .statusCode(201)
                .extract().as(PeopleCreated.class);
        return peopleCreated;
    }
}
