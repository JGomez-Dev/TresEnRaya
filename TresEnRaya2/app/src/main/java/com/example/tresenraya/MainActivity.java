package com.example.tresenraya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    //ATRIBUTOS NECESARIOS RECYCLERVIEW
    private RecyclerView recyclerView;
    private ExampleAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList <ExampleItem> exampleList = new ArrayList<>();

    //BOTONES PARA LOS MODOS DE JUEGO
    private Button BTReset; //Boton para jugar al ultimo modo de juego jugado
    private Switch BTCambio; //Boton que cambia el modo de juego

    //UTILIZADOS EN LA LOGICA DEL JUEGO
    boolean MueveJugador1; // Atributo que se utiliza para determinar cuando el jugador1 ya haya movido.
    private int num; // Atributo que se utiliza para almacenar el numero aleatorio que genera el metodo MueveOrdenador().
    private boolean ganador; // Atributo que se utiliza para cuando hay un ganador
    private boolean empate; // Atributo que se utiliza para cuandoo hay un empate
    private logicaTresEnraya logica; //Atributo que nos permitira acceder a los metodos de la logica del tres en raya

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INSTANCIAMOS ATRIBUTOS UTILIZADOS EN LA LOGICA DEL JUEGO
        logica= new logicaTresEnraya(); //Instanciamos el objeto de la clase LogicaTresEnRaya
        MueveJugador1=true; //Instanciamos la variable MueveJugador1 a true indica que empieza a mover el juegador 1 (x)
        ganador=false; //Instanciamos la variable ganador a false, para indicar que no hay ningun ganador
        empate=false;//Instanciamos la variable empate a false, para indicar que no hay empate

        //VINCULAMOS LOS BOTONES DEL XML A LOS ATRIBUTOS PARA PODER TRABAJAR CON ELLOS
        BTReset=findViewById(R.id.BT1SV1);
        BTCambio=findViewById(R.id.BTCambio);

        //ASOCIAMOS LOS EVENTOS ONCLICK Y ONCHECKED A LOS BOTONES
        BTReset.setOnClickListener(this); //Reinicia el juego
        BTCambio.setOnCheckedChangeListener(this); //Cambia el modo de juego

        //CREAMOS EL TABLERO
        creaTablero();

        //INSTANCIAMOS Y ASOCIAMOS ELEMENTOS NECESARIOS PARA EL CORRECTO FUNCIONAMIENTO DEL RECYCLERVIEW
        recyclerView=findViewById(R.id.recyclerViewXML); //Vinculamos el recyclerview del xml con el de la clase main
        recyclerView.setHasFixedSize(true);// RecyclerView sabe de antemano que su tamaño no depende del contenido del adaptador, entonces omitirá la comprobación de si su tamaño debería cambiar cada vez que se agregue o elimine un elemento del adaptador.(mejora el rendimiento)
        layoutManager=new GridLayoutManager(this,3);//Creamos el layoutManager de tipo GridLayaout que vamos a utilizar
        recyclerView.setLayoutManager(layoutManager);//Asociamos al recyclerView el layoutManager que creamos en el paso anterior
        adapter=new ExampleAdapter(exampleList);//Instanciamos un objeto de tipo Example_Adapter
        recyclerView.setAdapter(adapter);//Vinculamos el adapter al recyclerView

        //Llamamos al metodo setOnClickListener y le introducimos un objeto de tipo ExampleAdapter llamando a su inferfac OnItemClickListener,
        //esta implementa el metodo OnItemClick el cual estamos obligados a implementar puesto que es una interfaz.
        //Basicamente le mete al metodo setOnClickListener la posicion mediante la interface OnItemClickListener.
        adapter.setOnClickListener(new ExampleAdapter.OnItemClickListener () {
            @Override
            public void OnItemClick(int position) {//Metodo OnItemClick de la interfaz OnItemClickListener ( estamos obligados a implementarlo ) --> Ir a la clase ExampleAdapter
                if(BTCambio.isChecked()==false){//Si el boton de dos posiciones no esta check signific jugador vs jugador
                    if (MueveJugador1 == true) { //Cuando la variable MueveJugador1 sea true indica que es turno del jugador 1
                        if (empate == false) { //Si no hay empate sigue el juego
                            if (logica.GanaJugador2() == false || ganador == false) {//Se compureba que el jugador 2 no haya ganado, si no ha ganado sigue el juego
                               //MOVIMIENTO NO VALIDO
                                if (logica.MovimientoValido(position) == false) {//Se comprueba que la posicion que a elegido el jugador es valida es decir que no esta ocupada.
                                    Toast.makeText(MainActivity.this, "Casilla ocupada", Toast.LENGTH_SHORT).show();
                                } else {
                                    logica.MueveJugador1(position); //Si es valida habra llegado aqui y metemos la posicion a la clase logica mediante el metodo MueveJugador1() para que rellene el array colocando en esa posicion un 1
                                    exampleList.get(position).setmImageResource(R.drawable.x);//El metodo nos devuelve la posicion y establece una imagen "circulo" en esta misma.
                                    adapter.notifyItemChanged(position);//Se avisa al adaptador para que avise al recyclerview de que un item a sido cambiado y se le indica la posicion
                                    MueveJugador1 = false; //Jugador1 ya ha movido la variable cambia

                                    //GANA EL JUGADOR 1
                                    if (logica.GanaJugador1() == true) {  //Se comprueba si ha ganado el jugador 1
                                        Toast.makeText(MainActivity.this, "Gana X", Toast.LENGTH_SHORT).show();
                                        iniciar(); //Se reinicia la partida
                                        ganador = true; //Cambia la variable a true para que no siga moviendo el jugador 2
                                    }
                                }
                            }
                        }
                    //TURNO JUGADOR 2
                    } else {
                        if (empate == false) { //Si no hay empeate sigue la partida y mueve el jugador 2
                            if (logica.GanaJugador1() == false || ganador == false) {//Si el juegador 1 no ha ganado.
                                //Se compueba que la posicion es valida

                                //MOVIMIENTO NO VALIDO
                                if (logica.MovimientoValido(position) == false) {//Se comprueba que la posicion que a elegido el jugador es valida es decir que no esta ocupada.
                                    Toast.makeText(MainActivity.this, "Casilla ocupada", Toast.LENGTH_SHORT).show();
                                } else {
                                    logica.MueveJugador2(position);//Si es valida habra llegado aqui y metemos la posicion a la clase logica mediante el metodo MueveJugador2() para que rellene el array colocando en esa posicion un 2
                                    exampleList.get(position).setmImageResource(R.drawable.circulo);//El metodo nos devuelve la posicion y establece una imagen "X" en esta misma
                                    adapter.notifyItemChanged(position);//Se avisa al adaptador de que un item a sido cambiado y se le indica la posicion

                                    MueveJugador1 = true; //Como el juegador 2 ya ha movido vuelve a ser turno del juegador 1

                                    //GANA EL JUGADOR 2
                                    if (logica.GanaJugador2() == true) {//Se comprueba si ha ganado el jugador 1
                                        Toast.makeText(MainActivity.this, "Gana O", Toast.LENGTH_SHORT).show();
                                        iniciar();//Se reinicia la partida
                                        ganador = true; //Cambia la variable a true para que no siga moviendo el jugador 2
                                    }
                                }
                            }
                        }
                    }
                    //EMPATE
                    if (logica.QuedanMovimientos() == false) {//Se comprueba que no quedan posiciones en el array de la clase logica libre eso quiere decir que tenemos un empate
                        Toast.makeText(MainActivity.this, "EMPATE", Toast.LENGTH_SHORT).show();
                        iniciar();
                    }
                //ORDENADOR VS JUGADOR
                }else{  //Si el moton de 2 posicion esta en posicion ON significa que el usuario quiere jugar jugador vs ordenador
                    if (logica.GanaJugador2() == false && ganador == false) {//Se compueba que el Ordenador no haya ganado, si no ha ganado sigue el juego
                        //MOVIMIENTO NO VALIDO
                        if (logica.MovimientoValido(position) == false) {//Se comprueba que el movimiento es valido
                            Toast.makeText(MainActivity.this, "Casilla ocupada", Toast.LENGTH_SHORT).show();
                        } else {
                            logica.MueveJugador1(position); //Si es valida habra llegado aqui y metemos la posicion a la clase logica mediante el metodo MueveJugador1() para que rellene el array colocando en esa posicion un 1
                            exampleList.get(position).setmImageResource(R.drawable.circulo);//El metodo nos devuelve la posicion y establece una imagen "circulo" en esta misma.
                            adapter.notifyItemChanged(position);//Se avisa al adaptador para que avise al recyclerview de que un item a sido cambiado y se le indica la posicion

                            //GANA JUGADOR 1
                            if (logica.GanaJugador1() == true) { //Se comprueba si ha ganado el juegador 1
                                Toast.makeText(MainActivity.this, "Gana Jugador", Toast.LENGTH_SHORT).show();
                                ganador=true;
                                iniciar();
                            }

                            //EMPATE
                            if (logica.QuedanMovimientos() == false) {//Se comprueba que no quedan posiciones en el array de la clase logica libre eso quiere decir que tenemos un empate
                                Toast.makeText(MainActivity.this, "EMPATE", Toast.LENGTH_SHORT).show();
                                iniciar();
                            }

                            //TURNO ORDENADOR
                            if(ganador==false) { //Si no hay ganador significa que es el turno del ordenador
                                num = logica.MueveOrdenador2(); //Se llama al metodo MueveOrdenador2 de la logica, colocara de forma "inteligente"
                                exampleList.get(num).setmImageResource(R.drawable.x); //El metodo nos devuelve la posicion y establece una imagen "X" en esta misma
                                adapter.notifyItemChanged(num); //Se avisa al adaptador de que un item a sido cambiado y se le indica la posicion
                            }
                            //GANA ORDENADOR
                            if (logica.GanaJugador2() == true && ganador == false ) {//Se comprueba si ha ganado el Ordenador
                                Toast.makeText(MainActivity.this, "Gana Ordenador", Toast.LENGTH_SHORT).show();
                                ganador=true;
                                iniciar();
                            }

                            //EMPATE
                            if (logica.QuedanMovimientos() == false) {//Se comprueba que no quedan posiciones en el array de la clase logica libre eso quiere decir que tenemos un empate
                                Toast.makeText(MainActivity.this, "EMPATE", Toast.LENGTH_SHORT).show();
                                iniciar();
                            }
                        }
                    }
                }
            }
        });
    }

    //VOLVER A JUGAR AL ULTIMO MODO  DE JUEGO
    @Override
    public void onClick(View v) {
        if(v.equals(BTReset)){
            iniciar();
        }
    }

    //SE REINICIA LA PARTIDA
    public void iniciar(){
        ganador=false;
        empate=false;
        MueveJugador1 = true;
        num=0;
        logica.iniciar();
        for (int i = 0; i<3*3;i++){//Reinia tdodas las posiciones a un "cuadrado"
            exampleList.get(i).setmImageResource(R.drawable.cuadrado);
            adapter.notifyItemChanged(i); //Se notifica al adapter de que una posicion a cambiado.
        }
        if(BTCambio.isChecked()){ //Jugador vs Ordenador
            quienEmpieza();
        }else{ //Jugador vs Jugador

        }

    }

    //MODO DE JUEGO
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(BTCambio.isChecked()){ //Jugador vs Ordenador
            Toast.makeText(MainActivity.this, "Jugador VS Ordenador", Toast.LENGTH_SHORT).show();
            iniciar(); //Renicia la partida cada vez que se cambia
        }else{ //Jugador vs Jugador
            Toast.makeText(MainActivity.this, "Jugador VS Jugador", Toast.LENGTH_SHORT).show();
            iniciar();
        }


    }
    //QUIEN EMPIEZA
    public void quienEmpieza(){// Se determina si empieza el ordenador o el jugador
        int numero = (int)(Math.random()*2+1);
        if(numero==1){
            MueveJugador1=true;
            Toast.makeText(MainActivity.this, "Empieza  O", Toast.LENGTH_SHORT).show();
        }else{
            MueveJugador1=false;
            Toast.makeText(MainActivity.this, "Empieza  X", Toast.LENGTH_SHORT).show();
            num = logica.MueveOrdenador2();//Se llama al metodo MueveOrdenador2 de la logica, colocara de forma "inteligente"
            exampleList.get(num).setmImageResource(R.drawable.x); //El metodo nos devuelve la posicion y establece una imagen "X" en esta misma
            adapter.notifyItemChanged(num);//Se avisa al adaptador de que un item a sido cambiado y se le indica la posicion
        }
    }

    //CREA EL TABLERO INICIAL
    public void creaTablero(){
        for (int i=0;i<3*3;i++) {
            exampleList.add(new ExampleItem(R.drawable.cuadrado));
        }
    }
}
