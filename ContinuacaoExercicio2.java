
package com.mycompany.aula14;

public class ContinuacaoExercicio2 {
    private Exercicio2 head;
    private Exercicio2 tail;

    public ContinuacaoExercicio2() {
        // Criação do nó cabeça
        head = new Exercicio2(-1);
        tail = new Exercicio2(-1);
        head.next = tail;
        tail.previous = head;
    }

    public void insert(int data) {
        Exercicio2 newNode = new Exercicio2(data);
        Exercicio2 lastNode = tail.previous;

        newNode.next = tail;
        newNode.previous = lastNode;

        lastNode.next = newNode;
        tail.previous = newNode;
    }

    public void delete(int data) {
        Exercicio2 current = head.next;

        while (current != tail) {
            if (current.data == data) {
                Exercicio2 previousNode = current.previous;
                Exercicio2 nextNode = current.next;

                previousNode.next = nextNode;
                nextNode.previous = previousNode;
                return;
            }

            current = current.next;
        }
    }

    public Exercicio2 search(int data) {
        Exercicio2 current = head.next;

        while (current != tail) {
            if (current.data == data) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    public void printList() {
        Exercicio2 current = head.next;

        while (current != tail) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }
}
