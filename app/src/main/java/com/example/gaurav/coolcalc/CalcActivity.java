package com.example.gaurav.coolcalc;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CalcActivity extends Activity {

    public enum Operation {
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }

    String runningNum="";
    String leftValStr ="";
    String rightValStr ="";
    TextView resultsTextView;
    Operation currOperation;
    int result = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button oneBtn = (Button) findViewById(R.id.oneBtn);
        Button twoBtn = (Button) findViewById(R.id.twoBtn);
        Button threeBtn = (Button) findViewById(R.id.threeBtn);
        Button fourBtn = (Button) findViewById(R.id.fourBtn);
        Button fiveBtn = (Button) findViewById(R.id.fiveBtn);
        Button sixBtn = (Button) findViewById(R.id.sixbtn);
        Button sevenBtn = (Button) findViewById(R.id.sevenBtn);
        Button eightBtn = (Button) findViewById(R.id.eightBtn);
        Button nineBtn = (Button) findViewById(R.id.NineBtn);
        Button zeroBtn = (Button) findViewById(R.id.zeroBtn);

        ImageButton equalsBtn = (ImageButton) findViewById(R.id.equalsBtn);
        ImageButton divideBtn = (ImageButton) findViewById(R.id.divideBtn);
        ImageButton multiplyBtn = (ImageButton) findViewById(R.id.multiplyBtn);
        ImageButton addBtn = (ImageButton) findViewById(R.id.addBtn);
        ImageButton subtractBtn = (ImageButton) findViewById(R.id.subtractBtn);

        resultsTextView = (TextView) findViewById(R.id.resultsTextview);
        Button clearBtn = (Button) findViewById(R.id.clearBtn);

        resultsTextView.setText("");


        //Setting onclick listening for buttons and textview
        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numpressed (1);
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numpressed (2);
            }
        });


        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numpressed (3);
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numpressed (4);
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numpressed (5);
            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numpressed (6);
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numpressed (7);
            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numpressed (8);
            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numpressed (9);
            }
        });

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numpressed (0);
            }
        });

        equalsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.EQUAL);
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.DIVIDE);
            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.MULTIPLY);
            }
        });

        subtractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.SUBTRACT);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.ADD);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftValStr = "";
                rightValStr = "";
                result = 0;
                runningNum = "";
                currOperation = null;
                resultsTextView.setText("0");
            }
        });


    }

        void processOperation(Operation O)
        {
            if(currOperation != null)
            {
                if(runningNum != "")
                {
                    rightValStr = runningNum;
                    runningNum = "";

                    switch (currOperation)
                    {
                        case ADD:
                            result = Integer.parseInt(leftValStr) + Integer.parseInt(rightValStr);
                            break;
                        case SUBTRACT:
                            result = Integer.parseInt(leftValStr) - Integer.parseInt(rightValStr);
                            break;
                        case MULTIPLY:
                            result = Integer.parseInt(leftValStr) * Integer.parseInt(rightValStr);
                            break;
                        case DIVIDE:
                            result = Integer.parseInt(leftValStr) / Integer.parseInt(rightValStr);
                            break;
                    }
                    leftValStr = String.valueOf(result);
                    resultsTextView.setText(leftValStr);
                }

            }
            else
            {
                leftValStr = runningNum;
                runningNum = "";

            }
            currOperation = O;
        }

        void numpressed (int num){
            runningNum +=String.valueOf(num); // combing numbers 1 then 2 then 3 and so fourth as pressed.
            resultsTextView.setText(runningNum);
        }


}