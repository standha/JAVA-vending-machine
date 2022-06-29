//가격 변경
package Machine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Newprice extends JFrame{
   
public Newprice() {
   
   //프레임
    JFrame frame = new JFrame("가격 변경");
     frame.setBounds(0, 0, 800, 600);     //크기
     frame.setBackground(Color.black);     //색

     // 폰트
     Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
     Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);

   // 패널 생성
   JPanel p = new JPanel();
    p.setLayout(null);
    p.setSize(800,600);
    p.setBackground(new Color(219, 243, 226));    //배경 색
    p.setFont(font);                               //폰트 
    frame.add(p, BorderLayout.CENTER);
    frame.add(p);
    
   // 레이블 생성
   JLabel n0 = new JLabel("0번: "+Drink.product[0].getName());
   JLabel n1 = new JLabel("1번: "+Drink.product[1].getName());
   JLabel n2 = new JLabel("2번: "+Drink.product[2].getName());
   JLabel n3 = new JLabel("3번: "+Drink.product[3].getName());
   JLabel n4 = new JLabel("4번: "+Drink.product[4].getName());
   JLabel n5 = new JLabel("메뉴 번호 및 이름 - ");
   JLabel lbl1 = new JLabel("변경할 이름 입력: ");
   JLabel lbl2 = new JLabel("변경할 번호 입력: ");
   JLabel lbl3 = new JLabel("변경 가격 입력:");
   
   // 20자리 텍스트 필드 생성
   JTextField txt1 = new JTextField(20);    //텍스트 필드
   JTextField txt2 = new JTextField(20);    //텍스트 필드
   JTextField txt3 = new JTextField(20); 
   
   //버튼 생성
    JButton bt1=new JButton("돌아가기");
    JButton change=new JButton("음료 가격 변경");
   
    //위치,크기 조정   
    n0.setBounds(150,50,120,120);
    n1.setBounds(250,50,120,120);
    n2.setBounds(350,50,120,120);
    n3.setBounds(450,50,120,120);
    n4.setBounds(550,50,120,120);
    n5.setBounds(30,50,120,120);
    lbl1.setBounds(197,100,120,120);
    lbl2.setBounds(197,150,120,120);
    lbl3.setBounds(210,200,120,120);
    //텍스트 필드 위치,크기 조정 
    txt1.setBounds(300, 150, 200, 30);     
    txt2.setBounds(300, 200, 200, 30); 
    txt3.setBounds(300, 250, 200, 30); 
    //돌아가기 버튼 위치,크기 조정
    bt1.setBounds(630, 20, 130, 30);   
    //변경 버튼 위치,크기 조정
    change.setBounds(330,330,130,30);   
    
   p.add(bt1);         //돌아가기 버튼 추가
   //버튼 및 텍스트필드 추가
   p.add(lbl1);      
   p.add(txt1);
   p.add(lbl2);       
   p.add(txt2);
   p.add(lbl3);     
   p.add(txt3);  
   p.add(n0);
   p.add(n1);
   p.add(n2);
   p.add(n3);
   p.add(n4);
   p.add(n5);
   p.add(change);     //변경 버튼 추가
   
    bt1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               frame.dispose();      // 창 안보이게 하기
               new Admin();             //관리자 페이지로 이동
           } 
       });
   
    change.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              String s=txt1.getText();                       // 기존 메뉴
              int i1=Integer.valueOf(txt2.getText());       // 메뉴 번호
              int i=Integer.valueOf(txt3.getText());       // 변경 가격 
              
            if(i1 > 4) {
               JOptionPane.showMessageDialog(null, "다시입력", "번호를 확인하세요", JOptionPane.DEFAULT_OPTION);
               frame.dispose();       // 창 안보이게 하기
               new Admin();             //관리자 페이지로 이동
              }
             else {
            	 Drink.setproductprice(i1,i);
                 frame.dispose();    // 창 안보이게 하기
               new Admin();             //관리자 페이지로 이동
           }
           }
       });
    
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
}