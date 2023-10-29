package com.androidwithshiv.rating;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context;
    ImageView rating, star1, star2, star3, star4, star5;
    TextView rateCount;
    CardView cancel, ok;
    AlertDialog dialogMain;
     int countVal;
    public void init(){
        context = MainActivity.this;
        rating = findViewById(R.id.imageView);
        rateCount = findViewById(R.id.count);
        countVal = 0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        createDialogue();
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(ContextCompat.getColor(context, R.color.bg));

        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogMain.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogMain.show();
            }
        });
    }
    public void createDialogue(){
        View ratingDialogue = LayoutInflater.from(context).inflate(R.layout.rating_dialogue, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(ratingDialogue);

        dialogMain = builder.create();
        dialogMain.setCanceledOnTouchOutside(false);

        star1 = (ImageView) ratingDialogue.findViewById(R.id.star1);
        star2 = (ImageView) ratingDialogue.findViewById(R.id.star2);
        star3 = (ImageView) ratingDialogue.findViewById(R.id.star3);
        star4 = (ImageView) ratingDialogue.findViewById(R.id.star4);
        star5 = (ImageView) ratingDialogue.findViewById(R.id.star5);

        ok = (CardView) ratingDialogue.findViewById(R.id.ok);
        cancel = (CardView) ratingDialogue.findViewById(R.id.cancel);

        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countVal = 1;
                star1.setImageResource(R.drawable.fill);
                star2.setImageResource(R.drawable.not_fill);
                star3.setImageResource(R.drawable.not_fill);
                star4.setImageResource(R.drawable.not_fill);
                star5.setImageResource(R.drawable.not_fill);
            }
        });
        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countVal = 2;
                star1.setImageResource(R.drawable.fill);
                star2.setImageResource(R.drawable.fill);
                star3.setImageResource(R.drawable.not_fill);
                star4.setImageResource(R.drawable.not_fill);
                star5.setImageResource(R.drawable.not_fill);
            }
        });
        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countVal = 3;
                star1.setImageResource(R.drawable.fill);
                star2.setImageResource(R.drawable.fill);
                star3.setImageResource(R.drawable.fill);
                star4.setImageResource(R.drawable.not_fill);
                star5.setImageResource(R.drawable.not_fill);
            }
        });
        star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countVal = 4;
                star1.setImageResource(R.drawable.fill);
                star2.setImageResource(R.drawable.fill);
                star3.setImageResource(R.drawable.fill);
                star4.setImageResource(R.drawable.fill);
                star5.setImageResource(R.drawable.not_fill);
            }
        });
        star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countVal = 5;
                star1.setImageResource(R.drawable.fill);
                star2.setImageResource(R.drawable.fill);
                star3.setImageResource(R.drawable.fill);
                star4.setImageResource(R.drawable.fill);
                star5.setImageResource(R.drawable.fill);
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(countVal==0){
                    Toast.makeText(context, "Click star please", Toast.LENGTH_SHORT).show();
                }
                else{
                    rateCount.setText("Rated Value : "+countVal);
                    dialogMain.dismiss();
                    countVal=0;
                    star1.setImageResource(R.drawable.not_fill);
                    star2.setImageResource(R.drawable.not_fill);
                    star3.setImageResource(R.drawable.not_fill);
                    star4.setImageResource(R.drawable.not_fill);
                    star5.setImageResource(R.drawable.not_fill);
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogMain.dismiss();
                countVal=0;
                star1.setImageResource(R.drawable.not_fill);
                star2.setImageResource(R.drawable.not_fill);
                star3.setImageResource(R.drawable.not_fill);
                star4.setImageResource(R.drawable.not_fill);
                star5.setImageResource(R.drawable.not_fill);
            }
        });
    }
}