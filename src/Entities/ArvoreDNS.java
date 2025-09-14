package Entities;

import java.util.ArrayList;

public class ArvoreDNS<T extends Comparable<T>> {

    /* Constante da raiz principal conceitual */
    private static final String ROOT_DNS_SERVER = "Root DNS Server";

    /* Valor do nó */
    private T noRaiz;
    private int IP;

    /* Lista de subárvores */
    private final ArrayList<ArvoreDNS<T>> lista_subarvores;

    /* Construtor da raiz principal */
    public ArvoreDNS(T valor) {
        this.noRaiz = valor;
        this.lista_subarvores = new ArrayList<>();
    }

    /* Construtor de nó com valor e IP */
    public ArvoreDNS(T valor, int IP) {
        this.noRaiz = valor;
        this.IP = IP;
        this.lista_subarvores = new ArrayList<>();
    }

    /* Insere subárvore */
    public void inserirSubarvore(ArvoreDNS<T> subArvore) {
        if (subArvore != null) {
            this.lista_subarvores.add(subArvore);
        }
    }

    /* Retorna valor armazenado em nó filho pelo índice */
    public T retornaValorNo(int index) {
        if (!lista_subarvores.isEmpty() && index >= 0 && index < lista_subarvores.size()) {
            return lista_subarvores.get(index).noRaiz;
        }
        return null;
    }

    /* Modifica valor da raiz deste nó */
    public void alterarRaiz(T novaRaiz) {
        this.noRaiz = novaRaiz;
    }

    /* Busca uma subárvore a partir de um valor */
    public ArvoreDNS<T> retornaSubArvore(T valor) {
        if (noRaiz.equals(valor)) {
            return this;
        }
        for (ArvoreDNS<T> filho : lista_subarvores) {
            ArvoreDNS<T> resultado = filho.retornaSubArvore(valor);
            if (resultado != null) {
                return resultado;
            }
        }
        return null;
    }

    /* Imprime a árvore recursivamente */
    public void mostra() {
        System.out.print("(" + noRaiz);
        for (ArvoreDNS<T> filho : lista_subarvores) {
            filho.mostra();
        }
        System.out.print(")");

    }

    /* Busca por valor */
    public ArvoreDNS<T> busca(T valor) {
        if (valor.compareTo(noRaiz) == 0) {
            return this;
        }
        for (ArvoreDNS<T> filho : lista_subarvores) {
            ArvoreDNS<T> ret = filho.busca(valor);
            if (ret != null) {
                return ret;
            }
        }
        return null;
    }

    /* Conta número total de nós da árvore */
    public int contaNos() {
        int total = 1; // conta o próprio nó
        for (ArvoreDNS<T> filho : lista_subarvores) {
            total += filho.contaNos();
        }
        return total;
    }

    /* Calcula altura da árvore */
    public int calculaAltura() {
        int alturaMax = 0;
        for (ArvoreDNS<T> filho : lista_subarvores) {
            alturaMax = Math.max(alturaMax, filho.calculaAltura());
        }
        return 1 + alturaMax;
    }

    /* Getters básicos */
    public T getNoRaiz() {
        return noRaiz;
    }

    public int getIP() {
        return IP;
    }
}
