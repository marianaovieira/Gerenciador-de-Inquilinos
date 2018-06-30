package br.iff.pooa20181.gerenciadordeinquilinos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class Cadastro_Inquilino extends AppCompatActivity {

    EditText nome_locador, sobrenome_locador, email_locador;
    Button btsalvar,btalterar, btdeletar;

    int id;
    BD_Inquilinos bd_inquilinos;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro__inquilino);

        nome_locador = (EditText) findViewById(R.id.txtNome_locador);
        sobrenome_locador = (EditText) findViewById(R.id.txtSobrenome_locador);
        email_locador = (EditText) findViewById(R.id.txtEmail_locador);

        btsalvar = (Button) findViewById(R.id.btnSalvar_Inquilino);
        btalterar = (Button) findViewById(R.id.btnAlterar_Inquilino);
        btdeletar = (Button) findViewById(R.id.btnExcluir_Inquilino);

        Intent intent    = getIntent();
        id = (int) intent.getSerializableExtra("id");
        realm = Realm.getDefaultInstance();

        if (id !=0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);

            bd_inquilinos = realm.where(BD_Inquilinos.class).equalTo("id",id).findFirst();

            nome_locador.setText(bd_inquilinos.getNome_locador());
            sobrenome_locador.setText(bd_inquilinos.getSobrenome_locador());
            email_locador.setText(bd_inquilinos.getEmail_locador());

        }else{
            btalterar.setEnabled(false);
            btalterar.setClickable(false);
            btalterar.setVisibility(View.INVISIBLE);
            btdeletar.setEnabled(false);
            btdeletar.setClickable(false);
            btdeletar.setVisibility(View.INVISIBLE);

        }



        btsalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });
        btalterar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                alterar();
            }
        });
        btdeletar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                deletar();
            }
        });


    }

    public void deletar(){
        realm.beginTransaction();
        bd_inquilinos.deleteFromRealm();
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Inquilino deletado",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void salvar() {


        int proximoID = 1;
        if(realm.where(BD_Inquilinos.class).max("id") !=null)
            proximoID = realm.where(BD_Inquilinos.class).max("id").intValue()+1;

        realm.beginTransaction();
        BD_Inquilinos bd_inquilinos = new BD_Inquilinos();
        bd_inquilinos.setId(proximoID);
        bd_inquilinos.setNome_locador(nome_locador.getText().toString());
        bd_inquilinos.setSobrenome_locador(sobrenome_locador.getText().toString());
        bd_inquilinos.setEmail_locador(email_locador.getText().toString());

        realm.copyToRealm(bd_inquilinos);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Inquilino Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void alterar() {

        realm.beginTransaction();

        bd_inquilinos.setNome_locador(nome_locador.getText().toString());
        bd_inquilinos.setSobrenome_locador(sobrenome_locador.getText().toString());
        bd_inquilinos.setEmail_locador(email_locador.getText().toString());

        realm.copyToRealm(bd_inquilinos);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Inquilino Alterado",Toast.LENGTH_LONG).show();
        this.finish();

    }
    }

