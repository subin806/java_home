package subin_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Csb806Login extends JFrame {
	private JTextField usernameField;
	private JPasswordField passwordField;

	public Csb806Login() {
		setTitle("로그인");
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

	    //상단 타이틀 패널
		//챗지피티 네이버 계정에 있다 확인하삼
		
		JPanel titlePanel = new JPanel(new GridLayout());
		JLabel titleLabel = new JLabel("Title", JLabel.CENTER);
		titleLabel.setFont(titleLabel.getFont().deriveFont(24f));
		JLabel subtitleLabel = new JLabel("로그인", JLabel.CENTER);
		titlePanel.add(titleLabel);
		titlePanel.add(subtitleLabel);
		
		//중앙 입력 필드 패널
		JPanel inputPanel = new JPanel(new GridLayout(5, 1, 10, 10));
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		
		//아이디/비번 입력필드
		inputPanel.add(new JLabel("아이디", JLabel.CENTER));
		inputPanel.add(usernameField);
		inputPanel.add(new JLabel("비밀번호",JLabel.CENTER));
		inputPanel.add(passwordField);
		
		//로그인/회원가입버튼
		JButton loginButton = new JButton("로그인");
		loginButton.addActionListener(new LoginAction());
		inputPanel.add(loginButton);

		JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
		buttonPanel.add(loginButton);
		inputPanel.add(buttonPanel);
		
		//하단광고패널
		JPanel adPanel = new JPanel();
		adPanel.setBackground(Color.LIGHT_GRAY);
		
		//이미지추가
		ImageIcon adImage = new ImageIcon("src/csb806image/advertisement.jpg");
		Image img = adImage.getImage();
		Image scaledImg = img.getScaledInstance(380, 150, Image.SCALE_SMOOTH); 
        adImage = new ImageIcon(scaledImg);
        JLabel adLabel = new JLabel(adImage);
        adLabel.setHorizontalAlignment(JLabel.CENTER);
        adPanel.add(adLabel);
        
        add(titlePanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(adPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
		
	private class LoginAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String username = usernameField.getText();
			String password = new String(passwordField.getPassword());

			try (Connection conn = Csb806DB.getConnection()) {
				String query = "SELECT * FROM MEMBER502";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "로그인 성공!");
					// 홈페이지 또는 패키지 페이지로 이동
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패. 다시 시도하세요.");
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Csb806Login();
	}
}