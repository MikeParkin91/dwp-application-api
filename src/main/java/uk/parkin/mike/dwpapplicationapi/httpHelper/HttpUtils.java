package uk.parkin.mike.dwpapplicationapi.httpHelper;

import org.springframework.web.client.RestTemplate;
import uk.parkin.mike.dwpapplicationapi.dataObjects.Person;

public class HttpUtils {

    private RestTemplate backendRestTemplate;

    public HttpUtils() {
        backendRestTemplate = new RestTemplate();
    }

    public Person[] makeCall(String url){
        return backendRestTemplate.getForObject(url, Person[].class);
    }
}
