
import com.shivam.stockmatching.model.EXCH;
import com.shivam.stockmatching.model.ORDER_TYPE;
import com.shivam.stockmatching.model.Order;
import com.shivam.stockmatching.model.Stock;
import com.shivam.stockmatching.model.TXN_TYPE;
import com.shivam.stockmatching.model.User;
import com.shivam.stockmatching.repository.Db;
import com.shivam.stockmatching.service.OrderManager;

public class StockMatchingApplication {

	public static void main(String[] args) {


		Db db=Db.getConnector();

		Stock reliance=new Stock(EXCH.NSE,"RELIANCE",1000.0);
		Stock tata=new Stock(EXCH.NSE,"TATA",1200.0);

		Order order=new Order(TXN_TYPE.SELL, ORDER_TYPE.LIMIT, 1100.0, 2, reliance,EXCH.NSE);
		Order order1=new Order(TXN_TYPE.BUY, ORDER_TYPE.LIMIT, 1200.0, 1, tata,EXCH.NSE);
		Order order2=new Order(TXN_TYPE.BUY, ORDER_TYPE.LIMIT, 1200.0, 1, reliance,EXCH.NSE);
		Order order3=new Order(TXN_TYPE.SELL, ORDER_TYPE.LIMIT, 1300.0, 1, tata,EXCH.NSE);
 	    Order order4=new Order(TXN_TYPE.BUY, ORDER_TYPE.LIMIT, 1200.0, 2, reliance,EXCH.NSE);
        Order order5=new Order(TXN_TYPE.SELL, ORDER_TYPE.LIMIT, 1300.0, 1, tata,EXCH.NSE);
 	    Order order6=new Order(TXN_TYPE.BUY, ORDER_TYPE.LIMIT, 1200.0, 2, reliance,EXCH.NSE);
        Order order7=new Order(TXN_TYPE.SELL, ORDER_TYPE.LIMIT, 1300.0, 1, tata,EXCH.NSE);
 	    Order order8=new Order(TXN_TYPE.BUY, ORDER_TYPE.LIMIT, 1200.0, 2, reliance,EXCH.NSE);

		// db.addOrder(order3);
		// db.addOrder(order2);
		// db.addOrder(order1);
		// db.addOrder(order);
        User user =new User("Rajesh",10000.0);
		User user1 =new User("Ram",10000.0);
		User user2 =new User("Raju",10000.0);
		User user3=new User("Raj",10000.0);

		db.addFunds("Rajesh",user );
		db.addFunds("Ram",user1 );
		db.addFunds("Raju",user2 );
		db.addFunds("Raj",user3 );




		OrderManager orderManager=new OrderManager();
	
		orderManager.placeOrder("Rajesh",order);
		orderManager.placeOrder("Ram",order1);
		orderManager.placeOrder("Raju",order2);
		orderManager.placeOrder("Raj",order3);
		orderManager.placeOrder("Rocky",order4);
		orderManager.placeOrder("R",order5);
		orderManager.placeOrder("Rr",order6);
		orderManager.placeOrder("Rrr",order7);
		


	}

}
