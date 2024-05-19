import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.FileWriter;
import java.io.IOException;

public class FirstTask {
    private static String setHashValue(String text, String alg) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(alg);
        byte[] bytesHash = md.digest(text.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte bh : bytesHash) {
            sb.append(String.format("%02x", bh));
        }
        return sb.toString();
    }

    private static void saveHashesToFile(String md5Hash, String sha1Hash, String sha256Hash, String sha512Hash) throws IOException {
        try (FileWriter writer = new FileWriter("task1_hashes.txt")) {
            writer.write("1) MD5: " + md5Hash + "\n");
            writer.write("2) SHA-1: " + sha1Hash + "\n");
            writer.write("3) SHA-256: " + sha256Hash + "\n");
            writer.write("4) SHA-512: " + sha512Hash + "\n");
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String text = "I am Sanka. 19 years";

        String MD5 = setHashValue(text, "MD5");
        String SHA_1 = setHashValue(text, "SHA-1");
        String SHA_256 = setHashValue(text, "SHA-256");
        String SHA_512 = setHashValue(text, "SHA-512");

        try {
            saveHashesToFile(MD5, SHA_1, SHA_256, SHA_512);
        } catch (IOException error) {
            System.err.println("Could not save to file, error: " + error.getMessage());
        }

        System.out.println("1) MD5: " + MD5);
        System.out.println("2) SHA-1: " + SHA_1);
        System.out.println("3) SHA-256: " + SHA_256);
        System.out.println("4) SHA-512: " + SHA_512);
    }
}
