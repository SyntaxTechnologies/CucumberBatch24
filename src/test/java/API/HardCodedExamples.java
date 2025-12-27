package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    //BaseURI = base URL in rest assured
    //BasePath = endpoint
    String baseURI = RestAssured.baseURI = "https://www.syntaxhrm.com/web/index.php/";
    String token = "Bearer aHJtX3VzZXI6MTc2Njg1MDk1Njo4ZmNkNDI0MDZjOGYxNWRkODEzMWE5Mjc2YTk3ZGVmNw==";
    static String empNumber;

    @Test
    public void acreateEmployee() {
        //prepare the request
        RequestSpecification request = given().header("Authorization", token).
                header("Content-Type", "application/json").
                body("{\n" +
                        "  \"firstName\": \"John\",\n" +
                        "  \"lastName\": \"Doe\",\n" +
                        "  \"middleName\": \"Smith\",\n" +
                        "  \"employeeId\": \"EMP187\"\n" +
                        "}");

        //hit the endpoint
        Response response = request.when().post("api/v2/pim/employees");

        //verify the response
        //verify status code, verify key and values of the body, we verify employee Number
        response.then().assertThat().statusCode(201);
        //we use this method to print the response in a pretty way.
        response.prettyPrint();
        //validate employee details
        //hamcrest matchers
        response.then().assertThat().body("data.firstName",equalTo("John"));
        response.then().assertThat().body("data.lastName",equalTo("Doe"));
        response.then().assertThat().body("data.middleName",equalTo("Smith"));
        response.then().assertThat().header("Content-Type",equalTo("application/json"));
        //we need to store emp number so that we can use it in the get request
        empNumber = response.jsonPath().getString("data.empNumber");
        System.out.println(empNumber);
    }

    @Test
    public void bgetCreatedEmployee() {
        //prepare the request
        RequestSpecification request = given().header("Authorization", token).
                header("Content-Type", "application/json");
        //hit the endpoint
        Response response = request.when().get("api/v2/pim/employees"
        );
        //verify the response
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void cupdateEmployee(){
        //prepare the request
        RequestSpecification request = given().header("Authorization", token).
                header("Content-Type", "application/json").
                body("{\n" +
                        "  \"firstName\": \"johnupdated\",\n" +
                        "  \"lastName\": \"doeupdated\",\n" +
                        "  \"middleName\": \"smithupdated\",\n" +
                        "  \"employeeId\": \"EMP189\"\n" +
                        "}");

        Response response = request.when().put("api/v2/pim/employees"+"/"+empNumber);
        //verify the response
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
    }
}
