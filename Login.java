//관리자 페이지로 넘어가기 위한 로그인 패이지
package Machine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame{

private JPanel loginPanel = new JPanel(new GridLayout(3, 2));
private JPasswordField pwText = new JPasswordField();     //비밀번호 입력받는 창 생성
private JButton loginBtn = new JButton("로그인");          //로그인 버튼 생성
static String pass = "20204025@";                      //비빌번호 초기값

//암호변경해주는 함수
public static void setPass(String newPW) { 
   pass = newPW;
}

public Login() {
	super("로그인 창");
    this.setContentPane(loginPanel);
 
    loginPanel.add(pwText);
    loginPanel.add(loginBtn);

    //현재 프레임 창 가운데 정렬 setSize를 먼저 해줘서 정상적으로 프레임이 가운데로 정렬됨
    setSize(350,150);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //엔터키로 버튼 클릭
    JRootPane rootPane = this.getRootPane();
     rootPane.setDefaultButton(loginBtn);
    
    //로그인 버튼을 눌렀을때
    loginBtn.addActionListener(new ActionListener() {

		@Override
        public void actionPerformed(ActionEvent e) {

    		//아이디 비번 확인 테스트 코드
			String pw = pwText.getText().trim();  //암호 입력
			
    		if(pass=="") {   //비밀번호에 아무것도 입력을 하지 않을 때
    			JOptionPane.showMessageDialog(null, "비밀번호를 입력하셔야 됩니다.", "비번 입력", JOptionPane.DEFAULT_OPTION);
    			return;
    			}
    		else if(pass.equals(pw)) {      //입력한 비밀번호와 초기 비밀번호가 일치할 때
    			JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인", JOptionPane.DEFAULT_OPTION);
    			new Admin();                //관리자 페이지로 이동
                setVisible(false);         //창 안보이게 하기 
    			return;
    			}
    		
    		//입력한 비밀번호와 초기 비밀번호가 일치하지 않을 떄
    		JOptionPane.showMessageDialog(null, "로그인 실패", "로그인 확인", JOptionPane.DEFAULT_OPTION);
    		new Login();           //로그인 장 이동
    		setVisible(false);     // 창 안보이게 하기  	
    	}
    	});
    }
}