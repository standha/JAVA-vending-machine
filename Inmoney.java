//돈 투입 화면
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
    int total=0;            //돈 받는 변수       
    static int moneytotal=0;   //총 입력 받는 돈을 저장할 변수
    static int profit=0;        //수익을 입력 받을 변수
    private static Money[] money = new Money[5];   //Money 생성자 생성
    String show = "";

    //총 받은 돈 저장하는 함수
    public static void setM(int moneytotal1 ) { 
       moneytotal = moneytotal1;
    }
     //총 받은 돈 출력 함수
    public static int getM( ) {
        return moneytotal;
     }
    //돈 재고 변경 함수
    public static int getmoneystock(int i) {
 	  return money[i].getcountMoney();
	}
    //돈 재고 반환 함수(자판기 내 화폐 개수)
    public static void setmoneystock(int i,int newmoney) {
   	 money[i].setcountMoney(newmoney);
 	}   
    //수익 반환 함수
    public static int getmoneyprofit() {
   	 return profit;
    } 
    //수익 저장 함수
    public static void setmoneyprofit(int newprofit) {
   	 profit=newprofit;
 	}
    //선택한 돈 1로 해주기
    public static void setnum1(int i,int n) {
    	 money[i].setm(n);
    }
    //선택한 돈 1 반환
    public static int getnum1(int i) {
    	 return  money[i].getm();
    } 
    //선택한 돈 개수
    public static void setcount1(int i,int num) {
    	 money[i].setmm(num);
    }
    //선택한 돈 개수 반환
    public static int getcount1(int i) {
    	 return money[i].getmm();
    }
        
 // 잔고 초기화 함수
    public static void initMoney() {
       for(int i=0; i<money.length; i++) 
    	   money[i] = new Money();
          
       // 재고와 가격,이름 설정
       money[0].setcountMoney(5);   money[0].setpriceMoney(1000);   money[0].setMoney("1000");
       money[1].setcountMoney(5);   money[1].setpriceMoney(500);   money[1].setMoney("500 ");
       money[2].setcountMoney(5);   money[2].setpriceMoney(100);   money[2].setMoney("100 ");
       money[3].setcountMoney(5);   money[3].setpriceMoney(50);   money[3].setMoney("50  ");
       money[4].setcountMoney(5);   money[4].setpriceMoney(10);   money[4].setMoney("10  ");
    }
    
    public Inmoney(){
        // 디자인단
        // 프레임 설정단
        JFrame frame = new JFrame("돈을 투입하세요");
        frame.setBounds(0, 0, 800, 600);
        frame.setBackground(Color.black);
 
        // 폰트
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
        Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);
 
        // 북쪽
        Panel pNorth = new Panel();
        pNorth.setBackground(new Color(219, 243, 226));
        pNorth.setLayout(null);
        pNorth.setSize(0, 350); //중앙 텍스트 위치
        pNorth.setFont(font);

        // 배열 설정 부분
        JButton bt[] = new JButton[money.length];             //메뉴 버튼
        TextField suja[] = new TextField[money.length];       //수량확인할수있는 텍스트필드
        Button minus[] = new Button[money.length];            //-버튼
        Button plus[] = new Button[money.length];             //+버튼
        JButton ok[] = new JButton[money.length];             //확인버튼
        ImageIcon icon[] = new ImageIcon[money.length];       //그림 버튼
        Button admin= new Button("관리자 메뉴");                 //관리자 버튼
        
        // 버튼 설정 부분
        for (int i = 0; i < money.length; i++) {
 
            // 메뉴 버튼
            bt[i] = new JButton();   
            //음료 버튼 만듦
            bt[i].setBounds(25 + i * 150, 50, 100, 100);   //버튼 사이즈
           
            icon[i] = new ImageIcon((i+5) + ".jpg");      //음료 사진
            bt[i].setIcon(icon[i]);
 
            // 숫자 txt 버튼
            suja[i] = new TextField("0");                //숫자를 0으로 만든다.
            suja[i].setBackground(Color.white);
            suja[i].setEditable(false);
            suja[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);  //숫자 텍스트 필드 위치와 확인 버튼 위치
 
            // "-" 버튼
            minus[i] = new Button("-");
            minus[i].setBounds(bt[i].getX(), suja[i].getY(), 20, 20);
            minus[i].setEnabled(false);
 
            // "+" 버튼
            plus[i] = new Button("+");
            plus[i].setBounds(bt[i].getX() + (100 - 20), suja[i].getY(), 20, 20);
            plus[i].setEnabled(false);
 
            // 확인 버튼
            ok[i] = new JButton("확인");
            ok[i].setBounds(bt[i].getX(), suja[i].getY() + 30, 100, 20);
            ok[i].setEnabled(false);
            
            //버튼 추가
            pNorth.add(bt[i]);  
            pNorth.add(suja[i]);
            pNorth.add(minus[i]);
            pNorth.add(plus[i]);
            pNorth.add(ok[i]);
        }
        
        admin.setBounds(630, 10, 130, 30);    //돌아가기 버튼 위치,크기 조정
        pNorth.add(admin);                    //관리자 버튼 추가
          
        // 중앙 텍스트
        TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        ta.setText("   금액          수량          합계\n\n");
        ta.setBackground(Color.white);     //텍스트 배경색
        ta.setEditable(false);
        ta.setFont(font1);                //글씨체
       
        // 남쪽
        Panel pSouth = new Panel();
        pSouth.setFont(font);
        pSouth.setBackground(new Color(219, 243, 226));
 
        //버튼 생성
        Button bt1 = new Button("음료 주문");
        Button bt3 = new Button("닫기");
        pSouth.add(bt1); //버튼추가
        pSouth.add(bt3);
       
      //관리자 메뉴 클릭시 관리자 페이지로 넘어감
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            		frame.dispose();     // 현재 창 닫기
                    new Login();            // 로그인 창 띄우기
            }
         });
        
        //음료주문 클릭시 음료주문 페이지로 넘어감
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	if(total>5000) {        // 투입 금액이 5000원이상이면
            		JOptionPane.showMessageDialog(null,"5000원까지 가능합니다.\n다시 금액을 투입해주세요.");   //경고 문구 
            		  for (int i = 0; i < money.length; i++) {
            		       setcount1(i,0);  //선택 개수 0으로 초기화
                           setnum1(i,0);        // 선택 화폐 0로 해주기
                }
            		total=0;
            		new Inmoney();
            		frame.dispose();
            	}	
            	else {
            		
            	    for (int i = 0; i < money.length; i++) {
                    int j=i;
                    if(getnum1(j)==1) {
                        setmoneystock(j,(getmoneystock(j)+getcount1(j)));   //화폐 재고 변경 
                        setcount1(j,0);   //선택 개수 0으로 초기화 
                        setM(total);
                           }
                    setnum1(j,0);  //선택 화폐 0으로 초기화
            	}
            	    frame.dispose();   // 현재 창 닫기
                    new Drink();   // 음료 구매 창 띄우기
            }
            }
         });
        
        //bt3 닫기버튼 클릭시 시스템 종료
        bt3.addActionListener(new ActionListener() {          
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
 
        // 컴포넌트
        frame.add(pNorth, BorderLayout.NORTH);
        frame.add(ta, BorderLayout.CENTER);
        frame.add(pSouth, BorderLayout.SOUTH);
        frame.setVisible(true);
        
        //확인 버튼 이벤트(1000원 눌렀을 때)
        ok[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	if((money[0].getpriceMoney() * count)>3000) {      //지폐 상한선 이상 투입 시
            		JOptionPane.showMessageDialog(null, "지폐는 3000원까지 가능합니다.\n다시 금액을 투입해주세요.");    //경고 문구
              		new Inmoney();                //돈 투입 창으로 이동
             		frame.dispose();              //창 닫기
            	}
            	else {
            	 total+=(money[0].getpriceMoney()*count);      //total에 1000원으로 받은 총 돈 저장
                show = bt[0].getActionCommand();
                ta.append("" + show + "   " + money[0].getpriceMoney() + "            " + count + "           " + money[0].getpriceMoney() * count
                        + "원" + "\n");                       //텍스트 필드에 선택한 동전과 개수와 합계 출력                 
                setcount1(0,count);  //1000원 개수
                setnum1(0,1);        //1000원 화폐 1로 해주기
                ok[0].setEnabled(false);
            }
            }
        });
        
        //동전 눌렀을 때
        for (int i = 1; i < money.length; i++) {
            int j = i;
        //확인 버튼 이벤트(1000원을 제외한 동전 확인 버튼 눌렀을 때)
        ok[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 total+=(money[j].getpriceMoney()*count);      //total에 받은 총 돈 저장
                show = bt[j].getActionCommand();
                ta.append("" + show + "   " + money[j].getpriceMoney() + "            " + count + "           " + money[j].getpriceMoney() * count
                        + "원" + "\n");                        //텍스트 필드에서 선택한 동전과 개수와 합계 출력
                setcount1(j,count);  //선택한 개수
                setnum1(j,1);        // 선택 화폐 1로 해주기
                ok[j].setEnabled(false);
               
            }
        });
        }
               
        // 이벤트단
        for (int i = 0; i < money.length; i++) {
            int j = i;
 
            //버튼 이벤트 
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
 
        // 끄기
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	 for(int i = 0; i < money.length; i++) {
                 	money[i]=null; //동적할당해제
                 } 
            	System.exit(0);       
            }
        });
        }
    }

    //메인
    public static void main(String[] args) {
   	 Drink.initProduct(); //음료메뉴 초기화 함수 호출
   	 initMoney(); //돈 초기화 함수 호출
      new Inmoney();
    }
    }
