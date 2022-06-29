//������ ������
package Machine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Admin extends JFrame {

public Admin() {
	
	// �����δ�
    // ������ ������
    JFrame frame = new JFrame("������ ���");
    frame.setBounds(0, 0, 800, 600);
    
	Container container = frame.getContentPane();  //���� ����
    container.setBackground(new Color(219, 243, 226));
    
    // ��Ʈ
    Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
    Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);

    // ����
    Panel pNorth = new Panel();
    pNorth.setLayout(null);
    pNorth.setSize(0, 800);
    pNorth.setFont(font);
    
    // �迭 ���� �κ�(�޴�)
    JButton bt[] = new JButton[8];
    //ȭ�� ���ư��� ��ư ����
    JButton bt1=new JButton("���ư���");
    //�̹��� 
    ImageIcon icon[] = new ImageIcon[8];
    
    // ��ư ���� �κ�
    for (int i = 0; i < 8; i++) {

        // �޴� ��ư
        bt[i] = new JButton();                      //��ư ����
        icon[i] = new ImageIcon((i+10) + ".png");        //�̹���
        bt[i].setIcon(icon[i]);                     //�̹��� ��ư
        pNorth.add(bt[i]);                          //��ư �߰�
    }
    bt[0].setBounds(165, 30, 120, 120);    //�޴� ���� ��ư ũ��
    bt[1].setBounds(335, 30, 120, 120);    //���� ���� ��ư ũ��
    bt[2].setBounds(505, 30, 120, 120);    //��� ���� ��ư ũ��
    bt[3].setBounds(165, 200, 120, 120);    //ȭ�� ��Ȳ ��ư ũ��
    bt[4].setBounds(335, 200, 120, 120);    //���� Ȯ�� ��ư ũ��
    bt[5].setBounds(505, 200, 120, 120);    //���� ��ư ũ��
    bt[6].setBounds(165, 370, 120, 120);    //��ȣ ���� ��ư ũ��
    bt[7].setBounds(335, 370, 120, 120);    //��ȣ ���� ��ư ũ��
   pNorth.add(bt1); //���ư��� ��ư �߰�
   bt1.setBounds(650, 510, 130, 30);    //���ư��� ��ư ũ��
   
    // ������Ʈ
    frame.add(pNorth, BorderLayout.NORTH);
    frame.setVisible(true);      //������ ���̰� ����

    //���ư��� ������ �� ���� â���� ���ư���
    bt1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();       // â �Ⱥ��̰� �ϱ�
            new Inmoney();              //�� �޴� â���� �̵�
        }
    });
    
  //�޴����� ������ �޴��� ������ �� �ִ� �������� �̵�
    bt[0].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();       // â �Ⱥ��̰� �ϱ� 
            new Newmenu();         //�޴� ���� �������� �̵�
        }
    });
    
    //���ݺ��� ������ ������ ������ �� �ִ� �������� �̵�
    bt[1].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {   
            frame.dispose();       // â �Ⱥ��̰� �ϱ� 
            new Newprice();        //���� ���� �������� �̵�
        } 
    });
    
    //����� ������ ��� ������ �� �ִ� �������� �̵�
    bt[2].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();      // â �Ⱥ��̰� �ϱ� 
            new Newstock();       //��� ���� �������� �̵�
        }
    });
    
    //ȭ����Ȳ ������ ȭ����Ȳ�� �� �� �ִ� �������� �̵�
    bt[3].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();          // â �Ⱥ��̰� �ϱ� 
            new Moneycondition();    //ȭ����Ȳ �� �� �ִ� �������� �̵�
        }
    });
    
    //����Ȯ�� ������ ������ Ȯ�� �� �� �ִ� �������� �̵�
    bt[4].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();     // â �Ⱥ��̰� �ϱ� 
            new Profit();        //���� �� �� �ִ� �������� �̵�
        }
    });
    
    //���� ������ ������ �� �� �ִ� �������� �̵�
    bt[5].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();    // â �Ⱥ��̰� �ϱ� 
            new Collection();   //���� �� �� �ִ� �������� �̵�
        }
    });
    
    //��ȣ ���� ������ ��ȣ�� ������ �� �ִ� �������� �̵�
    bt[6].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();    // â �Ⱥ��̰� �ϱ� 
            new Password();     //��ȣ ���� �������� �̵�
        }
    });
    
    //��/�� ���� Ȯ��
    bt[7].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();    // â �Ⱥ��̰� �ϱ� 
            new Filecheck();     //��ȣ ���� �������� �̵�
        }
    });
}
}