import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.*;

public class Client extends JFrame {

  private Socket s = null;
  private DataOutputStream dout = null;
  private DataInputStream dis = null;
  private JTextField inputArea;
  private JPanel inputPanel;
  private static JTextArea messageShowArea;

  public Client() {
    inputArea = new JTextField();
    inputArea.setPreferredSize(new Dimension(270, 50));
    inputArea.setFont(new Font("Areal", Font.PLAIN, 26));

    messageShowArea = new JTextArea();
    messageShowArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(messageShowArea);

    setTitle("Client Chat");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(700, 400);
    setLayout(new BorderLayout());

    inputPanel = new JPanel();
    inputPanel.setLayout(new BorderLayout());

    inputPanel.add(inputArea, BorderLayout.CENTER);

    add(scrollPane, BorderLayout.CENTER);
    add(inputPanel, BorderLayout.SOUTH);

    //connectiond thread
    try {
      new Thread(
        new Runnable() {
          @Override
          public void run() {
            try {
              InetAddress hostip = InetAddress.getByName("0.0.0.0");
              s = new Socket(hostip, 5000);
              dout = new DataOutputStream(s.getOutputStream());
              dis = new DataInputStream(s.getInputStream());
            } catch (Exception e) {
              System.out.println(e);
            }
          }
        }
      )
        .start();
    } catch (Exception e) {
      System.out.println(e);
    }

    //communication thread
    new Thread(
      new Runnable() {
        @Override
        public void run() {
          try {
            while (true) {
              Thread.sleep(500);
              if (s != null) {
                if (s.isConnected()) {
                  String newmsg = dis.readUTF();

                  addMessage("Server: " + newmsg);
                  System.out.println("Server : " + newmsg);
                } else {
                  System.out.println("inner else block");
                }
              } else {
                System.out.println("server offline");
              }
            }
          } catch (Exception e) {
            System.out.println(e);
          }
        }
      }
    )
      .start();

    inputArea.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          try {
            if (s.isConnected()) {
              String msg = inputArea.getText();
              dout.writeUTF(msg);

              addMessage("Client: " + msg);
              System.out.println("Client: " + msg);
              inputArea.setText("");
            } else {
              System.out.println("Client: Not connected to server yet");
            }
          } catch (Exception ex) {
            System.out.println(e);
          }
        }
      }
    );
  }

  public static void addMessage(String msg) {
    messageShowArea.append(msg + "\n");
  }

  public static void main(String[] args) {
    Client client = new Client();
    client.setVisible(true);
  }
}
