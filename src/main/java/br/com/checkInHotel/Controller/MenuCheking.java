package br.com.checkInHotel.Controller;

import java.util.Scanner;

public class MenuCheking {
    public int getNumeroReserva() {
        return numeroReserva;
    }

    public String getSenha() {
        return senha;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    private int numeroReserva;
    private String senha;
    private String formaPagamento;
    public void menuCheking(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Número da reserva:");
        numeroReserva = sc.nextInt();
        sc.nextLine();
        System.out.println("Qual é sua senha:");
        senha =  sc.nextLine().strip();
        System.out.println("Forma de pagamento:");
        formaPagamento = sc.nextLine().toLowerCase().strip().replaceAll("[áàâã]","a");;
    }
}
