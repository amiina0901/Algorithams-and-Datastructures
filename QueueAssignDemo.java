public class QueueAssignDemo {
    public static void main(String[] args) {
        QueueAssign queueAssign = new QueueAssign(5);

        queueAssign.insert(7);
        queueAssign.insert(9);
        queueAssign.insert(10);
        queueAssign.insert(8);
        queueAssign.insert(6);

      
        queueAssign.display();
    }
}
