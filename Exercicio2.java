
package com.mycompany.aula14;

public class Exercicio2 {
       public int data;
    public Exercicio2 previous;
    public Exercicio2 next;

    public Exercicio2(int data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }
}