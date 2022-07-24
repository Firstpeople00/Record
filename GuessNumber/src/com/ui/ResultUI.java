package com.ui;

import com.JDBC.Dao;
import com.til.User;
import com.tool.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.attribute.AclEntry;

public class ResultUI {

    int count = 0;
    User user;

    public ResultUI(User user,int count){
        this.count = count;
        this.user = user;
        System.out.println(user.getUser_id());
        init();
    }

    public void init(){
        JFrame resultFrame = new JFrame();
        resultFrame.setTitle("猜数字");
        resultFrame.setLocationRelativeTo(null);
        resultFrame.setSize(400,550);
        resultFrame.setLayout(new FlowLayout());
        ImageIcon icon = new ImageIcon("src/image/mark.png");
        resultFrame.setIconImage(icon.getImage());


        ImageIcon backgroundImage = new ImageIcon("src/image/mainBackground.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        resultFrame.getLayeredPane().add(backgroundLabel, new Integer(Integer.MIN_VALUE));
        backgroundLabel.setBounds(0,0,backgroundImage.getIconWidth(),backgroundImage.getIconHeight());
        ((JPanel)resultFrame.getContentPane()).setOpaque(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setSize(resultFrame.getWidth(),resultFrame.getHeight());
        resultFrame.add(mainPanel);
        mainPanel.setOpaque(false);

        ImageIcon markImage = new ImageIcon("src/image/mark.png");
        JLabel markLabel = new JLabel(markImage);
        mainPanel.add(markLabel,BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(3,1));
        centerPanel.setOpaque(false);

        mainPanel.add(centerPanel,BorderLayout.CENTER);

        JLabel x1 = new JLabel(" ");
        centerPanel.add(x1);

        int  score = 0;
        if(count>=5){
            score = 50;
        }else {
            score = (10-count)*10;
        }

        JLabel scoreLabel = new JLabel("你的得分为："+score);
        scoreLabel.setFont(new Font("幼圆",Font.BOLD,16));

        centerPanel.add(scoreLabel);
        JLabel x2 = new JLabel(" ");

        centerPanel.add(x2);

        JPanel buttonPanel = new JPanel(new GridLayout(2,1));
        buttonPanel.setOpaque(false);
        mainPanel.add(buttonPanel,BorderLayout.SOUTH);

        ImageIcon anotherImage = new ImageIcon("src/image/another.png");
        JLabel anotherLabel = new JLabel(anotherImage);
        buttonPanel.add(anotherLabel);
        anotherLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GameUI gameUI = new GameUI(user);
            }
        });

        ImageIcon endImage = new ImageIcon("src/image/end.png");
        JLabel endLabel = new JLabel(endImage);
        buttonPanel.add(endLabel);

        update(score);

        resultFrame.setVisible(true);

    }

    public void update(int score){
        Dao dao = new Dao();
        dao.update(user.getUser_id(),score);
    }
}
