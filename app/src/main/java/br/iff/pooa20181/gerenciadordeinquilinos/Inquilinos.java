package br.iff.pooa20181.gerenciadordeinquilinos;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;


import java.util.List;

import io.realm.Realm;


public class Inquilinos extends AppCompatActivity implements ClickRecyclerViewListener{

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquilinos);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Inquilinos.this, Cadastro_Inquilino.class);
                intent.putExtra("id", 0);
                startActivity(intent);
            }
        });


    }

    private List<BD_Inquilinos> getInquilinos(){

        return (List)realm.where(BD_Inquilinos.class).findAll();

    }

    @Override
    public void onClick(Object object) {
        BD_Inquilinos inquilino = (BD_Inquilinos) object;
        Intent intent = new Intent(Inquilinos.this,Cadastro_Inquilino.class);
        intent.putExtra("id",inquilino.getId());
        startActivity(intent);

    }

    protected void onResume(){
        super.onResume();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_Inquilinos);

        recyclerView.setAdapter(new Inquilino_Adapter(getInquilinos(),this,this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);


    }


    @Override
    public void finish(){
        realm.close();

    }
}