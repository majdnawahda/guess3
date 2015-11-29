package com.example.majd.guess;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity {
    Button mGuessButton;
    int mGuessNumber,number,mCounter=0;
    TextView mTextNumber,mTextTry;
    String string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random r=new Random();
        number=r.nextInt(1000);

        mGuessButton=(Button)findViewById(R.id.B1);
        mGuessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextNumber=(TextView)findViewById(R.id.T1);
                string=mTextNumber.getText().toString();
                mGuessNumber=Integer.parseInt(string);

                if(mGuessNumber==number)
                {
                    Toast.makeText(getApplicationContext(),"Congratulations this is True", Toast.LENGTH_LONG).show();
                    mCounter++;
                }
                else
                if(mGuessNumber>number)
                {
                    if(mGuessNumber-number<=5) {
                        Toast.makeText(getApplicationContext(), "very closed", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(getApplicationContext(),"guess less than it", Toast.LENGTH_LONG).show();
                    mCounter++;
                }
                else
                if(mGuessNumber<number)
                {
                    if(number-mGuessNumber<=5) {
                        Toast.makeText(getApplicationContext(), "very closed", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(getApplicationContext(),"guess grater than it", Toast.LENGTH_LONG).show();
                    mCounter++;

                }

                mTextTry=(TextView)findViewById(R.id.T3);
                mTextTry.setText(""+mCounter);
            }
        });

    }

}
