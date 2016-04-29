package group.termproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/*
  Borrowed from chandpriyankara/BullyWiiPlaza's AES implementation
  Added timer for data gathering purposes
  Encryption key is static, nonrandom due to security not being a concern.
  Key generation time is a known quantity
*/

public class EncryptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);
    }

    public void buttonOnClick(View v)
    {
        String encryptionKey = "PaZgWaeEmAaaeRuJ";
        TextView t = (TextView) findViewById(R.id.editText);
        String plainText = t.getText().toString();
        AdvancedEncryptionStandard my_aes = new AdvancedEncryptionStandard(encryptionKey);
        long starttime1, starttime2, endtime1, endtime2, duration1, duration2, durationtotal;
        starttime1 = System.nanoTime();
        String cipherText = "";
        try {
            cipherText = my_aes.encrypt(plainText);
        }
        catch(Exception e)
        {
            Log.d("ERROR", e.getMessage());
        }
        endtime1 = System.nanoTime();
        duration1 = (endtime1 - starttime1);
        starttime2 = System.nanoTime();
        String decryptedCipherText = "";
        try{
            decryptedCipherText = my_aes.decrypt(cipherText);
        }
        catch(Exception e)
        {
            Log.d("ERROR", e.getMessage());
        }
        endtime2 = System.nanoTime();
        duration2 = (endtime2 - starttime2);
        durationtotal = duration1 + duration2;
        TextView t1 = (TextView) findViewById(R.id.textView3);
        String outstr1 = "Original text: " + plainText;
        t1.setText(outstr1);
        TextView t2 = (TextView) findViewById(R.id.textView4);
        String outstr2 = "Cipher text: " + cipherText;
        t2.setText(outstr2);
        TextView t3 = (TextView) findViewById(R.id.textView5);
        String outstr3 = "Total time taken: " + durationtotal + " nanoseconds";
        t3.setText(outstr3);
        TextView t4 = (TextView) findViewById(R.id.textView6);
        String outstr4 = "Decrypted Text: " + decryptedCipherText;
        t4.setText(outstr4);
    }
}
