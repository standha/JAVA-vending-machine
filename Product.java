//Product Ŭ����
package Machine;

public class Product {
	private String Name = "";    //Name���� ���� �� �ʱ�ȭ
	   private int price = 0;
	   private int stock = 0;
	   private int p = 0;
	   private int c = 0;
	   
	   public String getName() {        //�̸� ��ȯ
	      return Name;
	   }
	   
	   public void setName(String Name) {      //�̸� ����
	      this.Name = Name;
	   }
	    
	   public int getPrice() {      //���� ��ȯ
	      return price;
	   }
	   
	   public void setPrice(int price) {       //���� ����
	      this.price = price;
	   }
	   
	   public int getStock() {      //��� ��ȯ
	      return stock;
	   }
	   
	   public void setStock(int stock) {     //��� ����
	      this.stock = stock;
	   }
	   
	   public int getp() {      //�ֹ��� ���� 
	     return p;
	   }
		   
	   public void setp(int p) {     //�ֹ��� ����
		     this.p = p;
	   }
	   
	   public int getc() {       //������ ���� ����
	     return c;
	  }
			   
	  public void setc(int c) {     //������ ���� ���� ����
	     this.c = c;
     }
}
