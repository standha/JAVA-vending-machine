//일/월 매출 
package Machine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Filecheck extends JFrame{

public Filecheck() {

	//프레임
	 JFrame frame = new JFrame("일/월 매출");
     frame.setBounds(0, 0, 800, 600);
     frame.setBackground(Color.black);

     // 폰트
     Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
     Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);
     //위치
     Panel p = new Panel();
     p.setBackground(new Color(219, 243, 226));
     p.setLayout(null);
     p.setSize(0, 70); //중앙 텍스트 위치
     p.setFont(font);
         
     //버튼
     JButton bt1=new JButton("돌아가기");
     bt1.setBounds(630, 20, 130, 30);    //돌아가기 버튼 위치,크기 조정
     p.add(bt1); //버튼 추가
          
    // 중앙(텍스트)
     TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
     ta.setBackground(Color.white);
     ta.setEditable(false);
     ta.setFont(font1);
     
     // 현재 날짜 구하기
     LocalDate now = LocalDate.now();
     // 포맷 정의
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
     // 포맷 적용
     String formatedNow = now.format(formatter);
	
	 File file = new File("C:\\Users\\myyun\\eclipse-workspace\\Term_project\\sales.txt");
	 
	    try { 	  	
	    	if (!file.exists()) {  //파일이 존재하지 않을 떼
	    		file.createNewFile();  //파일 생성		
	    	}
	    	String string="";
	    	FileWriter fw = new FileWriter(file);	
	    	FileReader rfw = new FileReader(file);
	    	BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	    	FileWriter filewriter=new FileWriter(file);
			writer.write(formatedNow+" : "+Inmoney.getmoneyprofit());
			BufferedReader readwriter = new BufferedReader(new FileReader(file));
			while((string=readwriter.readLine())!=null) {
				 ta.append("\n\n\n\n\n "+string+"원");
			}
			writer.close();
			readwriter.close();
	    } catch (FileNotFoundException e) {
	    	e.printStackTrace();

	    } catch (IOException e) {
	   		e.printStackTrace();
	    }
 
     ta.append("\n\n\n\n\n "+formatedNow+" : "+Inmoney.getmoneyprofit()+"원");
     //돌아가기 버튼 눌렀을 때 
     bt1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             frame.dispose();        // 창 안보이게 하기
             new Admin();              //관리자 페이지로 이동
         }
     });

     frame.add(p, BorderLayout.NORTH);
     frame.add(ta, BorderLayout.CENTER);
     frame.setVisible(true);
     frame.setLocationRelativeTo(null);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}