package ex_241028;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Csb806Voca extends JFrame {
    private JLabel a = new JLabel("apple");
    private JLabel a2 = new JLabel("banana");
    private JLabel a3 = new JLabel("house");
    private JLabel a4 = new JLabel("car");

    public Csb806Voca() {
        setTitle("Subin Voca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);


        a.setSize(100, 20);
        a.setLocation(200, 60);
        a2.setSize(100, 20);
        a2.setLocation(200, 80);
        a3.setSize(100, 20);
        a3.setLocation(200, 100);
        a4.setSize(100, 20);
        a4.setLocation(200, 120);


        MyMouseListener listener = new MyMouseListener();
        a.addMouseListener(listener);
        a2.addMouseListener(listener);
        a3.addMouseListener(listener);
        a4.addMouseListener(listener);

        c.add(a); 
        c.add(a2); 
        c.add(a3); 
        c.add(a4); 

        setSize(500, 300);
        setVisible(true);
    }

    class MyMouseListener extends MouseAdapter {
        private String originalText;

        public void mousePressed(MouseEvent e) {
            JLabel word = (JLabel) e.getSource();
            originalText = word.getText(); 
            switch (originalText) {
                case "apple":
                    word.setText("사과");
                    break;
                case "banana":
                    word.setText("바나나");
                    break;
                case "house":
                    word.setText("집");
                    break;
                case "car":
                    word.setText("차");
                    break;
            }
        }

        public void mouseReleased(MouseEvent e) {
            JLabel word = (JLabel) e.getSource();
            word.setText(originalText);
        }
    }

    public static void main(String[] args) {
        new Csb806Voca();
    }
}
