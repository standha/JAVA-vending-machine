//자판기 내 화폐 개수
package Machine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Moneycondition extends JFrame{
	
public Moneycondition() {

	//프레임
	 JFrame frame = new JFrame("화폐현황");
     frame.setBounds(0, 0, 800, 600);
     frame.setBackground(Color.black);

     // 폰트
     Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
     Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);
     
     //위치
     Panel p = new Panel();
     p.setBackground(new Color(219, 243, 226));
     p.setLayout(null);
     p.setSize(0, 70);                  //중앙 텍스트 위치
     p.setFont(font);
     
     //버튼
     JButton bt1=new JButton("돌아가기");
     bt1.setBounds(630, 20, 130, 30);    //돌아가기 버튼 위치,크기 조정
     p.add(bt1); //버튼 추가

     String[]s=new String[5]; //5개 배열 생성
     String[]m= {"1000원 개수: ","500원 개수: ","100원 개수: ","50원 개수: ","10원 개수: "}; //5개 배열 생성
     
     for(int i=0;i<5;i++) {
    	 s[i]= String.valueOf(Inmoney.getmoneystock(i))+"개"; //s배열에 금액별 돈 재고 저장
     }
     
     // 텍스트
     TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
     ta.setBackground(Color.white);
     ta.setEditable(false);
     ta.setFont(font1);
     
     //텍스트에 넣을 문구
     ta.append("\n\n\n\n                    서하 자판기 화폐 현황            \n\n");
     for(int j=0;j<5;j++) {
    	 ta.append("                      "+m[j]+s[j]+"\n");
     }
     
     //돌아가기 버튼 눌렀을 때 
     bt1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             frame.dispose();       // 창 안보이게 하기
             new Admin();           // 관리자 페이지 이동
         }
     });

     frame.add(p, BorderLayout.NORTH);
     frame.add(ta, BorderLayout.CENTER);
     frame.setVisible(true);
     frame.setLocationRelativeTo(null);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }

}
