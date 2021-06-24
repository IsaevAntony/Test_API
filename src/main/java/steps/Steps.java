package steps;

import data.classes.Data;
import data.classes.Resource;
import io.qameta.allure.Step;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class Steps {
    @Step("Проверяем Json Resource на отсутствие нулевых полей")
    public static void checkNotNull(Resource resource){
        Assert.assertNotNull(resource.getPage(), "Поле колличество страниц пустое");
        Assert.assertNotNull(resource.getPer_page(), "Поле колличество страниц пустое");
        Assert.assertNotNull(resource.getTotal(), "Поле колличество страниц пустое");
        Assert.assertNotNull(resource.getTotal_pages(), "Поле колличество страниц пустое");
        for (Data data : resource.getData()){
            Assert.assertNotNull(data.getLast_name());
            Assert.assertNotNull(data.getAvatar());
            Assert.assertNotNull(data.getEmail());
            Assert.assertNotNull(data.getId());
            Assert.assertNotNull(data.getFirst_name());
        }
        Assert.assertNotNull(resource.getSupport().getUrl(), "Поле колличество страниц пустое");
        Assert.assertNotNull(resource.getSupport().getText(), "Поле колличество страниц пустое");
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
}
