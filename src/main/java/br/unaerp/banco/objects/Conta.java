package br.unaerp.banco.objects;

import br.unaerp.banco.enums.TipoConta;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private final int numeroDaConta;
    private final double limiteContratado;
    private final List<Extrato> extrato;
    private TipoConta tipoConta;
    private double saldo;

    public Conta(int numeroDaConta, TipoConta tipoConta, double limiteContratado) {
        this.numeroDaConta = numeroDaConta;
        this.tipoConta = tipoConta;
        this.limiteContratado = limiteContratado;
        extrato = new ArrayList<Extrato>();
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }


    public double getLimiteContratado() {
        return limiteContratado;
    }

    public List<Extrato> getExtrato() {
        return extrato;
    }

    public double sacar(double valor) {
        if ((saldo - valor < 0) || (valor > saldo)) {
            new Exception("Nao possui Saldo suficiente");
        }
        saldo -= valor;
        return saldo;
    }

    public double depositar(double valor) {
        saldo += valor;

        return saldo;
    }

    public void transferirValor(double valor, Conta contaPara) {
        if ((saldo - valor < 0) || (valor > saldo)) {
            new Exception("Nao possui Saldo suficiente");
        }

        if (contaPara.equals(this)) {
            new Exception("As duas contas nao podem ser iguais");
        }

    }

    private void exibirExtrato() {
        for (Extrato extrato : extrato) {
            System.out.println(extrato.getHorario() + " - " + extrato.getAcao() + " - " + extrato.getValor());
        }
    }

}
