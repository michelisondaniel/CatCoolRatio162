package net.michelison.catcoolratio;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener{

    private TextView catsOwned;
    private TextView coolFactor;
    private SeekBar catSeekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get references to widgets
        catSeekBar = (SeekBar) findViewById(R.id.catSeekBar);
        catsOwned = (TextView) findViewById(R.id.catsOwned);
        coolFactor = (TextView) findViewById(R.id.coolFactor);

        // set listener
        catSeekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        catsOwned.setText(progress + " Cats owned");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        int progress = catSeekBar.getProgress();

        if(progress <= 1) {
            coolFactor.setText("Standard");
        }
        if (progress > 1 && progress <= 3){
            coolFactor.setText("Pretty cool cat");
        }
        if(progress > 3 && progress <= 7){
            coolFactor.setText("Interesting...");
        }
        if (progress > 7){
            coolFactor.setText("Crazy cat person");
        }

    }
}
