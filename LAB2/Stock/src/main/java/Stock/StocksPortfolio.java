package Stock;
import java.util.*;
public class StocksPortfolio {
    private String name;
    List<Stock> myStocks=new ArrayList<Stock>();
    IStockMarket stockMarket;

    public IStockMarket getMarketService(){
        return null;
    };

    public void setMarketService(IStockMarket stockMarket){
            this.stockMarket=stockMarket;
    };

    public String getName(){
        return null;
    };

    public void setName(String name){
    };

    public double getTotalValue(){

        double total=0;
        for (Stock s:
             myStocks) {
            total+=stockMarket.getPrice(s.getName())*s.getQuantity();

        }
        return total;
    };

    public void addStock(Stock s){
        myStocks.add(s);
    };




}
