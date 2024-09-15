package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextView txtresult;
        EditText edtheightFt,edtheightIn,edtweight;
        Button  btncalculate;
        LinearLayout llmain;

      edtweight=findViewById(R.id.edtWeight);
      edtheightFt=findViewById(R.id.edtheightft);
      edtheightIn=findViewById(R.id.edtHeightIn);
      txtresult=requireViewById(R.id.textresult);
      btncalculate=findViewById(R.id.btnbmi);
llmain=findViewById(R.id.llmain);
  btncalculate.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          int wt=Integer.parseInt(edtweight.getText().toString());
          int ft=Integer.parseInt(edtheightFt.getText().toString());
          int in=Integer.parseInt(edtheightIn.getText().toString());

          int totalIn=ft*12 +in;
          double totalcm=totalIn*2.53;
          double totalm=totalcm/100;
          double bmi=wt/(totalm*totalm);

          if (bmi > 25) {
              Toast.makeText(MainActivity.this, "You're Overweight!", Toast.LENGTH_SHORT).show();
              llmain.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colarOv));
          } else if (bmi < 18) {
              Toast.makeText(MainActivity.this, "You're Underweight!", Toast.LENGTH_SHORT).show();              llmain.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colarUn));
          } else {
              Toast.makeText(MainActivity.this, "You're Healthy!", Toast.LENGTH_SHORT).show();
              llmain.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colarHe));
          }

      }
  });

}
}