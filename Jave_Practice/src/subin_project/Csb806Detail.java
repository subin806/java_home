package subin_project;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Csb806Detail extends JFrame {
	public Csb806Detail(String packageNmae, String location, String price) {
		setTitle("패키지 상품정보");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(4,1));
		
		JLabel nameLabel = new JLabel("패키지 이름: " + packageNmae);
		JLabel locationLabel = new JLabel("위치: " + location);
		JLabel priceLabel = new JLabel("가격: " + price);
		JButton reserveButton = new JButton("예약하기");
		
		reserveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//예약 성공 메세지
				JOptionPane.showMessageDialog(null, "예약 성공!");
				//상세페이지 창 닫기
				dispose();
			}
		});
		
		add(nameLabel);
		add(locationLabel);
		add(priceLabel);
		add(reserveButton);
		
		setVisible(true);
	}

}
