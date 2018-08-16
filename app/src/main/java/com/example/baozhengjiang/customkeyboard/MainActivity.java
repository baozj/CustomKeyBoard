package com.example.baozhengjiang.customkeyboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private InputLayout inputLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {

        inputLayout = findViewById(R.id.inputlayout);
        inputLayout.setAllPiece(Piece.getInputLayoutAllPiece(this));
        inputLayout.setOnInputLayoutListener(new InputLayout.OnInputLayoutListener() {
            @Override
            public void onIntegerClick(View view, Piece piece) {

            }

            @Override
            public void onDecimalClick(View view, Piece piece) {

            }

            @Override
            public void onCloseClick(View view, Piece piece) {

            }

            @Override
            public void onBtn13(View view, Piece piece) {

            }

            @Override
            public void onBtn14(View view, Piece piece) {

            }

            @Override
            public void onBtn15(View view, Piece piece) {

            }
        });
    }
}
