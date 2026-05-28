package br.com.checkInHotel.Controller;

import br.com.checkInHotel.Model.CadastroReservas;
import br.com.checkInHotel.Model.ListaReservas;

import java.util.Random;

public class ValidarCadastro  {
    private ListaReservas listaReservas = new ListaReservas();
    private boolean acesso;
    private Random aleatorio = new Random();
    public ValidarCadastro() {}
    public boolean validarDocumento(CadastroReservas c){
        if(c.getNome() == null || c.getDocumento() == null){
            return false;
        }else {
            return true;
        }
    }
    public boolean avaliarIdade(CadastroReservas c){
        boolean acesso = c.getIdade()>=18;
        return acesso;
    }
    public boolean validarTipoClient(CadastroReservas c){
        if("vip".equals(c.getTipoDeclient())|| "comum".equals(c.getTipoDeclient())){
            return true;
        }else  {
            return false;
        }
    }
    public boolean validarSenhaClient(CadastroReservas c){
        if(c.getSenhaDaReserva().length()<5){
            return false;
        }else  {
            return true;
        }
    }
    public boolean numeroDeHospedes(CadastroReservas c){
        if("vip".equals(c.getTipoDeclient())){
            boolean acesso = c.getQuantidadeDeHospedes()<=6;
            return acesso;
        } else if ("comum".equals(c.getTipoDeclient())) {
            boolean acesso = c.getQuantidadeDeHospedes()<=4;
            return acesso;
        }else{
            return false;
        }
    }
    public boolean validarQuantidadeDeNoites(CadastroReservas c){
        boolean acesso = c.getQuantidadeDeNoites()>0;
        return acesso;
    }
    public boolean validarTipoDeQuarto(CadastroReservas c){
        return "simples".equals(c.getTipoDequarto()) ||"luxo".equals(c.getTipoDequarto()) ||"presidencial".equals(c.getTipoDequarto());
    }
    public boolean validarNumeroReservas(CadastroReservas c){
        for(int i = 0; i<listaReservas.getListaReservas().size();i++){
            while (c.getNumeroDaReserva() == listaReservas.getListaReservas().get(i).getNumeroDaReserva()){
                c.setNumeroDaReserva(gerarNumeroAleatorioReservas());
            }
        }
        return true;
    }
    public int gerarNumeroAleatorioReservas(){
        int numeroAleatorio = aleatorio.nextInt();
        if(numeroAleatorio<0){
            return numeroAleatorio*-1;
        }else{
            return numeroAleatorio;
        }
    }

    public ListaReservas getListaReservas() {
        return listaReservas;
    }

    public void validarCadastro(CadastroReservas c){
        c.setNumeroDaReserva(gerarNumeroAleatorioReservas());
        acesso = validarDocumento(c)&&
                validarTipoClient(c)&&
                validarSenhaClient(c)&&
                avaliarIdade(c)&&
                validarQuantidadeDeNoites(c)&&
                validarTipoDeQuarto(c)&&
                numeroDeHospedes(c)&&
                validarNumeroReservas(c);
        if(acesso){
            String mensagem = """
                    Reserva cadastrada com sucesso.
                    Número da reserva: %s
                    Cliente: %s
                    Tipo: %s
                    Quarto: %s
                    """.formatted(c.getNumeroDaReserva(),c.getNome(),c.getTipoDeclient(),c.getTipoDequarto());
            c.setStatus("Pendente");
            listaReservas.adicionarReserva(c);
            System.out.println(mensagem);
        }else{
            String mensagem = """
                    Cadastro recusado.
                      Motivos:
                      documento não informado
                      senha muito curta
                      quantidade de hóspedes acima do limite""";
            System.out.println(mensagem);
        }
    }
    public boolean isAcesso() {
        return acesso;}
}

