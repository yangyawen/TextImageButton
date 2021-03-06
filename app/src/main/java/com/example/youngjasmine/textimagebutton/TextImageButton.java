package com.example.youngjasmine.textimagebutton;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by youngjasmine on 16/3/16.
 */
public class TextImageButton extends FrameLayout {

    private static final String LOG_TAG = "TextImageButton";

    private ImageView imageView;
    private TextView textView;

    public TextImageButton(Context context){
        this(context, null);
    }

    public TextImageButton(Context context, AttributeSet attrs){
        this(context, attrs, 0);
    }

    public TextImageButton(Context context, AttributeSet attrs, int defaultStyle){
        super(context, attrs, android.R.attr.buttonStyle);
        Log.i(LOG_TAG, "构造函数： attrs: "+ attrs + "  defaultStyle: "+defaultStyle);

        imageView = new ImageView(context, attrs, defaultStyle);
        textView = new TextView(context, attrs, defaultStyle);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER);

        this.addView(imageView, params);
        this.addView(textView, params);

        if(imageView.getDrawable() != null){
            textView.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
        }else{
            textView.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.GONE);
        }
    }

    public void setText(CharSequence text){
        textView.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.GONE);

        textView.setText(text);
    }

    public void setImageResource(int resId){
        textView.setVisibility(View.GONE);
        imageView.setVisibility(View.VISIBLE);

        imageView.setImageResource(resId);
    }

    public void setImageDrawable(Drawable drawable){
        textView.setVisibility(View.GONE);
        imageView.setVisibility(View.VISIBLE);

        imageView.setImageDrawable(drawable);
    }
}
