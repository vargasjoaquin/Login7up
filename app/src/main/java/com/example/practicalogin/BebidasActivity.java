package com.example.practicalogin;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class BebidasActivity extends AppCompatActivity {

    private VideoView vv1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);
       vv1=findViewById(R.id.vv1);

       vv1.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video));

        MediaController mc = new MediaController(this);
        vv1.setMediaController(mc);
        mc.setAnchorView(vv1);

       vv1.start();

    }
}
