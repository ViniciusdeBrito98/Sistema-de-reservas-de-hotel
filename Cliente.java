public class Cliente {
    private static int geradorId = 1;
    private int id;
    private String nome;

    public Cliente(String nome) {
        this.id = geradorId++;
        this.nome = nome;
    }

    public String getNome() { return nome; }

    @Override
    public String toString() {
        return "Cliente #" + id + ": " + nome;
    }
}
