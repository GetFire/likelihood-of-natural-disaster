package myproject.likelihoodofnaturaldisaster.dto;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class GeoFormTest {

    private static final String LATITUDE = "12341234";
    public static final String LONGITUDE = "33322111";
    private GeoForm testEntry;

    @Before
    public void setUp() {
        testEntry = new GeoForm();
    }

    @Test
    public void shouldCreateTestedInstance() {
        assertThat(testEntry).isNotNull();
    }

    @Test
    public void shouldSetLatitude() {
        testEntry.setLatitude(LATITUDE);
        assertThat(testEntry.getLatitude()).isEqualTo(LATITUDE);
    }

    @Test
    public void shouldSetLongitude() {
        testEntry.setLongitude(LONGITUDE);
        assertThat(testEntry.getLongitude()).isEqualTo(LONGITUDE);
    }

    @Test
    public void shouldSetLongitudeAndLatitude() {
        testEntry.setLongitude(LONGITUDE);
        testEntry.setLatitude(LATITUDE);
        assertThat(testEntry.getLongitude()).isEqualTo(LONGITUDE);
        assertThat(testEntry.getLatitude()).isEqualTo(LATITUDE);
    }
}