import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSockets {

    private ServerSocket serverSocket;
    private static final int port = 3335;
    private Socket socketEnd1;
    private InputStream inputStream=null;
    private OutputStream outputStream=null;
    private Dao dao;
    private PrintWriter printWriter;

    public ServerSockets() {
        dao =new Dao();
        System.out.println("Server......");
        try {
            serverSocket=new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server Connected");
    }

    public void acceptConnection(){
        System.out.println("En attente de Connection");
        try {
            socketEnd1=serverSocket.accept();
            this.inputStream=socketEnd1.getInputStream();
            this.outputStream=socketEnd1.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Connection Accepted");
    }

    public void sendInfosClient(){
        try {

            //inputStream pour envoye un entier
            //int i =inputStream.read();
            //System.out.println(i);
            //String massege ="Bonjour "+dao.clientMap.get(1).getFname();

            //PrintWriter pour envoyer une chaine de caractere
            //printWriter=new PrintWriter(outputStream);
            //printWriter.write(massege);
            //printWriter.flush();
            //printWriter.close();
            //System.out.println("Le String est envoyee avec succes ");

            //ObjectInputStream ObjectOutStream pour envoyer un Objet il faut le serializer
            ObjectOutputStream objectOutputStream =new ObjectOutputStream(outputStream);
            Client client = new Client("youness","iboudaaten",34);
            objectOutputStream.writeObject(client);
            objectOutputStream.flush();
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
