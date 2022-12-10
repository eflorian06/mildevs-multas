package br.com.mesttra;

import br.com.mesttra.menus.MenuCondutor;
import br.com.mesttra.menus.MenuMultas;
import br.com.mesttra.menus.MenuPrincipal;
import br.com.mesttra.menus.MenuVeiculo;

import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 4) {
            MenuPrincipal.menuPrincipal();
            opcao = teclado.nextInt();
            switch (opcao) {
                case 1:
                    MenuCondutor.menuCondutor();
                    opcao = teclado.nextInt();
                    switch (opcao) {

                        case 1: // Cadastrar Condutor
                            MenuCondutor.cadastrarCondutor();
                            break;
                        case 2: // Listar Condutor
                            MenuCondutor.listarCondutor();
                            break;

                        case 3: // Buscar Condutor
                            MenuCondutor.buscarCondutor();
                            break;

                    }
                    break;
                case 2:
                    MenuVeiculo.menuVeiculo();

                    opcao = teclado.nextInt();
                    switch (opcao) {
                        case 1: // Cadastrar Veículo
                            MenuVeiculo.cadastrarVeiculo();
                            break;
                        case 2: // Listar Veículo
                            break;
                        case 3: // Buscar Veículo
                            break;
                        case 4: // Excluir Veículo
                            break;
                    }

                    break;

                case 3:
                    MenuMultas.menuMultas();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
