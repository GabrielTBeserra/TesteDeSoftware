package br.unaerp.banco.objects;

import br.unaerp.banco.enums.TipoConta;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private final int numeroDaConta;
    private TipoConta tipoConta;
    private double saldo;
    private double limiteContratado;
    private List<Extrato> extrato;

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
        return 0;
    }

    public void depositar(double valor) {

    }

    public void transferirValor(double value, Conta contaPara) {

    }

    private void exibirExtrato(){
        for(Extrato extrato : extrato){
            System.out.println(extrato.getHorario() + " - " + extrato.getAcao() + " - " + extrato.getValor());
        }
    }

}
