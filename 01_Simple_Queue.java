// Simple Queue implementation using Array
class SimpleQueueArray {

    int[] queue;      // array to store elements
    int front = 0;    // points to first element
    int rear = -1;    // points to last element
    int size;         // maximum size of queue

    // ================= CONSTRUCTOR =================
    SimpleQueueArray(int size) {
        this.size = size;
        queue = new int[size];
    }

    // ================= ENQUEUE OPERATION =================
    // Adds element at the REAR of the queue
    void enqueue(int value) {

        // Check for Queue Overflow
        if (rear == size - 1) {
            // OUTPUT:
            // Queue Overflow! Cannot insert.
            System.out.println("Queue Overflow! Cannot insert.");
            return;
        }

        rear++;
        queue[rear] = value;

        // OUTPUT:
        // enqueue(10) → 10 inserted
        // enqueue(20) → 20 inserted
        System.out.println(value + " inserted into queue");
    }

    // ================= DEQUEUE OPERATION =================
    // Removes element from the FRONT of the queue
    int dequeue() {

        // Check for Queue Underflow
        if (front > rear) {
            // OUTPUT:
            // Queue Underflow! Nothing to remove.
            System.out.println("Queue Underflow! Nothing to remove.");
            return -1;
        }

        int removed = queue[front];
        front++;

        // OUTPUT:
        // dequeue() → removes 10
        return removed;
    }

    // ================= PEEK OPERATION =================
    // Returns front element without removing
    int peek() {

        if (front > rear) {
            // OUTPUT:
            // Queue is empty. Nothing to peek.
            System.out.println("Queue is empty. Nothing to peek.");
            return -1;
        }

        // OUTPUT:
        // peek() → returns 10
        return queue[front];
    }

    // ================= DISPLAY QUEUE =================
    void display() {

        if (front > rear) {
            // OUTPUT:
            // Queue is empty.
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");

        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }

        // OUTPUT:
        // Queue elements: 10 20 30
        System.out.println();
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        SimpleQueueArray q = new SimpleQueueArray(5);

        q.enqueue(10);
        // OUTPUT: 10 inserted into queue
        // Queue: 10

        q.enqueue(20);
        // OUTPUT: 20 inserted into queue
        // Queue: 10 20

        q.enqueue(30);
        // OUTPUT: 30 inserted into queue
        // Queue: 10 20 30

        q.display();
        // OUTPUT: Queue elements: 10 20 30

        System.out.println("Front element: " + q.peek());
        // OUTPUT: Front element: 10

        System.out.println("Removed element: " + q.dequeue());
        // OUTPUT: Removed element: 10
        // Queue after removal: 20 30

        q.display();
        // OUTPUT: Queue elements: 20 30
    }
}
