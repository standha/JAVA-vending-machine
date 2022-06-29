//���� ���� ȭ��
package Machine;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Drink extends JFrame {

	int Mcount=0;      
	int count = 0;  //���� ī��Ʈ �ϴ� ����
    int total=0;    //���� �ֹ��� ���� �޴� ����
    String show = "";
    static int stock=3;     //���� ä�� 3�� 
   static Product[] product = new Product[5];   //product������ ����
   private static int ctemp=0;
   private static int c1000=0;
   private static int c500=0;
   private static int c100=0;
   private static int c50=0;
   private static int c10=0;
    static int num=0;

 // ����޴� �ʱ�ȭ �Լ�
    public static void initProduct() {
        for(int i=0; i<product.length; i++) 
           product[i] = new Product();
              
        // �̸��� ����,��� ����
        product[0].setName("��      ");   product[0].setPrice(450);   product[0].setStock(3);
        product[1].setName("Ŀ��    ");   product[1].setPrice(500);   product[1].setStock(3);
        product[2].setName("�̿�����");   product[2].setPrice(550);   product[2].setStock(3);
        product[3].setName("���Ŀ��");   product[3].setPrice(700);   product[3].setStock(3);
        product[4].setName("ź������");   product[4].setPrice(750);   product[4].setStock(3);
     }
    
    //����� �̸� �޴� �Լ�
    public static void setproductMenu(int i,String name) {
    	product[i].setName(name);
    }
    //���� �������ִ� �Լ�
    public static void setproductprice(int i,int newprice) { 
    	product[i].setPrice (newprice);
  	}
    //��� ���� �Լ�
    public static void setproductstoct(int i,int newstock) {
    	 product[i].setStock(newstock);
    }
    //��� ���� ��ȯ �Լ�
    public static int getproductstoct(int i) {
    	 return product[i].getStock();
    }
    
    //���� ���� ���� 1�� ���ֱ�
    public static void setnum(int i,int n) {
    	 product[i].setp(n);
    }
  //���� ���� ���� 1 ��ȯ
    public static int getnum(int i) {
    	 return product[i].getp();
    }
    
    //���� ���� ����
    public static void setcount(int i,int num) {
        product[i].setc(num);
    }
  //���� ���� ���� ��ȯ
    public static int getcount(int i) {
    	 return product[i].getc();
    }
    
    public Drink(){
        // �����δ�
        // ������ ������
        JFrame frame = new JFrame("���� ���Ǳ�");
        frame.setBounds(0, 0, 800, 600);
        frame.setBackground(Color.black);
 
        // ��Ʈ
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
        Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);
 
        // ����
        Panel pNorth = new Panel();
        pNorth.setBackground(new Color(219, 243, 226));
        pNorth.setLayout(null);
        pNorth.setSize(0, 350);
        pNorth.setFont(font);
     
        // �迭 ���� �κ�
        JButton bt[] = new JButton[product.length];
        TextField suja[] = new TextField[product.length];
        Button minus[] = new Button[product.length];
        Button plus[] = new Button[product.length];
        JButton ok[] = new JButton[product.length];
        Label l[] = new Label[product.length];
        Label ll[] = new Label[product.length];
        ImageIcon icon[] = new ImageIcon[product.length];
        
        // ��ư ���� �κ�
        for (int i = 0; i < product.length; i++) {	  
           // �޴� ��ư
            bt[i] = new JButton();
            bt[i].setBounds(25 + i * 150, 50, 100, 100);               
            icon[i] = new ImageIcon(i + ".png");           //�̹���           
            bt[i].setIcon(icon[i]);                        //�̹��� ��ư
                      
            if(getproductstoct(i)==0){   //���� ��� 0�̸�
        	   bt[i].setEnabled(false);  //�޴���ư ��Ȱ��ȭ
             }
            // ���� txt ��ư
            suja[i] = new TextField("0");
            suja[i].setBackground(Color.white);
            suja[i].setEditable(false);
            suja[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 170, 40, 20);
 
            // "-" ��ư
            minus[i] = new Button("-");
            minus[i].setBounds(bt[i].getX(), suja[i].getY(), 20, 20);
            minus[i].setEnabled(false);
 
            // "+" ��ư
            plus[i] = new Button("+");
            plus[i].setBounds(bt[i].getX() + (100 - 20), suja[i].getY(), 20, 20);
            plus[i].setEnabled(false);
 
            // ���ݰ� ���� �̸��� ��� �� ǰ�� ǥ��
            if(getproductstoct(i)==0){
            	l[i] = new Label(product[i].getName()+"("+ product[i].getStock() +")");
            	ll[i] = new Label(product[i].getPrice() + "��-ǰ��");
                l[i].setBounds(bt[i].getX()+6, suja[i].getY() -50, 100, 20);
                ll[i].setBounds(bt[i].getX()+23, suja[i].getY()-30, 100, 20);
            }
            
            else {
            	l[i] = new Label(product[i].getName()+"("+ product[i].getStock() +")");
            	ll[i] = new Label(product[i].getPrice() + "��");
                l[i].setBounds(bt[i].getX()+6, suja[i].getY() -50, 100, 20);
                ll[i].setBounds(bt[i].getX()+23, suja[i].getY()-30, 100, 20);
            }

            // Ȯ�� ��ư
            ok[i] = new JButton("Ȯ��");
            ok[i].setBounds(bt[i].getX(), suja[i].getY() + 30, 100, 20);
            ok[i].setEnabled(false);
                        
            //��ư�� �ؽ�Ʈ �߰�
            pNorth.add(bt[i]);
            pNorth.add(suja[i]);
            pNorth.add(minus[i]);
            pNorth.add(plus[i]);
            pNorth.add(l[i]);
            pNorth.add(ll[i]);
            pNorth.add(ok[i]);
            
            if(Inmoney.getM()< product[i].getPrice()) {
            	 bt[i].setEnabled(false);       //������ �޾׺��� ���ᰡ���� ������ ��ư ��Ȱ��ȭ(���ø��ϰ�)
            }
            if(product[i].getStock()==0) { //��� 0�� �� ��ư ��Ȱ��ȭ(���ø��ϰ�)
            	 bt[i].setEnabled(false);
            }       	 
        }
 
        // �߾�
        TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        ta.setText("   ��ǰ��        �ܰ�        ����        �հ�\n\n");
        ta.setBackground(Color.white);
        ta.setEditable(false);
        ta.setFont(font1);
 
        // ����
        Panel pSouth = new Panel();
        pSouth.setFont(font);
        pSouth.setBackground(new Color(219, 243, 226));
 
        //�ֹ��� �ʱ�ȭ ��ư �߰�
        Button bt1 = new Button("�ֹ�");
        Button bt2 = new Button("�ʱ�ȭ");
        pSouth.add(bt1);
        pSouth.add(bt2);

        // �ʱ�ȭ ��ư
        bt2.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < product.length; i++) {
                    //�� �ʱ�ȭ���ش�.
                    total=0;
                    count=0;
                    suja[i].setText("0");
                    ta.setText("   ��ǰ��        �ܰ�        ����        �հ�\n\n");
                }
            }
        });
 
        // ������Ʈ
        frame.add(pNorth, BorderLayout.NORTH);
        frame.add(ta, BorderLayout.CENTER);
        frame.add(pSouth, BorderLayout.SOUTH);
        frame.setVisible(true);
 
        // �̺�Ʈ��
        for (int i = 0; i < product.length; i++) {
            int j = i;

            // ��ư �̺�Ʈ
            bt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    minus[j].setEnabled(true);
                    plus[j].setEnabled(true);
                    ok[j].setEnabled(true);
                    count = 0;
                }
            });
 
            // "-" ��ư �̺�Ʈ
            minus[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (count > 0) {
                        count = count - 1;
                        suja[j].setText(count + "");
                        ok[j].setEnabled(true);
                    } else {
                        minus[j].setEnabled(false);
                    }
                }
            });
            
            // "+" ��ư �̺�Ʈ
            plus[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                    count = count + 1;
                    suja[j].setText(count + "");
                    ok[j].setEnabled(true);
                    if (count > 0) {
                        minus[j].setEnabled(true);
                    }
                }
            });
            
            //Ȯ�� ��ư �̺�Ʈ
            ok[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                	
                	if(count>getproductstoct(j)){        //������ ������ ������
                		JOptionPane.showMessageDialog(null,"��� ����", "��� ����", JOptionPane.DEFAULT_OPTION);
                	}
                	else if(count<=getproductstoct(j)){
                	 total+=(product[j].getPrice()*count);  //���� �ֹ��� ����
                    show = bt[j].getActionCommand(); 
                    ta.append("   " + product[j].getName() + "      " + product[j].getPrice() + "          " + count + "         " + product[j].getPrice() * count
                            + "��" + "\n");

                     setcount(j,count);  //������ ����
                     setnum(j,1);        //��� �ٲ� ���� 1�� ���ֱ�     
                     ok[j].setEnabled(false);
                }
                }
            });
        }
 
        // �ֹ���ư
        bt1.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(Inmoney.getM()<total) {      //�ֹ��� ����ݾ��� ������ ����ݾ׺��� Ŭ ��
                  JOptionPane.showMessageDialog(null, ta.getText() + "�� "+total+"�� �Դϴ�.\n �ֹ��� ���� �ݾ��� ������ �ݾ׺��� Ů�ϴ�\n�ٽ� ���Ḧ �������ּ���."); //��� ����
           		  ta.setText("   ��ǰ��        �ܰ�        ����        �հ�\n\n");
           		  for (int i = 0; i < product.length; i++) {
           		     setcount(i,0);      //���� ���� 0���� �ʱ�ȭ
                     setnum(i,0);        // ���� ���� 0�� ���ֱ�
           		  }
           		  frame.dispose();     // ���� â �ݱ�
           		  new Drink();
            	}
            	else if(Inmoney.getM()>=total) {                     //�ֹ��� ����ݾ��� ������ ����ݾ׺��� ���� ��
            		
               	 Mcount=Inmoney.getM(); //������ ��
               	 Mcount-=total;  //�ܵ�

               	 //���Ǳ� �� �� ��� ����(�ܵ� ���ֱ�)
                    c1000 = Mcount / 1000; 
                    ctemp = Inmoney.getmoneystock(0);
                    Inmoney.setmoneystock(0,(ctemp-c1000));
                       
                    c500 = Mcount%1000 / 500;
                    ctemp = Inmoney.getmoneystock(1);
                    Inmoney.setmoneystock(1,(ctemp-c500));
                       
                    c100 = Mcount%1000 %500/ 100;
                    ctemp = Inmoney.getmoneystock(2);
                    Inmoney.setmoneystock(2,(ctemp-c100));
                       
                    c50 = Mcount%1000 %500% 100/50;
                    ctemp = Inmoney.getmoneystock(3);
                    Inmoney.setmoneystock(3,(ctemp-c50));
                          
                    c10 = Mcount%1000 %500% 100%50/10;
                    ctemp = Inmoney.getmoneystock(4);
                    Inmoney.setmoneystock(4,(ctemp-c10));

               	 Inmoney.setmoneyprofit(Inmoney.getmoneyprofit()+total);  //���� ����
               	 
            		JOptionPane.showMessageDialog(null, ta.getText() + "   �� " +total+"�� �ֹ��Ǿ����ϴ�.\n�Ž������� "+Mcount+"�� �Դϴ�.\n�̿����ּż� �����մϴ�.");
                    for (int i = 0; i < product.length; i++) {
                    	int j=i;
                    	if(getnum(j)==1) {
                    		setproductstoct(j,(getproductstoct(j)-getcount(j)));   //���� ��� ���� 
                    		bt[j].setEnabled(true);
                            minus[j].setEnabled(false);
                            plus[j].setEnabled(false);
                            suja[j].setText("0");  
                            setcount(i,0);        //���� ���� 0���� �ʱ�ȭ                         
                            ta.setText("   ��ǰ��        �ܰ�        ����        �հ�\n\n");    
                        }
                    	setnum(j,0);   //���� ���� 0���� �ʱ�ȭ
                    	}                      
                    Inmoney.setM(0);   //������ ���� 0������ �����
                    frame.dispose();   // ���� â �ݱ�
                    new Inmoney();
                }
            	}      
        });

        // ����
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                for(int i = 0; i < product.length; i++) {
                	product[i]=null;     //�����Ҵ�����
                }         
                System.exit(0);
            }
        });
        }
    }