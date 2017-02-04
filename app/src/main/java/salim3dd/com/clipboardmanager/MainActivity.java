package salim3dd.com.clipboardmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyClipboardManager myClipboardManager;

    EditText edittext ;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext = (EditText) findViewById(R.id.edit_text);
        textView = (TextView) findViewById(R.id.textView1);

        myClipboardManager = new MyClipboardManager();

        findViewById(R.id.BTN_Copy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String TXT = edittext.getText().toString();
                myClipboardManager.copyToClipboard(MainActivity.this, TXT);
                Toast.makeText(MainActivity.this, "تم نسخ النص", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.BTN_Paste).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myTXT = myClipboardManager.readFromClipboard(MainActivity.this);
                textView.setText(myTXT);
            }
        });

    }
}
