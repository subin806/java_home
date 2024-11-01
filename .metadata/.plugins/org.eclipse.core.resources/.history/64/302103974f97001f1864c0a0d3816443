package ex_240510_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SudokuGame extends JFrame implements ActionListener {
    private JTextField[][] fields;
    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USERNAME = "scott";
    private static final String PASSWORD = "tiger";

    public SudokuGame() {
        setTitle("Sudoku Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Panel for buttons
        JPanel centerPanel = new JPanel(new GridLayout(9, 9)); // Panel for text fields
        fields = new JTextField[9][9];

        // Create text fields and add to the center panel
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                fields[i][j] = new JTextField();
                fields[i][j].setHorizontalAlignment(JTextField.CENTER);
                fields[i][j].setPreferredSize(new Dimension(30, 30));
                centerPanel.add(fields[i][j]);
            }
        }

        // Buttons
        JButton insertButton = new JButton("Insert Non-Zero Numbers");
        JButton selectButton = new JButton("Select Numbers");
        JButton updateButton = new JButton("Update Numbers");
        JButton initializeButton = new JButton("Initialize Puzzle");

        // Add action listeners
        insertButton.addActionListener(this);
        selectButton.addActionListener(this);
        updateButton.addActionListener(this);
        initializeButton.addActionListener(e -> initializePuzzle());

        // Add buttons to the top panel
        topPanel.add(insertButton);
        topPanel.add(selectButton);
        topPanel.add(updateButton);
        topPanel.add(initializeButton);

        // Add panels to the frame
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        setSize(900, 450);
        setLocationRelativeTo(null);
        setVisible(true);

        initializePuzzle();
    }

    // Method to initialize the puzzle with some numbers
    private void initializePuzzle() {
        // Example initial puzzle (incomplete)
        int[][] puzzle = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        // Fill the text fields with initial numbers from the puzzle
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (puzzle[i][j] != 0) {
                    fields[i][j].setText(Integer.toString(puzzle[i][j]));
                    fields[i][j].setEditable(false); // Make initial numbers non-editable
                } else {
                    fields[i][j].setText(""); // Empty string for cells with 0
                }
            }
        }
    }

    // Method to insert non-zero numbers into the database
    private void insertNonZeroNumbers(int[][] puzzle) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO sudoku_numbers1 (row_index, col_index, value) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int value = puzzle[i][j];
                    if (value != 0) {
                        statement.setInt(1, i);
                        statement.setInt(2, j);
                        statement.setInt(3, value);
                        statement.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to clear the puzzle
    private void clearPuzzle() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                fields[i][j].setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SudokuGame::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // When the insert button is clicked, insert non-zero numbers into the database
        if (e.getActionCommand().equals("Insert Non-Zero Numbers")) {
            int[][] puzzle = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    try {
                        puzzle[i][j] = Integer.parseInt(fields[i][j].getText());
                    } catch (NumberFormatException ex) {
                        puzzle[i][j] = 0; // If the field is empty or not a number, set to 0
                    }
                }
            }
            insertNonZeroNumbers(puzzle);
            JOptionPane.showMessageDialog(this, "Non-zero numbers inserted into the database.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getActionCommand().equals("Select Numbers")) { // When the select button is clicked, select numbers from the database and display them on the puzzle
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                String sql = "SELECT row_index, col_index, value FROM sudoku_numbers1";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();

                // Clear existing values in the puzzle
                clearPuzzle();

                // Fill the puzzle with selected numbers from the database
                while (resultSet.next()) {
                    int row = resultSet.getInt("row_index");
                    int col = resultSet.getInt("col_index");
                    int value = resultSet.getInt("value");
                    fields[row][col].setText(Integer.toString(value));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (e.getActionCommand().equals("Update Numbers")) { // When the update button is clicked, update numbers in the database
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                String updateSql = "UPDATE sudoku_numbers1 SET value = ? WHERE row_index = ? AND col_index = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateSql);

                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        int value;
                        try {
                            value = Integer.parseInt(fields[i][j].getText());
                        } catch (NumberFormatException ex) {
                            value = 0; // If the field is empty or not a number, set to 0
                        }
                        updateStatement.setInt(1, value);
                        updateStatement.setInt(2, i);
                        updateStatement.setInt(3, j);
                        updateStatement.executeUpdate();
                    }
                }
                JOptionPane.showMessageDialog(this, "Numbers updated in the database.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
