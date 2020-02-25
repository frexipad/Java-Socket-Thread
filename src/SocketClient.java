import java.io.*;
import java.net.Socket;

public class SocketClient {

    private Socket socketEnd2;
    private static final int port=3335;
    private String host = "127.0.0.1";
    private InputStream inputStream=null;
    private OutputStream  outputStream=null;
    BufferedReader bufferedReader;


    public SocketClient() {
        System.out.println("En cours d'etablir la connectio ......");

            try {
                socketEnd2=new Socket(host,port);
                inputStream=socketEnd2.getInputStream();
                outputStream=socketEnd2.getOutputStream();
            } catch (IOException e) {
                System.out.println("Connection refused");
            }

        System.out.println("Client Connected");
    }

    public void getInfosCompte(){
        int i = 12;
        try {
            //outputStream.write(i);
            //System.out.println("the number "+i+" is sending");
            //bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            //String message=bufferedReader.readLine();
            //System.out.println(message);

            ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
            try {
                Client client = (Client) objectInputStream.readObject();
                System.out.println(client.toString());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
