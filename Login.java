//������ �������� �Ѿ�� ���� �α��� ������
package Machine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame{

private JPanel loginPanel = new JPanel(new GridLayout(3, 2));
private JPasswordField pwText = new JPasswordField();     //��й�ȣ �Է¹޴� â ����
private JButton loginBtn = new JButton("�α���");          //�α��� ��ư ����
static String pass = "20204025@";                      //�����ȣ �ʱⰪ

//��ȣ�������ִ� �Լ�
public static void setPass(String newPW) { 
   pass = newPW;
}

public Login() {
	super("�α��� â");
    this.setContentPane(loginPanel);
 
    loginPanel.add(pwText);
    loginPanel.add(loginBtn);

    //���� ������ â ��� ���� setSize�� ���� ���༭ ���������� �������� ����� ���ĵ�
    setSize(350,150);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //����Ű�� ��ư Ŭ��
    JRootPane rootPane = this.getRootPane();
     rootPane.setDefaultButton(loginBtn);
    
    //�α��� ��ư�� ��������
    loginBtn.addActionListener(new ActionListener() {

		@Override
        public void actionPerformed(ActionEvent e) {

    		//���̵� ��� Ȯ�� �׽�Ʈ �ڵ�
			String pw = pwText.getText().trim();  //��ȣ �Է�
			
    		if(pass=="") {   //��й�ȣ�� �ƹ��͵� �Է��� ���� ���� ��
    			JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է��ϼž� �˴ϴ�.", "��� �Է�", JOptionPane.DEFAULT_OPTION);
    			return;
    			}
    		else if(pass.equals(pw)) {      //�Է��� ��й�ȣ�� �ʱ� ��й�ȣ�� ��ġ�� ��
    			JOptionPane.showMessageDialog(null, "�α��� ����", "�α��� Ȯ��", JOptionPane.DEFAULT_OPTION);
    			new Admin();                //������ �������� �̵�
                setVisible(false);         //â �Ⱥ��̰� �ϱ� 
    			return;
    			}
    		
    		//�Է��� ��й�ȣ�� �ʱ� ��й�ȣ�� ��ġ���� ���� ��
    		JOptionPane.showMessageDialog(null, "�α��� ����", "�α��� Ȯ��", JOptionPane.DEFAULT_OPTION);
    		new Login();           //�α��� �� �̵�
    		setVisible(false);     // â �Ⱥ��̰� �ϱ�  	
    	}
    	});
    }
}