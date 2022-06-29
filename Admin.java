//관리자 페이지
package Machine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Admin extends JFrame {

public Admin() {
	
	// 디자인단
    // 프레임 설정단
    JFrame frame = new JFrame("관리자 모드");
    frame.setBounds(0, 0, 800, 600);
    
	Container container = frame.getContentPane();  //배경색 지정
    container.setBackground(new Color(219, 243, 226));
    
    // 폰트
    Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
    Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);

    // 북쪽
    Panel pNorth = new Panel();
    pNorth.setLayout(null);
    pNorth.setSize(0, 800);
    pNorth.setFont(font);
    
    // 배열 설정 부분(메뉴)
    JButton bt[] = new JButton[8];
    //화면 돌아가기 버튼 설정
    JButton bt1=new JButton("돌아가기");
    //이미지 
    ImageIcon icon[] = new ImageIcon[8];
    
    // 버튼 설정 부분
    for (int i = 0; i < 8; i++) {

        // 메뉴 버튼
        bt[i] = new JButton();                      //버튼 생성
        icon[i] = new ImageIcon((i+10) + ".png");        //이미지
        bt[i].setIcon(icon[i]);                     //이미지 버튼
        pNorth.add(bt[i]);                          //버튼 추가
    }
    bt[0].setBounds(165, 30, 120, 120);    //메뉴 변경 버튼 크기
    bt[1].setBounds(335, 30, 120, 120);    //가격 변경 버튼 크기
    bt[2].setBounds(505, 30, 120, 120);    //재고 변경 버튼 크기
    bt[3].setBounds(165, 200, 120, 120);    //화폐 현황 버튼 크기
    bt[4].setBounds(335, 200, 120, 120);    //수익 확인 버튼 크기
    bt[5].setBounds(505, 200, 120, 120);    //수금 버튼 크기
    bt[6].setBounds(165, 370, 120, 120);    //암호 변경 버튼 크기
    bt[7].setBounds(335, 370, 120, 120);    //암호 변경 버튼 크기
   pNorth.add(bt1); //돌아가기 버튼 추가
   bt1.setBounds(650, 510, 130, 30);    //돌아가기 버튼 크기
   
    // 컴포넌트
    frame.add(pNorth, BorderLayout.NORTH);
    frame.setVisible(true);      //프레임 보이게 설정

    //돌아가기 누르면 돈 투입 창으로 돌아가기
    bt1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();       // 창 안보이게 하기
            new Inmoney();              //돈 받는 창으로 이동
        }
    });
    
  //메뉴변경 누르면 메뉴를 변경할 수 있는 페이지로 이동
    bt[0].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();       // 창 안보이게 하기 
            new Newmenu();         //메뉴 변경 페이지로 이동
        }
    });
    
    //가격변경 누르면 가격을 변경할 수 있는 페이지로 이동
    bt[1].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {   
            frame.dispose();       // 창 안보이게 하기 
            new Newprice();        //가격 변경 페이지로 이동
        } 
    });
    
    //재고변경 누르면 재고를 변경할 수 있는 페이지로 이동
    bt[2].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();      // 창 안보이게 하기 
            new Newstock();       //재고 변경 페이지로 이동
        }
    });
    
    //화폐현황 누르면 화폐현황을 알 수 있는 페이지로 이동
    bt[3].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();          // 창 안보이게 하기 
            new Moneycondition();    //화폐현황 알 수 있는 페이지로 이동
        }
    });
    
    //수익확인 누르면 수익을 확인 할 수 있는 페이지로 이동
    bt[4].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();     // 창 안보이게 하기 
            new Profit();        //수익 알 수 있는 페이지로 이동
        }
    });
    
    //수금 누르면 수금을 할 수 있는 페이지로 이동
    bt[5].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();    // 창 안보이게 하기 
            new Collection();   //수금 할 수 있는 페이지로 이동
        }
    });
    
    //암호 변경 누르면 암호를 변경할 수 있는 페이지로 이동
    bt[6].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();    // 창 안보이게 하기 
            new Password();     //암호 변경 페이지로 이동
        }
    });
    
    //일/월 매출 확인
    bt[7].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();    // 창 안보이게 하기 
            new Filecheck();     //암호 변경 페이지로 이동
        }
    });
}
}