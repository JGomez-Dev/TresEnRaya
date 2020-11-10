package com.example.tresenraya;

import androidx.appcompat.app.AppCompatActivity;

public class logicaTresEnraya extends AppCompatActivity {
    boolean hecho;
    int num;
    int [] tablero  = new int[9];

    //La clase tendrá un constructor que inicializará el array y pondrá todas las posiciones a 0
    public logicaTresEnraya(){
        for(int i = 0; i<tablero.length;i++){
            tablero[i] = 0;
        }
    }

    //void MueveJugador1(int pos), al que le pasamos la posición (un número del 1 al 9) que representa una casilla.
    // El método pondrá una X (un 1) en esa posición si es posible.
    public void MueveJugador1(int pos){
        if ((pos>=0 || pos<=9) && (tablero[pos]==0)) {
            tablero[pos]=1;
        }
    }

    public void MueveJugador2(int pos) {
        if ((pos >= 0 || pos <= 9) && (tablero[pos] == 0)) {
			/*Tablero en la posiciÃ³n elegida -1 por ejemplo si el jugador elige la casilla nÃºmero 1 metera un 2 en la
			  posiciÃ³n 0 del array,esto se debe a que el enunciado pide que el jugador deberÃ¡ meter un nÃºmero entre 1 y 9.*/
            tablero[pos] = 2;

        }
    }

    //boolean MovimientoValido(int pos), el método devolverá true si el movimiento es válido y false si no se puede realizar (la casilla ya está ocupada).
    public boolean MovimientoValido(int pos) {
        //Varibale booleana un movimiento siempre serÃ¡ valido mientras se demuestre lo contrario.
        boolean MovimientoValido=true;
        //Con este condicional evaluo si la posicion elegida por el jugador es valida.
        if ((pos>=0 || pos<=9) && (tablero[pos]==0)) {
			/*Si 'pos' esta entre los valores y la posicion del tablero es 0 retornara MovimientoValido = true es decir le dira al
			programa principal que el movmiento se puede realizar.*/
            MovimientoValido=true;
            return MovimientoValido;
        }
        else {
			/*Si 'pos' esta entre los valores y la posiciÃ³n del tablero no es 0 retornara MovimientoValido = false es decir le dirÃ¡ al
			programa principal que el movmiento no se puede realizar.*/
            MovimientoValido=false;
        }
        return MovimientoValido;
    }

