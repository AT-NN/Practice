package robohash;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class robohash {
    static SecureRandom sr = new SecureRandom();
    public static void main(String[] args) {
        Map<Integer,String> collection = new HashMap<>();
        Client client = Client.create();
        System.out.println("Saving data and request... ");
        for (int i=0;i<10000;i++) {
            System.out.print(i+1 + " ");
            String url = "https://robohash.org/" + generateRandomString(1 + sr.nextInt(20));
            WebResource webResource = client.resource(url);
            ClientResponse response = webResource.get(ClientResponse.class);
            if (response.getStatus() != 200)
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            String responseString = response.getEntity(String.class);
            Integer hashcode = getHashcode(responseString);
            if (!collection.containsKey(hashcode)) collection.put(hashcode,url);
            else {
                if (!collection.get(hashcode).equals(url)) {
                    System.out.println();
                    System.out.println(i + " " + hashcode + "\n" + url);
                    System.out.println(collection.get(hashcode));
                    System.out.println("-----------------------------");
                    break;
                }
            }
        }
        System.out.println();

        for(Map.Entry<Integer,String> entry : collection.entrySet()){
            System.out.printf("'%15d'\t%s%n",entry.getKey(),entry.getValue());
        }

        System.out.println("Total elements: " + collection.size());
    }

    static String generateRandomString(int length){
    String string="";
        for (int i=0;i<length;i++){
            string = string + getRandomCharacter();
        }
        return string;
    }

    static char getRandomCharacter(){
        int index;
        while (true){
            index = sr.nextInt(127);
            if (Character.isLetterOrDigit(index)) break;
        }
        return (char) index;
    }

    static int getHashcode(String string){
        int hash = 7;
        for (int i = 0; i < string.length(); i++) {
            hash = hash*31 + string.charAt(i);
        }
        return hash;
    }
}
/********************************************************
 Same hashcode:
 https://robohash.org/58PCLO1h
 https://robohash.org/XMAurYoCWOmwquYV

 https://robohash.org/bd95uKF6
 https://robohash.org/9WAcJb2X

 https://robohash.org/LXXmVq
 https://robohash.org/anUS2vJJ7Mh

 https://robohash.org/ufKG
 https://robohash.org/luCqfU9XqNySr7Drc
********************************************************/
