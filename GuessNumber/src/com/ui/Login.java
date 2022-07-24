package com.ui;

import com.JDBC.Dao;
import com.til.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

    public Login(){
        init();
    }

    public void init(){
        JFrame loginFrame = new JFrame();
        loginFrame.setTitle("猜数字");
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setSize(400,550);
        loginFrame.setLayout(new FlowLayout());
        ImageIcon icon = new ImageIcon("src/image/mark.png");
        loginFrame.setIconImage(icon.getImage());

        ImageIcon backgroundImage = new ImageIcon("src/image/mainBackground.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        loginFrame.getLayeredPane().add(backgroundLabel, new Integer(Integer.MIN_VALUE));
        backgroundLabel.setBounds(0,0,backgroundImage.getIconWidth(),backgroundImage.getIconHeight());
        ((JPanel)loginFrame.getContentPane()).setOpaque(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setSize(loginFrame.getWidth(),loginFrame.getHeight());
        loginFrame.add(mainPanel);
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
        JLabel userID = new JLabel("账号:");
        userID.setFont(new Font("幼圆",Font.BOLD,16));

        JTextField userIDField = new JTextField(15);
        idPanel.add(userID);
        idPanel.add(userIDField);
        tablePane.add(idPanel);

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


        ImageIcon loginImage = new ImageIcon("src/image/login.png");
        JLabel loginLabel = new JLabel(loginImage);
        buttonPanel.add(loginLabel);
        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(login(userIDField.getText(),passwordField.getText())){
                    loginFrame.setVisible(false);
                }
            }
        });

        ImageIcon deleteImage = new ImageIcon("src/image/delete.png");
        JLabel deleteLabel = new JLabel(deleteImage);
        buttonPanel.add(deleteLabel);
        deleteLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginFrame.setVisible(false);
            }
        });

        JPanel registerPanel = new JPanel();
        registerPanel.setOpaque(false);
        JLabel register = new JLabel("没有账号？注册一个");
        registerPanel.add(register);
        southPanel.add(registerPanel,BorderLayout.SOUTH);
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Register register1 = new Register();
                loginFrame.setVisible(false);
            }
        });
        loginFrame.setVisible(true);
    }

    public boolean login(String id,String password){
        boolean b = false;
        Dao dao = new Dao();
        if(dao.logIn(id,password)){
            User user = new User();
            user.setUser_id(id);
            GameUI gameUI = new GameUI(user);
            b = true;
        }else {
            int t = JOptionPane.showConfirmDialog(null, "用户名或密码错误", "确认", JOptionPane.OK_CANCEL_OPTION);
//            if (t == JOptionPane.OK_OPTION)
//            {
//                userField.setText("");
//                passwordField.setText("");
//            }
        }
        return b;
    }
}
