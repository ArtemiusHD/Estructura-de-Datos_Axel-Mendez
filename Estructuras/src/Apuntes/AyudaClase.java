package Apuntes;

import java.util.*;
import java.time.LocalDate;

public class AyudaClase {
    public static void main(String[] args) {
        // 1. Cola de Prioridad con Números (Mayor prioridad a números menores)
        PriorityQueue<Integer> colaPrioridadNumeros = new PriorityQueue<>();
        colaPrioridadNumeros.add(10);
        colaPrioridadNumeros.add(5);
        colaPrioridadNumeros.add(20);

        System.out.println("Cola de Prioridad (números):");
        while (!colaPrioridadNumeros.isEmpty()) {
            System.out.println(colaPrioridadNumeros.poll()); // Elementos en orden ascendente
        }

        // 2. Cola de Prioridad con Fechas (Mayor prioridad a fechas más recientes)
        PriorityQueue<LocalDate> colaPrioridadFechas = new PriorityQueue<>(Comparator.reverseOrder());
        colaPrioridadFechas.add(LocalDate.of(2023, 1, 1));
        colaPrioridadFechas.add(LocalDate.of(2022, 12, 31));
        colaPrioridadFechas.add(LocalDate.of(2024, 5, 15));

        System.out.println("\nCola de Prioridad (fechas):");
        while (!colaPrioridadFechas.isEmpty()) {
            System.out.println(colaPrioridadFechas.poll()); // Fechas en orden descendente
        }

        // 3. Cola de Prioridad con Booleanos (Mayor prioridad a true)
        PriorityQueue<Boolean> colaPrioridadBooleanos = new PriorityQueue<>(Comparator.reverseOrder());
        colaPrioridadBooleanos.add(false);
        colaPrioridadBooleanos.add(true);
        colaPrioridadBooleanos.add(false);

        System.out.println("\nCola de Prioridad (booleanos):");
        while (!colaPrioridadBooleanos.isEmpty()) {
            System.out.println(colaPrioridadBooleanos.poll()); // Prioridad a true primero
        }

        // 4. Cola Normal usando LinkedList (FIFO)
        Queue<String> colaNormal = new LinkedList<>();
        colaNormal.add("Elemento 1");
        colaNormal.add("Elemento 2");
        colaNormal.add("Elemento 3");

        System.out.println("\nCola Normal (FIFO):");
        while (!colaNormal.isEmpty()) {
            System.out.println(colaNormal.poll()); // Elementos en orden de inserción
        }

        // 5. Cola Circular (implementación manual)
        CircularQueue circularQueue = new CircularQueue(3);
        circularQueue.enqueue("A");
        circularQueue.enqueue("B");
        circularQueue.enqueue("C");
        System.out.println("\nCola Circular:");
        while (!circularQueue.isEmpty()) {
            System.out.println(circularQueue.dequeue());
        }
    }
}

// Implementación de una cola circular
class CircularQueue {
    private String[] arr;
    private int front, rear, size;

    public CircularQueue(int capacity) {
        arr = new String[capacity];
        front = -1;
        rear = -1;
        size = capacity;
    }

    public void enqueue(String value) {
        if ((rear + 1) % size == front) {
            System.out.println("La cola circular está llena");
            return;
        }
        if (front == -1) front = 0;
        rear = (rear + 1) % size;
        arr[rear] = value;
    }

    public String dequeue() {
        if (front == -1) {
            System.out.println("La cola circular está vacía");
            return null;
        }
        String value = arr[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return value;
    }

    public boolean isEmpty() {
        return front == -1;
    }
}