    //void MueveOrdenador2(), el ordenador pondrá un O (un 2) donde el crea que es mejor (de  forma aleatoria usando Math.Random()).
    public int MueveOrdenador2() {
        num=0;
        hecho = false;
        //Ataque
        if(hecho==false && (tablero[0] == 2) && (tablero[1] == 2) && (tablero[2] == 0)) {tablero[2] = 2;num=2;hecho=true;}
        else if(hecho==false && (tablero[3] == 2) && (tablero[4] == 2) && (tablero[5] == 0)) {tablero[5] = 2;num=5;hecho=true;}
        else if(hecho==false && (tablero[6] == 2) && (tablero[7] == 2) && (tablero[8] == 0)) {tablero[8] = 2;num=8;hecho=true;}
        else if(hecho==false && (tablero[0] == 2) && (tablero[3] == 2) && (tablero[6] == 0)) {tablero[6] = 2;num=6;hecho=true;}
        else if(hecho==false && (tablero[1] == 2) && (tablero[4] == 2) && (tablero[7] == 0)) {tablero[7] = 2;num=7;hecho=true;}
        else if(hecho==false && (tablero[2] == 2) && (tablero[5] == 2) && (tablero[8] == 0)) {tablero[8] = 2;num=8;hecho=true;}
        else if(hecho==false && (tablero[0] == 2) && (tablero[4] == 2) && (tablero[8] == 0)) {tablero[8] = 2;num=8;hecho=true;}
        else if(hecho==false && (tablero[2] == 2) && (tablero[4] == 2) && (tablero[6] == 0)) {tablero[6] = 2;num=6;hecho=true;}
        else if(hecho==false && (tablero[2] == 2) && (tablero[1] == 2) && (tablero[0] == 0)) {tablero[0] = 2;num=0;hecho=true;}
        else if(hecho==false && (tablero[5] == 2) && (tablero[4] == 2) && (tablero[3] == 0)) {tablero[3] = 2;num=3;hecho=true;}
        else if(hecho==false && (tablero[8] == 2) && (tablero[7] == 2) && (tablero[6] == 0)) {tablero[6] = 2;num=6;hecho=true;}
        else if(hecho==false && (tablero[6] == 2) && (tablero[3] == 2) && (tablero[0] == 0)) {tablero[0] = 2;num=0;hecho=true;}
        else if(hecho==false && (tablero[7] == 2) && (tablero[4] == 2) && (tablero[1] == 0)) {tablero[1] = 2;num=1;hecho=true;}
        else if(hecho==false && (tablero[8] == 2) && (tablero[5] == 2) && (tablero[2] == 0)) {tablero[2] = 2;num=2;hecho=true;}
        else if(hecho==false && (tablero[6] == 2) && (tablero[4] == 2) && (tablero[2] == 0)) {tablero[2] = 2;num=2;hecho=true;}
        else if(hecho==false && (tablero[8] == 2) && (tablero[4] == 2) && (tablero[0] == 0)) {tablero[0] = 2;num=0;hecho=true;}
        else if(hecho==false && (tablero[0] == 2) && (tablero[2] == 2) && (tablero[1] == 0)) {tablero[1] = 2;num=1;hecho=true;}
        else if(hecho==false && (tablero[3] == 2) && (tablero[5] == 2) && (tablero[4] == 0)) {tablero[4] = 2;num=4;hecho=true;}
        else if(hecho==false && (tablero[6] == 2) && (tablero[8] == 2) && (tablero[7] == 0)) {tablero[7] = 2;num=7;hecho=true;}
        else if(hecho==false && (tablero[0] == 2) && (tablero[6] == 2) && (tablero[3] == 0)) {tablero[3] = 2;num=3;hecho=true;}
        else if(hecho==false && (tablero[1] == 2) && (tablero[7] == 2) && (tablero[4] == 0)) {tablero[4] = 2;num=4;hecho=true;}
        else if(hecho==false && (tablero[2] == 2) && (tablero[8] == 2) && (tablero[5] == 0)) {tablero[5] = 2;num=5;hecho=true;}
        else if(hecho==false && (tablero[0] == 2) && (tablero[8] == 2) && (tablero[4] == 0)) {tablero[4] = 2;num=4;hecho=true;}
        else if(hecho==false && (tablero[6] == 2) && (tablero[2] == 2) && (tablero[4] == 0)) {tablero[4] = 2;num=4;hecho=true;}
        //Defensa
        if(hecho==false && (tablero[0] == 1) && (tablero[1] == 1) && (tablero[2] == 0)) {tablero[2] = 2;num=2;hecho=true;}
        else if(hecho==false &&(tablero[3] == 1) && (tablero[4] == 1) && (tablero[5] == 0)) {tablero[5] = 2;num=5;hecho=true;}
        else if(hecho==false &&(tablero[6] == 1) && (tablero[7] == 1) && (tablero[8] == 0)) {tablero[8] = 2;num=8;hecho=true;}
        else if(hecho==false &&(tablero[0] == 1) && (tablero[3] == 1) && (tablero[6] == 0)) {tablero[6] = 2;num=6;hecho=true;}
        else if(hecho==false &&(tablero[1] == 1) && (tablero[4] == 1) && (tablero[7] == 0)) {tablero[7] = 2;num=7;hecho=true;}
        else if(hecho==false &&(tablero[2] == 1) && (tablero[5] == 1) && (tablero[8] == 0)) {tablero[8] = 2;num=8;hecho=true;}
        else if(hecho==false &&(tablero[0] == 1) && (tablero[4] == 1) && (tablero[8] == 0)) {tablero[8] = 2;num=8;hecho=true;}
        else if(hecho==false &&(tablero[2] == 1) && (tablero[4] == 1) && (tablero[6] == 0)) {tablero[6] = 2;num=6;hecho=true;}
        else if(hecho==false &&(tablero[2] == 1) && (tablero[1] == 1) && (tablero[0] == 0)) {tablero[0] = 2;num=0;hecho=true;}
        else if(hecho==false &&(tablero[5] == 1) && (tablero[4] == 1) && (tablero[3] == 0)) {tablero[3] = 2;num=3;hecho=true;}
        else if(hecho==false &&(tablero[8] == 1) && (tablero[7] == 1) && (tablero[6] == 0)) {tablero[6] = 2;num=6;hecho=true;}
        else if(hecho==false &&(tablero[6] == 1) && (tablero[3] == 1) && (tablero[0] == 0)) {tablero[0] = 2;num=0;hecho=true;}
        else if(hecho==false &&(tablero[7] == 1) && (tablero[4] == 1) && (tablero[1] == 0)) {tablero[1] = 2;num=1;hecho=true;}
        else if(hecho==false &&(tablero[8] == 1) && (tablero[5] == 1) && (tablero[2] == 0)) {tablero[2] = 2;num=2;hecho=true;}
        else if(hecho==false &&(tablero[6] == 1) && (tablero[4] == 1) && (tablero[2] == 0)) {tablero[2] = 2;num=2;hecho=true;}
        else if(hecho==false &&(tablero[8] == 1) && (tablero[4] == 1) && (tablero[0] == 0)) {tablero[0] = 2;num=0;hecho=true;}
        else if(hecho==false &&(tablero[0] == 1) && (tablero[2] == 1) && (tablero[1] == 0)) {tablero[1] = 2;num=1;hecho=true;}
        else if(hecho==false &&(tablero[3] == 1) && (tablero[5] == 1) && (tablero[4] == 0)) {tablero[4] = 2;num=4;hecho=true;}
        else if(hecho==false &&(tablero[6] == 1) && (tablero[8] == 1) && (tablero[7] == 0)) {tablero[7] = 2;num=7;hecho=true;}
        else if(hecho==false &&(tablero[0] == 1) && (tablero[6] == 1) && (tablero[3] == 0)) {tablero[3] = 2;num=3;hecho=true;}
        else if(hecho==false &&(tablero[1] == 1) && (tablero[7] == 1) && (tablero[4] == 0)) {tablero[4] = 2;num=4;hecho=true;}
        else if(hecho==false &&(tablero[2] == 1) && (tablero[8] == 1) && (tablero[5] == 0)) {tablero[5] = 2;num=5;hecho=true;}
        else if(hecho==false &&(tablero[0] == 1) && (tablero[8] == 1) && (tablero[4] == 0)) {tablero[4] = 2;num=4;hecho=true;}
        else if(hecho==false &&(tablero[6] == 1) && (tablero[2] == 1) && (tablero[4] == 0)) {tablero[4] = 2;num=4;hecho=true;}

        //Mientras el tablero tenga alguna posicion con un 0 buscara una casilla aleatoriamente y cambiara¡ el valor a 2.
        if(hecho==false) {
            num = (int) (9 * Math.random());
            while (tablero[num] != 0) {
                num = (int) (9 * Math.random());
            }
            tablero[num] = 2;
        }
        return num;
    }

