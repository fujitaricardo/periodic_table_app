package com.fujitalabs.periodic_table;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.squareup.picasso.Picasso;

public class ElementDataActivity extends AppCompatActivity {

    private static final String IMG_BASE_PATH = "file:///android_asset/img/";
    private static final String IMG_EXT = ".jpg";
    public static final String ELEMENT_EXTRA = "element";

    private MaterialToolbar mtAppBar;
    private ImageView ivPhoto;

    private Integer elementId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.elementId = bundle.getInt(ELEMENT_EXTRA);
        }

        if (elementId != null) {
            setViews();
        } else {
            onDestroy();
        }
    }

    private void setViews() {
        setContentView(R.layout.activity_element_data);
        mtAppBar = findViewById(R.id.mt_app_bar);
        ivPhoto = findViewById(R.id.iv_photo);

        mtAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        if (elementId > 1 && elementId < 104) {
            Picasso.get().load(Uri.parse(IMG_BASE_PATH + elementId + IMG_EXT))
                    .fit().into(ivPhoto);
        }
    }
}
