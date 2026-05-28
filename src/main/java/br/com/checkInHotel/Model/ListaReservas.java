package br.com.checkInHotel.Model;

import java.util.ArrayList;
import java.util.List;

public class ListaReservas {
    List<CadastroReservas> listaReservas;
    public ListaReservas() {
        listaReservas = new ArrayList<>();
    }
    public void adicionarReserva(CadastroReservas c) {
        listaReservas.add(c);
    }

    public List<CadastroReservas> getListaReservas() {
        return listaReservas;
    }

    public void mostrarListaDeReservas(){
        if(listaReservas != null && listaReservas.isEmpty()){
            System.out.println("Nenhuma reserva cadastrada.");
        }else {
            for(CadastroReservas c: listaReservas){
                System.out.println(c);
            }
        }
    }
    @Override
    public String toString() {
        return "ListaReservas{" +
                "listaReservas=" + listaReservas+
                '}';
    }
}
