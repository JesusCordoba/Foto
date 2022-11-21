package com.example.foto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final int img_id = 123;
    ImageView vista_imagen;
    Button btnFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vista_imagen = (ImageView) findViewById(R.id.vista_imagen);
        btnFoto = (Button) findViewById(R.id.btnFoto);
        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // llamar actividad que usara la camara
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // Recibir el resultado de la actividad y mostrarlo por pantalla
                startActivityForResult(camera_intent, img_id);
            }
        });
    }

    // Metodo que recibe la imagen y la procesa para mostrarla
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Comprobar que concuerde la id de la imagen con la recibida en el metodo
        if (requestCode == img_id) {
            // Recibir los datos de la imagen en bitmap
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Mostrar la imagen por pantalla
            vista_imagen.setImageBitmap(photo);
        }
    }
}