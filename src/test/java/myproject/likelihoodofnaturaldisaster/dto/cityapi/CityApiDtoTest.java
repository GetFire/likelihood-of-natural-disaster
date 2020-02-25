package myproject.likelihoodofnaturaldisaster.dto.cityapi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CityApiDtoTest {

    private static final String STUPID_STRING = "string";
    private static final double STUPID_DOUBLE = 112d;

    private CityApiDto testEntry;

    @Mock
    private LocalityInfoDto localityInfoDto;

    @Before
    public void setUp() {
        testEntry = new CityApiDto();
    }

    @Test
    public void stupidTestJustForCoverage() {

        testEntry.setContinentCode(STUPID_STRING);
        testEntry.setCountryCode(STUPID_STRING);
        testEntry.setCountryName(STUPID_STRING);
        testEntry.setLocality(STUPID_STRING);
        testEntry.setLatitude(STUPID_DOUBLE);
        testEntry.setLongitude(STUPID_DOUBLE);
        testEntry.setLocalityLanguageRequested(STUPID_STRING);
        testEntry.setLocalityInfo(localityInfoDto);
        testEntry.setPrincipalSubdivision(STUPID_STRING);

        assertThat(testEntry.getContinentCode()).isEqualTo(STUPID_STRING);
        assertThat(testEntry.getCountryCode()).isEqualTo(STUPID_STRING);
        assertThat(testEntry.getCountryName()).isEqualTo(STUPID_STRING);
        assertThat(testEntry.getLocality()).isEqualTo(STUPID_STRING);
        assertThat(testEntry.getLocalityLanguageRequested()).isEqualTo(STUPID_STRING);
        assertThat(testEntry.getPrincipalSubdivision()).isEqualTo(STUPID_STRING);

        assertThat(testEntry.getLatitude()).isEqualTo(STUPID_DOUBLE);
        assertThat(testEntry.getLongitude()).isEqualTo(STUPID_DOUBLE);
        assertThat(testEntry.getLocalityInfo()).isEqualTo(localityInfoDto);
    }
}