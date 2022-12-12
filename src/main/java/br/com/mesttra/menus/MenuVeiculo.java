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
        System.out.println("5 - Vender / Trocar de condutor");
        System.out.println("6 - Consultar valor do IPVA");
        System.out.println("7 - Voltar");
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

        boolean verifica = veiculoDAO.criaVeiculo(veiculo);

        if (verifica) {
            System.out.println("Veículo cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar veículo!");
        }


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
        boolean verifica = veiculoDAO.removeVeiculo(placa);

        if (verifica) {
            System.out.println("Veículo excluído com sucesso!");
        } else {
            System.out.println("Erro ao excluir veículo!");
        }

    }

    public static void transferirCondutor(Veiculo veiculo, VeiculoDAO veiculoDAO, CondutorDAO condutorDAO, Condutor condutor) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite a placa do veículo: ");
        String placa = teclado.next();
        veiculo = veiculoDAO.buscaVeiculo(placa);
        System.out.println("Digite a CNH do novo condutor: ");
        int cnhCondutor = teclado.nextInt();
        condutor = condutorDAO.buscaCondutor(cnhCondutor);
        veiculo.setCondutor(condutor);
        boolean verifica = veiculoDAO.atualizaVeiculo(veiculo);

        if (verifica) {
            System.out.println("Veículo transferido com sucesso!");
        } else {
            System.out.println("Erro ao transferir veículo!");
        }
    }

    public static void consultaIpva (Scanner teclado) {
        System.out.println("Digite o valor do veículo na tabela FIPE: ");
        double valorFIPE = teclado.nextDouble();
        double valorIpva = valorFIPE * 0.04;
        System.out.println("O valor do IPVA é: R$ " + valorIpva);
    }


}
