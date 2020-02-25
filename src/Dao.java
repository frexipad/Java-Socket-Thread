import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Dao {

    Map<Integer,Client> clientMap;

    public Dao() {
        Client c1 = new Client("ynss","ibou",34);
        Client c2 = new Client("sah","ibou",30);
        Client c3 = new Client("yousra","ibou",10);
        Client c4 = new Client("souraya","ibou",6);
        clientMap = new HashMap<>();
        clientMap.put(1,c1);
        clientMap.put(2,c2);
        clientMap.put(3,c3);
        clientMap.put(4,c4);
    }

    public Dao(Map<Integer, Client> clientMap) {
        this.clientMap = clientMap;
    }
}
