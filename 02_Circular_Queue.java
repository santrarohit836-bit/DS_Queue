// Circular Queue using Array (Beginner Friendly)
class CircularQueue {

    int[] queue;        // array to store elements
    int front = 0;      // points to first element
    int rear = -1;      // points to last element
    int size = 0;       // current number of elements
    int capacity;       // maximum size of queue

    // ================= CONSTRUCTOR =================
    CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
    }

    // ================= ENQUEUE =================
    // Insert element from REAR
    void enqueue(int value) {

        // Queue FULL condition
        if (size == capacity) {
            // OUTPUT:
            // Queue is FULL! Cannot insert 60
            System.out.println("Queue is FULL! Cannot insert " + value);
            return;
        }

        // Circular movement of rear
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;

        // OUTPUT:
        // 10 inserted
        System.out.println(value + " inserted");
    }

    // ================= DEQUEUE =================
    // Remove element from FRONT
    int dequeue() {

        // Queue EMPTY condition
        if (size == 0) {
            // OUTPUT:
            // Queue is EMPTY! Nothing to remove
            System.out.println("Queue is EMPTY! Nothing to remove");
            return -1;
        }

        int removed = queue[front];

        // Circular movement of front
        front = (front + 1) % capacity;
        size--;

        // OUTPUT:
        // Removed: 10
        return removed;
    }

    // ================= PEEK =================
    // Get front element without removing
    int peek() {

        if (size == 0) {
            // OUTPUT:
            // Queue is EMPTY! No front element
            System.out.println("Queue is EMPTY! No front element");
            return -1;
        }

        // OUTPUT:
        // Front element: 20
        return queue[front];
    }

    // ================= DISPLAY =================
    void display() {

        if (size == 0) {
            // OUTPUT:
            // Queue is EMPTY
            System.out.println("Queue is EMPTY");
            return;
        }

        System.out.print("Queue elements: ");

        // Print elements in circular manner
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }

        // OUTPUT:
        // Queue elements: 20 30 40
        System.out.println();
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        CircularQueue cq = new CircularQueue(5);

        // -------- INSERTIONS --------
        cq.enqueue(10);
        // Queue: 10

        cq.enqueue(20);
        // Queue: 10 20

        cq.enqueue(30);
        // Queue: 10 20 30

        cq.enqueue(40);
        // Queue: 10 20 30 40

        cq.display();
        // OUTPUT: Queue elements: 10 20 30 40

        // -------- REMOVALS --------
        System.out.println("Removed: " + cq.dequeue());
        // OUTPUT: Removed: 10
        // Queue: 20 30 40

        System.out.println("Removed: " + cq.dequeue());
        // OUTPUT: Removed: 20
        // Queue: 30 40

        cq.display();
        // OUTPUT: Queue elements: 30 40

        // -------- CIRCULAR BEHAVIOR --------
        cq.enqueue(50);
        cq.enqueue(60);
        // rear goes back to start (circular)

        cq.display();
        // OUTPUT: Queue elements: 30 40 50 60

        // -------- FULL QUEUE --------
        cq.enqueue(70);
        // OUTPUT: Queue is FULL! Cannot insert 70

        // -------- PEEK --------
        System.out.println("Front element: " + cq.peek());
        // OUTPUT: Front element: 30
    }
}
