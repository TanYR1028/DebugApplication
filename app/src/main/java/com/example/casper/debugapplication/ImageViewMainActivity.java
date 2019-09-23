package com.example.casper.debugapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageViewMainActivity extends AppCompatActivity {

    private Button buttonPrevious ,buttonNext;
    private ImageView imageViewFunny ;
    private int[] imageIDArray = {R.drawable.funny_1, R.drawable.funny_2
            , R.drawable.funny_3, R.drawable.funny_4, R.drawable.funny_5
            , R.drawable.funny_6
    };
    private int imageIDArrayCurrentIndex;
   //需要一个无参的构造函数启动程序
    public ImageViewMainActivity() {
        imageIDArrayCurrentIndex = 0;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_main);

        buttonPrevious = (Button)findViewById(R.id.button_previous);
        buttonNext =(Button) findViewById(R.id.button_next);
        imageViewFunny = (ImageView)findViewById(R.id.image_view_funny);

        buttonNext. setOnClickListener(new MyButtonClickListener());
        buttonPrevious.setOnClickListener(new MyButtonClickListener());
    }

    private class MyButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (((Button) view).getText() == "下一个") {
                imageIDArrayCurrentIndex = (imageIDArrayCurrentIndex + 1) % imageIDArray.length;
            } else {
                imageIDArrayCurrentIndex = (imageIDArrayCurrentIndex + imageIDArray.length - 1) % imageIDArray.length;
            }
            if(imageIDArrayCurrentIndex==-1)imageIDArrayCurrentIndex=5;
            Log.d("tan","OnClick:"+imageIDArrayCurrentIndex);
            imageViewFunny.setImageResource(imageIDArray[imageIDArrayCurrentIndex]);
        }
    }
}
