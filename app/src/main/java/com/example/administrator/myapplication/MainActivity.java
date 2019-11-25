package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity {
    private EditText editText,editText2;
    private Button button;
    private String  ResultObj, AccessToken;
    private TextView textView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        textView5=findViewById(R.id.textView5);
        button=findViewById(R.id.button);
    }

    public void click(View view)
    {
        Thread t=new Thread(r);
        t.start();
    }

    Runnable r=new Runnable() {
        @Override
        public void run() {
            String e1=editText.getText().toString();
            String e2=editText2.getText().toString();
            try {
                String SERVER_URL="http://api.nlecloud.com/Users/Login";
                URL url=new URL(SERVER_URL);
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("connection","Keep-Alive");
                connection.setRequestProperty("Charset","UTF-8");
                connection.setRequestProperty("Content-Type","application/json");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                OutputStream outputStream=connection.getOutputStream();
                UserBeen userBeen=new UserBeen();
                userBeen.setAccount(e1);
                userBeen.setPassword(e2);
                userBeen.setIsRememberMe(true);
                Gson gson=new Gson();
                String jsonStr=gson.toJson(userBeen);
                outputStream.write(jsonStr.getBytes());
                outputStream.flush();
                outputStream.close();
                Message msg=new Message();
                if(connection.getResponseCode()==HttpURLConnection.HTTP_OK)
                {
                    InputStream in=connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    String result = reader.readLine();
                    JSONObject jsonObject=new JSONObject(result);
                    ResultObj = jsonObject.getString("ResultObj");
                    JSONObject jsonObject1 = new JSONObject(ResultObj);
                    AccessToken = jsonObject1.getString("AccessToken");
                    msg.what = 1;
                    msg.obj=AccessToken ;
                    handler.sendMessage(msg);
                }
                else
                {
                    msg.what=2;
                    handler.sendMessage(msg);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    };

    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch(msg.what){
                case 1:
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,Main2Activity.class);
                    intent.putExtra("Token",AccessToken);
                    startActivity(intent);
                    textView5.setText(msg.obj.toString());
                    break;
                case 2:
                    Toast.makeText(MainActivity.this, "账号或密码错误！", Toast.LENGTH_SHORT).show();
                    textView5.setText(msg.obj.toString());
                    break;
            }
        }

    };
}
