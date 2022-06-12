package com.example.Assignment.Controller;

import com.example.Assignment.Dto.EmployeeData;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import static org.junit.jupiter.api.Assertions.*;

class assignmentControllerTest {


    HttpClient client = HttpClient.newBuilder().build();
    String baseURI = "http://localhost:8080/api/";


    @Test
    void testSaveEmployee() throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(baseURI + "employees"))
                .header("Content-Type", "application/json; charset=UTF-8")
                //.POST(HttpRequest.BodyPublishers.ofString(getEmployeeData("C1002").toString()))
                .build();
        HttpResponse <String> httpResponse = client.send(request, BodyHandlers.ofString());
        System.out.println(httpResponse);
    }

    @Test
    void testGetEmployees() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(baseURI + "employees/C1002"))
                .GET()
                .build();
        HttpResponse <String> response = client.send(request, BodyHandlers.ofString());
        JSONObject employeeDataResponse;
        try {
            employeeDataResponse = new JSONObject(response.body().toString());
            assertEquals(employeeDataResponse.get("lastName"), "Aitha");
        } catch (JSONException err){
            System.out.println(err);
        }
    }

    @Test
    void testGetAllEmployees() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(baseURI + "employees"))
                .GET()
                .build();
        HttpResponse <String> response = client.send(request, BodyHandlers.ofString());
        assertNotNull(response.body().contains("Rajesh"));
        assertNotNull(response.body().contains("Sowmya"));
    }


    private EmployeeData getEmployeeData(String id){
        EmployeeData employeeData = new EmployeeData();
        if(id.equals("C1002")){
            employeeData.setEmployeeNumber(id);
            employeeData.setFirstName("Rajesh");
            employeeData.setLastName("Aitha");
            employeeData.setPhoneNumber("89798754");
            employeeData.setPosition("Java Developer");
        } else if(id.equals("C1001")){
            employeeData.setEmployeeNumber(id);
            employeeData.setFirstName("Sowmya");
            employeeData.setLastName("Macha");
            employeeData.setPhoneNumber("89798754");
            employeeData.setPosition("CEO");
        }
        return employeeData;
    }
}