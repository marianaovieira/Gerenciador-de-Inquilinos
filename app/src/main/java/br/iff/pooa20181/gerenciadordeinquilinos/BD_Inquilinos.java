package br.iff.pooa20181.gerenciadordeinquilinos;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class BD_Inquilinos extends RealmObject implements Serializable {

    @PrimaryKey
    private int id;
    private String nome_locador;
    private String sobrenome_locador;
    private String email_locador;


    public BD_Inquilinos() {

    }


    public BD_Inquilinos(int id, String nome_locador, String sobrenome_locador, String email_locador) {
        this.id = id;
        this.nome_locador = nome_locador;
        this.sobrenome_locador = sobrenome_locador;
        this.email_locador = email_locador;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_locador() {
        return nome_locador;
    }

    public void setNome_locador(String nome_locador) {
        this.nome_locador = nome_locador;
    }

    public String getSobrenome_locador() {
        return sobrenome_locador;
    }

    public void setSobrenome_locador(String sobrenome_locador) {
        this.sobrenome_locador = sobrenome_locador;
    }

    public String getEmail_locador() {
        return email_locador;
    }

    public void setEmail_locador(String email_locador) {
        this.email_locador = email_locador;
    }



}
