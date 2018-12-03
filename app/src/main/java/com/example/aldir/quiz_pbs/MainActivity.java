package com.example.aldir.quiz_pbs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    int idJawaban = 0;
    Button btn_nextSoal;
    TextView banyakSoal,txt_randomAngka1, txt_randomAngka2, hasilA, hasilB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_nextSoal = (Button)findViewById(R.id.btn_nextSoal);
        banyakSoal = (TextView)findViewById(R.id.banyakSoal);
        banyakSoal.setText("0/10");
        btn_nextSoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int batasAwal = 0;
                int batasAkhir = 10;
                if (batasAwal <=batasAkhir){
                    generateSoal();
                    banyakSoal.setText(batasAwal+"/"+batasAkhir);
                    batasAwal++;
                }
            }
        });

        generateSoal();
        }

    private int randomTempatJawaban() {
        Random random = new Random();
        return random.nextInt(2);
    }

    public void generateSoal(){
        Random random = new Random();

        txt_randomAngka1 = (TextView)findViewById(R.id.txt_randomAngka1);
        txt_randomAngka2 = (TextView)findViewById(R.id.txt_randomAngka2);
        hasilA = (TextView)findViewById(R.id.hasilA);
        hasilB = (TextView)findViewById(R.id.hasilB);

        int angkaRandom1 = random.nextInt(100);
        int angkaRandom2 = random.nextInt(100);
        int angkasalah = random.nextInt(100);
        int angkasalah2 = random.nextInt(100);


        Log.d("Cek Hasil Angka Random", "onCreate: " + angkaRandom1 + " " +angkaRandom2);

        String angka1 = Integer.toString(angkaRandom1);
        String angka2 = Integer.toString(angkaRandom2);

        txt_randomAngka1.setText(angka1.toString());
        txt_randomAngka2.setText(angka2.toString());

        int jawabanSementara,jawabanSalah;
        jawabanSalah = angkasalah + angkasalah2;


        jawabanSementara = angkaRandom1 + angkaRandom2;
        String StringJawabanSementara = Integer.toString(jawabanSementara);
        String StringJawabanSalah = Integer.toString(jawabanSalah);
        if (randomTempatJawaban() == 1){

            hasilA.setText("A : "+StringJawabanSementara); // JAWABAN BENAR PASANG DISINI
            hasilB.setText("B : "+StringJawabanSalah);
        }
        else {
            hasilA.setText("A : "+StringJawabanSalah);
            hasilB.setText("B : "+StringJawabanSementara); // JAAWABN BENAR PASANG DISINI
        }
        Log.d("RantomTempatJawab", "onCreate: "+randomTempatJawaban());
    }
}
