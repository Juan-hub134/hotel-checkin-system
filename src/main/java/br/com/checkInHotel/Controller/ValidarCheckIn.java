package br.com.checkInHotel.Controller;

import br.com.checkInHotel.Model.ListaReservas;

public class ValidarCheckIn implements IcalculaDescontoEtaxa {

    private int numeroReserva;
    private String senhaReserva;
    private String formaDepagamento;
    private int client;
    private double totalPorNoitesDormidas = 0;

    public ValidarCheckIn(int numeroReserva, String senhaReserva, String formaDepagamento) {
        this.numeroReserva = numeroReserva;
        this.senhaReserva = senhaReserva;
        this.formaDepagamento = formaDepagamento;
    }

    public ValidarCheckIn() {
    }

    public boolean validarNumeroReservaESenha(ListaReservas l){
        for( client = 0; client < l.getListaReservas().size(); client++){
            if(l.getListaReservas().get(client).getNumeroDaReserva() == numeroReserva && senhaReserva.equals(l.getListaReservas().get(client).getSenhaDaReserva())){
                return true;
            }
        }
        client = -1;
        return false;
    }
    public boolean validarFormaDepagamento(){
        if("pix".equals(formaDepagamento)||"cartao".equals(formaDepagamento)||"dinheiro".equals(formaDepagamento)){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public double calcularDesconto(ListaReservas l) {
        double preco = totalPorNoitesDormidas;
        double desconto = 0;
        if("vip".equals(l.getListaReservas().get(client).getTipoDeclient())&& "pix".equals(formaDepagamento)){
            desconto = preco - (preco/100)*20;
        }else if("vip".equals(l.getListaReservas().get(client).getTipoDeclient())){
            desconto = preco - (preco/100)*15;
        }else if("pix".equals(formaDepagamento)){
            desconto = preco - (preco/100)* 5;
        }else{
            desconto = preco;
        }
        return desconto;
    }

    @Override
    public double calcularTaxa(ListaReservas l) {
        double acrescimo = 0;
        double descontoCalculado = calcularDesconto(l);
        if(descontoCalculado != totalPorNoitesDormidas){
            acrescimo = (descontoCalculado/100)*10+descontoCalculado;
        }else{
            double noiteDormidas = totalPorNoitesDormidas;
            acrescimo = (noiteDormidas/100)*10+noiteDormidas;
        }

        return acrescimo;
    }
    @Override
    public void calcularPrecoPorNoite(ListaReservas l) {
        if("simples".equals(l.getListaReservas().get(client).getTipoDequarto())){
            totalPorNoitesDormidas = simples*l.getListaReservas().get(client).getQuantidadeDeNoites();
        } else if ("luxo".equals(l.getListaReservas().get(client).getTipoDequarto())) {
            totalPorNoitesDormidas = luxo*l.getListaReservas().get(client).getQuantidadeDeNoites();
            
        } else if ("presidencial".equals(l.getListaReservas().get(client).getTipoDequarto())) {
            totalPorNoitesDormidas = presidencial*l.getListaReservas().get(client).getQuantidadeDeNoites();
        }
    }
    public void exibirMensagem(ListaReservas l) {
        calcularPrecoPorNoite(l);
        String mensagemPix = """
                Check-in aprovado.
                Cliente: %s
                Tipo: %s
                Reserva: %d
                Quarto: %s
                Hóspedes: %d
                Noites: %d
                Valor base: R$ %.2f
                Valor final: R$ %.2f
                Pagamento: %s
                Status: check-in realizado
                """.formatted(l.getListaReservas().get(client).getNome(), l.getListaReservas().get(client).getTipoDeclient(),
                numeroReserva, l.getListaReservas().get(client).getTipoDequarto(), l.getListaReservas().get(client).getQuantidadeDeHospedes(),
                l.getListaReservas().get(client).getQuantidadeDeNoites(),
                totalPorNoitesDormidas,calcularDesconto(l), formaDepagamento);
        String mensagemCartao = """
                Check-in aprovado.
                Cliente: %s
                Tipo: %s
                Reserva: %d
                Quarto: %s
                Hóspedes: %d
                Noites: %d
                Valor base: R$ %.2f
                Valor final: R$ %.2f
                Pagamento: %s
                Status: check-in realizado
                """.formatted(l.getListaReservas().get(client).getNome(), l.getListaReservas().get(client).getTipoDeclient(),
                numeroReserva, l.getListaReservas().get(client).getTipoDequarto(), l.getListaReservas().get(client).getQuantidadeDeHospedes(),
                l.getListaReservas().get(client).getQuantidadeDeNoites(),
                totalPorNoitesDormidas, calcularTaxa(l), formaDepagamento);
        if ("cartao".equals(formaDepagamento)) {
            System.out.println(mensagemCartao);
        } else if ("pix".equals(formaDepagamento)) {
            System.out.println(mensagemPix);
        } else {
            //dentro do método calcular desconto ele já verifica se é dinheiro e não altera o valor base, mas se o client for vip ainda tem desconto, mas sem taxa do cartão e desconto do pix
            System.out.println(mensagemPix);
        }
    }
    public boolean validarSeCheckinJaFoiFeito(ListaReservas l) {
        for (int i = 0; i < l.getListaReservas().size(); i++) {
            if (i == client){
                if("check-in aprovado".equals(l.getListaReservas().get(i).getStatus())){
                    return false;
                }
            }
        }
        return true;
    }

    public void validarCheckIn(ListaReservas l) {
        boolean acesso = validarNumeroReservaESenha(l)&&validarFormaDepagamento()&&validarSeCheckinJaFoiFeito(l);
        if(acesso){
            l.getListaReservas().get(client).setStatus("check-in aprovado");
            exibirMensagem(l);
        }else {
            //validarSeChekingJaFoiFeito vai olhar na lista se os status tá aprovado
            //se tiver vai dar false e vai mostrar o motivo
            //se não existir nenhum "check-in aprovado" cai no else e mostrar que não tem nenhuma reserva cadastrada
            if (validarSeCheckinJaFoiFeito(l) == false){
                System.out.println("Check-in recusado.\n" +
                        "Motivos:\n" +
                        "- check-in já realizado");
            }else  {
                System.out.println("Check-in recusado.\n" +
                        "Motivos:\n" +
                        "- reserva não encontrada");
            }
        }
    }
}
