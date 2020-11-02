package com.xy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tvTitle;       //静态文本框
    private TextView tvResult;
    private EditText editInput;     //定义文本框
    private Button btnC2F;          //定义按钮
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = (TextView)findViewById(R.id.tv_title);
        tvResult = (TextView)findViewById(R.id.tv_result);
        editInput = (EditText) findViewById(R.id.value_hint);
        btnC2F = (Button)findViewById(R.id.celsius_to_fahren);

        btnC2F.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.celsius_to_fahren:
                outputValue(false);
                break;
            default:
        }
    }

    private boolean checkValidInput(){
        if(editInput.getText().length()==0){
            String errorMsg = getResources().getString(R.string.msg_error_input);
            Toast.makeText(this,errorMsg,Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }
    }
    private void outputValue(boolean isF2C){
            float inputValue = Float.parseFloat(editInput.getText().toString());
                String title = getResources().getString(R.string.celsius);
                title = title + String.valueOf(inputValue);
                title = title + getResources().getString(R.string.fahren);
                tvTitle.setText(title);
                tvResult.setText(String.valueOf(getC2F(inputValue)));

    }
    private float getC2F(float c){
        return (c*1.8f)+32.0f;
    }
}