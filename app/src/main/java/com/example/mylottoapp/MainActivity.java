package com.example.mylottoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.NumberPicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private NumberPicker numberPicker;
    private Button addButton;
    private Button initButton;
    private Button runButton;
    private Set<Integer> pickerNumberSet = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotto);
        initData();
        addEventListener();
    }

    private void initData() {
        numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(45);

        addButton = findViewById(R.id.addButton);
        initButton = findViewById(R.id.initButton);
        runButton = findViewById(R.id.runButton);

    }

    private void addEventListener() {
        addButton.setOnClickListener(v -> {
            //Log.d("TAG", numberPicker.getValue() + "");
            if(pickerNumberSet.size() <= 5) {
                pickerNumberSet.add(numberPicker.getValue());
            }

        });
        initButton.setOnClickListener(v -> {

        });
        runButton.setOnClickListener(v -> {
//            getRandomNumberTest();
            getRandomNumber();
        });
    }

    private void getRandomNumberTest() {
        // 랜던 숫자를 만들어주는 클래스를 가져온다.
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        while (list.size() < 6) {
            int number = random.nextInt(45) + 1;
            if(list.contains(number)) {
               continue;
            }
            list.add(number);
        }
        Collections.sort(list);
        Log.d("TAG", list.toString());
    }

    private List<Integer> getRandomNumber() {
        ArrayList<Integer> numberList = new ArrayList<>();

        // 사용자 선택한 번호 확인
        Log.d("TAG", pickerNumberSet.toString());

        for (int i = 1; i < 46; i++) {
            if(pickerNumberSet.contains(i)) {
                continue;
            }
            numberList.add(i);
        }
        Collections.shuffle(numberList);
        Log.d("TAG", "number List " + numberList.subList(0, 6).toString());
        return numberList.subList(0, 6);
    }


}