package com.ui;

import com.JDBC.Dao;
import com.til.User;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class OrderUI {

    public OrderUI(){
        init();
    }

    public void init(){
        JFrame orderFrame = new JFrame();
        orderFrame.setTitle("猜数字");
        orderFrame.setLocationRelativeTo(null);
        orderFrame.setSize(400,550);
        orderFrame.setLayout(new FlowLayout());
        ImageIcon icon = new ImageIcon("src/image/mark.png");
        orderFrame.setIconImage(icon.getImage());

        ImageIcon backgroundImage = new ImageIcon("src/image/mainBackground.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        orderFrame.getLayeredPane().add(backgroundLabel, new Integer(Integer.MIN_VALUE));
        backgroundLabel.setBounds(0,0,backgroundImage.getIconWidth(),backgroundImage.getIconHeight());
        ((JPanel)orderFrame.getContentPane()).setOpaque(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setSize(orderFrame.getWidth(),orderFrame.getHeight());
        orderFrame.add(mainPanel);
        mainPanel.setOpaque(false);

        ImageIcon markImage = new ImageIcon("src/image/mark.png");
        JLabel markLabel = new JLabel(markImage);
        mainPanel.add(markLabel,BorderLayout.NORTH);

        LinkedList<User> linkedList = getList();

        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        mainPanel.add(centerPanel,BorderLayout.CENTER);

        int size = linkedList.size();
        String columnNames[]= {"账号","姓名","成绩"};


        String tableValues[][] = new String[size][3];

        for(int i=0;i<size;i++){
            tableValues[i][0] = linkedList.get(i).getUser_id();
            tableValues[i][1] = linkedList.get(i).getName();
            tableValues[i][2] = String.valueOf(linkedList.get(i).getScore());
        }

        JTable table = new JTable(tableValues,columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        centerPanel.add(scrollPane);
        table.setOpaque(false);
        scrollPane.setOpaque(false);

        orderFrame.setVisible(true);
    }

    public LinkedList<User> getList(){
        Dao dao = new Dao();
        LinkedList<User> linkedList = dao.getOrder();
        return linkedList;
    }
}
