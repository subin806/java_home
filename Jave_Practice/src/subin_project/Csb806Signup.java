package subin_project;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Csb806Signup extends JFrame {

	private JTextField nameField, usernamerField, contactField;
	private JPasswordField passwordField;

	public Csb806Signup() {
		setTitle("회원가입");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(5, 2, 5, 5));

		// 라벨과 입력필드 추가
		add(new JLabel("이름"));
		nameField = new JTextField();
		add(nameField);

		add(new JLabel("아이디"));
		usernamerField = new JTextField();
		add(usernamerField);

		add(new JLabel("비밀번호"));
		passwordField = new JPasswordField();
		add(passwordField);

		add(new JLabel("연락처"));
		contactField = new JTextField();
		add(contactField);

		// 회원가입 버튼 추가
		JButton signupButton = new JButton("회원가입");
		signupButton.addActionListener(new signupAction());
		add(signupButton);

		setVisible(true);
	}

	private class signupAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String name = nameField.getText();
			String username = usernamerField.getText();
			String password = new String(passwordField.getPassword());
			String contact = contactField.getText();

			// 유효성 검사
			if (name.isEmpty() || username.isEmpty() || password.isEmpty() || contact.isEmpty()) {
				JOptionPane.showMessageDialog(null, "모든 필드를 채워주세요.");
				return;
			}

			// db에 정보 저장
			try (Connection conn = Csb806DB.getConnection()) {
				String query = "INSERT INTO member502 (name, username, password, contact) VALUES (MEMBER502_SEQ.NEXTVAL,?, ?, ?, ?)";
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setString(1, name);
				stmt.setString(2, username);
				stmt.setString(3, password);
				stmt.setString(4, contact);

				int rows = stmt.executeUpdate();
				if (rows > 0) {
					JOptionPane.showMessageDialog(null, "회원가입 성공!");
					dispose(); // 회원가입 창 닫기
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "회원가입 중 오류가 발생했습니다.");
			}
		}
	}

	public static void main(String[] args) {
		new Csb806Signup();
	}
}
