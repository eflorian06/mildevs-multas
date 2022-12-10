package br.com.mesttra.menus;

import br.com.mesttra.dao.CondutorDAO;
import br.com.mesttra.entity.Condutor;

import java.util.List;
import java.util.Scanner;

public class MenuCondutor {
    public static void menuCondutor() {
        System.out.println("-----MENU CONDUTOR-----");
        System.out.println();
        System.out.println("1 - Cadastrar Condutor");
        System.out.println("2 - Listar Condutores");
        System.out.println("3 - Buscar Condutor");
        System.out.println("4 - Excluir Condutor");
        System.out.println("5 - Voltar");
        System.out.println();
        System.out.println("-----MENU CONDUTOR-----");
    }

    public static void cadastrarCondutor() {
        Scanner teclado = new Scanner(System.in);

        CondutorDAO condutorDAO = new CondutorDAO();
        Condutor condutor = new Condutor();

        System.out.println("Cadastrar Condutor");
        System.out.println();

        System.out.println("Digite o numero da CNH: ");
        condutor.setNroCnh(teclado.nextInt());

        System.out.println("Digite a data de emissão: ");
        condutor.setDataEmissao(teclado.next());

        System.out.println("Digite o orgão emissor: ");
        condutor.setOrgaoEmissor(teclado.next());

        condutorDAO.criaCondutor(condutor);
        System.out.println("Condutor cadastrado com sucesso!");

    }

    public static void listarCondutor() {
        CondutorDAO condutorDAO = new CondutorDAO();
        List<Condutor> todosCondutores = condutorDAO.buscarTodosCondutores();
    }

    public static void buscarCondutor(Condutor condutor, CondutorDAO condutorDAO) {
        Scanner teclado = new Scanner(System.in);


        System.out.println("Digite o numero da CNH: ");
        int numcnh = teclado.nextInt();
        Condutor condutorBusc = condutorDAO.buscaCondutor(numcnh);
        System.out.println(condutorBusc);
    }

    public static void excluirCondutor(Condutor condutor, CondutorDAO condutorDAO) {
        Scanner teclado = new Scanner(System.in);


        System.out.println("Digite o numero da CNH: ");
        int nroCnh = teclado.nextInt();
        condutorDAO.removeCondutor(nroCnh);
        System.out.println("Condutor excluído com sucesso!");
    }
}
