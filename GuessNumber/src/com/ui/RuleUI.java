package com.ui;

import javax.swing.*;
import java.awt.*;

public class RuleUI {

    public RuleUI(){
        init();
    }

    public void init(){
        JFrame ruleFrame = new JFrame();
        ruleFrame.setTitle("猜数字");
        ruleFrame.setLocationRelativeTo(null);
        ruleFrame.setSize(400,550);
        ruleFrame.setLayout(new FlowLayout());
        ImageIcon icon = new ImageIcon("src/image/mark.png");
        ruleFrame.setIconImage(icon.getImage());


        ImageIcon backgroundImage = new ImageIcon("src/image/mainBackground.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        ruleFrame.getLayeredPane().add(backgroundLabel, new Integer(Integer.MIN_VALUE));
        backgroundLabel.setBounds(0,0,backgroundImage.getIconWidth(),backgroundImage.getIconHeight());
        ((JPanel)ruleFrame.getContentPane()).setOpaque(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setSize(ruleFrame.getWidth(),ruleFrame.getHeight());
        ruleFrame.add(mainPanel);
        mainPanel.setOpaque(false);

        ImageIcon markImage = new ImageIcon("src/image/mark.png");
        JLabel markLabel = new JLabel(markImage);
        mainPanel.add(markLabel,BorderLayout.NORTH);

        JPanel center = new JPanel();
        center.setOpaque(false);
        mainPanel.add(center,BorderLayout.CENTER);

        String str = "<html>开始游戏后，产生一个没有重复数字的4<br/>" +
                "位随机数，用户每猜一个数字，显示出“完<br/>" +
                "全猜中的数字个数”和“猜中数字但位置错<br/>" +
                "误的数字个数”，用户根据游戏提示的信息继<br/>" +
                "续猜，直到猜中为止。一次猜对得100分，多<br/>" +
                "一次扣十分，多于五次得50分</html>";
        JLabel rule = new JLabel(str);
        rule.setFont(new Font("幼圆",Font.BOLD,16));
        rule.setSize(300,300);

        center.add(rule);


        ruleFrame.setVisible(true);


    }
}
