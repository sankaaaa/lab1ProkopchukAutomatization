import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class SecondTask {
    private static byte[] generateRandomValue() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstanceStrong();
        byte[] randValues = new byte[32];
        sr.nextBytes(randValues);
        return randValues;
    }

    private static String hashValue(byte[] value, String alg) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(alg);
        byte[] bytes = md.digest(value);
        return Base64.getEncoder().encodeToString(bytes);
    }

    private static void saveHashesToFile(String MD5, String SHA_1, String SHA_256) {
        try (FileWriter writer = new FileWriter("task2_hashes.txt")) {
            writer.write("1) MD5: " + MD5 + "\n");
            writer.write("2) SHA-1: " + SHA_1 + "\n");
            writer.write("3) SHA-256: " + SHA_256 + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        byte[] rV1 = generateRandomValue();
        byte[] rV2 = generateRandomValue();
        byte[] rV3 = generateRandomValue();

        String MD5 = hashValue(rV1, "MD5");
        String SHA_1 = hashValue(rV2, "SHA-1");
        String SHA_256 = hashValue(rV3, "SHA-256");

        saveHashesToFile(MD5, SHA_1, SHA_256);

        System.out.println("1) MD5: " + MD5);
        System.out.println("2) SHA-1: " + SHA_1);
        System.out.println("3) SHA-256: " + SHA_256);
    }
}
