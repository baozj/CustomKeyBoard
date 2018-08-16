package com.example.baozhengjiang.customkeyboard;

import android.content.Context;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class Piece {

    private String text; //文案
    private int Img;//图片
    private float textSize;//字体大小
    private int textColor;//字体颜色
    private boolean idEnable; //是否可以点击
    private int backgroundSelector;//背景色

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }

    public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public boolean isIdEnable() {
        return idEnable;
    }

    public void setIdEnable(boolean idEnable) {
        this.idEnable = idEnable;
    }

    public int getBackgroundSelector() {
        return backgroundSelector;
    }

    public void setBackgroundSelector(int backgroundSelector) {
        this.backgroundSelector = backgroundSelector;
    }

    public static List<Piece> getInputLayoutAllPiece(Context context){

        List<Piece> pieceList = new ArrayList<Piece>();
        for (int i=1;i<=11;i++){
            Piece piece = new Piece();
            if (i==10){
               piece.setText(".");
               piece.setIdEnable(false);
               piece.setTextSize(24);
               piece.setTextColor(R.color.Global_B);
               piece.setBackgroundSelector(R.drawable.bg_input_button);
            }else if (i==11){
                piece.setText("0");
                piece.setIdEnable(false);
                piece.setTextSize(24);
                piece.setTextColor(R.color.Global_B);
                piece.setBackgroundSelector(R.drawable.bg_input_button);
            }else {
                piece.setText(i+"");
                piece.setIdEnable(false);
                piece.setTextSize(24);
                piece.setTextColor(R.color.Global_B);
                piece.setBackgroundSelector(R.drawable.bg_input_button);
            }
            pieceList.add(piece);
        }

        Piece piece12 = new Piece();
        piece12.setIdEnable(true);
        piece12.setImg(R.drawable.keyboard_hide);
        piece12.setBackgroundSelector(R.drawable.bg_input_button);
        pieceList.add(piece12);

        Piece piece13 = new Piece();
        piece13.setIdEnable(true);
        piece13.setImg(R.drawable.keyboard_delete);
        piece13.setBackgroundSelector(R.drawable.bg_input_button);
        pieceList.add(piece13);

        Piece piece14 = new Piece();
        piece14.setIdEnable(true);
        piece14.setText("收益试算");
        piece14.setTextSize(16);
        piece14.setTextColor(R.color.text_white_nineTy);
        piece14.setBackgroundSelector(R.drawable.bg_input_button_spec);
        pieceList.add(piece14);



        return pieceList;
    }

}
