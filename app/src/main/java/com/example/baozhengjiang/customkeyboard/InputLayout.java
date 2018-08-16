package com.example.baozhengjiang.customkeyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class InputLayout extends FrameLayout {

    @BindView(R.id.inputButton1)
    InputPieceButton minputButton1;
    @BindView(R.id.inputButton2)
    InputPieceButton minputButton2;
    @BindView(R.id.inputButton3)
    InputPieceButton minputButton3;
    @BindView(R.id.inputButton4)
    InputPieceButton minputButton4;
    @BindView(R.id.inputButton5)
    InputPieceButton minputButton5;
    @BindView(R.id.inputButton6)
    InputPieceButton minputButton6;
    @BindView(R.id.inputButton7)
    InputPieceButton minputButton7;
    @BindView(R.id.inputButton8)
    InputPieceButton miputButton8;
    @BindView(R.id.inputButton9)
    InputPieceButton minputButton9;
    @BindView(R.id.inputButton10)
    InputPieceButton minputButton10;
    @BindView(R.id.inputButton11)
    InputPieceButton minputButton11;
    @BindView(R.id.inputButton12)
    InputPieceButton minputButton12;
    @BindView(R.id.inputButton13)
    InputPieceButton minputButton13;
    @BindView(R.id.inputButton14_line)
    View minputButton14Line;
    @BindView(R.id.inputButton14)
    InputPieceButton minputButton14;
    @BindView(R.id.inputButton15_line)
    View minputButton15Line;
    @BindView(R.id.inputButton15)
    InputPieceButton minputButton15;
    private Context mContext;
    private Unbinder unbinder;
    private List<Piece> pieceList;
    private OnInputLayoutListener onInputLayoutListener;
    private EditText mEditText;
    private View view;

    public InputLayout(Context context) {
        this(context,null);
    }

    public InputLayout(Context context, AttributeSet attr) {
        this(context, attr,0);
    }

    public InputLayout(Context context, AttributeSet attr, int defstyle) {
        super(context, attr, defstyle);
        mContext = context;
        view = LayoutInflater.from(context).inflate(R.layout.item_input_layout, null);
        int systemW = getScreenWidth(context) / 8;
        view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, systemW * 5));
        unbinder = ButterKnife.bind(this, view);
        this.addView(view);
        pieceList = new ArrayList<Piece>();
    }

    public void setAllPiece(List<Piece> list) {
        pieceList = list;
        updateUI();
    }

    public void unbindEditText() {
        this.mEditText = null;
    }

    public void bindEditText(EditText editText) {
        this.mEditText = editText;
    }

    private void updateUI() {

        minputButton1.setPiece(pieceList.get(0));
        minputButton2.setPiece(pieceList.get(1));
        minputButton3.setPiece(pieceList.get(2));
        minputButton4.setPiece(pieceList.get(3));
        minputButton5.setPiece(pieceList.get(4));
        minputButton6.setPiece(pieceList.get(5));
        minputButton7.setPiece(pieceList.get(6));
        miputButton8.setPiece(pieceList.get(7));
        minputButton9.setPiece(pieceList.get(8));
        minputButton10.setPiece(pieceList.get(9));
        minputButton11.setPiece(pieceList.get(10));
        minputButton12.setPiece(pieceList.get(11));
        minputButton13.setPiece(pieceList.get(12));
        minputButton1.setOnInputPieceListener(onInputPieceListener);
        minputButton2.setOnInputPieceListener(onInputPieceListener);
        minputButton3.setOnInputPieceListener(onInputPieceListener);
        minputButton4.setOnInputPieceListener(onInputPieceListener);
        minputButton5.setOnInputPieceListener(onInputPieceListener);
        minputButton6.setOnInputPieceListener(onInputPieceListener);
        minputButton7.setOnInputPieceListener(onInputPieceListener);
        miputButton8.setOnInputPieceListener(onInputPieceListener);
        minputButton9.setOnInputPieceListener(onInputPieceListener);
        minputButton10.setOnInputPieceListener(onInputPieceListener);
        minputButton11.setOnInputPieceListener(onInputPieceListener);
        minputButton12.setOnInputPieceListener(onInputPieceListener);
        minputButton13.setOnInputPieceListener(onInputPieceListener);

        if (pieceList.size() < 14) {
            minputButton14.setVisibility(View.GONE);
            minputButton14Line.setVisibility(View.GONE);
            minputButton15.setVisibility(View.GONE);
            minputButton15Line.setVisibility(View.GONE);
        } else {
            minputButton14.setPiece(pieceList.get(13));
            minputButton14.setOnInputPieceListener(onInputPieceListener);

            if (pieceList.size() < 15) {
                minputButton15.setVisibility(View.GONE);
                minputButton15Line.setVisibility(View.GONE);
            } else {
                minputButton15.setPiece(pieceList.get(14));
                minputButton15.setOnInputPieceListener(onInputPieceListener);
            }
        }
    }

    public void onRemoveView() {
        unbinder.unbind();
    }

    public static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        return display.getWidth();
    }

    private InputPieceButton.OnInputPieceListener onInputPieceListener = new InputPieceButton.OnInputPieceListener(){

        @Override
        public void onPieceClick(View v, Piece piece) {
             switch (v.getId()){
                 case R.id.inputButton1:
                     add(piece);
                     onInputLayoutListener.onIntegerClick(v,piece);
                     break;
                 case R.id.inputButton2:
                     add(piece);
                     onInputLayoutListener.onIntegerClick(v, piece);
                     break;
                 case R.id.inputButton3:
                     add(piece);
                     onInputLayoutListener.onIntegerClick(v, piece);
                     break;
                 case R.id.inputButton4:
                     add(piece);
                     onInputLayoutListener.onIntegerClick(v, piece);
                     break;
                 case R.id.inputButton5:
                     add(piece);
                     onInputLayoutListener.onIntegerClick(v, piece);
                     break;
                 case R.id.inputButton6:
                     add(piece);
                     onInputLayoutListener.onIntegerClick(v, piece);
                     break;
                 case R.id.inputButton7:
                     add(piece);
                     onInputLayoutListener.onIntegerClick(v, piece);
                     break;
                 case R.id.inputButton8:
                     add(piece);
                     onInputLayoutListener.onIntegerClick(v, piece);
                     break;
                 case R.id.inputButton9:
                     add(piece);
                     onInputLayoutListener.onIntegerClick(v, piece);
                     break;
                 case R.id.inputButton10:
                     add(piece);
                     onInputLayoutListener.onDecimalClick(v, piece);
                     break;
                 case R.id.inputButton11:
                     add(piece);
                     onInputLayoutListener.onIntegerClick(v, piece);
                     break;
                 case R.id.inputButton12:
                     onInputLayoutListener.onCloseClick(v, piece);
                     break;
                 case R.id.inputButton13:
                     remove();
                     onInputLayoutListener.onBtn13(v, piece);
                     break;
                 case R.id.inputButton14:
                     onInputLayoutListener.onBtn14(v, piece);
                     break;
                 case R.id.inputButton15:
                     onInputLayoutListener.onBtn15(v, piece);
                     break;
             }
        }
    };

    public void add(Piece piece) {
        if (mEditText != null) {
            mEditText.setText(mEditText.getText().toString() + piece.getText());
            mEditText.setSelection(mEditText.getText().length());
        }
    }

    public void remove() {
        if (mEditText != null) {
            String s = mEditText.getText().toString();
            mEditText.setText(s.substring(0, s.length() - 1));
            mEditText.setSelection(mEditText.getText().length());
        }
    }

    public void setOnInputLayoutListener(OnInputLayoutListener l){
        onInputLayoutListener = l;
    }

    interface OnInputLayoutListener{
        void onIntegerClick(View view,Piece piece);

        void onDecimalClick(View view, Piece piece);

        void onCloseClick(View view, Piece piece);

        void onBtn13(View view, Piece piece);

        void onBtn14(View view, Piece piece);

        void onBtn15(View view, Piece piece);
    }

}
