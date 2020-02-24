package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import id.putraprima.skorbola.model.Data;

public class MatchActivity extends AppCompatActivity {

    private TextView hometeamText;
    private TextView awayteamText;
    private ImageView homelogo;
    private ImageView awaylogo;

    private Data data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        hometeamText = findViewById(R.id.txt_home);
        awayteamText =findViewById(R.id.txt_away);
        homelogo = findViewById(R.id.home_logo);
        awaylogo = findViewById(R.id.away_logo);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
//            String usernameInput
            // TODO: display value here
            data = extras.getParcelable(MainActivity.DATA_KEY);

            hometeamText.setText(data.getHometeam());
            awayteamText.setText(data.getAwayteam());
//            Bitmap bmp = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("yourImage"), 0, getIntent().getByteArrayExtra("yourImage").length);
//            homelogo.setImageBitmap(bmp);
//            homelogo.setImageBitmap(bmp);



        }

        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }
}
