package utils;

public class APIPayloadConstants {

    public static String createEmployeePayload(){
        String  createEmployeePayload = "{\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"middleName\": \"Smith\",\n" +
                "  \"employeeId\": \"EMP143\"\n" +
                "}";
        return createEmployeePayload;
    }
}
