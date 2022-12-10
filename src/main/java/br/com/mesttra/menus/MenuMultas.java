package br.com.mesttra.menus;

import br.com.mesttra.dao.CondutorDAO;
import br.com.mesttra.dao.MultaDAO;
import br.com.mesttra.dao.VeiculoDAO;
import br.com.mesttra.entity.Condutor;
import br.com.mesttra.entity.Multa;
import br.com.mesttra.entity.Veiculo;

import java.util.List;
import java.util.Scanner;

public class MenuMultas {
    public static void menuMultas() {
        System.out.println("-----MENU MULTAS-----");
        System.out.println();
        System.out.println("1 - Cadastrar Multa");
        System.out.println("2 - Listar Multas");
        System.out.println("3 - Buscar Multa");
        System.out.println("4 - Excluir Multa");
        System.out.println("5 - Voltar");
        System.out.println();
        System.out.println("-----MENU MULTAS-----");
    }

    public static void cadastrarMulta(Multa multa, MultaDAO multaDAO, VeiculoDAO veiculoDAO, Condutor condutor, CondutorDAO condutorDAO) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("-----CADASTRAR MULTA-----");
        System.out.println();



        System.out.println("Digite o valor da multa: ");
        multa.setValor(teclado.nextDouble());

        System.out.println("Digite o valor da multa: ");
        multa.setPontuacao(teclado.nextInt());

        System.out.println("Digite a placa do veiculo que foi multado: ");
        String placaMultada = teclado.next();

        Veiculo veiculoMultado = veiculoDAO.buscaVeiculo(placaMultada);

        if (veiculoMultado != null) {
            multa.setVeiculo(veiculoMultado);
        } else {
            System.out.println("Veiculo não encontrado!");
            return;
        }

        multaDAO.criaMulta(multa);

        Condutor infrator = veiculoMultado.getCondutor();
        int pontosMulta = infrator.getPontuacao();
        pontosMulta += multa.getPontuacao();
        condutorDAO.atualizaCondutor(infrator, pontosMulta);

    }

    public static void listarMultas(MultaDAO multaDAO) {
        List<Multa> multas = multaDAO.todasMultas();
        for (Multa multa : multas) {
            System.out.println(multa);
        }
    }

    public static void buscarMulta(MultaDAO multaDAO) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o codigo da multa: ");
        int cod = teclado.nextInt();
        Multa multa = multaDAO.buscaMulta(cod);
        System.out.println(multa);
    }

    public static void excluirMulta(MultaDAO multaDAO) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o codigo da multa: ");
        int cod = teclado.nextInt();
        multaDAO.removeMulta(cod);


    }
}
