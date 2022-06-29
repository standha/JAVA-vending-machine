//수금하는 페이지
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
	 private static Money[] money = new Money[5];   //Money 생성자 생성
	
	public Collection() {
		for(int j=0;j<5;j++) {
			if(Inmoney.getmoneystock(j)>5) {      //동전별로 재고가 5개 이상이면
				i0=Inmoney.getmoneystock(j)-5;    //i0변수에 5개를 남긴 개수를 저장해준다
				Inmoney.setmoneystock(j,(Inmoney.getmoneystock(j)-i0));       //동전별 재고를 5개로 만들어준다.
			}
		}
		
		JOptionPane.showMessageDialog(null, "수금되었습니다.", "수금", JOptionPane.DEFAULT_OPTION); //수금 완료 문구
		new Admin();             //관리자 페이지 이동
        setVisible(false);    // 창 안보이게 하기 
		return;
	}
}
