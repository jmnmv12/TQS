package Stock;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.mockito.stubbing.OngoingStubbing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StocksPortfolioTest {

    @Mock  IStockMarket stockMarket;
    @InjectMocks StocksPortfolio portfolio;



    @Test
    void getTotalValue() {
        Stock stockA=new Stock("Ebay",2);
        Stock stockB=new Stock("Tesla",2);

        when(stockMarket.getPrice("Ebay")).thenReturn(50.0);
        when(stockMarket.getPrice("Tesla")).thenReturn(45.0);

        portfolio.addStock(stockA);
        portfolio.addStock(stockB);



        double result =portfolio.getTotalValue();
        assertThat(result,is(190.0));
        verify(stockMarket, times(2)).getPrice(anyString());







    }


}