package com.escobedo.jees.exam_p2_app;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import java.util.regex.Matcher;

public class MainActivity extends AppCompatActivity {


    private Random generador;
    private int num1;
    private int num2;
    private int resultado;
    private EditText respuesta;
    private Button nextbutton, resetbutton, startbutton;
    private TextView time, correctas, incorrectas;
    private int correct = 0;
    private int incorrect = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }





        public void start (View view) {

            generador = new Random();
            num1 = Math.abs(generador.nextInt() % 10);
            num2 = Math.abs(generador.nextInt() % 10);
            resultado = num1 + num2;
            TextView n1 = (TextView) findViewById(R.id.num1);
            n1.setText("" + num1);
            TextView n2 = (TextView) findViewById(R.id.num2);
            n2.setText("" + num2);

            nextbutton = (Button) findViewById(R.id.next);
            resetbutton = (Button) findViewById(R.id.res);
            startbutton = (Button) findViewById(R.id.start);
            respuesta = (EditText) findViewById(R.id.resp);
            time = (TextView) findViewById(R.id.time);
            correctas = (TextView) findViewById(R.id.corr);
            incorrectas = (TextView) findViewById(R.id.inco);

            resetbutton.setEnabled(false);
            resetbutton.setVisibility(View.INVISIBLE);
            respuesta.setEnabled(true);
            correctas.setText("" + 0);
            incorrectas.setText("" + 0);
            incorrect = 0;
            correct = 0;


            new CountDownTimer(30000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    time.setText("" + (millisUntilFinished / 1000));
                }

                @Override
                public void onFinish() {
                    startbutton.setEnabled(false);
                    startbutton.setVisibility(View.INVISIBLE);
                    nextbutton.setEnabled(false);
                    nextbutton.setVisibility(View.INVISIBLE);
                    resetbutton.setEnabled(true);
                    resetbutton.setVisibility(View.VISIBLE);
                    respuesta.setEnabled(false);
                }
            }.start();
            startbutton.setEnabled(false);
            startbutton.setVisibility(View.INVISIBLE);
            resetbutton.setVisibility(View.INVISIBLE);
        }

    public void next (View view) {
                int resp = Integer.valueOf(respuesta.getText().toString().trim());

                if (resp == resultado) {
                    correct = correct + 1;
                    correctas.setText("" + correct);
                    num1 = Math.abs(generador.nextInt() % 10);
                    num2 = Math.abs(generador.nextInt() % 10);
                    resultado = num1 + num2;
                    TextView n1 = (TextView) findViewById(R.id.num1);
                    n1.setText("" + num1);
                    TextView n2 = (TextView) findViewById(R.id.num2);
                    n2.setText("" + num2);

                } else {
                    incorrect = incorrect + 1;
                    incorrectas.setText("" + incorrect);
                }


            }
    public void restart (View view){
        startbutton.setEnabled(true);
        startbutton.setVisibility(View.VISIBLE);
        nextbutton.setEnabled(true);
        nextbutton.setVisibility(View.VISIBLE);
        resetbutton.setEnabled(false);
        resetbutton.setVisibility(View.INVISIBLE);
    }
            }



