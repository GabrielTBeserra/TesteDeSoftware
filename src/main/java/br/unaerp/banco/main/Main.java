package br.unaerp.banco.main;

import br.unaerp.banco.entitys.Cliente;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Data.clients = new HashMap<String, Cliente>();
    }
}
