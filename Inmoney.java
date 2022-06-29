//�� ���� ȭ��
package Machine;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Inmoney extends JFrame {

	int count = 0;
    int total=0;            //�� �޴� ����       
    static int moneytotal=0;   //�� �Է� �޴� ���� ������ ����
    static int profit=0;        //������ �Է� ���� ����
    private static Money[] money = new Money[5];   //Money ������ ����
    String show = "";

    //�� ���� �� �����ϴ� �Լ�
    public static void setM(int moneytotal1 ) { 
       moneytotal = moneytotal1;
    }
     //�� ���� �� ��� �Լ�
    public static int getM( ) {
        return moneytotal;
     }
    //�� ��� ���� �Լ�
    public static int getmoneystock(int i) {
 	  return money[i].getcountMoney();
	}
    //�� ��� ��ȯ �Լ�(���Ǳ� �� ȭ�� ����)
    public static void setmoneystock(int i,int newmoney) {
   	 money[i].setcountMoney(newmoney);
 	}   
    //���� ��ȯ �Լ�
    public static int getmoneyprofit() {
   	 return profit;
    } 
    //���� ���� �Լ�
    public static void setmoneyprofit(int newprofit) {
   	 profit=newprofit;
 	}
    //������ �� 1�� ���ֱ�
    public static void setnum1(int i,int n) {
    	 money[i].setm(n);
    }
    //������ �� 1 ��ȯ
    public static int getnum1(int i) {
    	 return  money[i].getm();
    } 
    //������ �� ����
    public static void setcount1(int i,int num) {
    	 money[i].setmm(num);
    }
    //������ �� ���� ��ȯ
    public static int getcount1(int i) {
    	 return money[i].getmm();
    }
        
 // �ܰ� �ʱ�ȭ �Լ�
    public static void initMoney() {
       for(int i=0; i<money.length; i++) 
    	   money[i] = new Money();
          
       // ���� ����,�̸� ����
       money[0].setcountMoney(5);   money[0].setpriceMoney(1000);   money[0].setMoney("1000");
       money[1].setcountMoney(5);   money[1].setpriceMoney(500);   money[1].setMoney("500 ");
       money[2].setcountMoney(5);   money[2].setpriceMoney(100);   money[2].setMoney("100 ");
       money[3].setcountMoney(5);   money[3].setpriceMoney(50);   money[3].setMoney("50  ");
       money[4].setcountMoney(5);   money[4].setpriceMoney(10);   money[4].setMoney("10  ");
    }
    
    public Inmoney(){
        // �����δ�
        // ������ ������
        JFrame frame = new JFrame("���� �����ϼ���");
        frame.setBounds(0, 0, 800, 600);
        frame.setBackground(Color.black);
 
        // ��Ʈ
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
        Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);
 
        // ����
        Panel pNorth = new Panel();
        pNorth.setBackground(new Color(219, 243, 226));
        pNorth.setLayout(null);
        pNorth.setSize(0, 350); //�߾� �ؽ�Ʈ ��ġ
        pNorth.setFont(font);

        // �迭 ���� �κ�
        JButton bt[] = new JButton[money.length];             //�޴� ��ư
        TextField suja[] = new TextField[money.length];       //����Ȯ���Ҽ��ִ� �ؽ�Ʈ�ʵ�
        Button minus[] = new Button[money.length];            //-��ư
        Button plus[] = new Button[money.length];             //+��ư
        JButton ok[] = new JButton[money.length];             //Ȯ�ι�ư
        ImageIcon icon[] = new ImageIcon[money.length];       //�׸� ��ư
        Button admin= new Button("������ �޴�");                 //������ ��ư
        
        // ��ư ���� �κ�
        for (int i = 0; i < money.length; i++) {
 
            // �޴� ��ư
            bt[i] = new JButton();   
            //���� ��ư ����
            bt[i].setBounds(25 + i * 150, 50, 100, 100);   //��ư ������
           
            icon[i] = new ImageIcon((i+5) + ".jpg");      //���� ����
            bt[i].setIcon(icon[i]);
 
            // ���� txt ��ư
            suja[i] = new TextField("0");                //���ڸ� 0���� �����.
            suja[i].setBackground(Color.white);
            suja[i].setEditable(false);
            suja[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);  //���� �ؽ�Ʈ �ʵ� ��ġ�� Ȯ�� ��ư ��ġ
 
            // "-" ��ư
            minus[i] = new Button("-");
            minus[i].setBounds(bt[i].getX(), suja[i].getY(), 20, 20);
            minus[i].setEnabled(false);
 
            // "+" ��ư
            plus[i] = new Button("+");
            plus[i].setBounds(bt[i].getX() + (100 - 20), suja[i].getY(), 20, 20);
            plus[i].setEnabled(false);
 
            // Ȯ�� ��ư
            ok[i] = new JButton("Ȯ��");
            ok[i].setBounds(bt[i].getX(), suja[i].getY() + 30, 100, 20);
            ok[i].setEnabled(false);
            
            //��ư �߰�
            pNorth.add(bt[i]);  
            pNorth.add(suja[i]);
            pNorth.add(minus[i]);
            pNorth.add(plus[i]);
            pNorth.add(ok[i]);
        }
        
        admin.setBounds(630, 10, 130, 30);    //���ư��� ��ư ��ġ,ũ�� ����
        pNorth.add(admin);                    //������ ��ư �߰�
          
        // �߾� �ؽ�Ʈ
        TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        ta.setText("   �ݾ�          ����          �հ�\n\n");
        ta.setBackground(Color.white);     //�ؽ�Ʈ ����
        ta.setEditable(false);
        ta.setFont(font1);                //�۾�ü
       
        // ����
        Panel pSouth = new Panel();
        pSouth.setFont(font);
        pSouth.setBackground(new Color(219, 243, 226));
 
        //��ư ����
        Button bt1 = new Button("���� �ֹ�");
        Button bt3 = new Button("�ݱ�");
        pSouth.add(bt1); //��ư�߰�
        pSouth.add(bt3);
       
      //������ �޴� Ŭ���� ������ �������� �Ѿ
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            		frame.dispose();     // ���� â �ݱ�
                    new Login();            // �α��� â ����
            }
         });
        
        //�����ֹ� Ŭ���� �����ֹ� �������� �Ѿ
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	if(total>5000) {        // ���� �ݾ��� 5000���̻��̸�
            		JOptionPane.showMessageDialog(null,"5000������ �����մϴ�.\n�ٽ� �ݾ��� �������ּ���.");   //��� ���� 
            		  for (int i = 0; i < money.length; i++) {
            		       setcount1(i,0);  //���� ���� 0���� �ʱ�ȭ
                           setnum1(i,0);        // ���� ȭ�� 0�� ���ֱ�
                }
            		total=0;
            		new Inmoney();
            		frame.dispose();
            	}	
            	else {
            		
            	    for (int i = 0; i < money.length; i++) {
                    int j=i;
                    if(getnum1(j)==1) {
                        setmoneystock(j,(getmoneystock(j)+getcount1(j)));   //ȭ�� ��� ���� 
                        setcount1(j,0);   //���� ���� 0���� �ʱ�ȭ 
                        setM(total);
                           }
                    setnum1(j,0);  //���� ȭ�� 0���� �ʱ�ȭ
            	}
            	    frame.dispose();   // ���� â �ݱ�
                    new Drink();   // ���� ���� â ����
            }
            }
         });
        
        //bt3 �ݱ��ư Ŭ���� �ý��� ����
        bt3.addActionListener(new ActionListener() {          
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
 
        // ������Ʈ
        frame.add(pNorth, BorderLayout.NORTH);
        frame.add(ta, BorderLayout.CENTER);
        frame.add(pSouth, BorderLayout.SOUTH);
        frame.setVisible(true);
        
        //Ȯ�� ��ư �̺�Ʈ(1000�� ������ ��)
        ok[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	if((money[0].getpriceMoney() * count)>3000) {      //���� ���Ѽ� �̻� ���� ��
            		JOptionPane.showMessageDialog(null, "����� 3000������ �����մϴ�.\n�ٽ� �ݾ��� �������ּ���.");    //��� ����
              		new Inmoney();                //�� ���� â���� �̵�
             		frame.dispose();              //â �ݱ�
            	}
            	else {
            	 total+=(money[0].getpriceMoney()*count);      //total�� 1000������ ���� �� �� ����
                show = bt[0].getActionCommand();
                ta.append("" + show + "   " + money[0].getpriceMoney() + "            " + count + "           " + money[0].getpriceMoney() * count
                        + "��" + "\n");                       //�ؽ�Ʈ �ʵ忡 ������ ������ ������ �հ� ���                 
                setcount1(0,count);  //1000�� ����
                setnum1(0,1);        //1000�� ȭ�� 1�� ���ֱ�
                ok[0].setEnabled(false);
            }
            }
        });
        
        //���� ������ ��
        for (int i = 1; i < money.length; i++) {
            int j = i;
        //Ȯ�� ��ư �̺�Ʈ(1000���� ������ ���� Ȯ�� ��ư ������ ��)
        ok[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 total+=(money[j].getpriceMoney()*count);      //total�� ���� �� �� ����
                show = bt[j].getActionCommand();
                ta.append("" + show + "   " + money[j].getpriceMoney() + "            " + count + "           " + money[j].getpriceMoney() * count
                        + "��" + "\n");                        //�ؽ�Ʈ �ʵ忡�� ������ ������ ������ �հ� ���
                setcount1(j,count);  //������ ����
                setnum1(j,1);        // ���� ȭ�� 1�� ���ֱ�
                ok[j].setEnabled(false);
               
            }
        });
        }
               
        // �̺�Ʈ��
        for (int i = 0; i < money.length; i++) {
            int j = i;
 
            //��ư �̺�Ʈ 
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
 
        // ����
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	 for(int i = 0; i < money.length; i++) {
                 	money[i]=null; //�����Ҵ�����
                 } 
            	System.exit(0);       
            }
        });
        }
    }

    //����
    public static void main(String[] args) {
   	 Drink.initProduct(); //����޴� �ʱ�ȭ �Լ� ȣ��
   	 initMoney(); //�� �ʱ�ȭ �Լ� ȣ��
      new Inmoney();
    }
    }
