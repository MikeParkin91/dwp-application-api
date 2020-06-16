package uk.parkin.mike.dwpapplicationapi.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import uk.parkin.mike.dwpapplicationapi.dataObjects.Person;
import uk.parkin.mike.dwpapplicationapi.httpHelper.HttpUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GetLondonPeopleServiceTest {

    GetLondonPeopleService getLondonPeopleService = new GetLondonPeopleService();
    HttpUtils httpUtils = mock(HttpUtils.class);

    @Test
    public void testGetLondonPeopleService(){
        getLondonPeopleService.setHttpUtils(httpUtils);
        Person[] people = new Person[1];

        int id = 1;
        String first_name = "Forename";
        String last_name = "Surname";
        String email = "test.email@testdomain.com";
        String ip_address = "1.1.1.1";
        double latitude = 54.9732819;
        double longitude = -1.61396;

        Person person1 = new Person(id, first_name, last_name, email, ip_address, latitude, longitude);
        people[0] = person1;
        when(httpUtils.makeCall(anyString())).thenReturn(people);

        List<Person> expectedListOfPeople = new ArrayList<>();
        expectedListOfPeople.add(person1);

        List<Person> actualListOfPeople = getLondonPeopleService.callBackEndService();

        assertEquals(actualListOfPeople, expectedListOfPeople);
    }

    @Test
    public void testWhenPersonWithin50Miles2PeopleAreReturned(){
        getLondonPeopleService.setHttpUtils(httpUtils);
        Person[] people = new Person[1];

        int id = 1;
        String first_name = "Forename";
        String last_name = "Surname";
        String email = "test.email@testdomain.com";
        String ip_address = "1.1.1.1";
        double latitude = 51.593282;
        double longitude = 0.193646;

        Person person1 = new Person(id, first_name, last_name, email, ip_address, latitude, longitude);
        people[0] = person1;
        when(httpUtils.makeCall(anyString())).thenReturn(people);

        List<Person> expectedListOfPeople = new ArrayList<>();
        expectedListOfPeople.add(person1);
        expectedListOfPeople.add(person1);

        List<Person> actualListOfPeople = getLondonPeopleService.callBackEndService();

        assertEquals(actualListOfPeople, expectedListOfPeople);
    }

}