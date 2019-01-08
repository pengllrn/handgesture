package com.example.pengl.demohandnumber;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayResult extends Activity {

    Bitmap bitmap;
    private ImageView imageView;
    private TextView resultTextView;
    private TextView probTextView;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);
        //bundle接受数据
        Bundle bundle = getIntent().getExtras();
        bitmap=(Bitmap) bundle.getParcelable("image");
        ArrayList<String> list=(ArrayList<String>)bundle.get("recognize_result");

        //展示图片
        imageView = (ImageView) findViewById(R.id.display_photo);
        imageView.setImageBitmap(bitmap);
        //展示识别结果
        resultTextView = (TextView) findViewById(R.id.display_result);
        resultTextView.setText("识别结果："+list.get(0));
        probTextView = (TextView) findViewById(R.id.display_prob);
        probTextView.setText("识别概率："+list.get(1));
        //
        layout = (LinearLayout) findViewById(R.id.display_layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }

    public void exitbutton1(View v){
        this.finish();
    }

    public void exitbutton0(View v){
        finish();
    }
}
