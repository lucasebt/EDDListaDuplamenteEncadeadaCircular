
package com.mycompany.aula14;

public class Exercicio1 {
    public int data;
    public Exercicio1 previous;
    public Exercicio1 next;
    
    public Exercicio1(int data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }
}

