package uk.parkin.mike.dwpapplicationapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.parkin.mike.dwpapplicationapi.dataObjects.Person;
import org.springframework.http.ResponseEntity;
import uk.parkin.mike.dwpapplicationapi.service.GetLondonPeopleService;

@RestController
public class GetLondonPeopleController {

  private GetLondonPeopleService getLondonPeopleService = new GetLondonPeopleService();

  @GetMapping("/v1/get/london/people")
  public ResponseEntity<List<Person>> getLondonUsers() {
    return new ResponseEntity<List<Person>>(getLondonPeopleService.callBackEndService(), HttpStatus.OK);
  }



}
