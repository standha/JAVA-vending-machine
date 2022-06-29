//음료 구매 화면
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
	int count = 0;  //개수 카운트 하는 변수
    int total=0;    //음료 주문한 가격 받는 변수
    String show = "";
    static int stock=3;     //음료 채고 3개 
   static Product[] product = new Product[5];   //product생성자 생성
   private static int ctemp=0;
   private static int c1000=0;
   private static int c500=0;
   private static int c100=0;
   private static int c50=0;
   private static int c10=0;
    static int num=0;

 // 음료메뉴 초기화 함수
    public static void initProduct() {
        for(int i=0; i<product.length; i++) 
           product[i] = new Product();
              
        // 이름과 가격,재고 설정
        product[0].setName("물      ");   product[0].setPrice(450);   product[0].setStock(3);
        product[1].setName("커피    ");   product[1].setPrice(500);   product[1].setStock(3);
        product[2].setName("이온음료");   product[2].setPrice(550);   product[2].setStock(3);
        product[3].setName("고급커피");   product[3].setPrice(700);   product[3].setStock(3);
        product[4].setName("탄산음료");   product[4].setPrice(750);   product[4].setStock(3);
     }
    
    //변경된 이름 받는 함수
    public static void setproductMenu(int i,String name) {
    	product[i].setName(name);
    }
    //가격 변경해주는 함수
    public static void setproductprice(int i,int newprice) { 
    	product[i].setPrice (newprice);
  	}
    //재고 변경 함수
    public static void setproductstoct(int i,int newstock) {
    	 product[i].setStock(newstock);
    }
    //재고 변경 반환 함수
    public static int getproductstoct(int i) {
    	 return product[i].getStock();
    }
    
    //선택 음료 숫자 1로 해주기
    public static void setnum(int i,int n) {
    	 product[i].setp(n);
    }
  //선택 음료 숫자 1 반환
    public static int getnum(int i) {
    	 return product[i].getp();
    }
    
    //선택 음료 개수
    public static void setcount(int i,int num) {
        product[i].setc(num);
    }
  //선택 음료 개수 반환
    public static int getcount(int i) {
    	 return product[i].getc();
    }
    
    public Drink(){
        // 디자인단
        // 프레임 설정단
        JFrame frame = new JFrame("서하 자판기");
        frame.setBounds(0, 0, 800, 600);
        frame.setBackground(Color.black);
 
        // 폰트
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
        Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);
 
        // 북쪽
        Panel pNorth = new Panel();
        pNorth.setBackground(new Color(219, 243, 226));
        pNorth.setLayout(null);
        pNorth.setSize(0, 350);
        pNorth.setFont(font);
     
        // 배열 설정 부분
        JButton bt[] = new JButton[product.length];
        TextField suja[] = new TextField[product.length];
        Button minus[] = new Button[product.length];
        Button plus[] = new Button[product.length];
        JButton ok[] = new JButton[product.length];
        Label l[] = new Label[product.length];
        Label ll[] = new Label[product.length];
        ImageIcon icon[] = new ImageIcon[product.length];
        
        // 버튼 설정 부분
        for (int i = 0; i < product.length; i++) {	  
           // 메뉴 버튼
            bt[i] = new JButton();
            bt[i].setBounds(25 + i * 150, 50, 100, 100);               
            icon[i] = new ImageIcon(i + ".png");           //이미지           
            bt[i].setIcon(icon[i]);                        //이미지 버튼
                      
            if(getproductstoct(i)==0){   //음료 재고가 0이면
        	   bt[i].setEnabled(false);  //메뉴버튼 비활성화
             }
            // 숫자 txt 버튼
            suja[i] = new TextField("0");
            suja[i].setBackground(Color.white);
            suja[i].setEditable(false);
            suja[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 170, 40, 20);
 
            // "-" 버튼
            minus[i] = new Button("-");
            minus[i].setBounds(bt[i].getX(), suja[i].getY(), 20, 20);
            minus[i].setEnabled(false);
 
            // "+" 버튼
            plus[i] = new Button("+");
            plus[i].setBounds(bt[i].getX() + (100 - 20), suja[i].getY(), 20, 20);
            plus[i].setEnabled(false);
 
            // 가격과 음료 이름과 재고 및 품절 표시
            if(getproductstoct(i)==0){
            	l[i] = new Label(product[i].getName()+"("+ product[i].getStock() +")");
            	ll[i] = new Label(product[i].getPrice() + "원-품절");
                l[i].setBounds(bt[i].getX()+6, suja[i].getY() -50, 100, 20);
                ll[i].setBounds(bt[i].getX()+23, suja[i].getY()-30, 100, 20);
            }
            
            else {
            	l[i] = new Label(product[i].getName()+"("+ product[i].getStock() +")");
            	ll[i] = new Label(product[i].getPrice() + "원");
                l[i].setBounds(bt[i].getX()+6, suja[i].getY() -50, 100, 20);
                ll[i].setBounds(bt[i].getX()+23, suja[i].getY()-30, 100, 20);
            }

            // 확인 버튼
            ok[i] = new JButton("확인");
            ok[i].setBounds(bt[i].getX(), suja[i].getY() + 30, 100, 20);
            ok[i].setEnabled(false);
                        
            //버튼과 텍스트 추가
            pNorth.add(bt[i]);
            pNorth.add(suja[i]);
            pNorth.add(minus[i]);
            pNorth.add(plus[i]);
            pNorth.add(l[i]);
            pNorth.add(ll[i]);
            pNorth.add(ok[i]);
            
            if(Inmoney.getM()< product[i].getPrice()) {
            	 bt[i].setEnabled(false);       //투입한 급액보다 음료가격이 높으면 버튼 비활성화(선택못하게)
            }
            if(product[i].getStock()==0) { //재고가 0일 때 버튼 비활성화(선택못하게)
            	 bt[i].setEnabled(false);
            }       	 
        }
 
        // 중앙
        TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        ta.setText("   상품명        단가        수량        합계\n\n");
        ta.setBackground(Color.white);
        ta.setEditable(false);
        ta.setFont(font1);
 
        // 남쪽
        Panel pSouth = new Panel();
        pSouth.setFont(font);
        pSouth.setBackground(new Color(219, 243, 226));
 
        //주문과 초기화 버튼 추가
        Button bt1 = new Button("주문");
        Button bt2 = new Button("초기화");
        pSouth.add(bt1);
        pSouth.add(bt2);

        // 초기화 버튼
        bt2.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < product.length; i++) {
                    //다 초기화해준다.
                    total=0;
                    count=0;
                    suja[i].setText("0");
                    ta.setText("   상품명        단가        수량        합계\n\n");
                }
            }
        });
 
        // 컴포넌트
        frame.add(pNorth, BorderLayout.NORTH);
        frame.add(ta, BorderLayout.CENTER);
        frame.add(pSouth, BorderLayout.SOUTH);
        frame.setVisible(true);
 
        // 이벤트단
        for (int i = 0; i < product.length; i++) {
            int j = i;

            // 버튼 이벤트
            bt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    minus[j].setEnabled(true);
                    plus[j].setEnabled(true);
                    ok[j].setEnabled(true);
                    count = 0;
                }
            });
 
            // "-" 버튼 이벤트
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
            
            // "+" 버튼 이벤트
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
            
            //확인 버튼 이벤트
            ok[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                	
                	if(count>getproductstoct(j)){        //수량이 제고보다 많으면
                		JOptionPane.showMessageDialog(null,"재고 부족", "재고 부족", JOptionPane.DEFAULT_OPTION);
                	}
                	else if(count<=getproductstoct(j)){
                	 total+=(product[j].getPrice()*count);  //음료 주문한 가격
                    show = bt[j].getActionCommand(); 
                    ta.append("   " + product[j].getName() + "      " + product[j].getPrice() + "          " + count + "         " + product[j].getPrice() * count
                            + "원" + "\n");

                     setcount(j,count);  //선택한 개수
                     setnum(j,1);        //재고 바뀔 음료 1로 해주기     
                     ok[j].setEnabled(false);
                }
                }
            });
        }
 
        // 주문버튼
        bt1.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(Inmoney.getM()<total) {      //주문한 음료금액이 투입한 음료금액보다 클 때
                  JOptionPane.showMessageDialog(null, ta.getText() + "총 "+total+"원 입니다.\n 주문한 음료 금액이 투입한 금액보다 큽니다\n다시 음료를 선택해주세요."); //경고 문구
           		  ta.setText("   상품명        단가        수량        합계\n\n");
           		  for (int i = 0; i < product.length; i++) {
           		     setcount(i,0);      //선택 개수 0으로 초기화
                     setnum(i,0);        // 선택 음료 0로 해주기
           		  }
           		  frame.dispose();     // 현재 창 닫기
           		  new Drink();
            	}
            	else if(Inmoney.getM()>=total) {                     //주문한 음료금액이 투입한 음료금액보다 작을 때
            		
               	 Mcount=Inmoney.getM(); //투입한 돈
               	 Mcount-=total;  //잔돈

               	 //자판기 내 돈 재고 관리(잔돈 뺴주기)
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

               	 Inmoney.setmoneyprofit(Inmoney.getmoneyprofit()+total);  //수익 저장
               	 
            		JOptionPane.showMessageDialog(null, ta.getText() + "   총 " +total+"원 주문되었습니다.\n거스름돈은 "+Mcount+"원 입니다.\n이용해주셔서 감사합니다.");
                    for (int i = 0; i < product.length; i++) {
                    	int j=i;
                    	if(getnum(j)==1) {
                    		setproductstoct(j,(getproductstoct(j)-getcount(j)));   //음료 재고 변경 
                    		bt[j].setEnabled(true);
                            minus[j].setEnabled(false);
                            plus[j].setEnabled(false);
                            suja[j].setText("0");  
                            setcount(i,0);        //선택 개수 0으로 초기화                         
                            ta.setText("   상품명        단가        수량        합계\n\n");    
                        }
                    	setnum(j,0);   //선택 음료 0으로 초기화
                    	}                      
                    Inmoney.setM(0);   //돈받은 상태 0원으로 만들기
                    frame.dispose();   // 현재 창 닫기
                    new Inmoney();
                }
            	}      
        });

        // 끄기
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                for(int i = 0; i < product.length; i++) {
                	product[i]=null;     //동적할당해제
                }         
                System.exit(0);
            }
        });
        }
    }