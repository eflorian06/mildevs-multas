package br.com.mesttra.menus;

import br.com.mesttra.dao.MultaDAO;
import br.com.mesttra.dao.VeiculoDAO;
import br.com.mesttra.entity.Condutor;
import br.com.mesttra.entity.Multa;
import br.com.mesttra.entity.Veiculo;

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

    public static void cadastrarMulta() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("-----CADASTRAR MULTA-----");
        System.out.println();

        MultaDAO multaDAO = new MultaDAO();
        Multa multa = new Multa();
        Condutor infrator = new Condutor();

        System.out.println("Digite o valor da multa: ");
        multa.setValor(teclado.nextDouble());

        System.out.println("Digite o valor da multa: ");
        multa.setValor(teclado.nextDouble());

        System.out.println("Digite a placa do veiculo que foi multado: ");
        String placaMultada = teclado.next();

        Veiculo veiculoMultado = new VeiculoDAO().buscaVeiculo(placaMultada);

        if (veiculoMultado != null) {
            multa.setVeiculo(veiculoMultado);
        } else {
            System.out.println("Veiculo não encontrado!");
            return;
        }

        multaDAO.criaMulta(multa);

        infrator = veiculoMultado.getCondutor();
        int pontos = infrator.getPontuacao();
        pontos += multa.getPontuacao();
        infrator.setPontuacao(pontos);

    }
}
