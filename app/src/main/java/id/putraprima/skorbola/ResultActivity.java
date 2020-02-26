package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.TextView;

import id.putraprima.skorbola.model.Data;

import static id.putraprima.skorbola.MainActivity.DATA_KEY;

public class ResultActivity extends AppCompatActivity {

    public static final String EXTRA_RESULT = "EXTRA_RESULT";
    private TextView resultText;
    private String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        result=intent.getStringExtra(EXTRA_RESULT);

        resultText = findViewById(R.id.textView3);
        resultText.setText(result);


    }
}
