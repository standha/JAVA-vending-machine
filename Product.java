//Product 클래스
package Machine;

public class Product {
	private String Name = "";    //Name변수 선언 및 초기화
	   private int price = 0;
	   private int stock = 0;
	   private int p = 0;
	   private int c = 0;
	   
	   public String getName() {        //이름 반환
	      return Name;
	   }
	   
	   public void setName(String Name) {      //이름 변경
	      this.Name = Name;
	   }
	    
	   public int getPrice() {      //가격 반환
	      return price;
	   }
	   
	   public void setPrice(int price) {       //가격 변경
	      this.price = price;
	   }
	   
	   public int getStock() {      //재고 반환
	      return stock;
	   }
	   
	   public void setStock(int stock) {     //재고 변경
	      this.stock = stock;
	   }
	   
	   public int getp() {      //주문한 음료 
	     return p;
	   }
		   
	   public void setp(int p) {     //주문한 음료
		     this.p = p;
	   }
	   
	   public int getc() {       //선택한 음료 개수
	     return c;
	  }
			   
	  public void setc(int c) {     //선택한 음료 개수 변경
	     this.c = c;
     }
}
