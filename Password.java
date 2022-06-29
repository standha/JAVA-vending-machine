//��ȣ���� ������

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
private JLabel pwLabel = new JLabel("���ο� ��й�ȣ ");     
private JPasswordField pwText = new JPasswordField();  //��й�ȣ �Է¹޴� â ����
private JButton loginBtn = new JButton("�α��� ����");    //�α��� ��ư ����

public Password() {
	super("�α��� ����");
  this.setContentPane(loginPanel);
  
  //��ư ����
  loginPanel.add(pwLabel);    
  loginPanel.add(pwText);
  loginPanel.add(loginBtn);

  //�� ��� ����
  pwLabel.setHorizontalAlignment(NORMAL);

  //���� ������ â ��� ���� setSize�� ���� ���־�� ���������� �������� ��� ������ ��!
  setSize(350,150);
  this.setLocationRelativeTo(null);
  this.setVisible(true);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  // ����Ű�� ��ư Ŭ��
  JRootPane rootPane = this.getRootPane();
   rootPane.setDefaultButton(loginBtn);

  //�α��� ��ư�� ��������
  loginBtn.addActionListener(new ActionListener() {
  	@Override
      public void actionPerformed(ActionEvent e) {

     	//���̵� ��� Ȯ�� �׽�Ʈ �ڵ�
		@SuppressWarnings("deprecation")
		String Newpw1 = pwText.getText().trim();
  		
  	       // ��й�ȣ ���� Ȯ�� �Լ�(Ư������, ���� ���� 8�� �̻�)
  	       // �־��� ����ǥ�������κ��� ���� ����(Ư�����ڿ� ���ڷ� �̷��������)
  	       Pattern passPattern1 = Pattern.compile("^(?=.*\\d)(?=.*\\W).{8,20}$");     
  	       // ���Ͽ� ��Ī�� ���ڿ��� �Է��� Matcher����
  	       Matcher passMatcher1 = passPattern1.matcher(Newpw1);  
  		
  		if(!passMatcher1.find()) {   //�Է��� ��й�ȣ�� ���ǿ� �������� ���� ��
  			JOptionPane.showMessageDialog(null, "���� �� Ư����ȣ�� �ϳ� �̻� ����ؼ� 8�ڸ� �̻��� �Ǿ���մϴ�. ", "��й�ȣ ���� ����", JOptionPane.DEFAULT_OPTION);
  			return;
  			}
  	      //�Է��� ��й�ȣ�� ���ǰ� ������ ��
  		else {               // ������ ��ġ�Ѵٸ�
  			JOptionPane.showMessageDialog(null, "��й�ȣ�� ���������� �ٲ�����ϴ�.", "��й�ȣ ����", JOptionPane.DEFAULT_OPTION);
  	  	    Login.setPass(Newpw1);   //��ȣ�� �Է��� ������ �������ش�.
  	  	    setVisible(false);    // â �Ⱥ��̰� �ϱ� 
  	  		new Admin();            //������ �������� �̵�
         }
  	}
  	});
  }
}