import java.time.LocalDate;
import java.util.*;

public class Controle {
    private List<Reserva> reservas = new ArrayList<>();
    private List<Quarto> quartos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public void criarReserva(String nomeCliente, int numeroQuarto, String dataInicio, String dataFim) {
        Cliente cliente = getCliente(nomeCliente);
        Quarto quarto = getQuarto(numeroQuarto);
        if (cliente != null && quarto != null && quarto.getStatus() == Status.LIVRE) {
            Reserva reserva = new Reserva(LocalDate.parse(dataInicio), LocalDate.parse(dataFim), quarto, cliente);
            reservas.add(reserva);
            quarto.setStatus(Status.RESERVADO);
            System.out.println("Reserva criada com sucesso!");
        } else {
            System.out.println("Erro ao criar reserva. Verifique cliente e quarto.");
        }
    }

    public void cadastrarCliente(String nome) {
        clientes.add(new Cliente(nome));
    }

    public void cadastrarQuarto(int numero, TipoQuarto tipo) {
        quartos.add(new Quarto(numero, tipo));
    }

    public String imprimirReservas() {
        StringBuilder sb = new StringBuilder();
        for (Reserva r : reservas) sb.append(r).append("\n");
        return sb.toString();
    }

    public String imprimirReservasCliente(String nomeCliente) {
        StringBuilder sb = new StringBuilder();
        for (Reserva r : reservas)
            if (r.getCliente().getNome().equalsIgnoreCase(nomeCliente))
                sb.append(r).append("\n");
        return sb.toString();
    }

    public String imprimirReservasPeriodo(String dataInicial, String dataFinal) {
        LocalDate ini = LocalDate.parse(dataInicial);
        LocalDate fim = LocalDate.parse(dataFinal);
        StringBuilder sb = new StringBuilder();
        for (Reserva r : reservas)
            if (!(r.getDataFim().isBefore(ini) || r.getDataInicio().isAfter(fim)))
                sb.append(r).append("\n");
        return sb.toString();
    }

    public String imprimirReservasPorNumeroQuarto(int numeroQuarto) {
        StringBuilder sb = new StringBuilder();
        for (Reserva r : reservas)
            if (r.getQuarto().getNumero() == numeroQuarto)
                sb.append(r).append("\n");
        return sb.toString();
    }

    public String imprimirQuartosNaoOcupados() {
        StringBuilder sb = new StringBuilder();
        for (Quarto q : quartos)
            if (q.getStatus() != Status.OCUPADO)
                sb.append(q).append("\n");
        return sb.toString();
    }

    public String imprimirClientes() {
        StringBuilder sb = new StringBuilder();
        for (Cliente c : clientes) sb.append(c).append("\n");
        return sb.toString();
    }

    public String imprimirQuartos() {
        StringBuilder sb = new StringBuilder();
        for (Quarto q : quartos) sb.append(q).append("\n");
        return sb.toString();
    }

    public void ocuparQuarto(int idReserva) {
        for (Reserva r : reservas) {
            if (r.getId() == idReserva) {
                r.getQuarto().setStatus(Status.OCUPADO);
                System.out.println("Quarto ocupado com sucesso!");
                return;
            }
        }
        System.out.println("Reserva não encontrada.");
    }

    private Cliente getCliente(String nome) {
        for (Cliente c : clientes)
            if (c.getNome().equalsIgnoreCase(nome))
                return c;
        return null;
    }

    private Quarto getQuarto(int numero) {
        for (Quarto q : quartos)
            if (q.getNumero() == numero)
                return q;
        return null;
    }
}
