package com.example.administrator.weatherreport.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.weatherreport.R;

public class CityActivity extends AppCompatActivity {

    TextView cityName;
    EditText getCityName;
    Button search;
    String cityName1="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        init();
    }

    @Override
    protected  void onStart(){
        super.onStart();
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)cityName1=(String) bundle.get("cityName");
        if(cityName1!="该城市不存在")
            cityName.setText(cityName1);
        else
            cityName.setText("");
    }

    private void init(){
        cityName=(TextView) this.findViewById(R.id.cityName);
        search=(Button)this.findViewById(R.id.search);
        getCityName=(EditText)this.findViewById(R.id.getCityName);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getCityName.getText().toString()!=null){
                    Intent intent=new Intent(CityActivity.this,MainActivity.class);
                    intent.putExtra("cityName",getCityName.getText().toString());
                    CityActivity.this.startActivity(intent);
                }
            }
        });
    }
}
