package utils;

import io.restassured.RestAssured;

public class APIConstants {

    public static final String baseURI = RestAssured.baseURI = "https://www.syntaxhrm.com/web/index.php/";

    public static final String CREATE_EMPLOYEE_ENDPOINT = baseURI + "api/v2/pim/employees";
    public static final String GET_EMPLOYEE_ENDPOINT = baseURI +"api/v2/pim/employees";
    public static final String GENERATE_TOKEN_ENDPOINT = baseURI + "api/v2/auth/login";
    public static final String UPDATE_EMPLOYEE_ENDPOINT = baseURI + "api/v2/pim/employees";
    public static final String DELETE_EMPLOYEE_ENDPOINT = baseURI+"api/v2/pim/employees";
    public static final String GET_EMPLOYEE_COUNT_ENDPOINT = baseURI+"api/v2/pim/employees/count";


    //headers key and value
    public static final String HEADER_CONTENT_TYPE_KEY="Content-Type";
    public static final String HEADER_CONTENT_TYPE_VALUE="application/json";
    public static final String HEADER_AUTHORIZATION_KEY="Authorization";

}
