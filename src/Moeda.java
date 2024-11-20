
public class Moeda {
    private String nome;
    private double taxa;

    public Moeda(String nome, double taxa) {
        this.nome = nome;
        this.taxa = taxa;
    }

    public String getNome() {
        return nome;
    }

    public double getTaxa() {
        return taxa;
    }
}
