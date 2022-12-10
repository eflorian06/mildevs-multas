package br.com.mesttra.menus;

import br.com.mesttra.dao.CondutorDAO;
import br.com.mesttra.dao.VeiculoDAO;
import br.com.mesttra.entity.Condutor;
import br.com.mesttra.entity.Veiculo;

import java.util.List;
import java.util.Scanner;

public class MenuVeiculo {
    public static void menuVeiculo() {
        System.out.println("-----MENU VEÍCULO-----");
        System.out.println();
        System.out.println("1 - Cadastrar Veículo");
        System.out.println("2 - Listar Veículos");
        System.out.println("3 - Buscar Veículo");
        System.out.println("4 - Excluir Veículo");
        System.out.println("5 - Voltar");
        System.out.println();
        System.out.println("-----MENU VEÍCULO-----");
    }

    public static void cadastrarVeiculo(VeiculoDAO veiculoDAO, Veiculo veiculo, CondutorDAO condutorDAO, Condutor condutor) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("-----CADASTRAR VEÍCULO-----");
        System.out.println();

        System.out.println("Digite a placa do veículo: ");
        veiculo.setPlaca(teclado.next());

        System.out.println("Digite o modelo do veículo: ");
        veiculo.setModelo(teclado.next());

        System.out.println("Digite a marca do veículo: ");
        veiculo.setMarca(teclado.next());

        System.out.println("Digite o ano do veículo: ");
        veiculo.setAno(teclado.nextInt());

        System.out.println("Digite a CNH do condutor: ");
        int cnhCondutor = teclado.nextInt();

        condutor = condutorDAO.buscaCondutor(cnhCondutor);

        veiculo.setCondutor(condutor);

        veiculoDAO.criaVeiculo(veiculo);


    }

    public static void listarVeiculo(VeiculoDAO veiculoDAO) {

        List<Veiculo> todosCarros = veiculoDAO.todosVeiculos();
        for (Veiculo veiculosDB : todosCarros) {
            System.out.println(veiculosDB);
        }
    }

    public static void buscarVeiculo(Veiculo veiculo, VeiculoDAO veiculoDAO) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite a placa do veículo: ");
        String placa = teclado.next();
        veiculo = veiculoDAO.buscaVeiculo(placa);
        System.out.println(veiculo);
    }

    public static void excluirVeiculo(Veiculo veiculo, VeiculoDAO veiculoDAO) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite a placa do veículo: ");
        String placa = teclado.next();
        veiculoDAO.removeVeiculo(placa);
    }


}
