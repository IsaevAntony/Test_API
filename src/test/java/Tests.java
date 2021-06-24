import data.classes.People;
import data.classes.PeopleCreated;
import data.classes.Resource;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static steps.Steps.*;

public class Tests {
    @Test
    public void getUsers() {
        Resource resource = getUserDataFromPage();
        checkNotNull(resource);

    }
    @Test
    public void newUser(){
        People people = new People("morpheus", "leader");
        PeopleCreated peopleCreated = getDataNewUser();
        checkNewUser(people, peopleCreated);
    }
}
