//Money Ŭ����
package Machine;

public class Money {
	private String Money = ""; //Name���� ���� �� �ʱ�ȭ
   private int price = 0;
   private int stock = 0;
   private int m = 0;
   private int mm = 0;
   
   public int getcountMoney() {       //��� ����
      return stock;
   }
   
   public void setcountMoney(int stock) {  //��� ����
      this.stock = stock;
   }
	    
	public int getpriceMoney() {    //���� ����
	   return price;
   }
	   
    public void setpriceMoney(int price) {   //���� ����
	   this.price = price;
	}
	   
	public String getMoney() {    //�̸� ����
	   return Money;
	}
	   
	public void setMoney(String Money) { //�̸� ����
	   this.Money = Money;
	}
	
	 public int getm() {      //������ ��
	   return m;
	}
			   
	public void setm(int m) {      //������ ��
		this.m = m;
	}
		   
	 public int getmm() {       //������ �� ����
		return mm;
	}
				   
	 public void setmm(int mm) {     //������ �� ���� ����
		 this.mm = mm;
	}
}