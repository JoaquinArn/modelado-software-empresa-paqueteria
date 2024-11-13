package aed;

import java.util.ArrayList;

public class EstadisticasCiudades {
    int[] ganancias;
    int[] perdidas;
    ArrayList<Integer> masLucrativas;
    ArrayList<Integer> menosLucrativas;
    int gananciaMaxima;
    int perdidaMaxima;
    Tupla amountAndProfitDespachos;
    
public EstadisticasCiudades(int[] ganancias, int[] perdidas, ArrayList<Integer> masLucrativas, ArrayList<Integer> menosLucrativas, int gananciaMaxima, int perdidaMaxima, Tupla amountAndProfitDespachos){
    this.ganancias = ganancias;
    this.perdidas = perdidas;
    this.masLucrativas = masLucrativas;
    this.menosLucrativas = menosLucrativas;
    this.gananciaMaxima = gananciaMaxima;
    this.perdidaMaxima = perdidaMaxima;
    this.amountAndProfitDespachos = amountAndProfitDespachos;

}


     
}