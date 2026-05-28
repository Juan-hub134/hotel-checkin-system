package br.com.checkInHotel.Model;

public class CadastroReservas {
    private String nome;
    private int idade;
    private String documento;
    private String tipoDeclient;
    private int numeroDaReserva;
    private String senhaDaReserva;
    private int quantidadeDeHospedes;
    private int quantidadeDeNoites;
    private String tipoDequarto;
    private String status;
    public CadastroReservas() {}

    public CadastroReservas(String nome, int idade, String documento, String tipoDeclient,String senhaDaReserva, int quantidadeDeHospedes, int quantidadeDeNoites, String tipoDequarto) {
        this.nome = nome;
        this.idade = idade;
        this.documento = documento;
        this.tipoDeclient = tipoDeclient;
        this.senhaDaReserva = senhaDaReserva;
        this.tipoDequarto = tipoDequarto;
        this.quantidadeDeHospedes = quantidadeDeHospedes;
        this.quantidadeDeNoites = quantidadeDeNoites;
    }

    @Override
    public String toString() {
        String mensagem = """
                RESERVAS CADASTRADAS
                Reserva: %d | Cliente: %s | Tipo: %s | Quarto: %s | Status: %s
                """.formatted(numeroDaReserva,nome,tipoDeclient,tipoDequarto,status);
        return mensagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipoDeclient() {
        return tipoDeclient;
    }

    public void setTipoDeclient(String tipoDeclient) {
        this.tipoDeclient = tipoDeclient;
    }

    public int getNumeroDaReserva() {
        return numeroDaReserva;
    }

    public void setNumeroDaReserva(int numeroDaReserva) {
        this.numeroDaReserva = numeroDaReserva;
    }

    public String getSenhaDaReserva() {
        return senhaDaReserva;
    }

    public void setSenhaDaReserva(String senhaDaReserva) {
        this.senhaDaReserva = senhaDaReserva;
    }

    public int getQuantidadeDeHospedes() {
        return quantidadeDeHospedes;
    }

    public void setQuantidadeDeHospedes(int quantidadeDeHospedes) {
        this.quantidadeDeHospedes = quantidadeDeHospedes;
    }

    public int getQuantidadeDeNoites() {
        return quantidadeDeNoites;
    }

    public void setQuantidadeDeNoites(int quantidadeDeNoites) {
        this.quantidadeDeNoites = quantidadeDeNoites;
    }
    public String getTipoDequarto() {
        return tipoDequarto;
    }

    public void setTipoDequarto(String tipoDequarto) {
        this.tipoDequarto = tipoDequarto;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
