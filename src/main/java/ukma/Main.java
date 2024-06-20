package ukma;

import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String str = "Hello world";
        try {
            FileWriter writer = new FileWriter("1.txt");
            String hashedString = getHashedString(str, "MD5");
            System.out.println(hashedString);
            writer.write(hashedString + "\n");

            hashedString = getHashedString(str, "SHA-256");
            System.out.println(hashedString);
            writer.write(hashedString + "\n");

            hashedString = getHashedString(str, "SHA-1");
            System.out.println(hashedString);
            writer.write(hashedString + "\n");
            System.out.println();
            writer.close();


            writer = new FileWriter("2.txt");
            long hashedStr = getHashedStringSecureRandom(str, "DRBG");
            System.out.println(hashedString);
            writer.write(hashedString + "\n");

            hashedStr = getHashedStringSecureRandom(str, "SHA1PRNG");
            System.out.println(hashedString);
            writer.write(hashedString + "\n");

            hashedStr = getHashedStringSecureRandom(str, "SHA1PRNG");
            System.out.println(hashedString);
            writer.write(hashedString + "\n");
            System.out.println();
            writer.close();


            writer = new FileWriter("3.txt");
            User user1 = new User("one");
            User user2 = new User("two");
            User user3 = new User("three");
            HashMap<User, Integer> users = new HashMap<>();
            users.put(user1, 1);
            users.put(user2, 2);
            users.put(user3, 3);
            for (Map.Entry<User, Integer> entry : users.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
                String hash = entry.getKey().hashCode() + "";
                writer.append(hash + "\n");
            }
            System.out.println(users.get(new User("one")));

            BrokenUser bUser1 = new BrokenUser("one");
            BrokenUser bUser2 = new BrokenUser("two");
            BrokenUser bUser3 = new BrokenUser("three");
            HashMap<BrokenUser, Integer> bUsers = new HashMap<>();
            bUsers.put(bUser1, 1);
            bUsers.put(bUser2, 2);
            bUsers.put(bUser3, 3);
            for (Map.Entry<BrokenUser, Integer> entry : bUsers.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
                String hash = entry.getKey().hashCode() + "";
                writer.append(hash + "\n");
            }
            System.out.println(bUsers.get(new BrokenUser("one")));
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static long getHashedStringSecureRandom(String str, String algorithm) throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance(algorithm);
        sr.setSeed(1234);
        sr.nextBytes(str.getBytes());
        long number = sr.nextLong();
        return number;
    }

    private static String getHashedString(String str, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        byte[] hashBytes = messageDigest.digest(str.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hashBytes);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}