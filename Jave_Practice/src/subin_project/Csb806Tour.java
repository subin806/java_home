package subin_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ex_241031.Csb806Personal;

public class Csb806Tour extends JFrame {

	public Csb806Tour() {
		setTitle("Subin's Tour");
		setSize(1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// 상단 메뉴바 생성
		JPanel topPanel = new JPanel(new BorderLayout());
		
		//패널 왼쪽에 텍스트 추가
		JLabel titleLabel = new JLabel("Welcome to subin's tour");
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		topPanel.add(titleLabel, BorderLayout.WEST);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton loginButton = new JButton("로그인");
		JButton signupButton = new JButton("회원가입");
		JButton reservationButton = new JButton("예약조회");

		buttonPanel.add(loginButton);
		buttonPanel.add(signupButton);
		buttonPanel.add(reservationButton);
		topPanel.add(buttonPanel, BorderLayout.EAST);

		// 메인 패키지 패널 생성
		JPanel packagePanel = new JPanel();
		packagePanel.setLayout(new GridLayout(1, 3, 10, 10));

		//이미지 로드 및 라벨 생성
		JLabel packageA = new JLabel("패키지 A", new ImageIcon("src/csb806image/hokongNight.jpg"), SwingConstants.CENTER);
		JLabel packageB = new JLabel("패키지 B", new ImageIcon("src/csb806image/sharkTour.jpg"), SwingConstants.CENTER);
		JLabel packageC = new JLabel("패키지 C", new ImageIcon("src/csb806image/europeTour.jpg"), SwingConstants.CENTER);

		packagePanel.add(packageA);
		packagePanel.add(packageB);
		packagePanel.add(packageC);

		// 패키지 라벨에 대한 디자인 추가
		packageA.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		packageB.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		packageC.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		// 패키지선택 시 상세 페이지로 이동
		packageA.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				new Csb806Detail("홍콩 2박3일 투어", "아시아나항공/하버플라자노스포인트호텔/소호", "649,000원");
			}
		});

		packageB.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				new Csb806Detail("보홀 4박5일 투어", "진에어항공/솔레아팡라오코스트리조트/고래상어투어", "560,000원");
			}
		});

		packageC.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				new Csb806Detail("유럽 일주일 투어", "티웨이항공/호텔미정/유럽일주", "1,833,000원");
			}
		});

		// 구성요소 추가
		add(topPanel, BorderLayout.NORTH);
		add(packagePanel, BorderLayout.CENTER);

		setVisible(true);

		// 버튼 액션 리스너 추가
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Csb806Login();
			}
		});

		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Csb806Signup();
			}
		});

		reservationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "예약 조회 기능은 현재 사용 불가합니다");
			}
		});
	}
		
		public static void main(String[] args) {
	        new Csb806Tour();
	}
}