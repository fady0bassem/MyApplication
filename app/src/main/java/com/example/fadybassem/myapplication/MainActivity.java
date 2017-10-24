package com.example.fadybassem.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Signup();
    }

    private void Signup() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://mannish-alcohols.000webhostapp.com/instructor/webservice.php";
        // Request a string response from the provided URL.;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("_R", "Response is: " + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("_R_SignupFacebook", "That didn't work!" + "\n" + error.toString());
            }
        }) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                String s = "{\"api_name\":\"register_instructor\",\"user_name\":\"mohamed\",\"phone\":\"011483453\",\"email\":\"mohamednasser.dev@gamil.com\"," +
                        "\"password\":\"m123456\",\"gender\":\"m\",\"birth_date\":\"9/5/1996\",\"city\":\"cairo\",\"area\":\"el marg\"}";
                return s.getBytes();
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                /*params.put("api_name", "register_instructor");
                params.put("user_name", "user_name");
                params.put("phone", "011483453");
                params.put("email", "mohamednasser.dev@gamil.com");
                params.put("password", "m123456");
                params.put("gender", "m");
                params.put("birth_date", "9/5/1996");
                params.put("city", "cairo");
                params.put("area", "el marg");*/
                return params;
            }
        };
        // Add the request to the RequestQueue.
        queue.add(stringRequest);


    }
}
