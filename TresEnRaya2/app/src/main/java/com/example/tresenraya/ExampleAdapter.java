package com.example.tresenraya;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private ArrayList<ExampleItem> mExampleList;//Atributo que contiene la lista de los datos a tratar (objetos de tipo ExampleItem)
    private OnItemClickListener mListener;//Atributo que nos permitira asignar un listener a cada item

    //INTERFAZ dentro de la clase la cual nos obliga a implementar y sobreescribir el metodo OnItemClick
    public interface OnItemClickListener {
        void OnItemClick(int position);//Metodo abstracto que recibe por parametro la posicion del item que ha sido pulsado
    }

    //Metodo SET de la clase Adapter que nos permite asignar un listener
    public void setOnClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    //Metodo CONSTRUCTOR de la clase, que recibe por parametro una lista de Items
    public ExampleAdapter(ArrayList<ExampleItem> exampleList) {
        mExampleList = exampleList;
    }

    @NonNull
    @Override
    //Sobreescribimos el metodo onCreateViewHolder que se va a encargar de asignar a una vista los elementos que contiene la plantilla creada en XML
    //para posteriormente instanciar un objeto de la clase interna ExampleViewHolder, pasandole por parametro la vista anterior y un listener
    //finaliza devolviendo un objeto de tipo exampleViewHolder
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);    //Usamos el método inflate() para crear una vista a partir del layout XML definido en layout_listitem.
        ExampleViewHolder exampleViewHolder=new ExampleViewHolder(v,mListener);

        return exampleViewHolder;
    }

    //Sobreescribimos el metodo onBindViewHolder que recibe por parametro un objeto de tipo ExampleViewHolder y la posicion del item al que
    //debe asociar datos, asocia a una instancia de ExampleItem el objeto de tipo ExampleItem que se encuentra en la posicion que ha recibido
    //por parametro. Por ultimo utiliza el objeto de tipo ExampleViewHolder para acceder a su unico atributo (mImageView) al que establece
    //el recurso que tiene asociado el objeto de la clase ExampleItem (currentItem) del que recibe la posición por parametro
    //El método onBindViewHolder() personaliza un elemento de tipo ViewHolder según su posicion.
    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem nuevaImagen=mExampleList.get(position); //Crea un objeto ExampleItem igual que el objeto que devuelve el metodo mExampleList.get() en su posicion
        holder.mImageView.setImageResource(nuevaImagen.getImageResource());
    }

    //Sobreescribimos el metodo getItemCount que nos devuelve el tamaño de la lista de objetos ExampleItem
    //Este metodo internamente establece la longuitud maxima que tendra la lista
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    //CLASE INTERNA ESTATICA
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;//Atributo de tipo ImageView

        //METODO CONSTRUCTOR de la clase interna ExampleViewHolder que recibe como parametro una instancia de la clase View y un listener ya que
        //al ser una clase estatica de no pasarselo no podria acceder a el listener
        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {

            super(itemView);

            mImageView = itemView.findViewById(R.id.imageView);//Asocia el atributo de la clase al XML (imagen para el tablero)

            itemView.setOnClickListener(new View.OnClickListener() {//Asociamos al objeto itemView el evento OnclickListener

                //Sobreescribimos el metodo onClick que recibe por parametro una instancia de la clase View
                @Override
                public void onClick(View v) {
                    if (listener != null) {//Si el listener que recibimos en el constructor es valido
                        //El adapter es el que sabe la posición absoluta dentro de la vista,
                        int position = getAdapterPosition();//Almacenamos la posicion del elemento que ha activado el evento
                        if (position != RecyclerView.NO_POSITION) {//Si la posición recibida es una posición valida dentro del RecyclerView
                            listener.OnItemClick(position);//Asignamos un listener al Item de la posición que hemos comprobado
                        }
                    }
                }
            });
        }
    }
}

