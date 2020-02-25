public class MainServer {

    public static void main(String[] args) {

        ServerSockets serverSocket = new ServerSockets();
        serverSocket.acceptConnection();
        serverSocket.sendInfosClient();
    }
}
