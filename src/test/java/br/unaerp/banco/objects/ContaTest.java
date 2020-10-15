package br.unaerp.banco.objects;

import br.unaerp.banco.enums.TipoConta;
import br.unaerp.banco.exceptions.IncorrectAccountException;
import br.unaerp.banco.exceptions.WithoutBalanceException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContaTest {

    @Test
    public void sacar() {
        Conta conta = new Conta(52116, TipoConta.CONTA_CORRENTE, 50);
        Cliente cliente = new Cliente("Alfredo", "161231561321", conta);

        cliente.getConta().depositar(50);

        assertEquals(50, cliente.getConta().getSaldo(), 0.0001);
    }

    @Test
    public void depositar() {
        Conta conta = new Conta(52116, TipoConta.CONTA_CORRENTE, 50);
        Cliente cliente = new Cliente("Alfredo", "161231561321", conta);
        // Depositando 50 na conta do cliente 1
        cliente.getConta().depositar(50);

        assertEquals(50, cliente.getConta().getSaldo(), 0.0001);
    }

    @Test(expected = WithoutBalanceException.class)
    public void sacarMenosQueZero() {
        Conta conta = new Conta(52116, TipoConta.CONTA_CORRENTE, 50);
        Cliente cliente = new Cliente("Alfredo", "161231561321", conta);
        cliente.getConta().sacar(50);
    }

    @Test(expected = WithoutBalanceException.class)
    public void sacarValorMenorQueOSaldo() {
        Conta conta = new Conta(52116, TipoConta.CONTA_CORRENTE, 50);
        Cliente cliente = new Cliente("Alfredo", "161231561321", conta);
        // Depositando 50
        cliente.getConta().depositar(50);
        // Retirando 100
        cliente.getConta().sacar(100);
    }


    @Test
    public void transferirParaOutraConta() {
        Conta conta1 = new Conta(52116, TipoConta.CONTA_CORRENTE, 50);
        Cliente cliente1 = new Cliente("Alfredo", "161231561321", conta1);
        // Depositando 50 para o cliente 1
        cliente1.getConta().depositar(50);

        Conta conta2 = new Conta(52116, TipoConta.CONTA_CORRENTE, 50);
        Cliente cliente2 = new Cliente("Alfredo", "161231561321", conta2);
        // Depositando 50 para o cliente 2
        cliente2.getConta().depositar(50);
        conta1.transferirValor(50, conta2);

        assertEquals(100, cliente2.getConta().getSaldo(), 0.0001);
    }

    @Test(expected = IncorrectAccountException.class)
    public void transferirParaAMesmaConta(){
        Conta conta1 = new Conta(52116, TipoConta.CONTA_CORRENTE, 50);
        Cliente cliente1 = new Cliente("Alfredo", "161231561321", conta1);
        // Depositando 50 para o cliente 1
        cliente1.getConta().depositar(50);
        conta1.transferirValor(50, conta1);
    }

}