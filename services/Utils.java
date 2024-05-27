// Utils.java
package services;

import java.util.Scanner;

public class Utils {
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void timeSleep(int sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            System.out.println("Erro ao pausar a execução: " + e.getMessage());
        }
    }

    public static int verificarEntrada(Scanner scan) {
        int opcao = -1;
        while (true) {
            System.out.print("Digite a opção desejada: ");
            String entrada = scan.nextLine();
            try {
                opcao = Integer.parseInt(entrada);
                if (opcao >= 0 && opcao <= 4) {
                    break;
                } else {
                    System.out.println("Digite uma das opções acima.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite uma das opções acima.");
            }
        }
        return opcao;
    }

    public static int verificarEntradaVeiculo(Scanner scan) {
        int tipoVeiculo = -1;
        while (true) {
            System.out.print("Digite a opção desejada: ");
            String entrada = scan.nextLine();
            try {
                tipoVeiculo = Integer.parseInt(entrada);
                if (tipoVeiculo >= 1 && tipoVeiculo <= 2) {
                    break;
                } else {
                    System.out.println("Digite uma das opções acima.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite uma das opções acima.");
            }
        }
        return tipoVeiculo;
    }

    public static int verificarEntradaNumerica(Scanner scan) {
        while (true) {
            try {
                int entrada = Integer.parseInt(scan.nextLine());
                return entrada;
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor numérico válido.");
            }
        }
    }

    public static int verificarEntradaNumericaAno(Scanner scan) {
        while (true) {
            try {
                System.out.print("Digite o ano do veículo: ");
                int entrada = Integer.parseInt(scan.nextLine());
                return entrada;
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor numérico válido.");
            }
        }
    }
}
