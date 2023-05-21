
package com.mycompany.aula14;

public class ContinuacaoExercicio1 {
    private Exercicio1 head;
    private Exercicio1 tail;
    
    public ContinuacaoExercicio1() {
        this.head = null;
        this.tail = null;
    }
    
    public void concat(ContinuacaoExercicio1 list) {
        if (list.head == null) {
            return;
        }
        
        if (this.head == null) {
            this.head = list.head;
            this.tail = list.tail;
        } else {
            this.tail.next = list.head;
            list.head.previous = this.tail;
            this.tail = list.tail;
        }
    }
    
    public ContinuacaoExercicio1[] split() {
        ContinuacaoExercicio1[] result = new ContinuacaoExercicio1[2];
        result[0] = new ContinuacaoExercicio1();
        result[1] = new ContinuacaoExercicio1();
        
        if (this.head == null) {
            return result;
        }
        
        Exercicio1 current = this.head;
        int size = getSize();
        int halfSize = size / 2;
        
        for (int i = 0; i < halfSize; i++) {
            result[0].addToTail(current.data);
            current = current.next;
        }
        
        while (current != null) {
            result[1].addToTail(current.data);
            current = current.next;
        }
        
        return result;
    }
    
    public ContinuacaoExercicio1 merge(ContinuacaoExercicio1 list1, ContinuacaoExercicio1 list2) {
        ContinuacaoExercicio1 mergedList = new ContinuacaoExercicio1();
        
        Exercicio1 current1 = list1.head;
        Exercicio1 current2 = list2.head;
        
        while (current1 != null && current2 != null) {
            if (current1.data <= current2.data) {
                mergedList.addToTail(current1.data);
                current1 = current1.next;
            } else {
                mergedList.addToTail(current2.data);
                current2 = current2.next;
            }
        }
        
        while (current1 != null) {
            mergedList.addToTail(current1.data);
            current1 = current1.next;
        }
        
        while (current2 != null) {
            mergedList.addToTail(current2.data);
            current2 = current2.next;
        }
        
        return mergedList;
    }
    
    public void addToTail(int data) {
        Exercicio1 newNode = new Exercicio1(data);
        
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.previous = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }
    
    public int getSize() {
        int size = 0;
        Exercicio1 current = this.head;
        
        while (current != null) {
            size++;
            current = current.next;
        }
        
        return size;
    }
    
    public void printList() {
        Exercicio1 current = this.head;
        
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        
        System.out.println();
    }
} 

