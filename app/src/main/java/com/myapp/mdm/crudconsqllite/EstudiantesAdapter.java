package com.myapp.mdm.crudconsqllite;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.myapp.mdm.crudconsqllite.entidades.Estudiante;
import com.myapp.mdm.crudconsqllite.utilidades.utilidades;

import java.util.ArrayList;

public class EstudiantesAdapter extends  RecyclerView.Adapter<EstudiantesAdapter.MyViewHolder >{
    private ArrayList<Estudiante> Estudiante ;
    private ArrayAdapter<Estudiante> arrayAdapter;
    private Context context=null;


    public EstudiantesAdapter(ArrayList<Estudiante> Estudiante, Context context) {
        this.Estudiante = Estudiante;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Log.e("POSITION : ", "CREO FILA");
        View view =LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.row_reciclerview,viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        final  Estudiante estudiante=(Estudiante) Estudiante.get(i);
        myViewHolder.tvNombre.setText(estudiante.getNombre());
        myViewHolder.tvappAterno.setText(estudiante.getApPaterno());
        myViewHolder.tvapMaterno.setText(estudiante.getApMaterno());
        myViewHolder.tvMovil.setText(estudiante.getNumeroMovil());


        // aqui se puede agregar eventos al componente listaview
myViewHolder.cont.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        ModificarEstudianteActivity.position=i;
        Toast.makeText(context, "seleccion de "+estudiante.getNombre()
                , Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(v.getContext(),ModificarEstudianteActivity.class);
        intent.putExtra("nombre",estudiante.getNombre());
        intent.putExtra("app",estudiante.getApPaterno());
        intent.putExtra( "apm", estudiante.getApMaterno());
        intent.putExtra("Movil",estudiante.getNumeroMovil());
        context.startActivity(intent);
    }
});


myViewHolder.btnBorar.setOnClickListener(new View.OnClickListener() {
    ConexionSQL  con = new ConexionSQL(context, "bd_Escuela", null, 1);
    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder =new AlertDialog.Builder(context);
        builder.setMessage("¿Seguro que quieres Eliminarlo  ?");
        builder.setTitle("Borrar");
        builder.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                SQLiteDatabase db=con.getWritableDatabase();
                String[] parametros={myViewHolder.tvNombre.getText().toString()};
                db.delete(utilidades.TABLA_ESTUDIANTE,utilidades.CAMPO_NOMBRE+"=?",parametros);
                Toast.makeText(context," Elimino el usuario",Toast.LENGTH_LONG).show();
                db.close();
                Intent intent = new Intent(
                        context,
                        MainActivity.class
                );
                context.startActivity(intent);

            }
        });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
});

    }

    @Override
    public int getItemCount() {
        return this.Estudiante.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNombre,tvappAterno,tvapMaterno,tvMovil;
        Button btnBorar;
        CardView cont;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvNombre=itemView.findViewById(R.id.tvnombre);
            this.tvappAterno=itemView.findViewById(R.id.tvappAterno);
            this.tvapMaterno=itemView.findViewById(R.id.tvapMaterno);
            this.tvMovil=itemView.findViewById(R.id.tvMovil);
            this.cont=itemView.findViewById(R.id.Contendor);
            this.btnBorar=itemView.findViewById(R.id.btnBorrar);


        }
    }


}
