package utils;

import org.json.JSONObject;

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

    public static String createEmployeePayloadJson(){
        JSONObject obj = new JSONObject();
        obj.put("firstName","John");
        obj.put("lastName","Doe");
        obj.put("middleName","Smith");
        obj.put("employeeId","EMP243");
        return obj.toString();
    }

    public static String createEmployeePayloadJsonDynamic
            (String firstname, String lastname, String middlename, String empid){
        JSONObject obj = new JSONObject();
        obj.put("firstName", firstname);
        obj.put("lastName", lastname);
        obj.put("middleName", middlename);
        obj.put("employeeId",  empid   );
        return obj.toString();
    }

}
