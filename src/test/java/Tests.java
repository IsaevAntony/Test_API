import data.classes.People;
import data.classes.PeopleCreated;
import data.classes.Resource;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static steps.Steps.checkNotNull;
import static steps.Steps.getUserDataFromPage;

public class Tests {
    @Test
    public void test_1() {
        Resource resource = getUserDataFromPage();
        checkNotNull(resource);

    }

    @Test()
    public void dtoTest(){
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
        System.out.println(peopleCreated.getCreatedAt());
    }
}
