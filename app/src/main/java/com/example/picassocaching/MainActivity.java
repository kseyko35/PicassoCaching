package com.example.picassocaching;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView img=findViewById(R.id.img);

        Picasso.get().load("http://af.amatis.nl/app_images/aquapark/7/0.jpg")
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(img, new Callback() {
            @Override
            public void onSuccess() {
                Log.d("veri","veri"); // Eğer image daha önce çekilmiş ise client sunucuya gitmeden imageyi kullanıcıya göstermiş olacak
            }

            @Override
            public void onError(Exception e) {

                Picasso.get().load("https://wallpapertag.com/wallpaper/full/2/b/3/118575-full-hd-wallpapers-1920x1200-720p.jpg").into(img); // Eğer image cachelenmemiş ise client sunucuya gidip imageyi cacheleyecek
            }
        });
    }
}
