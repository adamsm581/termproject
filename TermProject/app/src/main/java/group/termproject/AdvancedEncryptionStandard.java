package group.termproject;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import android.util.Base64;
/*
  Borrowed from chandpriyankara/BullyWiiPlaza's AES implementation
  For use in term project
  Modified for use with android.util.Base64 instead of Apache CC
*/

public class AdvancedEncryptionStandard
{
    private String encryptionKey;

    public AdvancedEncryptionStandard(String encryptionKey)
    {
        this.encryptionKey = encryptionKey;
    }

    public String encrypt(String plainText) throws Exception
    {
        Cipher cipher = getCipher(Cipher.ENCRYPT_MODE);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        String ct = new String(encryptedBytes);
        return Base64.encodeToString(ct.getBytes(), Base64.NO_WRAP);
    }

    public String decrypt(String encrypted) throws Exception
    {
        Cipher cipher = getCipher(Cipher.DECRYPT_MODE);
        byte[] plainBytes = cipher.doFinal(Base64.decode(encrypted, Base64.NO_WRAP));
        return new String(plainBytes);
    }

    private Cipher getCipher(int cipherMode)
            throws Exception
    {
        String encryptionAlgorithm = "AES";
        SecretKeySpec keySpecification = new SecretKeySpec(
                encryptionKey.getBytes("UTF-8"), encryptionAlgorithm);
        Cipher cipher = Cipher.getInstance(encryptionAlgorithm);
        cipher.init(cipherMode, keySpecification);

        return cipher;
    }
}
