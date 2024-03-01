import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ServerWindow extends JFrame {
    private JTextArea messageArea;
    private JTextField messageField;
    private JButton sendButton;
    // private JToggleButton connectionToggle;

    private Socket s = null;
    private DataOutputStream dout =null;
    private DataInputStream din =null;
    public ServerWindow() {
        try {
            InetAddress hostip=InetAddress.getByName("0.0.0.0");
            ServerSocket ss = new ServerSocket(5000, 0 ,hostip);
            

            // ImageIcon ico=createImage
            ImageIcon iconOn = new ImageIcon("online.png");
            // ImageIcon iconOff = new ImageIcon("o");
            ImageIcon notCon = new ImageIcon("offline.png");
            Icon searchLoad = new ImageIcon(this.getClass().getResource("loop-loading.gif"));
            ImageIcon notConnected=new ImageIcon("notConnected.png");
            Image temp=notConnected.getImage();
            notConnected.setImage(temp.getScaledInstance(50, 50, Image.SCALE_SMOOTH));


            ImageIcon closeCon=new ImageIcon("close.png");
            Image tempClose=closeCon.getImage();
            closeCon.setImage(tempClose.getScaledInstance(50, 50, Image.SCALE_SMOOTH));

            ImageIcon findImg = new ImageIcon("search.png");


            JButton find=new JButton(findImg);
            JLabel img = new JLabel(notCon);
            img.setToolTipText("Disconnected");
            setTitle("Server Chat");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(700, 400);
            setLayout(new BorderLayout());

            messageArea = new JTextArea();
            messageArea.setEditable(false);

            JScrollPane scrollPane = new JScrollPane(messageArea);
            add(scrollPane, BorderLayout.CENTER);

            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(new BorderLayout());

            messageField = new JTextField();
            messageField.setFont(new Font("Arial", Font.PLAIN, 26));

            inputPanel.add(messageField, BorderLayout.CENTER);

            sendButton = new JButton("Send");
            find.setToolTipText("Connect/Disconnect");


            new Thread(new Runnable() {
                @Override
                public void run(){
                    try {
                        while (true) {
                            Thread.sleep(500);
                            if(s!=null){
                                System.out.println("s is not null");
                                if(s.isConnected()){
                                    System.out.println("s is connected");                                    
                                    String msg=din.readUTF();
                                    addMessage("Client: "+msg);
                                    System.out.println(msg);
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                }
            }).start();
            find.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    try {
                        if(s!=null){
                            if(s.isConnected()){
                                // dout.writeUTF("exitDa");
                                dout.writeUTF("eExItThEsYsTeM");
                                s.close();
                                img.setIcon(notCon);
                                img.setToolTipText("Disconnected");
                                find.setIcon(findImg);
                                addMessage("Client Disconnected");
                                s=null;
                            }
                        }else{
                            img.setIcon(notConnected);
                            img.setToolTipText("Searching");
                            s=ss.accept();
                            dout = new DataOutputStream(s.getOutputStream());
                            din = new DataInputStream(s.getInputStream());
                            find.setIcon(closeCon);
                            img.setIcon(iconOn);
                            img.setToolTipText("Connected");
                            addMessage("Client Connected");
                        }
                        
                    } catch (Exception x) {
                        System.err.println(x);
                    }
                }
            });
            messageField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        
                        String message = messageField.getText();
                        if (!message.isEmpty()) {
                            if (s!=null) {
                                dout.writeUTF(message);
                                addMessage("Server: " + message);
                            }else{
                                addMessage("Server: Client is not connected!!!");
                                addMessage("Server: " + message);
                            }
                                messageField.setText("");
                        }
                    } catch (Exception ex) {
                        System.err.println(ex);
                    }
                }
            });
            
            sendButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        
                        String message = messageField.getText();
                        if (!message.isEmpty()) {
                            if (s!=null) {
                                dout.writeUTF(message);
                                addMessage("Server: " + message);
                            }else{
                                addMessage("Server: Client is not connected!!!");
                                addMessage("Server: " + message);
                            }
                                messageField.setText("");
                        }
                    } catch (Exception ex) {
                        System.err.println(ex);
                    }
                }
            });
            


            inputPanel.add(sendButton, BorderLayout.EAST);
            inputPanel.add(find, BorderLayout.WEST);


            add(inputPanel, BorderLayout.SOUTH);
            add(img, BorderLayout.NORTH);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void addMessage(String message) {
        messageArea.append(message + "\n");
    }

    public static void main(String[] args) {
        // SwingUtilities.invokeLater(new Runnable() {
            // @Override
            // public void run() {
                ServerWindow serverWindow = new ServerWindow();
                serverWindow.setVisible(true);
            // }
        // });
    }
}
