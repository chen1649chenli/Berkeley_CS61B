public class VengefulSLList<item> extends SLList<item> {
    private SLList<item> deletedItems;

    public VengefulSLList() {
        deletedItems = new SLList<>();
    }

    public void printLostItems() {
        deletedItems.print();
    }
    @Override
    public item removeLast() {
        item x = super.removeLast();
        deletedItems.addLast(x);
        return x;
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> vs1 = new VengefulSLList<>();
        vs1.addLast(1);
        vs1.addLast(5);
        vs1.addLast(10);
        vs1.addLast(13);

        vs1.removeLast();
        vs1.removeLast();
        System.out.println("The fallen are: ");
        vs1.printLostItems();
    }
}
