import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controle hotel = new Controle();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("0 - Sair");
            System.out.println("1 - Criar reserva");
            System.out.println("2 - Cadastrar quarto");
            System.out.println("3 - Cadastrar cliente");
            System.out.println("4 - Imprimir todas as reservas");
            System.out.println("5 - Imprimir uma reserva (nome do cliente)");
            System.out.println("6 - Imprimir clientes cadastrados");
            System.out.println("7 - Imprimir quartos cadastrados");
            System.out.println("8 - Alterar reserva para quarto ocupado (ID da reserva)");
            System.out.println("9 - Buscar reservas por número do quarto");
            System.out.println("10 - Imprimir quartos não ocupados");
            System.out.println("11 - Imprimir reservas de um período");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    System.out.print("Número do quarto: ");
                    int numero = sc.nextInt();
                    System.out.print("Data início (AAAA-MM-DD): ");
                    String dataIni = sc.next();
                    System.out.print("Data fim (AAAA-MM-DD): ");
                    String dataFim = sc.next();
                    hotel.criarReserva(nome, numero, dataIni, dataFim);
                    break;
                case 2:
                    System.out.print("Número do quarto: ");
                    int num = sc.nextInt();
                    System.out.print("Tipo (LUXO ou PADRAO): ");
                    String tipo = sc.next().toUpperCase();
                    hotel.cadastrarQuarto(num, TipoQuarto.valueOf(tipo));
                    break;
                case 3:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = sc.nextLine();
                    hotel.cadastrarCliente(nomeCliente);
                    break;
                case 4:
                    System.out.println(hotel.imprimirReservas());
                    break;
                case 5:
                    System.out.print("Nome do cliente: ");
                    String buscaCliente = sc.nextLine();
                    System.out.println(hotel.imprimirReservasCliente(buscaCliente));
                    break;
                case 6:
                    System.out.println(hotel.imprimirClientes());
                    break;
                case 7:
                    System.out.println(hotel.imprimirQuartos());
                    break;
                case 8:
                    System.out.print("ID da reserva: ");
                    int idReserva = sc.nextInt();
                    hotel.ocuparQuarto(idReserva);
                    break;
                case 9:
                    System.out.print("Número do quarto: ");
                    int numeroBusca = sc.nextInt();
                    System.out.println(hotel.imprimirReservasPorNumeroQuarto(numeroBusca));
                    break;
                case 10:
                    System.out.println(hotel.imprimirQuartosNaoOcupados());
                    break;
                case 11:
                    System.out.print("Data início (AAAA-MM-DD): ");
                    String inicio = sc.next();
                    System.out.print("Data fim (AAAA-MM-DD): ");
                    String fim = sc.next();
                    System.out.println(hotel.imprimirReservasPeriodo(inicio, fim));
                    break;
            }
        } while (opcao != 0);

        sc.close();
    }
}
