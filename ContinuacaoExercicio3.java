
package com.mycompany.aula14;

public class ContinuacaoExercicio3 {
    private Exercicio3 head;

    public ContinuacaoExercicio3() {
        this.head = null;
    }

    public int countElements() {
        if (head == null) {
            return 0;
        }

        int count = 1;
        Exercicio3 current = head.next;

        while (current != head) {
            count++;
            current = current.next;
        }

        return count;
    }

    public void insertLeft(int data) {
        Exercicio3 newNode = new Exercicio3(data);

        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Exercicio3 lastNode = head;
            while (lastNode.next != head) {
                lastNode = lastNode.next;
            }

            newNode.next = head;
            lastNode.next = newNode;
            head = newNode;
        }
    }

    public void concatenate(ContinuacaoExercicio3 list) {
        if (head == null) {
            head = list.head;
        } else if (list.head != null) {
            Exercicio3 lastNode = head;
            while (lastNode.next != head) {
                lastNode = lastNode.next;
            }

            lastNode.next = list.head;
            Exercicio3 lastNodeList2 = list.head;
            while (lastNodeList2.next != list.head) {
                lastNodeList2 = lastNodeList2.next;
            }
            lastNodeList2.next = head;
        }
    }

    public static ContinuacaoExercicio3 mergeOrderedLists(ContinuacaoExercicio3 list1, ContinuacaoExercicio3 list2) {
        ContinuacaoExercicio3 mergedList = new ContinuacaoExercicio3();

        Exercicio3 current1 = list1.head;
        Exercicio3 current2 = list2.head;

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
            current1 = current1.next;
        } else {
            mergedList.head = current2;
            current2 = current2.next;
        }

        Exercicio3 mergedListCurrent = mergedList.head;

        while (current1 != list1.head && current2 != list2.head) {
            if (current1.data <= current2.data) {
                mergedListCurrent.next = current1;
                current1 = current1.next;
            } else {
                mergedListCurrent.next = current2;
                current2 = current2.next;
            }
            mergedListCurrent = mergedListCurrent.next;
        }

        if (current1 == list1.head) {
            mergedListCurrent.next = current2;
        } else {
            mergedListCurrent.next = current1;
        }

        mergedListCurrent = mergedList.head;
        while (mergedListCurrent.next != list1.head && mergedListCurrent.next != list2.head) {
            mergedListCurrent = mergedListCurrent.next;
        }

        mergedListCurrent.next = mergedList.head;

        return mergedList;
    }

    public ContinuacaoExercicio3 copy() {
        ContinuacaoExercicio3 newList = new ContinuacaoExercicio3();

        if (head == null) {
            return newList;
        }

        Exercicio3 current = head;
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

        Exercicio3 current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);

        System.out.println();
    }
}
