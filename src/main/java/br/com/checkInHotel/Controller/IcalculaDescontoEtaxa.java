package br.com.checkInHotel.Controller;

import br.com.checkInHotel.Model.ListaReservas;

public interface IcalculaDescontoEtaxa {
    double simples = 180;
    double luxo = 350;
    double presidencial = 800;
    double calcularDesconto(ListaReservas l);
    double calcularTaxa(ListaReservas l);
    void calcularPrecoPorNoite(ListaReservas l);

}
