
package com.mycompany.aula14;

public class ContinuacaoExercicio5 {
    private Exercicio5 head;

    public ContinuacaoExercicio5() {
        head = new Exercicio5(-1);
        head.next = head;
    }

    public int countElements() {
        int count = 0;
        Exercicio5 current = head.next;

        while (current != head) {
            count++;
            current = current.next;
        }

        return count;
    }

    public void insertLeft(int data) {
        Exercicio5 newNode = new Exercicio5(data);
        newNode.next = head.next;
        head.next = newNode;
    }

    public void concatenate(ContinuacaoExercicio5 list) {
        Exercicio5 lastNode = head;

        while (lastNode.next != head) {
            lastNode = lastNode.next;
        }

        lastNode.next = list.head.next;
        list.head.next = head.next;
        head.next = list.head;
    }

    public static ContinuacaoExercicio5 mergeOrderedLists(ContinuacaoExercicio5 list1, ContinuacaoExercicio5 list2) {
        ContinuacaoExercicio5 mergedList = new ContinuacaoExercicio5();
        Exercicio5 current1 = list1.head.next;
        Exercicio5 current2 = list2.head.next;
        Exercicio5 mergePtr = mergedList.head;

        while (current1 != list1.head && current2 != list2.head) {
            if (current1.data <= current2.data) {
                mergePtr.next = current1;
                current1 = current1.next;
            } else {
                mergePtr.next = current2;
                current2 = current2.next;
            }
            mergePtr = mergePtr.next;
        }

        mergePtr.next = (current1 == list1.head) ? current2 : current1;

        mergedList.head.next = mergedList.head.next.next;
        return mergedList;
    }

    public ContinuacaoExercicio5 copy() {
        ContinuacaoExercicio5 newList = new ContinuacaoExercicio5();
        Exercicio5 current = head.next;

        while (current != head) {
            newList.insertLeft(current.data);
            current = current.next;
        }

        return newList;
    }

    public void printList() {
        if (head.next == head) {
            System.out.println("Lista circular vazia.");
            return;
        }

        Exercicio5 current = head.next;

        while (current != head) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }
}
