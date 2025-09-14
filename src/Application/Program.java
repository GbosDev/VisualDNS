package Application;

import Entities.ArvoreDNS;

public class Program {
    public static void main(String[] Args) {


        System.out.println("Seja bem vindo simulador de DNS (The Domain Name - System DMS)!");
        ArvoreDNS<String> root = new ArvoreDNS<>("Root DNS Server", 1);
        System.out.println("- O Root DNS Server acaba de ficar disponível!");

        //Criação de TLDs
        ArvoreDNS<String> tldCom = new ArvoreDNS<>(".com", 2);
        ArvoreDNS<String> tldOrg = new ArvoreDNS<>(".org", 3);
        ArvoreDNS<String> tldNet = new ArvoreDNS<>(".edu", 4);

        //Adicionando TLDs à raiz
        root.inserirSubarvore(tldCom);
        root.inserirSubarvore(tldOrg);
        root.inserirSubarvore(tldNet);

        //Servidores autoritativos para .com
        ArvoreDNS<String> autCom1 = new ArvoreDNS<>("yahoo.com", 101);
        ArvoreDNS<String> autCom2 = new ArvoreDNS<>("amazon.com", 102);
        tldCom.inserirSubarvore(autCom1);
        tldCom.inserirSubarvore(autCom2);

        //Servidores autoritativos para .org
        ArvoreDNS<String> autOrg1 = new ArvoreDNS<>("pbs.org", 201);
        tldOrg.inserirSubarvore(autOrg1);

        //Servidores autoritativos para .edu
        ArvoreDNS<String> autNet1 = new ArvoreDNS<>("nyu.edu", 301);
        ArvoreDNS<String> autNet2 = new ArvoreDNS<>("umass.edu", 302);
        tldNet.inserirSubarvore(autNet1);
        tldNet.inserirSubarvore(autNet2);

        //Exibição completa da árvore
        System.out.println("------------------------");
        System.out.println("Estrutura da árvore DNS: ");

        root.mostra();
        System.out.println();

        //Conta número total de nós
        System.out.println("----------------------");
        System.out.println("Total de nós na árvore: " + root.contaNos());

        //Calcula altura da árvore
        System.out.println("----------------------");
        System.out.println("Altura da árvore: " + root.calculaAltura());

        //Busca por um nó
        System.out.println("----------------------");
        String noRequisitado = "amazon.com";

        System.out.println("Busca de valor " + noRequisitado + " no DNS: ");

        ArvoreDNS<String> resultado = root.busca(noRequisitado);
        if (resultado != null) {
            System.out.println("Valor " + noRequisitado + " encontrado!");
        } else {
            System.out.println("Valor " + noRequisitado + " não encontrado.");
        }
    }
}
