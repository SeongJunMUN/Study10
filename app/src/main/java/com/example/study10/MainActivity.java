package com.example.study10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.study10.R;

public class MainActivity extends AppCompatActivity {
    ImageView imageView, imageView2;
    Button settingButton, closeButton;
    RadioGroup radioGroup;
    RadioButton radioButton, radioButton2;
    EditText input1, input2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        settingButton = findViewById(R.id.settingButton);
        closeButton = findViewById(R.id.closeButton);
        radioGroup = findViewById(R.id.radioGroup);
        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = input1.getText().toString();
                int age = Integer.parseInt(input2.getText().toString());

                Singer singer01 = new Singer(name);
                Singer singer02 = new Singer(age);
                // Singer singer02 = new Singer();
                // singer02.setAge(Integer.parseInt(age));
               /*Toast.makeText(MainActivity.this, "설정저장", Toast.LENGTH_SHORT).show();*/

                String result = "";

                /*if(isNumber(String.valueOf(singer02.age)) == false){
                    Toast.makeText(MainActivity.this, "숫자 입ㄺ", Toast.LENGTH_SHORT).show();
                }*/
                if(radioButton.isChecked() == true && singer01.name.getBytes().length > 0) {
                    result = "입력한 값이 첫번째 Singer 객체에 설정되었습니다.";
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "가수의 이름 : " + singer01.name + "," + "가수의 나이 : " + singer02.age, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else if(radioButton2.isChecked() == true && singer01.name.getBytes().length > 0) {
                    result = "입력한 값이 두번째 Singer 객체에 설정되었습니다.";
                    imageView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "가수의 이름 : " + singer01.name + "," + "가수의 나이 : " + singer02.age , Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else result = "잘못된 접근입니다.";
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /*public static boolean isNumber(String s){
        try{
            Double.parseDouble(s);
                    return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }*/
}

class Singer{
    String name;
    int age;

    //한줄입력으로 name을 출력하기 위한 선언
    public Singer(){

    }
    public Singer(String inName){
        name = inName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Singer(int inAge)
    {
        age = inAge;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}