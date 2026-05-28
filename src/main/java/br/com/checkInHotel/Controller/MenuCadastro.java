package br.com.checkInHotel.Controller;

import br.com.checkInHotel.Model.CadastroReservas;

import java.util.Scanner;

public class MenuCadastro {
    private ValidarCadastro validarCadastro = new ValidarCadastro();

    public ValidarCadastro getValidarCadastro() {
        return validarCadastro;
    }

    //se o usuário digitar 1
    public void realizarCadastro(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome do responsável: ");
        String nome = sc.nextLine().strip();
        System.out.println("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.println("tipo Cliente:\n"+"Cliente comum = até 4 hóspedes\n"+"Cliente vip = até 6 hóspedes");
        String tipoCliente = sc.nextLine().toLowerCase().strip();
        System.out.println("documento\n"+"Rg ou CPF");
        String documento = sc.nextLine();
        System.out.println("senha da reserva\n"+"Deve conter 6 caracteres:");
        String senhaDaReserva = sc.nextLine().strip();
        System.out.println("quantidade de hospedes");
        int quantidadeDeHospedes = sc.nextInt();
        sc.nextLine();
        System.out.println("quantidade de noites");
        int quantidadeDeNoites = sc.nextInt();
        sc.nextLine();
        System.out.println("Tipo de quarto: \n"+"simples = R$ 180 por noite\n"+"luxo = R$ 350 por noite\n"+"presidencial = R$ 800 por noite \n");
        String tipoQuarto = sc.nextLine().toLowerCase().strip();
        CadastroReservas cadastro = new CadastroReservas(nome,idade,documento,tipoCliente,senhaDaReserva,quantidadeDeHospedes,quantidadeDeNoites,tipoQuarto);
        validarCadastro.validarCadastro(cadastro);
    }
}
