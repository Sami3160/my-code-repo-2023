import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Scanner;
import javax.swing.*;

public class Server extends JFrame {

  private static Socket clientSocket = null;
  private DataOutputStream dout = null;
  private DataInputStream din = null;
  private JTextField messageField;
  private static JTextArea messageArea;

  public static ArrayList<ClientHandler> clients;

  public Server() {
    try {
      clients = new ArrayList<>();

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
      inputPanel.add(messageField);
      add(inputPanel, BorderLayout.SOUTH);

      messageField.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            try {
              String message = messageField.getText();
              if (!message.isEmpty()) {
                if (clientSocket != null) {
                  //dout.writeUTF(message);
                  broadcast(message);

                  addMessage("Server : " + message);
                  System.out.println("Server: " + message);
                } else {
                  System.out.println("Server: Client is not connected!!!");
                  System.out.println("Server: " + message);
                }
                messageField.setText("");
              }
            } catch (Exception ex) {
              System.err.println("msg catch" + ex);
            }
          }
        }
      );
    } catch (Exception e) {
      System.out.println("big catch");
      e.printStackTrace();
    }
  }

  private static void addMessage(String message) {
    messageArea.append(message + "\n");
  }

  public static void main(String[] args) {
    try {
      InetAddress hostip = InetAddress.getByName("0.0.0.0");
      ServerSocket ss = new ServerSocket(5000, 3, hostip);
      Server server = new Server();
      server.setVisible(true);
      while (true) {
        clientSocket = ss.accept();

        addMessage("New client connected : " + clientSocket);
        System.out.println("New client connected: " + clientSocket);

        // Create a new thread for each client
        ClientHandler clientHandler = new ClientHandler(clientSocket);
        clients.add(clientHandler);
        clientHandler.start();
      }
    } catch (Exception e) {
      System.out.println("void main catch");
      e.printStackTrace();
    }
  }

  public static class ClientHandler extends Thread {

    private Socket clientSocket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private boolean running = true;

    public ClientHandler(Socket s) {
      this.clientSocket = s;
      try {
        dis = new DataInputStream(clientSocket.getInputStream());
        dos = new DataOutputStream(clientSocket.getOutputStream());
      } catch (IOException e) {
        System.out.println("client handler constructor catch");
        e.printStackTrace();
      }
    }

    @Override
    public void run() {
      try {
        while (running) {
          // Receive and process messages from the client
          String message = dis.readUTF();

          addMessage("Client : " + message);
          System.out.println("client: " + message);
        }
      } catch (IOException e) {
        System.out.println("thread in client hadler catch");
        e.printStackTrace();
      } finally {
        try {
          dis.close();
          dos.close();
          clientSocket.close();
        } catch (IOException e) {
          System.out.println("thread in client hdlner 3 catch");
          e.printStackTrace();
        }
      }
    }

    public void sendMessage(String message) throws IOException {
      dos.writeUTF(message);
      dos.flush();
    }
  }

  public static void broadcast(String message) {
    for (ClientHandler client : clients) {
      try {
        client.sendMessage(message);
      } catch (IOException e) {
        System.out.println("broadcast catch");
        e.printStackTrace();
      }
    }
  }
}
