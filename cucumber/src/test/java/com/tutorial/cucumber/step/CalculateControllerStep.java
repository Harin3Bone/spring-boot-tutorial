package com.tutorial.cucumber.step;

import com.tutorial.cucumber.SpringBootCucumberApplication;
import com.tutorial.cucumber.controller.CalculateController;
import com.tutorial.cucumber.service.CalculateService;
import com.tutorial.cucumber.service.CalculateServiceImpl;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.util.TimeZone;

@CucumberContextConfiguration
@SpringBootTest(classes = SpringBootCucumberApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {CalculateControllerStep.Config.class})
@Slf4j
public class CalculateControllerStep {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private static final String BASE_URL = "/cal";

    private ResponseEntity<String> responseEntity;

    @TestConfiguration
    static class Config {
        @InjectMocks
        CalculateService calculateService;
    }

    @Before
    public void setup() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @When("the client call request GET {string}")
    public void theClientCallRequestGET(String path) {
        responseEntity = testRestTemplate.exchange(BASE_URL + path, HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), String.class);
    }

    @Then("the client receive status code of {int}")
    public void theClientReceiveStatusCodeOf(int expectedStatus) {
        String errMsg = "Unexpected response status code: " + responseEntity.getStatusCode();
        Assertions.assertEquals(expectedStatus, responseEntity.getStatusCodeValue(), errMsg);
    }

    @And("the client receive result are as follows")
    public void theClientReceiveResultAs(String expectedResponse) {
        Assertions.assertEquals(expectedResponse, responseEntity.getBody());
    }

}
