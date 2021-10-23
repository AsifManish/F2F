package com.example.sendotp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RequestQueue queue;
    EditText ed1;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Instantiate the RequestQueue.
       queue = Volley.newRequestQueue(this);
       ed1=findViewById(R.id.editTextPhone);
       btn=findViewById(R.id.button);
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Random random=new Random();
               int otp=random.nextInt(1000000);
               String msg="Your One Time Password is " +otp;
               String autoread=" Ahr/5d/5hr0";
               String mobile=ed1.getText().toString();
               String url ="http://Yourapihere="+mobile+"&sms="+msg+autoread+"&templateid=templateiidhere";
               StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                       new Response.Listener<String>() {
                           @Override
                           public void onResponse(String response) {
                               Toast.makeText(getApplicationContext(), ""+response, Toast.LENGTH_SHORT).show();
                           }
                       }, new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                   }
               });

// Add the request to the RequestQueue.
               queue.add(stringRequest);

           }
       });

// Request a string response from the provided URL.


    }
}