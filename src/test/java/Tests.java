import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Tests {
    @Test
    public void test_1() {
        Resourse resourse = given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().body()
                .extract().body().as(Resourse.class);
        resourse.getData().forEach(x -> System.out.println(x.getEmail()));
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
