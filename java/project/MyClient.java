import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.border.Border;

public class MyClient extends JFrame {
    private JTextArea messageShowArea;
    private JTextField inputArea;
    private JButton send;
    private JLabel status;
    private JPanel inputPanel;
    private Socket s=null;
    private DataOutputStream dout=null;
    private DataInputStream dis=null;

    public MyClient() {

        Border border=BorderFactory.createLineBorder(new Color(0, 150, 255));
        ImageIcon iconOn = new ImageIcon("online.png");
        ImageIcon notCon = new ImageIcon("offline.png");
        Icon searchLoad = new ImageIcon(this.getClass().getResource("loop-loading.gif"));
        ImageIcon notConnected = new ImageIcon("notConnected.png");
        Image temp = notConnected.getImage();
        notConnected.setImage(temp.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        ImageIcon closeCon = new ImageIcon("close.png");
        Image tempClose = closeCon.getImage();
        closeCon.setImage(tempClose.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        ImageIcon findImg = new ImageIcon("search.png");
        JButton find = new JButton(findImg);

        status = new JLabel(notCon);
        setTitle("Client Chat");
        try {
            setTitle("Client Chat");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(700, 400);
            setLayout(new BorderLayout());
            inputPanel = new JPanel();
            inputPanel.setLayout(new BorderLayout());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InetAddress hostip = InetAddress.getByName("0.0.0.0");
                         s = new Socket(hostip, 5000);
                         dout = new DataOutputStream(s.getOutputStream());
                         dis = new DataInputStream(s.getInputStream());
        
                        // Rest of your networking code...
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }).start();

            messageShowArea = new JTextArea();
            messageShowArea.setEditable(false);
            messageShowArea.setBackground(new Color(115, 147, 179));
            messageShowArea.setForeground(Color.WHITE);
            messageShowArea.setBorder(border);
            send = new JButton("Send");
            JScrollPane scrollPane = new JScrollPane(messageShowArea);

            inputArea = new JTextField();
            inputArea.setBorder(border);
            inputArea.setBackground(new Color(137, 207, 240));

            inputArea.setPreferredSize(new Dimension(270, 50));
            inputArea.setFont(new Font("Areal", Font.PLAIN, 26));
            inputArea.setForeground(Color.WHITE);

            inputPanel.add(inputArea, BorderLayout.CENTER);
            inputPanel.setBorder(border);
            inputPanel.add(send, BorderLayout.EAST);
            add(status, BorderLayout.NORTH);
            add(scrollPane, BorderLayout.CENTER);
            add(inputPanel, BorderLayout.SOUTH);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        while (true) {
                            Thread.sleep(500);
                            if (s != null) {
                                if (s.isConnected()) {
                                    status.setIcon(iconOn);
                                    status.setBackground(new Color(115, 147, 179));
                                    String newmsg = dis.readUTF();
                                    if (newmsg.equals("eExItThEsYsTeM")) {
                                        s.close();
                                        dout.close();
                                        dis.close();
                                        s=null;
                                        addMessage("Server disconneced...");
                                        status.setIcon(notCon);
                                        status.setToolTipText("Disconnected");
                                        break;
                                    }
                                    addMessage("Server: " + newmsg);
                                } else {
                                    status.setIcon(notCon);
                                    addMessage("Server is offline");
                                }
                            }

                            // if (newmsg.equals("nowu")) {
                            // java.util.Scanner sc = new java.util.Scanner(System.in);
                            // System.out.println("Enter your message: ");
                            // String msg = sc.nextLine();
                            // dout.writeUTF(msg);
                            // } else {
                            // System.out.println(newmsg);
                            // }
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }).start();

            inputArea.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (s.isConnected()) {
                            String msg = inputArea.getText();
                            dout.writeUTF(msg);
                            addMessage("Client: " + msg);
                            inputArea.setText("");
                        } else {
                            addMessage("Client: Not connected to server yet");
                        }
                    } catch (Exception ex) {
                        System.out.println(e);
                    }
                }
            });
            send.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String msg = inputArea.getText();
                        if (s!=null && msg.length() > 0 && s.isConnected()) {
                            dout.writeUTF(msg);
                            addMessage("Client: " + msg);
                            inputArea.setText("");
                        } else {
                            addMessage("Client: Not connected to server yet");
                            addMessage("Client: " + msg);
                        }
                    } catch (Exception ex) {
                        System.out.println(e);
                    }
                }
            });

        } catch (Exception e) {
            System.out.println(e);
        }         
    }

    public void addMessage(String msg) {
        messageShowArea.append(msg + "\n");
    }

    public static void main(String[] args) {
        MyClient client = new MyClient();
        client.setVisible(true);
    }
}