/** Linear queue (FIFO) implemented with a fixed-size array. */
public class LinearQueue {
    private final int[] data;
    private int front = 0;   // index of the first element
    private int rear = -1;   // index of the last element

    public LinearQueue(int capacity) {
        data = new int[capacity];
    }

    public boolean isEmpty() { return front > rear; }

    // Full when rear reached the last slot, even if slots before front are free.
    public boolean isFull() { return rear == data.length - 1; }

    public int size() { return isEmpty() ? 0 : rear - front + 1; }

    public boolean enqueue(int value) {          // O(1)
        if (isFull()) {
            System.out.println("Queue is full, cannot enqueue " + value);
            return false;
        }
        data[++rear] = value;
        return true;
    }

    public Integer dequeue() {                   // O(1)
        if (isEmpty()) {
            System.out.println("Queue is empty, cannot dequeue");
            return null;
        }
        int value = data[front++];
        if (front > rear) { front = 0; rear = -1; }  // reset when it becomes empty
        return value;
    }

    public Integer peek() {                      // O(1)
        return isEmpty() ? null : data[front];
    }

    public void display() {                      // O(n)
        if (isEmpty()) { System.out.println("Queue: [] (empty)"); return; }
        StringBuilder sb = new StringBuilder("Queue (front -> rear): ");
        for (int i = front; i <= rear; i++) sb.append(data[i]).append(i < rear ? ", " : "");
        sb.append("   [front=").append(front).append(", rear=").append(rear).append("]");
        System.out.println(sb);
    }
}
