package comcrypto.service;

import java.util.HashMap;
import java.util.Map;

public class BruteForceHelper {

    private Map<String, Integer> bruteForceSymbols() { // Map to store the value about symbols and their keys
        Map<String, Integer> map = new HashMap<>();
        map.put("!", 2); //if it's "!" the brute force will use the key 2
        map.put("&", 3); //if it's "&" the brute force will use the key 3
        map.put("*", 4); //if it's "*" the brute force will use the key 4
        return map;
    }

    public int findEncryptionKey(String encryptedText) { //fucntion that returns the key according to the found symbol in file
        Map<String, Integer> symbolToKeyMap = bruteForceSymbols();
        for (String symbol : symbolToKeyMap.keySet()) { // going through the symbols to find the appropriate one from the file
            if (encryptedText.contains(symbol)) {
                return symbolToKeyMap.get(symbol); // return the key
            }
        }
        return -1;
    }
}
