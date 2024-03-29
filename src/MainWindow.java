import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MainWindow extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainWindow window = new MainWindow();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }


    public MainWindow() throws HeadlessException {
        this("CatchMe");
    }

    public MainWindow(String title) throws HeadlessException {
        super(title);

        this.setFocusable(true);
        this.requestFocusInWindow();

        Random r = new Random();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 768);

        JPanel background = new JPanel();

        background.setBorder(new EmptyBorder(1, 1, 1, 1));
        setContentPane(background);
        background.setLayout(null);

        JLabel success = new JLabel("Gratulacje!");
        success.setVisible(false);
        background.add(success);

        JLabel figureType = new JLabel("Co chcesz narysować?");
        figureType.setBounds(300, 100, 300, 90);
        background.add(figureType);

        JButton catchMeBtn = new JButton("Catch Me!");
        catchMeBtn.setBounds(100, 100, 90, 23);

        catchMeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                success.setBounds(20, 150, 90, 23);
                success.setVisible(true);
            }
        });
        catchMeBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getX() < 80) {

                    final int randX = r.nextInt(1200 - 23);
                    final int randY = r.nextInt(768 - 90);

                    catchMeBtn.setLocation(randX, randY);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        background.add(catchMeBtn);

        JButton clearBtn = new JButton("Wyczyść");
        clearBtn.setBounds(100, 200, 90, 23);
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                catchMeBtn.setBounds(100, 100, 90, 23);
                success.setVisible(false);
            }
        });
        background.add(clearBtn);

        Kanwa kanwa = new Kanwa();
        kanwa.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                kanwa.mouseX = e.getX();
                kanwa.mouseY = e.getY();
                System.out.println(kanwa.mouseX + "," + kanwa.mouseY);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        background.add(kanwa);
        this.getContentPane().add(kanwa);

        kanwa.setFocusable(true);
        kanwa.requestFocusInWindow();

        JButton figBtn = new JButton("Rysuj kwadrat");
        figBtn.setBounds(350, 100, 130, 23);
        figBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (kanwa.drawSquare()) {
                    figBtn.setText("Rysuj koło");
                    kanwa.setDrawSquare(false);
                } else {
                    figBtn.setText("Rysuj kwadrat");
                    kanwa.setDrawSquare(true);
                }
            }
        });
        background.add(figBtn);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (kanwa.drawSquare()) {
                    kanwa.addSprajt(new Kwadrat(kanwa.mouseX-50, kanwa.mouseY-50));
                } else {
                    kanwa.addSprajt(new Kolo(kanwa.mouseX-50, kanwa.mouseY-50));
                }
                System.out.println("KeyTyped");
                kanwa.repaint();
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}
