//�����ϴ� ������
package Machine;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Collection extends JFrame{
	
	
	static int i = 5;
	static int i0 = 0;
	static int i1 = 0;
	static int i2 = 0;
	static int i3 = 0;
	static int i4 = 0;
	 private static Money[] money = new Money[5];   //Money ������ ����
	
	public Collection() {
		for(int j=0;j<5;j++) {
			if(Inmoney.getmoneystock(j)>5) {      //�������� ��� 5�� �̻��̸�
				i0=Inmoney.getmoneystock(j)-5;    //i0������ 5���� ���� ������ �������ش�
				Inmoney.setmoneystock(j,(Inmoney.getmoneystock(j)-i0));       //������ ��� 5���� ������ش�.
			}
		}
		
		JOptionPane.showMessageDialog(null, "���ݵǾ����ϴ�.", "����", JOptionPane.DEFAULT_OPTION); //���� �Ϸ� ����
		new Admin();             //������ ������ �̵�
        setVisible(false);    // â �Ⱥ��̰� �ϱ� 
		return;
	}
}
