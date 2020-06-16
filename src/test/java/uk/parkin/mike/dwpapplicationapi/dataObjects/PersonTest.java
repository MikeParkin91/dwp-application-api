package uk.parkin.mike.dwpapplicationapi.dataObjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

  @Test
  public void testConstructor(){
    int id = 1;
    String first_name = "Forename";
    String last_name = "Surname";
    String email = "test.email@testdomain.com";
    String ip_address = "1.1.1.1";
    double latitude = 51.509865;
    double longitude = -0.118092;

    Person person1 = new Person(id, first_name, last_name, email, ip_address, latitude, longitude);

    assertEquals(person1.getId(), id);
    assertEquals(person1.getFirstName(), first_name);
    assertEquals(person1.getLastName(), last_name);
    assertEquals(person1.getEmail(), email);
    assertEquals(person1.getIpAddress(), ip_address);
    assertEquals(person1.getLatitude(), latitude);
    assertEquals(person1.getLongitude(), longitude);

  }
}
