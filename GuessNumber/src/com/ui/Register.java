package com.ui;

import com.JDBC.Dao;
import com.til.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register {

    public Register(){
        init();
    }

    public void init(){
        JFrame registerFrame = new JFrame();
        registerFrame.setTitle("猜数字");
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setSize(400,550);
        registerFrame.setLayout(new FlowLayout());
        ImageIcon icon = new ImageIcon("src/image/mark.png");
        registerFrame.setIconImage(icon.getImage());

        ImageIcon backgroundImage = new ImageIcon("src/image/mainBackground.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        registerFrame.getLayeredPane().add(backgroundLabel, new Integer(Integer.MIN_VALUE));
        backgroundLabel.setBounds(0,0,backgroundImage.getIconWidth(),backgroundImage.getIconHeight());
        ((JPanel)registerFrame.getContentPane()).setOpaque(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setSize(registerFrame.getWidth(),registerFrame.getHeight());
        registerFrame.add(mainPanel);
        mainPanel.setOpaque(false);

        ImageIcon markImage = new ImageIcon("src/image/mark.png");
        JLabel markLabel = new JLabel(markImage);
        mainPanel.add(markLabel,BorderLayout.NORTH);

        JPanel southPanel = new JPanel(new BorderLayout());
        mainPanel.add(southPanel,BorderLayout.CENTER);
        southPanel.setOpaque(false);

        JPanel tablePane = new JPanel(new GridLayout(3,1));
        tablePane.setOpaque(false);
        southPanel.add(tablePane,BorderLayout.NORTH);

        JPanel idPanel = new JPanel();
        idPanel.setOpaque(false);
        JLabel userID = new JLabel("账 号:");
        userID.setFont(new Font("幼圆",Font.BOLD,16));

        JTextField userIDField = new JTextField(15);
        idPanel.add(userID);
        idPanel.add(userIDField);
        tablePane.add(idPanel);


        JPanel namePanel = new JPanel();
        namePanel.setOpaque(false);

        JLabel name = new JLabel("用户名:");
        userID.setFont(new Font("幼圆",Font.BOLD,16));
        namePanel.add(name);

        JTextField nameField = new JTextField(15);
        namePanel.add(nameField);
        tablePane.add(namePanel);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setOpaque(false);

        JLabel password = new JLabel("密码:");
        password.setFont(new Font("幼圆",Font.BOLD,16));
        passwordPanel.add(password);

        JPasswordField passwordField = new JPasswordField(15);
        passwordPanel.add(passwordField);
        tablePane.add(passwordPanel);

        JPanel buttonPanel = new JPanel(new GridLayout(1,2));
        buttonPanel.setOpaque(false);
        southPanel.add(buttonPanel,BorderLayout.CENTER);

        ImageIcon registerImage = new ImageIcon("src/image/register.png");
        JLabel registerLabel = new JLabel(registerImage);
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(register(userIDField.getText(),nameField.getText(),passwordField.getText())){
                    registerFrame.setVisible(false);
                }
            }
        });
        buttonPanel.add(registerLabel);

        ImageIcon deleteImage = new ImageIcon("src/image/delete.png");
        JLabel deleteLabel = new JLabel(deleteImage);
        buttonPanel.add(deleteLabel);
        deleteLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registerFrame.setVisible(false);
            }
        });

        JPanel loginPanel = new JPanel();
        loginPanel.setOpaque(false);
        JLabel login = new JLabel("已有账号？现在登录");
        loginPanel.add(login);
        southPanel.add(loginPanel,BorderLayout.SOUTH);
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Login login1 = new Login();
                registerFrame.setVisible(false);
            }
        });

        registerFrame.setVisible(true);
    }

    public boolean register(String id,String name,String password){
        Dao dao = new Dao();
        boolean b = false;
        if(dao.register(name,password,id)){
            User user = new User();
            user.setUser_id(id);
            user.setName(name);
            GameUI gameUI = new GameUI(user);
            b = true;
        }else{
            int t = JOptionPane.showConfirmDialog(null, "注册失败", "确认", JOptionPane.OK_CANCEL_OPTION);
        }
        return b;
    }
}
