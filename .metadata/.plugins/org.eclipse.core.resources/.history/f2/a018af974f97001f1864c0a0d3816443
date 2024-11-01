package ex_240510_4;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Sudoku_Main extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Sudoku_Main() {
        setTitle("Notes and Password Manager");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout()); // Use GridBagLayout for more flexible layout

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding

        JLabel usernameLabel = new JLabel("Username:");
        add(usernameLabel, gbc);

        gbc.gridy++;
        usernameField = new JTextField();
        add(usernameField, gbc);

        gbc.gridy++;
        JLabel passwordLabel = new JLabel("Password:");
        add(passwordLabel, gbc);

        gbc.gridy++;
        passwordField = new JPasswordField();
        add(passwordField, gbc);

        gbc.gridy++;
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        gbc.gridwidth = 2; // Make the button span two columns
        add(loginButton, gbc);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Authenticate user (You can implement your own authentication logic here)
        if (username.equals("admin") && password.equals("admin123")) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            openNotesPage();
            dispose(); // Close the login window after successful login
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password");
        }
    }

    private void openNotesPage() {
        SudokuGame sudokuGame = new SudokuGame();
        sudokuGame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Sudoku_Main();
            }
        });
    }
}

