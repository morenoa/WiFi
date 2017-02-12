package net.androidbootcamp.wifi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class competitor extends AppCompatActivity {
    double P2G = .05;
    double Contract = .15;
    double monthly;
    double save;
    double total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competitor);
        Button button3 = (Button) findViewById(R.id.btnHome);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText cost = (EditText) findViewById(R.id.txtCost);
        final RadioButton PayAsUGo = (RadioButton) findViewById(R.id.radCompetitor);
        final RadioButton life = (RadioButton) findViewById(R.id.radDied);
        final TextView result = (TextView) findViewById(R.id.txtSave);
        Button convert = (Button) findViewById(R.id.btnSave);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(competitor.this, MainActivity.class));
            }
        });

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monthly = Double.parseDouble(cost.getText  ( )  .toString( ));
                DecimalFormat tenth = new DecimalFormat("#.##");
                if(PayAsUGo.isChecked())
                {
                    save = monthly * P2G;
                    total = monthly - save;
                    result.setText(tenth.format(total));
                }
                else if(life.isChecked())
                {
                    save = monthly * Contract;
                    total = monthly - save;
                    result.setText(tenth.format(total));
                }
            }
        });
    }
}
