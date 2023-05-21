
package com.mycompany.aula14;

public class ContinuacaoExercicio4 {
    private Exercicio4 head;

    public ContinuacaoExercicio4() {
        this.head = null;
    }

    public int countElements() {
        if (head == null) {
            return 0;
        }

        int count = 1;
        Exercicio4 current = head.next;

        while (current != head) {
            count++;
            current = current.next;
        }

        return count;
    }

    public void insertLeft(int data) {
        Exercicio4 newNode = new Exercicio4(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void concatenate(ContinuacaoExercicio4 list) {
        if (head == null) {
            head = list.head;
        } else if (list.head != null) {
            Exercicio4 lastNode = head.prev;
            lastNode.next = list.head;
            list.head.prev.next = head;
            head.prev = list.head.prev;
            list.head.prev = lastNode;
        }
    }

    public static ContinuacaoExercicio4 mergeOrderedLists(ContinuacaoExercicio4 list1, ContinuacaoExercicio4 list2) {
        ContinuacaoExercicio4 mergedList = new ContinuacaoExercicio4();

        Exercicio4 current1 = list1.head;
        Exercicio4 current2 = list2.head;

        if (current1 == null) {
            mergedList.head = current2;
            return mergedList;
        }

        if (current2 == null) {
            mergedList.head = current1;
            return mergedList;
        }

        if (current1.data <= current2.data) {
            mergedList.head = current1;
            current1.prev = current2.prev;
            current2.prev.next = current1;
            current2.next.prev = current1;
            current1.next = current2.next;
            current2 = current2.next;
        } else {
            mergedList.head = current2;
            current2.prev = current1.prev;
            current1.prev.next = current2;
            current1.next.prev = current2;
            current2.next = current1.next;
            current1 = current1.next;
        }

        Exercicio4 mergedListCurrent = mergedList.head;

        while (current1 != list1.head && current2 != list2.head) {
            if (current1.data <= current2.data) {
                mergedListCurrent.next = current1;
                current1.prev = mergedListCurrent;
                current1 = current1.next;
            } else {
                mergedListCurrent.next = current2;
                current2.prev = mergedListCurrent;
                current2 = current2.next;
            }
            mergedListCurrent = mergedListCurrent.next;
        }

        if (current1 == list1.head) {
            mergedListCurrent.next = current2;
            current2.prev = mergedListCurrent;
        } else {
            mergedListCurrent.next = current1;
            current1.prev = mergedListCurrent;
        }

        mergedList.head.prev = mergedListCurrent;
        mergedListCurrent.next = mergedList.head;

        return mergedList;
    }

    public ContinuacaoExercicio4 copy() {
        ContinuacaoExercicio4 newList = new ContinuacaoExercicio4();

        if (head == null) {
            return newList;
        }

        Exercicio4 current = head;
        do {
            newList.insertLeft(current.data);
            current = current.next;
        } while (current != head);

        return newList;
    }

    public void printList() {
        if (head == null) {
            return;
        }

        Exercicio4 current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);

        System.out.println();
    }
}
