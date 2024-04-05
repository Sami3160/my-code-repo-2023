import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class calc implements ActionListener {
    JFrame jf;
    JLabel no1, no2, res;
    JTextField t1, t2, t3;
    JButton add, sub, mul, div, mod, clr;

    public calc() {
        jf = new JFrame("Practical 8.1");
        jf.setSize(230, 270);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLayout(new FlowLayout());
        JLabel no1 = new JLabel("Number 1");
        JLabel no2 = new JLabel("Number 2");
        JLabel res = new JLabel("Result");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t3.setEditable(false);
        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        mod = new JButton("%");
        clr = new JButton("Clear");
        jf.add(no1);    jf.add(t1);
        jf.add(no2);    jf.add(t2);
        jf.add(res);    jf.add(t3);
        jf.add(sub);    jf.add(add);
        jf.add(mul);    jf.add(div);
        jf.add(mod);    jf.add(clr);
        sub.setPreferredSize(new Dimension(100, 30));   sub.addActionListener(this);
        add.setPreferredSize(new Dimension(100, 30));   add.addActionListener(this);
        mul.setPreferredSize(new Dimension(100, 30));   mul.addActionListener(this);
        div.setPreferredSize(new Dimension(100, 30));   div.addActionListener(this);
        mod.setPreferredSize(new Dimension(100, 30));   mod.addActionListener(this);
        clr.setPreferredSize(new Dimension(100, 30));   clr.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        int no1 = Integer.parseInt(t1.getText());
        int no2 = Integer.parseInt(t2.getText());
        if (e.getSource() == add) {
            t3.setText(String.valueOf(no1 + no2));
        } else if (e.getSource() == sub) {
            t3.setText(String.valueOf(no1 - no2));
        } else if (e.getSource() == div) {
            t3.setText(String.valueOf(no1 / no2));
        } else if (e.getSource() == mul) {
            t3.setText(String.valueOf(no1 * no2));
        } else if (e.getSource() == mod) {
            t3.setText(String.valueOf(no1 % no2));
        } else if (e.getSource() == clr) {
            t3.setText("");
        }
    }
    public static void main(String[] args) {
        new calc();
    }

}
