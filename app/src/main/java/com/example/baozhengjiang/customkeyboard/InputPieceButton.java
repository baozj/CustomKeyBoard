package com.example.baozhengjiang.customkeyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class InputPieceButton extends FrameLayout {

    private Unbinder unbinder;
    @BindView(R.id.tv_itemInputPiece_text)
    TextView mtvItemInputPieceText;
    @BindView(R.id.iv_itemInputPiece_img)
    ImageView mivItemInputPieceImg;

    private Piece piece;
    private OnInputPieceListener onInputPieceListener;
    private Context mContext;
    private View view;

    public InputPieceButton(Context context) {
        this(context,null);
    }

    public InputPieceButton(Context context, AttributeSet attr) {
        this(context, attr,0);
    }

    public InputPieceButton(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
        mContext = context;
        view = LayoutInflater.from(context).inflate(R.layout.item_input_piece_button, null);
        unbinder = ButterKnife.bind(this, view);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                 onInputPieceListener.onPieceClick(view,piece);
            }
        });
        this.addView(view);
    }


    public void setPiece(Piece piece){
                     this.piece = piece;
                     updateUI();
    }

    private void updateUI() {

        if (piece.getImg() ==0){
             mtvItemInputPieceText.setVisibility(View.VISIBLE);
             mivItemInputPieceImg.setVisibility(View.GONE);
             mtvItemInputPieceText.setText(piece.getText());
             mtvItemInputPieceText.setTextSize(piece.getTextSize());
             mtvItemInputPieceText.setTextColor(mContext.getResources().getColor(piece.getTextColor()));
             mtvItemInputPieceText.setBackgroundDrawable(mContext.getResources().getDrawable(piece.getBackgroundSelector()));
        }  else {
            mtvItemInputPieceText.setVisibility(View.GONE);
            mivItemInputPieceImg.setVisibility(View.VISIBLE);
            mivItemInputPieceImg.setImageResource(piece.getImg());
        }

        if (piece.getBackgroundSelector()!=0){
            this.setBackgroundDrawable(mContext.getResources().getDrawable(piece.getBackgroundSelector()));
        }
        if (!piece.isIdEnable()){
            if (piece.getText().equals(".")){
                 mtvItemInputPieceText.setVisibility(View.GONE);
                 mivItemInputPieceImg.setVisibility(View.GONE);
                 }
            this.setBackgroundColor(mContext.getResources().getColor(R.color.sold_out));
        }
           this.setEnabled(piece.isIdEnable());
    }

    public void onRemoveView() {
        unbinder.unbind();
    }

    public void setOnInputPieceListener(OnInputPieceListener l) {
        onInputPieceListener = l;
    }

    interface OnInputPieceListener {
        void onPieceClick(View v, Piece piece);
    }
}
