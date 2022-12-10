package br.com.mesttra;

import br.com.mesttra.dao.CondutorDAO;
import br.com.mesttra.dao.MultaDAO;
import br.com.mesttra.dao.VeiculoDAO;
import br.com.mesttra.entity.Condutor;
import br.com.mesttra.entity.Multa;
import br.com.mesttra.entity.Veiculo;
import br.com.mesttra.menus.MenuCondutor;
import br.com.mesttra.menus.MenuMultas;
import br.com.mesttra.menus.MenuPrincipal;
import br.com.mesttra.menus.MenuVeiculo;

import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Condutor condutor = new Condutor();
        CondutorDAO condutorDAO = new CondutorDAO();
        Multa multa = new Multa();
        MultaDAO multaDAO = new MultaDAO();
        Veiculo veiculo = new Veiculo();
        VeiculoDAO veiculoDAO = new VeiculoDAO();

        int opcao = 0;

        while (opcao != 9) {
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
                            MenuCondutor.buscarCondutor(condutor, condutorDAO);
                            break;

                    }
                    break;
                case 2:
                    MenuVeiculo.menuVeiculo();

                    opcao = teclado.nextInt();
                    switch (opcao) {
                        case 1: // Cadastrar Veículo
                            MenuVeiculo.cadastrarVeiculo(veiculoDAO, veiculo, condutorDAO, condutor);
                            break;
                        case 2: // Listar Veículo
                            MenuVeiculo.listarVeiculo(veiculoDAO);
                            break;
                        case 3: // Buscar Veículo
                            MenuVeiculo.buscarVeiculo(veiculo, veiculoDAO);
                            break;
                        case 4: // Excluir Veículo
                            MenuVeiculo.excluirVeiculo(veiculo, veiculoDAO);
                            break;
                    }

                    break;

                case 3:
                    MenuMultas.menuMultas();
                    opcao = teclado.nextInt();

                    switch (opcao) {
                        case 1: // Cadastrar Multa
                            MenuMultas.cadastrarMulta(multa, multaDAO, veiculoDAO, condutor, condutorDAO);
                            break;
                        case 2: // Listar Multa
                            MenuMultas.listarMultas(multaDAO);
                            break;
                        case 3: // Buscar Multa
                            MenuMultas.buscarMulta(multaDAO);
                            break;
                        case 4: // Excluir Multa
                            MenuMultas.excluirMulta(multaDAO, condutorDAO, condutor, multa);
                            break;
                    }
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
