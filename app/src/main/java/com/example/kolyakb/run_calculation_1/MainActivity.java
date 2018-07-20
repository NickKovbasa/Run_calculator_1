package com.example.kolyakb.run_calculation_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    TextView text_result;
    TextView text_km;
    TextView text_hr;
    TextView text_min;

    SeekBar seekBar_km;
    SeekBar seekBar_hr;
    SeekBar seekBar_min;

    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_result = findViewById(R.id.id_text_result);
        text_km = findViewById(R.id.id_text_km);
        text_hr = findViewById(R.id.id_text_hr);
        text_min = findViewById(R.id.id_text_min);

        text_min.setText("0 min");
        text_hr.setText("0 hr");
        text_km.setText("0 km");
        text_result.setText("0");

        seekBar_min = findViewById(R.id.id_seekBar_min);
        seekBar_km = findViewById(R.id.id_seekBar_km);
        seekBar_hr = findViewById(R.id.id_seekBar_hr);

        seekBar_hr.setMax(10);
        seekBar_km.setMax(100);
        seekBar_min.setMax(60);

        seekBar_min.setProgress(0);
        seekBar_km.setProgress(0);
        seekBar_hr.setProgress(0);

        seekBar_km.setOnSeekBarChangeListener(this);
        seekBar_hr.setOnSeekBarChangeListener(this);
        seekBar_min.setOnSeekBarChangeListener(this);

        result = 0.0;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        switch (seekBar.getId()) {

            case R.id.id_seekBar_min:

                text_min.setText(String.valueOf(seekBar_min.getProgress()) + " min");

                if (seekBar_km.getProgress() > 0) {

                    result = Double.parseDouble(String.valueOf((seekBar_hr.getProgress() * 60.00 + seekBar_min.getProgress()) / seekBar_km.getProgress()));

                    text_result.setText((String.valueOf(result).substring(0, 3)));

                    char [] char_min = text_result.getText().toString().toCharArray();

                    if (char_min[char_min.length - 1] == '.'){
                        text_result.getText().toString().substring(char_min.length - 1);
                    }
                } else {
                    text_result.setText("0");
                }

                break;

            case R.id.id_seekBar_hr:

                text_hr.setText(String.valueOf(seekBar_hr.getProgress()) + " hr");

                if (seekBar_km.getProgress() > 0) {

                    result = Double.parseDouble(String.valueOf((seekBar_hr.getProgress() * 60.00 + seekBar_min.getProgress()) / seekBar_km.getProgress()));

                    text_result.setText((String.valueOf(result).substring(0, 3)));

                    char [] char_hr = text_result.getText().toString().toCharArray();

                    if (char_hr[char_hr.length - 1] == '.'){
                        text_result.getText().toString().substring(char_hr.length - 1);
                    }


                } else {
                    text_result.setText("0");
                }

                    break;

                    case R.id.id_seekBar_km:

                        text_km.setText(String.valueOf(seekBar_km.getProgress()) + " km");

                        if (seekBar_km.getProgress() > 0) {

                            result = Double.parseDouble(String.valueOf((seekBar_hr.getProgress() * 60.00 + seekBar_min.getProgress()) / seekBar_km.getProgress()));

                            text_result.setText((String.valueOf(result).substring(0, 3)));

                            char [] char_km = text_result.getText().toString().toCharArray();

                            if (char_km[char_km.length - 1] == '.'){
                                text_result.getText().toString().substring(char_km.length - 1);
                            }

                        } else {
                            text_result.setText("0");
                        }

                        break;
                }





    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


}
