public interface List61B<item> {

    public void addFirst(item x);

    public item getFirst();

    public void addLast(item x);

    public item getLast();

    public int size();

    public item removeLast();

    public item get(int i);

    public void insert(item x, int position);

    default public void print() {
        for (int i = 0; i < size(); i++) {
            System.out.print(get(i) + " ");
            System.out.println();
        }
    }

}
