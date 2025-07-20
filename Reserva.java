import java.time.LocalDate;

public class Reserva {
    private static int geradorId = 1;
    private int id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Quarto quarto;
    private double valorTotal;
    private Cliente cliente;

    public Reserva(LocalDate inicio, LocalDate fim, Quarto quarto, Cliente cliente) {
        this.id = geradorId++;
        this.dataInicio = inicio;
        this.dataFim = fim;
        this.quarto = quarto;
        this.cliente = cliente;
        this.valorTotal = quarto.getTipoQuarto().getValorDiaria() *
                          (fim.toEpochDay() - inicio.toEpochDay());
    }

    public int getId() { return id; }
    public LocalDate getDataInicio() { return dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public Quarto getQuarto() { return quarto; }
    public Cliente getCliente() { return cliente; }

    @Override
    public String toString() {
        return "Reserva #" + id + ": " + cliente.getNome() +
               ", Quarto: " + quarto.getNumero() + " (" + quarto.getTipoQuarto() + ")" +
               ", De " + dataInicio + " até " + dataFim +
               ", Total: R$" + valorTotal;
    }
}
