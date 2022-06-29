//Money 클래스
package Machine;

public class Money {
	private String Money = ""; //Name변수 선언 및 초기화
   private int price = 0;
   private int stock = 0;
   private int m = 0;
   private int mm = 0;
   
   public int getcountMoney() {       //재고 리턴
      return stock;
   }
   
   public void setcountMoney(int stock) {  //재고 변경
      this.stock = stock;
   }
	    
	public int getpriceMoney() {    //가격 리턴
	   return price;
   }
	   
    public void setpriceMoney(int price) {   //가격 변경
	   this.price = price;
	}
	   
	public String getMoney() {    //이름 리턴
	   return Money;
	}
	   
	public void setMoney(String Money) { //이름 변경
	   this.Money = Money;
	}
	
	 public int getm() {      //선택한 돈
	   return m;
	}
			   
	public void setm(int m) {      //선택한 돈
		this.m = m;
	}
		   
	 public int getmm() {       //선택한 돈 개수
		return mm;
	}
				   
	 public void setmm(int mm) {     //선택한 돈 개수 변경
		 this.mm = mm;
	}
}