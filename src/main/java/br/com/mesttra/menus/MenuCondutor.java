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
        System.out.println("5 - Consultar informações sobre rodízio/licenciamento");
        System.out.println("6 - Voltar");
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

        boolean verifica = condutorDAO.criaCondutor(condutor);

        if (verifica) {
            System.out.println("Condutor cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar condutor!");
        }

    }

    public static void listarCondutor() {
        CondutorDAO condutorDAO = new CondutorDAO();
        List<Condutor> todosCondutores = condutorDAO.buscarTodosCondutores();

        if (todosCondutores != null) {
            System.out.println("Lista de Condutores");
            System.out.println();
            for (Condutor condutor : todosCondutores) {
                System.out.println("Numero da CNH: " + condutor.getNroCnh());
                System.out.println("Data de Emissão: " + condutor.getDataEmissao());
                System.out.println("Orgão Emissor: " + condutor.getOrgaoEmissor());
                System.out.println("Pontuação: " + condutor.getPontuacao());
                System.out.println();
            }
        } else {
            System.out.println("Não há condutores cadastrados!");
        }

    }

    public static void buscarCondutor(Condutor condutor, CondutorDAO condutorDAO) {
        Scanner teclado = new Scanner(System.in);


        System.out.println("Digite o numero da CNH: ");
        int numcnh = teclado.nextInt();
        Condutor condutorBusc = condutorDAO.buscaCondutor(numcnh);

        if (condutorBusc != null) {
            System.out.println(condutorBusc);
        } else {
            System.out.println("Condutor não encontrado!");
        }

    }

    public static void excluirCondutor(Condutor condutor, CondutorDAO condutorDAO) {
        Scanner teclado = new Scanner(System.in);


        System.out.println("Digite o numero da CNH: ");
        int nroCnh = teclado.nextInt();
        boolean confere = condutorDAO.removeCondutor(nroCnh);

        if (confere) {
            System.out.println("Condutor excluído com sucesso!");
        } else {
            System.out.println("Erro ao excluir condutor!");
        }

    }

    public static void consultaRodizioLicenc(Scanner teclado) {
        System.out.println("Digite o último número da placa do veículo: ");
        int ultimoNumeroPlaca = teclado.nextInt();

        if (ultimoNumeroPlaca == 1 || ultimoNumeroPlaca == 2) {
            System.out.println("O veículo não pode circular na segunda-feira das 7h às 10h e das 17h às 20h");
        } else if (ultimoNumeroPlaca == 3 || ultimoNumeroPlaca == 4) {
            System.out.println("O veículo não pode circular na terça-feira das 7h às 10h e das 17h às 20h");
        } else if (ultimoNumeroPlaca == 5 || ultimoNumeroPlaca == 6) {
            System.out.println("O veículo não pode circular na quarta-feira das 7h às 10h e das 17h às 20h");
        } else if (ultimoNumeroPlaca == 7 || ultimoNumeroPlaca == 8) {
            System.out.println("O veículo não pode circular na quinta-feira das 7h às 10h e das 17h às 20h");
        } else if (ultimoNumeroPlaca == 9 || ultimoNumeroPlaca == 0) {
            System.out.println("O veículo não pode circular na sexta-feira das 7h às 10h e das 17h às 20h");
        } else {
            System.out.println("Número inválido!");
        }

        if (ultimoNumeroPlaca == 1 || ultimoNumeroPlaca == 2) {
            System.out.println("A taxa de licenciamento deve ser paga até o ultimo dia útil de Julho!");
        } else if (ultimoNumeroPlaca == 3 || ultimoNumeroPlaca == 4) {
            System.out.println("A taxa de licenciamento deve ser paga até o ultimo dia útil de Agosto!");
        } else if (ultimoNumeroPlaca == 5 || ultimoNumeroPlaca == 6) {
            System.out.println("A taxa de licenciamento deve ser paga até o ultimo dia útil de Setembro!");
        } else if (ultimoNumeroPlaca == 7 || ultimoNumeroPlaca == 8) {
            System.out.println("A taxa de licenciamento deve ser paga até o ultimo dia útil de Outubro!");
        } else if (ultimoNumeroPlaca == 9) {
            System.out.println("A taxa de licenciamento deve ser paga até o ultimo dia útil de Novembro!");
        } else if (ultimoNumeroPlaca == 0) {
            System.out.println("A taxa de licenciamento deve ser paga até o ultimo dia útil de Dezembro!");
        } else {
            System.out.println("Número inválido!");
        }


    }
}
