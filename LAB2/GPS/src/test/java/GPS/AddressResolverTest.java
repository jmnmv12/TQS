package GPS;

import org.apache.http.client.utils.URIBuilder;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Formatter;
import org.apache.http.client.utils.URIBuilder;

import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddressResolverTest {

    @Mock TqsHttpClient httpClient;
    @InjectMocks AddressResolver addressResolver;
    private URIBuilder uriBuilder;


    @Test
    void findAddressForLocation() throws ParseException, IOException, URISyntaxException {

        uriBuilder = new URIBuilder("http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ");
        uriBuilder.addParameter("location", (new Formatter()).format(Locale.US, "%.6f,%.6f",40.6318 , -8.658).toString() );
        uriBuilder.addParameter("includeRoadMetadata", "true" );
        when(httpClient.get(uriBuilder.build().toString())).thenReturn("{\"info\":{\"statuscode\":0,\"copyright\":{\"text\":\"\\u00A9 2020 MapQuest, Inc.\",\"imageUrl\":\"http://api.mqcdn.com/res/mqlogo.gif\",\"imageAltText\":\"\\u00A9 2020 MapQuest, Inc.\"},\"messages\":[]},\"options\":{\"maxResults\":1,\"thumbMaps\":true,\"ignoreLatLngInput\":false},\"results\":[{\"providedLocation\":{\"latLng\":{\"lat\":40.6318,\"lng\":-8.658}},\"locations\":[{\"street\":\"Parque Estacionamento da Reitoria - Univerisdade de Aveiro\",\"adminArea6\":\"\",\"adminArea6Type\":\"Neighborhood\",\"adminArea5\":\"Gl\\u00F3ria e Vera Cruz\",\"adminArea5Type\":\"City\",\"adminArea4\":\"\",\"adminArea4Type\":\"County\",\"adminArea3\":\"Centro\",\"adminArea3Type\":\"State\",\"adminArea1\":\"PT\",\"adminArea1Type\":\"Country\",\"postalCode\":\"3810-193\",\"geocodeQualityCode\":\"P1AAA\",\"geocodeQuality\":\"POINT\",\"dragPoint\":false,\"sideOfStreet\":\"N\",\"linkId\":\"0\",\"unknownInput\":\"\",\"type\":\"s\",\"latLng\":{\"lat\":40.631803,\"lng\":-8.657881},\"displayLatLng\":{\"lat\":40.631803,\"lng\":-8.657881},\"mapUrl\":\"http://open.mapquestapi.com/staticmap/v5/map?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&type=map&size=225,160&locations=40.6318025,-8.657881|marker-sm-50318A-1&scalebar=true&zoom=15&rand=-791103453\",\"roadMetadata\":null}]}]}");

        Address address=addressResolver.findAddressForLocation(40.6318,-8.658);

        Address expectedAdress=new Address(null,"Parque Estacionamento da Reitoria - Univerisdade de Aveiro","Glória e Vera Cruz","Centro","3810-193");

        assertThat(expectedAdress.toString(),is(address.toString()));



    }

    @Test
    void findAddressForLocation_BadCoordinates() throws ParseException, IOException, URISyntaxException {

        uriBuilder = new URIBuilder("http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ");
        uriBuilder.addParameter("location", (new Formatter()).format(Locale.US, "%.6f,%.6f",4222220.6318 , -8.658).toString() );
        uriBuilder.addParameter("includeRoadMetadata", "true" );
        when(httpClient.get(uriBuilder.build().toString())).thenReturn("{\"info\":{\"statuscode\":0,\"copyright\":{\"text\":\"\\u00A9 2020 MapQuest, Inc.\",\"imageUrl\":\"http://api.mqcdn.com/res/mqlogo.gif\",\"imageAltText\":\"\\u00A9 2020 MapQuest, Inc.\"},\"messages\":[]},\"options\":{\"maxResults\":1,\"thumbMaps\":true,\"ignoreLatLngInput\":false},\"results\":[{\"providedLocation\":{\"latLng\":{\"lat\":4222220.6318,\"lng\":-8.658}},\"locations\":[]}]}");



        assertThrows(IndexOutOfBoundsException.class, () -> {
            Address address=addressResolver.findAddressForLocation(4222220.6318,-8.658);
        });





    }
}