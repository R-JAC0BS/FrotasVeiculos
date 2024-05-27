import java.util.List;
import java.util.Scanner;

import entities.Carro;
import entities.Moto;
import entities.Veiculo;
import services.VeiculoService;
import services.Utils;

public class CadVeiculo {
    private static Scanner scan;
    private static VeiculoService veiculoService;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        veiculoService = new VeiculoService();
        int opcao ;
        
        do {
            Utils.timeSleep(1000);
            Utils.limparTela();
            System.out.println("Sistema de Gerenciamento de Frotas");
            System.out.println("Escolha uma das opções:");
            System.out.println("1 - Cadastrar Novo Veículo");
            System.out.println("2 - Listar todos os Veículos");
            System.out.println("3 - Pesquisar Veículo por Placa");
            System.out.println("4 - Remover Veículo");
            System.out.println("0 - Sair");
            opcao = Utils.verificarEntrada(scan);

            switch (opcao) {
                case 1:
                    save();
                    break;
                case 2:
                    imprimirVeiculos();
                    break;
                case 3:
                    pesquisarVeiculo();
                    break;
                case 4:
                    removerVeiculo();
                    break;
                case 0:
                    System.out.println("Volte logo!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        
        } while (opcao != 0);
    }

    public static void save() {
        Utils.limparTela();
        Veiculo veiculoAdd;

        System.out.println("Qual o tipo de veículo");
        System.out.println("1 - Carro");
        System.out.println("2 - Moto");
        int tipoVeiculo = Utils.verificarEntradaVeiculo(scan);

        System.out.print("Digite a marca do veículo: ");
        String marca = scan.nextLine();

        System.out.print("Digite o modelo do veículo: ");
        String modelo = scan.nextLine();

        int ano = Utils.verificarEntradaNumericaAno(scan);
        System.out.print("Digite a placa do veículo: ");
        String placa = scan.nextLine().toUpperCase();

        if (ano <= 0) {
            Utils.limparTela();
            System.out.println("Ano do veículo não pode ser menor ou igual a zero.");
            Utils.timeSleep(1000);
            Utils.limparTela();
            return;
        }

        if (tipoVeiculo == 1) {
            System.out.print("Digite o número de portas: ");
            int numeroPortas = Utils.verificarEntradaNumerica(scan);
            veiculoAdd = new Carro("Carro " ,marca, modelo, ano, placa, numeroPortas);
            System.out.println("Veiculo cadastrado com sucesso");
            System.out.print("Aperte enter para continuar");
            scan.nextLine();
        } else {
            System.out.print("A moto possui partida elétrica: 1-Sim, 2-Não: ");
            int partidaEletrica = Utils.verificarEntradaNumerica(scan);
            boolean partida = partidaEletrica == 1;
            veiculoAdd = new Moto("Moto",marca, modelo, ano, placa, partida);
            System.out.println("Veiculo cadastrado com sucesso");
            System.out.print("Aperte enter para continuar");
            scan.nextLine();
        } 
        try {
            veiculoService.save(veiculoAdd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            scan.nextLine();
        }
    }

    private static void imprimirVeiculos() {
        Utils.limparTela();
        List<Veiculo> veiculos = veiculoService.getVeiculosDB();
        int contador = 1;
        for (Veiculo veiculo : veiculos) {
            System.out.println("Veiculo-" + contador + ":" + veiculo );
            contador ++;
        }
        System.out.print("Aperte Enter para continuar: ");
        scan.nextLine();
    }
    private static void removerVeiculo () {
        List <Veiculo> veiculos = veiculoService.getVeiculosDB();
        System.out.print("Digite a placa do veiculo que deseja remover:");
        String vereficar = scan.nextLine().toUpperCase();
        try {
            for (Veiculo veiculo : veiculos){
                if (vereficar.equals(veiculo.getPlaca())){
                    veiculos.remove(veiculo);
                    System.out.println("Veiculo deletado com sucesso");

                }else {
                    System.out.println("Veiculo não encontrado");
                    System.out.print("Aperte Enter para continuar: ");
                    scan.nextLine();
                }
            }
        } catch (Exception e) {
            return;
        }
    }
    private static void pesquisarVeiculo() {
        List<Veiculo> veiculos = veiculoService.getVeiculosDB();
        for (Veiculo veiculo : veiculos) {
            System.out.println("Digite sua placa");
            String Vereficar = scan.nextLine().toUpperCase();
            if (Vereficar.equals(veiculo.getPlaca())){
                Utils.limparTela();
                System.out.println("Veiculo-"  + ":" 
                + veiculo  );
                System.out.print("Aperte Enter para continuar: ");
                scan.nextLine();
            }
            else {
                Utils.limparTela();
                System.out.println("Não foi possivel encontrar a placa do veiculo ");
                System.out.print("Aperte Enter para continuar: ");
                scan.nextLine();
            }
        }
    }

}
