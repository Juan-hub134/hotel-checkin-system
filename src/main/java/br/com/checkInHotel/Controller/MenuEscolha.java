package br.com.checkInHotel.Controller;

import br.com.checkInHotel.Model.ListaReservas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuEscolha {
    private MenuCadastro reserva = new MenuCadastro();
   private MenuCheking menuCheking = new MenuCheking();

    public MenuCadastro getReserva() {
        return reserva;
    }

    public void escolhaMenu(){
        Scanner sc = new Scanner(System.in);
        String menu = """
                SISTEMA HOTEL
                1 - Cadastrar reserva
                2 - Listar reservas
                3 - Fazer check-in
                4 - Sair
                Escolha:
                """;

        int escolha = 0;
        try {
            while(escolha != 4){
                System.out.println(menu);
                escolha = sc.nextInt();
                if(escolha == 1){
                    reserva.realizarCadastro();
                } else if (escolha == 2) {
                    ListaReservas lista = reserva.getValidarCadastro().getListaReservas();
                    lista.mostrarListaDeReservas();
                }else if(escolha == 3){
                    menuCheking.menuCheking();
                    ValidarCheckIn validarCheckIn = new ValidarCheckIn(menuCheking.getNumeroReserva(),menuCheking.getSenha(),menuCheking.getFormaPagamento());
                    validarCheckIn.validarCheckIn(reserva.getValidarCadastro().getListaReservas());
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Digite um número");
            System.out.println(e.getMessage());
        }
    }
}
