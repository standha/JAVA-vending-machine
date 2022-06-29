//��/�� ���� 
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

	//������
	 JFrame frame = new JFrame("��/�� ����");
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
     
     // ���� ��¥ ���ϱ�
     LocalDate now = LocalDate.now();
     // ���� ����
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
     // ���� ����
     String formatedNow = now.format(formatter);
	
	 File file = new File("C:\\Users\\myyun\\eclipse-workspace\\Term_project\\sales.txt");
	 
	    try { 	  	
	    	if (!file.exists()) {  //������ �������� ���� ��
	    		file.createNewFile();  //���� ����		
	    	}
	    	String string="";
	    	FileWriter fw = new FileWriter(file);	
	    	FileReader rfw = new FileReader(file);
	    	BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	    	FileWriter filewriter=new FileWriter(file);
			writer.write(formatedNow+" : "+Inmoney.getmoneyprofit());
			BufferedReader readwriter = new BufferedReader(new FileReader(file));
			while((string=readwriter.readLine())!=null) {
				 ta.append("\n\n\n\n\n "+string+"��");
			}
			writer.close();
			readwriter.close();
	    } catch (FileNotFoundException e) {
	    	e.printStackTrace();

	    } catch (IOException e) {
	   		e.printStackTrace();
	    }
 
     ta.append("\n\n\n\n\n "+formatedNow+" : "+Inmoney.getmoneyprofit()+"��");
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