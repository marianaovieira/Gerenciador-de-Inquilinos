package br.iff.pooa20181.gerenciadordeinquilinos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Inquilino_Adapter  extends RecyclerView.Adapter{

    private List<BD_Inquilinos> inquilino;
    private Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public Inquilino_Adapter(List<BD_Inquilinos> inquilino, Context context,ClickRecyclerViewListener clickRecyclerViewListener) {

        this.inquilino = inquilino;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_inquilinos_cv, parent, false);
        InquilinoViewHolder inquilinoViewHolder = new InquilinoViewHolder(view);
        return inquilinoViewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                                 int position) {

        InquilinoViewHolder holder = (InquilinoViewHolder) viewHolder;

        BD_Inquilinos inq  = inquilino.get(position) ;

        holder.nome_locador.setText(inq.getNome_locador());
        holder.sobrenome_locador.setText(inq.getSobrenome_locador());
        holder.email_locador.setText(inq.getEmail_locador());



    }

    @Override
    public int getItemCount() {

        return inquilino.size();
    }

    private void updateItem(int position) {

    }

    // Método responsável por remover um usuário da lista.
    private void removerItem(int position) {

    }

    public class InquilinoViewHolder extends RecyclerView.ViewHolder {

        private final TextView nome_locador;
        private final TextView sobrenome_locador;
        private final TextView email_locador;


        public InquilinoViewHolder(View itemView) {
            super(itemView);
            nome_locador = (TextView) itemView.findViewById(R.id.txtNome_locador);
            sobrenome_locador = (TextView) itemView.findViewById(R.id.txtSobrenome_locador);
            email_locador = (TextView) itemView.findViewById(R.id.txtEmail_locador);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(inquilino.get(getLayoutPosition()));

                }
            });


        }
    }
}
