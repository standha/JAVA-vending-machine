//���� Ȯ��
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

public class Profit extends JFrame{
	
public Profit() {

	//������
	 JFrame frame = new JFrame("����Ȯ��");
     frame.setBounds(0, 0, 800, 600);
     frame.setBackground(Color.black);

     // ��Ʈ
     Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
     Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);
     //��ġ
     Panel p = new Panel();
     p.setBackground(new Color(219, 243, 226));
     p.setLayout(null);
     p.setSize(0, 70); //�߾� �ؽ�Ʈ ��ġ
     p.setFont(font);
         
     //��ư
     JButton bt1=new JButton("���ư���");
     bt1.setBounds(630, 20, 130, 30);    //���ư��� ��ư ��ġ,ũ�� ����
     p.add(bt1); //��ư �߰�
          
    // �߾�(�ؽ�Ʈ)
     TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
     ta.setBackground(Color.white);
     ta.setEditable(false);
     ta.setFont(font1);
     
     ta.append("\n\n\n\n\n                  ���� ���Ǳ� �� ����: "+Inmoney.getmoneyprofit()+"��");
     //���ư��� ��ư ������ �� 
     bt1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             frame.dispose();        // â �Ⱥ��̰� �ϱ�
             new Admin();              //������ �������� �̵�
         }
     });

     frame.add(p, BorderLayout.NORTH);
     frame.add(ta, BorderLayout.CENTER);
     frame.setVisible(true);
     frame.setLocationRelativeTo(null);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }

}