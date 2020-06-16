package uk.parkin.mike.dwpapplicationapi.service;

import uk.parkin.mike.dwpapplicationapi.dataObjects.Person;
import uk.parkin.mike.dwpapplicationapi.httpHelper.HttpUtils;
import uk.parkin.mike.dwpapplicationapi.tools.CalculateDistance;

import java.util.ArrayList;
import java.util.List;

public class GetLondonPeopleService {

    private HttpUtils httpUtils;

    public GetLondonPeopleService() {
        this.httpUtils = new HttpUtils();
    }

    public List<Person> callBackEndService() {
        List<Person> peopleToReturn = getPeopleInLondon();

        peopleToReturn.addAll(getPeopleNearLondon());

        return peopleToReturn;
    }

    private List<Person> getPeopleNearLondon() {
        String url = "https://bpdts-test-app.herokuapp.com/users";

        List<Person> peopleNearLondon = new ArrayList<>();
        for (Person p : httpUtils.makeCall(url)) {
            double distance = CalculateDistance.getDistanceFromLondon(p.getLatitude(), p.getLongitude());
            if (distance <= 50.00) {
                peopleNearLondon.add(p);
            }
        }

        return peopleNearLondon;
    }

    private List<Person> getPeopleInLondon(){
        String url = "https://bpdts-test-app.herokuapp.com/city/London/users";

        List<Person> londonPeople = new ArrayList<>();
        for (Person p : httpUtils.makeCall(url)) {
            londonPeople.add(p);
        }
        return londonPeople;
    }

    public void setHttpUtils(HttpUtils httpUtils) {
        this.httpUtils = httpUtils;
    }
}
