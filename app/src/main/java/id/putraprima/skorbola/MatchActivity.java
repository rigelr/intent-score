package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.putraprima.skorbola.model.Data;

import static id.putraprima.skorbola.MainActivity.DATA_KEY;

public class MatchActivity extends AppCompatActivity {

    private TextView hometeamText;
    private TextView awayteamText;
    private ImageView homelogo;
    private ImageView awaylogo;

//    skor
    private TextView homescoreText;
    private TextView awayscoreText;

    String result;

    int awayscore=0;
    int homescore=0;

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
            data = extras.getParcelable(DATA_KEY);

            hometeamText.setText(data.getHometeam());
            awayteamText.setText(data.getAwayteam());
            Bitmap bmphome = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("HomeImage"), 0, getIntent().getByteArrayExtra("HomeImage").length);
            homelogo.setImageBitmap(bmphome);
            Bitmap bmpaway = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("AwayImage"), 0, getIntent().getByteArrayExtra("AwayImage").length);
            awaylogo.setImageBitmap(bmpaway);
//            homelogo.setImageBitmap(bmp);



        }

        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }


    public void handleaddhome(View view) {
        awayscore=awayscore+1;
        displayForTeamAway(awayscore);

    }
    public void displayForTeamAway(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_home);
        scoreView.setText(String.valueOf(score));
    }

    public void handleaddaway(View view) {
        homescore=homescore+1;
        displayForTeamHome(homescore);

    }
    public void displayForTeamHome(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_away);
        scoreView.setText(String.valueOf(score));
    }

    public void handleHasil(View view) {

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(ResultActivity.EXTRA_RESULT,result);
        if (homescore>awayscore){

            result="pemenangnya adalah "+ data.getAwayteam();
            intent.putExtra(ResultActivity.EXTRA_RESULT,result);

        }else if(awayscore>homescore){

            result="pemenangnya adalah "+data.getHometeam();
            intent.putExtra(ResultActivity.EXTRA_RESULT,result);

        }else if(awayscore==homescore){

            result="skor seri";
            intent.putExtra(ResultActivity.EXTRA_RESULT,result);
        }
        startActivity(intent);
    }
}
