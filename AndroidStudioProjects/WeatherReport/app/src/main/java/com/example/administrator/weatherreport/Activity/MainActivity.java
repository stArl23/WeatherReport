package com.example.administrator.weatherreport.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.administrator.weatherreport.Model.Response;
import com.example.administrator.weatherreport.Model.Weather;
import com.example.administrator.weatherreport.NetUtils.HandleResponse;
import com.example.administrator.weatherreport.NetUtils.HttpUtils;
import com.example.administrator.weatherreport.R;
import com.example.administrator.weatherreport.Utils.JsonParse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String address1 ="http://www.sojson.com/open/api/weather/json.shtml?city=";
    String test="http://www.sojson.com/open/api/weather/json.shtml?city=杭州";
    String place="杭州";
    Response response1;
    Button cityManagement;
    Button fresh;
    TextView[] textViews=new TextView[9];
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected  void onStart(){
        super.onStart();
        Bundle bundle=getIntent().getExtras();
        String cityName=bundle!=null&&bundle.get("cityName")!=null?
                (String) bundle.get("cityName"):new String("该城市不存在");
        if(!cityName.equals("该城市不存在"))place=cityName;


        try {
            getData();
            Thread.sleep(1000);
            putData();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        textViews[0] = (TextView) this.findViewById(R.id.date);
        textViews[1] = (TextView) this.findViewById(R.id.high);
        textViews[2] = (TextView) this.findViewById(R.id.fengxiang);
        textViews[3] = (TextView) this.findViewById(R.id.low);
        textViews[4] = (TextView) this.findViewById(R.id.fengli);
        textViews[5] = (TextView) this.findViewById(R.id.type);
        textViews[6] = (TextView) this.findViewById(R.id.ganmao);
        textViews[7] = (TextView) this.findViewById(R.id.wendu);
        textViews[8]=(TextView)this.findViewById(R.id.city);
        listView=(ListView) this.findViewById(R.id.listView);
        cityManagement=(Button) this.findViewById(R.id.button3);
        fresh=(Button)this.findViewById(R.id.button2);

        cityManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CityActivity.class);
                intent.putExtra("cityName",place);
                MainActivity.this.startActivity(intent);
            }
        });

        fresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.onStart();
            }
        });
    }
    private void getData(){
        final String address=address1 +place;
        HttpUtils.setHttpRequest(address, new HandleResponse() {
            @Override
            public void onFinish(String response) {
                response1= JsonParse.readWeather(response);
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e.getStackTrace());
                response1=new Response();
                response1.setStatus("500");
            }
        });
    }

    private void putData(){
        if(response1!=null&&response1.getStatus().equals("200")) {
            Weather[] weathers = response1.getData().getForecast();
            textViews[0].setText(weathers[0].getDate());
            textViews[1].setText(weathers[0].getHigh());
            textViews[2].setText(weathers[0].getFengxiang());
            textViews[3].setText(weathers[0].getLow());
            textViews[4].setText(weathers[0].getFengli());
            textViews[5].setText(weathers[0].getType());
            textViews[6].setText(response1.getData().getGanmao());
            textViews[7].setText(response1.getData().getWendu());
            textViews[8].setText(response1.getData().getCity());

            List<Map<String,String>> listWeather=new ArrayList<Map<String,String>>();
            for(int i=1;i<weathers.length;i++){
                Map<String,String> map=new HashMap<String,String>();
                map.put("date",weathers[i].getDate());
                map.put("high",weathers[i].getHigh());
                map.put("low",weathers[i].getLow());
                map.put("type",weathers[i].getType());
                listWeather.add(map);
            }

            listView.setAdapter(new SimpleAdapter(this.getApplicationContext(),listWeather,R.layout.
                    forecast,new String[]{"date","high","low","type"},
                    new int[]{R.id.date1,R.id.high1,R.id.low1,R.id.type1}));
        }
    }
}