    //Reinicia el array se usa desde la clase Mainactivity
    public void iniciar(){
        for (int i=0;i<tablero.length;i++) {
            tablero[i]=0;
        }
    }

    //boolean QuedanMovimientos(), nos dice si todavía quedan casillas libres para seguir jugando.
    public boolean QuedanMovimientos() {
        //Quedaran movimientos a no ser que se demuestre lo contrario.
        boolean QuedanMovimientos=true;
        //Este bucle for recorrera el "tablero" de juego es decir el array en busca de una casilla con valor 0.
        for (int i=0;i<tablero.length;i++) {
            //Si la encuentra entrara en este If y mantendra el valor de QuedanMovimientos como true.
            if (tablero[i]==0) {
                QuedanMovimientos=true;
                return QuedanMovimientos;
            }
            //Si no encuentra ningun 0 la partida habra terminado. Y cambiara el valor de QuedanMovimientos como false.
            else
                QuedanMovimientos=false;
        }
        return QuedanMovimientos;
    }

    //boolean GanaJugador1(), nos devuelve true si hay tres X (1) en línea
    public boolean GanaJugador1() {
        boolean GanaJugador1=false;
        if ( (tablero[0] == tablero[1]) && (tablero[1] == tablero[2]) && (tablero[0]==1)) { GanaJugador1=true; }
        else if ( (tablero[3] == tablero[4]) && (tablero[4] == tablero[5]) && (tablero[3]==1))  { GanaJugador1=true; }
        else if ( (tablero[6] == tablero[7]) && (tablero[7] == tablero[8]) && (tablero[6]==1))  { GanaJugador1=true; }
        else if ( (tablero[0] == tablero[3]) && (tablero[3] == tablero[6]) && (tablero[0]==1))  { GanaJugador1=true; }
        else if ( (tablero[1] == tablero[4]) && (tablero[4] == tablero[7]) && (tablero[1]==1))  { GanaJugador1=true; }
        else if ( (tablero[2] == tablero[5]) && (tablero[5] == tablero[8]) && (tablero[2]==1))  { GanaJugador1=true; }
        else if ( (tablero[0] == tablero[4]) && (tablero[4] == tablero[8]) && (tablero[0]==1))  { GanaJugador1=true; }
        else if ( (tablero[2] == tablero[4]) && (tablero[4] == tablero[6]) && (tablero[2]==1))  { GanaJugador1=true; }
        return GanaJugador1;
    }

    //boolean GanaJugador2(), nos devuelve true si hay tres O (2) en línea.
    public boolean GanaJugador2() {
        boolean GanaJugador2=false;
        if ( (tablero[0] == tablero[1]) && (tablero[1] == tablero[2]) && (tablero[0]==2)) { GanaJugador2=true; }
        else if ( (tablero[3] == tablero[4]) && (tablero[4] == tablero[5]) && (tablero[3]==2))  { GanaJugador2=true; }
        else if ( (tablero[6] == tablero[7]) && (tablero[7] == tablero[8]) && (tablero[6]==2))  { GanaJugador2=true; }
        else if ( (tablero[0] == tablero[3]) && (tablero[3] == tablero[6]) && (tablero[0]==2))  { GanaJugador2=true; }
        else if ( (tablero[1] == tablero[4]) && (tablero[4] == tablero[7]) && (tablero[1]==2))  { GanaJugador2=true; }
        else if ( (tablero[2] == tablero[5]) && (tablero[5] == tablero[8]) && (tablero[2]==2))  { GanaJugador2=true; }
        else if ( (tablero[0] == tablero[4]) && (tablero[4] == tablero[8]) && (tablero[0]==2))  { GanaJugador2=true; }
        else if ( (tablero[2] == tablero[4]) && (tablero[4] == tablero[6]) && (tablero[2]==2))  { GanaJugador2=true; }
        return GanaJugador2;
    }

}
