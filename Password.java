//암호변경 페이지

package Machine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Password extends JFrame{

private static final long serialVersionUID = 1L;
private JPanel loginPanel = new JPanel(new GridLayout(3, 2));
private JLabel pwLabel = new JLabel("새로운 비밀번호 ");     
private JPasswordField pwText = new JPasswordField();  //비밀번호 입력받는 창 생성
private JButton loginBtn = new JButton("로그인 변경");    //로그인 버튼 생성

public Password() {
	super("로그인 변경");
  this.setContentPane(loginPanel);
  
  //버튼 생성
  loginPanel.add(pwLabel);    
  loginPanel.add(pwText);
  loginPanel.add(loginBtn);

  //라벨 가운데 정렬
  pwLabel.setHorizontalAlignment(NORMAL);

  //현재 프레임 창 가운데 정렬 setSize를 먼저 해주어야 정상적으로 프레임이 가운데 정렬이 됨!
  setSize(350,150);
  this.setLocationRelativeTo(null);
  this.setVisible(true);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  // 엔터키로 버튼 클릭
  JRootPane rootPane = this.getRootPane();
   rootPane.setDefaultButton(loginBtn);

  //로그인 버튼을 눌렀을때
  loginBtn.addActionListener(new ActionListener() {
  	@Override
      public void actionPerformed(ActionEvent e) {

     	//아이디 비번 확인 테스트 코드
		@SuppressWarnings("deprecation")
		String Newpw1 = pwText.getText().trim();
  		
  	       // 비밀번호 포맷 확인 함수(특수문자, 숫자 포함 8자 이상)
  	       // 주어진 정규표현식으로부터 패턴 생성(특수문자와 숫자로 이루어졌는지)
  	       Pattern passPattern1 = Pattern.compile("^(?=.*\\d)(?=.*\\W).{8,20}$");     
  	       // 패턴에 매칭할 문자열을 입력해 Matcher생성
  	       Matcher passMatcher1 = passPattern1.matcher(Newpw1);  
  		
  		if(!passMatcher1.find()) {   //입력한 비밀번호가 조건에 부합하지 않을 때
  			JOptionPane.showMessageDialog(null, "숫자 및 특수기호를 하나 이상 사용해서 8자리 이상이 되어야합니다. ", "비밀번호 변경 실패", JOptionPane.DEFAULT_OPTION);
  			return;
  			}
  	      //입력한 비밀번호가 조건과 부합할 때
  		else {               // 패턴이 일치한다면
  			JOptionPane.showMessageDialog(null, "비밀번호가 성공적으로 바뀌었습니다.", "비밀번호 변경", JOptionPane.DEFAULT_OPTION);
  	  	    Login.setPass(Newpw1);   //암호를 입력한 값으로 변경해준다.
  	  	    setVisible(false);    // 창 안보이게 하기 
  	  		new Admin();            //관리자 페이지로 이동
         }
  	}
  	});
  }
}