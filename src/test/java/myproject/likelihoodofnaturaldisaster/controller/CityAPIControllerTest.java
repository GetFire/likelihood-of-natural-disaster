package myproject.likelihoodofnaturaldisaster.controller;

import myproject.likelihoodofnaturaldisaster.dto.GeoForm;
import myproject.likelihoodofnaturaldisaster.dto.cityapi.CityApiDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class CityAPIControllerTest {

    private static final String CITY_API_URL = "cityApiUrl";

    @Mock
    private Model model;
    @Mock
    private GeoForm geoForm;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private CityApiDto cityApiDto;

    @InjectMocks
    private CityAPIController testEntry = new CityAPIController();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(testEntry);
        ReflectionTestUtils.setField(testEntry, CITY_API_URL, CITY_API_URL);
        doReturn(cityApiDto).when(restTemplate).getForObject(anyString(), eq(CityApiDto.class));
    }

    @Test
    public void simpleStupidTestJustForCoverage() {
        testEntry.getGeoForm();
        testEntry.getPage(model);
        testEntry.getPage(geoForm, model);
    }
}