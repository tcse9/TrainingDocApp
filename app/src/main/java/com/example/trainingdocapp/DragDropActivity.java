package com.example.trainingdocapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DragDropActivity extends AppCompatActivity implements View.OnTouchListener,View.OnDragListener {

    private View view1, view2, view3;
    private TextView txtAnswer1, txtAnswer2, txtAnswer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_drop);


        view1 = findViewById(R.id.view1);
        view1.setTag("view1");
        view2 = findViewById(R.id.view2);
        view2.setTag("view2");
        view3 = findViewById(R.id.view3);
        view3.setTag("view3");

        txtAnswer1 = findViewById(R.id.txtAnswer1);
        txtAnswer1.setTag("view1");
        txtAnswer2 = findViewById(R.id.txtAnswer2);
        txtAnswer2.setTag("view2");
        txtAnswer3 = findViewById(R.id.txtAnswer3);
        txtAnswer3.setTag("view3");


        //view1.setOnTouchListener(this);
        //view2.setOnTouchListener(this);
        //view3.setOnTouchListener(this);
        txtAnswer1.setOnTouchListener(this);
        txtAnswer2.setOnTouchListener(this);
        txtAnswer3.setOnTouchListener(this);

        view1.setOnDragListener(this);
        view2.setOnDragListener(this);
        view3.setOnDragListener(this);

    }


    @Override
    public boolean onDrag(View v, DragEvent event) {
        if (event.getAction()==DragEvent.ACTION_DROP) {
            //handle the dragged view being dropped over a target view
            TextView dropped = (TextView)event.getLocalState();
            View dropTarget = (View) v;
            //stop displaying the view where it was before it was dragged
            //dropped.setVisibility(View.INVISIBLE);

            //if an item has already been dropped here, there will be different string
            String text=dropTarget.getTag().toString();
            //if there is already an item here, set it back visible in its original place
            if(dropped.getTag().toString().equals(dropTarget.getTag().toString()) && dropped.getTag().toString().equals("view1")) {
                txtAnswer1.setVisibility(View.INVISIBLE);
                view1.setVisibility(View.VISIBLE);
            }
            else if(dropped.getTag().toString().equals(dropTarget.getTag().toString()) && dropped.getTag().toString().equals("view2")) {
                txtAnswer2.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.VISIBLE);
            }
            else if(dropped.getTag().toString().equals(dropTarget.getTag().toString()) && dropped.getTag().toString().equals("view3")) {
                txtAnswer3.setVisibility(View.INVISIBLE);
                view3.setVisibility(View.VISIBLE);

            }


            Toast.makeText(this, "dropped: "+dropped.getTag().toString()+" target: "+dropTarget.getTag().toString(), Toast.LENGTH_SHORT).show();


        }

        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN) {
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(null, shadowBuilder, v, 0);

            Toast.makeText(this, "drag view", Toast.LENGTH_SHORT).show();

            return true;
        }
        else return false;

    }

}
