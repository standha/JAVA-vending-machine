//���Ǳ� �� ȭ�� ����
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

	//������
	 JFrame frame = new JFrame("ȭ����Ȳ");
     frame.setBounds(0, 0, 800, 600);
     frame.setBackground(Color.black);

     // ��Ʈ
     Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
     Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);
     
     //��ġ
     Panel p = new Panel();
     p.setBackground(new Color(219, 243, 226));
     p.setLayout(null);
     p.setSize(0, 70);                  //�߾� �ؽ�Ʈ ��ġ
     p.setFont(font);
     
     //��ư
     JButton bt1=new JButton("���ư���");
     bt1.setBounds(630, 20, 130, 30);    //���ư��� ��ư ��ġ,ũ�� ����
     p.add(bt1); //��ư �߰�

     String[]s=new String[5]; //5�� �迭 ����
     String[]m= {"1000�� ����: ","500�� ����: ","100�� ����: ","50�� ����: ","10�� ����: "}; //5�� �迭 ����
     
     for(int i=0;i<5;i++) {
    	 s[i]= String.valueOf(Inmoney.getmoneystock(i))+"��"; //s�迭�� �ݾ׺� �� ��� ����
     }
     
     // �ؽ�Ʈ
     TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
     ta.setBackground(Color.white);
     ta.setEditable(false);
     ta.setFont(font1);
     
     //�ؽ�Ʈ�� ���� ����
     ta.append("\n\n\n\n                    ���� ���Ǳ� ȭ�� ��Ȳ            \n\n");
     for(int j=0;j<5;j++) {
    	 ta.append("                      "+m[j]+s[j]+"\n");
     }
     
     //���ư��� ��ư ������ �� 
     bt1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             frame.dispose();       // â �Ⱥ��̰� �ϱ�
             new Admin();           // ������ ������ �̵�
         }
     });

     frame.add(p, BorderLayout.NORTH);
     frame.add(ta, BorderLayout.CENTER);
     frame.setVisible(true);
     frame.setLocationRelativeTo(null);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }

}
