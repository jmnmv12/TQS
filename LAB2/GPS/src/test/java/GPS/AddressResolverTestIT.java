package GPS;

import org.apache.http.client.utils.URIBuilder;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Formatter;
import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AddressResolverTestIT {


    TqsHttpClient httpClient=new TqsBasicHttpClient();;

    AddressResolver addressResolver=new AddressResolver(httpClient);
    private URIBuilder uriBuilder=new URIBuilder();

    


    @Test
    void findAddressForLocation() throws ParseException, IOException, URISyntaxException {

        Address address=addressResolver.findAddressForLocation(40.6318,-8.658);

        Address expectedAdress=new Address(null,"Parque Estacionamento da Reitoria - Univerisdade de Aveiro","Glória e Vera Cruz","Centro","3810-193");

        assertThat(expectedAdress.toString(),is(address.toString()));



    }
}