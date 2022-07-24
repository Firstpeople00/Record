package com.company;

import com.ui.Login;
import com.ui.OrderUI;
import com.ui.RuleUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {

    int a = 0;
    int b = 0;

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.mainUI();
    }

    public void mainUI(){
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("猜数字");
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setSize(400,550);
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("src/image/mark.png");
        mainFrame.setIconImage(icon.getImage());


        ImageIcon backgroundImage = new ImageIcon("src/image/mainBackground.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        mainFrame.getLayeredPane().add(backgroundLabel, new Integer(Integer.MIN_VALUE));
        backgroundLabel.setBounds(0,0,backgroundImage.getIconWidth(),backgroundImage.getIconHeight());
        ((JPanel)mainFrame.getContentPane()).setOpaque(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setSize(mainFrame.getWidth(),mainFrame.getHeight());
        mainFrame.add(mainPanel);
        mainPanel.setOpaque(false);

        ImageIcon markImage = new ImageIcon("src/image/mark.png");
        JLabel markLabel = new JLabel(markImage);
        mainPanel.add(markLabel,BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4,1));
        mainPanel.add(buttonPanel,BorderLayout.CENTER);
        buttonPanel.setOpaque(false);

        ImageIcon startGame = new ImageIcon("src/image/buttonStart.png");
        JLabel startGameLabel = new JLabel(startGame);
        buttonPanel.add(startGameLabel);
        startGameLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Login login = new Login();
//                login.init();
            }
        });

        ImageIcon orderImage = new ImageIcon("src/image/buttonOrder.png");
        JLabel orderLabel = new JLabel(orderImage);
        buttonPanel.add(orderLabel);
        orderLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OrderUI orderUI = new OrderUI();
            }
        });

        ImageIcon ruleImage = new ImageIcon("src/image/buttonRule.png");
        JLabel ruleLabel = new JLabel(ruleImage);
        buttonPanel.add(ruleLabel);
        ruleLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RuleUI ruleUI = new RuleUI();
            }
        });

        ImageIcon exitGame = new ImageIcon("src/image/buttonExit.png");
        JLabel exitGameLabel = new JLabel(exitGame);
        buttonPanel.add(exitGameLabel);
        exitGameLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(JOptionPane.showConfirmDialog(mainFrame,"您确定要退出吗？","提示",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                }
            }
        });

        mainFrame.setVisible(true);
    }
}
