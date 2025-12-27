package APISteps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class APISteps {

    String baseURI = RestAssured.baseURI = "https://www.syntaxhrm.com/web/index.php/";
    static String token;
    RequestSpecification request;
    Response response;
    static String empNumber;

    @Given("a JWT is generated")
    public void a_jwt_is_generated() {
        request = given().header("Content-Type", "application/json").
                body("{\n" +
                        "  \"username\": \"hrm_user\",\n" +
                        "  \"password\": \"Hrm_user@123\"\n" +
                        "}");
        response = request.when().post("api/v2/auth/login");

        token = "Bearer " + response.jsonPath().getString("data.token");
    }

    @Given("a request is prepared to create employee API")
    public void a_request_is_prepared_to_create_employee_api() {
        //prepare the request
         request = given().header("Authorization", token).
                header("Content-Type", "application/json").
                body("{\n" +
                        "  \"firstName\": \"John\",\n" +
                        "  \"lastName\": \"Doe\",\n" +
                        "  \"middleName\": \"Smith\",\n" +
                        "  \"employeeId\": \"EMP169\"\n" +
                        "}");

    }

    @When("a POST call is made to create employee endpoint")
    public void a_post_call_is_made_to_create_employee_endpoint() {
        //hit the endpoint
         response = request.when().post("api/v2/pim/employees");
    }

    @Then("the status code for create employee API is {int}")
    public void the_status_code_for_create_employee_api_is(Integer int1) {
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
    }

    @Then("the empNumber is stored for future use")
    public void the_emp_number_is_stored_for_future_use() {
        empNumber = response.jsonPath().getString("data.empNumber");
        System.out.println(empNumber);
    }

    @Given("a request is prepared to get employee API")
    public void a_request_is_prepared_to_get_employee_api() {
         request = given().header("Authorization", token).
                header("Content-Type", "application/json");
        //hit the endpoint

    }

    @When("a GET call is made to get employee endpoint")
    public void a_get_call_is_made_to_get_employee_endpoint() {
        response = request.when().get("api/v2/pim/employees"
        );

    }

    @Then("the status code for get employee API is {int}")
    public void the_status_code_for_get_employee_api_is(Integer int1) {
        //verify the response
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
    }

    }

