package com.ui;

import com.til.User;
import com.tool.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameUI {

    int count=0;
    JLabel message;
    Game game;
    JTextField inputField;
    User userInGame;

    public GameUI(User user){
        init(user);
        userInGame = user;
        game = new Game();

    }

    public void init(User user){
        JFrame gameFrame = new JFrame();
        gameFrame.setTitle("猜数字");
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setSize(400,550);
        gameFrame.setLayout(new FlowLayout());
        ImageIcon icon = new ImageIcon("src/image/mark.png");
        gameFrame.setIconImage(icon.getImage());


        ImageIcon backgroundImage = new ImageIcon("src/image/mainBackground.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        gameFrame.getLayeredPane().add(backgroundLabel, new Integer(Integer.MIN_VALUE));
        backgroundLabel.setBounds(0,0,backgroundImage.getIconWidth(),backgroundImage.getIconHeight());
        ((JPanel)gameFrame.getContentPane()).setOpaque(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setSize(gameFrame.getWidth(),gameFrame.getHeight());
        gameFrame.add(mainPanel);
        mainPanel.setOpaque(false);

        ImageIcon markImage = new ImageIcon("src/image/mark.png");
        JLabel markLabel = new JLabel(markImage);
        mainPanel.add(markLabel,BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(4,1));
        centerPanel.setOpaque(false);

        JPanel inputPanel = new JPanel();
        inputPanel.setOpaque(false);
        mainPanel.add(centerPanel,BorderLayout.CENTER);

        JLabel x1 = new JLabel("  ");

        centerPanel.add(x1);

        JLabel input = new JLabel("请输入你猜的数字：");
        input.setFont(new Font("幼圆",Font.BOLD,16));

        inputField = new JTextField(8);

        inputPanel.add(input);
        inputPanel.add(inputField);
        centerPanel.add(inputPanel);

        message = new JLabel("提示：");

        centerPanel.add(message);

        JLabel x2 = new JLabel(" ");
        centerPanel.add(x2);

        JPanel buttonPanel = new JPanel(new GridLayout(1,2));
        buttonPanel.setOpaque(false);
        mainPanel.add(buttonPanel,BorderLayout.SOUTH);

        ImageIcon submitImage = new ImageIcon("src/image/submit.png");
        JLabel submitLabel = new JLabel(submitImage);
        buttonPanel.add(submitLabel);
        submitLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(submit(inputField.getText())){
                    gameFrame.setVisible(false);
                }
            }
        });

        ImageIcon abandonImage = new ImageIcon("src/image/abandon.png");
        JLabel abandonLabel = new JLabel(abandonImage);
        buttonPanel.add(abandonLabel);
        abandonLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gameFrame.setVisible(false);
            }
        });

        gameFrame.setVisible(true);

    }

    public boolean submit(String answer){
        int num = Integer.parseInt(answer);
        if(game.mark(num)){
            ResultUI resultUI = new ResultUI(userInGame,count);
            return true;
        }else{
            int a = game.getA();
            int b = game.getB();
            game.clear();
            message.removeAll();
            message.setText("提示：位置与数字都对的个数为"+a+",数字对的个数为："+b);
            count++;
            return false;
        }
    }


}
