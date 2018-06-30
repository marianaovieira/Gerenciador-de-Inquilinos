package br.iff.pooa20181.gerenciadordeinquilinos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnInquilino = (Button) findViewById(R.id.btn_Cadastro_Inq);

        btnInquilino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Inquilinos.class);
                startActivity(intent);

            }
        });
    }

    private Context getContext(){
        return this;
    }

}

