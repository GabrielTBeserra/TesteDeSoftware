package br.unaerp.banco.main;

import br.unaerp.banco.entitys.Cliente;
import br.unaerp.banco.entitys.Conta;
import br.unaerp.banco.enums.TipoConta;

import java.util.Scanner;

public class Menu {
    public Menu() {
        showMenu();
    }


    private void showMenu() {
        System.out.println("1..Cadastrar nova conta");
        System.out.println("2..Apagar conta");
        System.out.println("2..Ver contas cadastradas");
        System.out.println("3..Realizar Operacao");

        int op = new Scanner(System.in).nextInt();


        switch (op) {
            case 1:
                newAccount();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    private void newAccount() {
        System.out.println("Nome: ");
        String scannerNome = new Scanner(System.in).nextLine();

        System.out.println("Cpf: ");
        String scannerCpf = new Scanner(System.in).nextLine();

        if (Data.clients.containsKey(scannerCpf)) {
            System.out.println("CPF ja cadastrado");
            showMenu();
        }

        System.out.println("** Criando Conta **");

        System.out.println("Numero da conta");
        int numeroDaConta = new Scanner(System.in).nextInt();

        System.out.println("Limite Contratado");
        double limiteCOntratado = new Scanner(System.in).nextDouble();

        System.out.println("Tipo de conta (1. Conta corrente, 2. Conta Poupanca , 3. Conta Salario)");
        int tipo = new Scanner(System.in).nextInt();

        TipoConta tipoConta;
        switch (tipo) {
            case 1:
                tipoConta = TipoConta.CONTA_CORRENTE;
                break;
            case 2:
                tipoConta = TipoConta.CONTA_POUPANCA;
                break;
            case 3:
                tipoConta = TipoConta.CONTA_SALARIO;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + tipo);
        }

        Conta c = new Conta(numeroDaConta, tipoConta, limiteCOntratado);
        Cliente cliente = new Cliente(scannerNome, scannerCpf, c);

        System.out.println(cliente.toString() + "\n\n");

        showMenu();
    }

}
