import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/*
  Borrowed from chandpriyankara/BullyWiiPlaza's AES implementation
  Added timer for data gathering purposes
  Encryption key is static, nonrandom due to security not being a concern.
  Key generation time is a known quantity
*/

public class test
{
  public static void main(String[] arguments) throws Exception
  {
    String encryptionKey = "PaZgWaeEmAaaeRuJ";
    String plainText = "Hello world!";
    AdvancedEncryptionStandard advancedEncryptionStandard = new AdvancedEncryptionStandard(
            encryptionKey);
    long starttime1, starttime2, endtime1, endtime2, duration1, duration2, durationtotal;
    starttime1 = System.nanoTime();
    String cipherText = advancedEncryptionStandard.encrypt(plainText);
    endtime1 = System.nanoTime();
    duration1 = (endtime1 - starttime1);
    starttime2 = System.nanoTime();
    String decryptedCipherText = advancedEncryptionStandard.decrypt(cipherText);
    endtime2 = System.nanoTime();
    duration2 = (endtime2 - starttime2);
    durationtotal = duration1 + duration2;
    System.out.println("Original text: " + plainText);
    System.out.println("Time taken to encrypt: " + duration1 + " nano seconds.");
    System.out.println("Cipher text: " + cipherText);
    System.out.println("Time taken to decrypt: " + duration2 + " nano seconds.");
    System.out.println("Decrypted text: " + decryptedCipherText);
    System.out.println("Total time taken: " + durationtotal + " nano seconds.");
  }
}
