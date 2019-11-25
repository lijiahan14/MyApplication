package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main2Activity extends Activity {
    private TextView textView7;
    private String Token;
    private JSONObject jsonObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView7=findViewById(R.id.textView7);
        Intent intent=getIntent();
        Token= intent.getStringExtra("Token");
    }
    public void click1(View view)
    {
        Thread t=new Thread(r1);
        t.start();
    }

    public void click2(View view)
    {
        Thread t=new Thread(r2);
        t.start();
    }

    public void click3(View view)
    {
        Thread t=new Thread(r3);
        t.start();
    }

    public void click4(View view)
    {
        Thread t=new Thread(r4);
        t.start();
    }

    Runnable r1=new Runnable() {
        @Override
        public void run() {
            try {
                URL url = new URL("http://api.nlecloud.com/Cmds?deviceId=62502&apiTag=nl_lamp&AccessToken="+Token);
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                connection.setRequestProperty("Content-Type","application/json");
                connection.setRequestProperty("Connection","Keep-Alive");
                connection.setRequestProperty("Charset","UTF-8");
                 connection.setRequestProperty("AccessToken",Token);
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write("1".getBytes());
                outputStream.flush();
                outputStream.close();
                Message msg=new Message();
                if(connection.getResponseCode()==HttpURLConnection.HTTP_OK)
                {
                    InputStream in=connection.getInputStream();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                    String line;
                    while((line=reader.readLine())!=null) {
                        jsonObject=new JSONObject(line);
                    }
                    msg.what=1;
                    msg.obj=jsonObject;
                    handler.sendMessage(msg);
                } else {
                    msg.what=2;
                    handler.sendMessage(msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    Runnable r2=new Runnable() {
        @Override
        public void run() {
            try {
                URL url = new URL("http://api.nlecloud.com/Cmds?deviceId=62502&apiTag=nl_lamp&AccessToken="+Token);
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                connection.setRequestProperty("Content-Type","application/json");
                connection.setRequestProperty("Connection","Keep-Alive");
                connection.setRequestProperty("Charset","UTF-8");
                connection.setRequestProperty("AccessToken",Token);
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write("0".getBytes());
                outputStream.flush();
                outputStream.close();
                Message msg=new Message();
                if(connection.getResponseCode()==HttpURLConnection.HTTP_OK)
                {
                    InputStream in=connection.getInputStream();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                    String line;
                    while((line=reader.readLine())!=null) {
                        jsonObject=new JSONObject(line);
                    }
                    msg.what=1;
                    msg.obj=jsonObject;
                    handler.sendMessage(msg);
                } else {
                    msg.what=2;
                    handler.sendMessage(msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    Runnable r3=new Runnable() {
        @Override
        public void run() {
            try {
                URL url = new URL("http://api.nlecloud.com/Cmds?deviceId=62502&apiTag=nl_fan&AccessToken="+Token);
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                connection.setRequestProperty("Content-Type","application/json");
                connection.setRequestProperty("Connection","Keep-Alive");
                connection.setRequestProperty("Charset","UTF-8");
                connection.setRequestProperty("AccessToken",Token);
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write("1".getBytes());
                outputStream.flush();
                outputStream.close();
                Message msg=new Message();
                if(connection.getResponseCode()==HttpURLConnection.HTTP_OK)
                {
                    InputStream in=connection.getInputStream();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                    String line;
                    while((line=reader.readLine())!=null) {
                        jsonObject=new JSONObject(line);
                    }
                    msg.what=1;
                    msg.obj=jsonObject;
                    handler.sendMessage(msg);
                } else {
                    msg.what=2;
                    handler.sendMessage(msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    Runnable r4=new Runnable() {
        @Override
        public void run() {
            try {
                URL url = new URL("http://api.nlecloud.com/Cmds?deviceId=62502&apiTag=nl_fan&AccessToken="+Token);
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                connection.setRequestProperty("Content-Type","application/json");
                connection.setRequestProperty("Connection","Keep-Alive");
                connection.setRequestProperty("Charset","UTF-8");
                connection.setRequestProperty("AccessToken",Token);
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write("0".getBytes());
                outputStream.flush();
                outputStream.close();
                Message msg=new Message();
                if(connection.getResponseCode()==HttpURLConnection.HTTP_OK)
                {
                    InputStream in=connection.getInputStream();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                    String line;
                    while((line=reader.readLine())!=null) {
                        jsonObject=new JSONObject(line);
                    }
                    msg.what=1;
                    msg.obj=jsonObject;
                    handler.sendMessage(msg);
                } else {
                    msg.what=2;
                    handler.sendMessage(msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    Runnable r5=new Runnable() {
        @Override
        public void run() {
            try {
                URL url = new URL("http://api.nlecloud.com/devices/deviceId=62502&AccessToken="+Token);
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                connection.setRequestProperty("Content-Type","application/json");
                connection.setRequestProperty("Connection","Keep-Alive");
                connection.setRequestProperty("Charset","UTF-8");
                connection.setRequestProperty("AccessToken",Token);
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write("1".getBytes());
                outputStream.flush();
                outputStream.close();
                Message msg=new Message();
                if(connection.getResponseCode()==HttpURLConnection.HTTP_OK)
                {
                    InputStream in=connection.getInputStream();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                    String line;
                    while((line=reader.readLine())!=null) {
                        jsonObject=new JSONObject(line);
                    }
                    msg.what=1;
                    msg.obj=jsonObject;
                    handler.sendMessage(msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch(msg.what){
                case 1:
                    textView7.setText(msg.obj.toString());
                    break;
            }
        }

    };
}
