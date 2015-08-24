package Backupclassses;
import java.util.ArrayList;
import java.util.List;


public class OrderLine {
		
		private int OrderID;
		private List<Integer> ProductID = new ArrayList<Integer>(); 
		private List<Integer> Quantity = new ArrayList<Integer>(); 

	//Set the object
		public void setOrderID(Integer x){
			this.OrderID = x; 
			}
		public void SetProductID(ArrayList<Integer> x){
			this.ProductID = x;
		}
		public void SetQuantity(ArrayList<Integer> x){
			this.Quantity = x;
		}
	//Get  the object
		public Integer getOrderID(){ 
			return OrderID;
			}
		
		public List<Integer> getProductID(){
			return ProductID;
			}
		
		public List<Integer> getQuantity(){
			return Quantity;
			}
}
