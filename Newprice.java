//���� ����
package Machine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Newprice extends JFrame{
   
public Newprice() {
   
   //������
    JFrame frame = new JFrame("���� ����");
     frame.setBounds(0, 0, 800, 600);     //ũ��
     frame.setBackground(Color.black);     //��

     // ��Ʈ
     Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
     Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);

   // �г� ����
   JPanel p = new JPanel();
    p.setLayout(null);
    p.setSize(800,600);
    p.setBackground(new Color(219, 243, 226));    //��� ��
    p.setFont(font);                               //��Ʈ 
    frame.add(p, BorderLayout.CENTER);
    frame.add(p);
    
   // ���̺� ����
   JLabel n0 = new JLabel("0��: "+Drink.product[0].getName());
   JLabel n1 = new JLabel("1��: "+Drink.product[1].getName());
   JLabel n2 = new JLabel("2��: "+Drink.product[2].getName());
   JLabel n3 = new JLabel("3��: "+Drink.product[3].getName());
   JLabel n4 = new JLabel("4��: "+Drink.product[4].getName());
   JLabel n5 = new JLabel("�޴� ��ȣ �� �̸� - ");
   JLabel lbl1 = new JLabel("������ �̸� �Է�: ");
   JLabel lbl2 = new JLabel("������ ��ȣ �Է�: ");
   JLabel lbl3 = new JLabel("���� ���� �Է�:");
   
   // 20�ڸ� �ؽ�Ʈ �ʵ� ����
   JTextField txt1 = new JTextField(20);    //�ؽ�Ʈ �ʵ�
   JTextField txt2 = new JTextField(20);    //�ؽ�Ʈ �ʵ�
   JTextField txt3 = new JTextField(20); 
   
   //��ư ����
    JButton bt1=new JButton("���ư���");
    JButton change=new JButton("���� ���� ����");
   
    //��ġ,ũ�� ����   
    n0.setBounds(150,50,120,120);
    n1.setBounds(250,50,120,120);
    n2.setBounds(350,50,120,120);
    n3.setBounds(450,50,120,120);
    n4.setBounds(550,50,120,120);
    n5.setBounds(30,50,120,120);
    lbl1.setBounds(197,100,120,120);
    lbl2.setBounds(197,150,120,120);
    lbl3.setBounds(210,200,120,120);
    //�ؽ�Ʈ �ʵ� ��ġ,ũ�� ���� 
    txt1.setBounds(300, 150, 200, 30);     
    txt2.setBounds(300, 200, 200, 30); 
    txt3.setBounds(300, 250, 200, 30); 
    //���ư��� ��ư ��ġ,ũ�� ����
    bt1.setBounds(630, 20, 130, 30);   
    //���� ��ư ��ġ,ũ�� ����
    change.setBounds(330,330,130,30);   
    
   p.add(bt1);         //���ư��� ��ư �߰�
   //��ư �� �ؽ�Ʈ�ʵ� �߰�
   p.add(lbl1);      
   p.add(txt1);
   p.add(lbl2);       
   p.add(txt2);
   p.add(lbl3);     
   p.add(txt3);  
   p.add(n0);
   p.add(n1);
   p.add(n2);
   p.add(n3);
   p.add(n4);
   p.add(n5);
   p.add(change);     //���� ��ư �߰�
   
    bt1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               frame.dispose();      // â �Ⱥ��̰� �ϱ�
               new Admin();             //������ �������� �̵�
           } 
       });
   
    change.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              String s=txt1.getText();                       // ���� �޴�
              int i1=Integer.valueOf(txt2.getText());       // �޴� ��ȣ
              int i=Integer.valueOf(txt3.getText());       // ���� ���� 
              
            if(i1 > 4) {
               JOptionPane.showMessageDialog(null, "�ٽ��Է�", "��ȣ�� Ȯ���ϼ���", JOptionPane.DEFAULT_OPTION);
               frame.dispose();       // â �Ⱥ��̰� �ϱ�
               new Admin();             //������ �������� �̵�
              }
             else {
            	 Drink.setproductprice(i1,i);
                 frame.dispose();    // â �Ⱥ��̰� �ϱ�
               new Admin();             //������ �������� �̵�
           }
           }
       });
    
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
}