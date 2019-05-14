package com.lambdaschool.school.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.school.model.Course;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

import java.util.ArrayList;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void initialiseRestAssuredMockMvcWebApplicationContext()
    {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @Test
    public void whenMeasuredReponseTime()
    {
        given().when().get("/courses/courses").then().time(lessThan(5000L));
    }

    @Test
    public void givenPostACourse() throws Exception
    {


        Course c1 = new Course("AddCourseIntegrationtest");
        c1.setCourseid(11);


        ObjectMapper mapper = new ObjectMapper();
        String stringC1 = mapper.writeValueAsString(c1);

        given().contentType("application/json").body(stringC1).when().post("/courses/course/add").then().statusCode(201);
    }
}
