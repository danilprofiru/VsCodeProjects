package lab4;

class CustomStack {
    private int[] stack;
    private int top;
    private int capacity;

    public CustomStack(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int item) throws CustomEmptyStackException {
        if (top == capacity - 1) {
            throw new CustomEmptyStackException("Ошибка: Стек полон.");
        }
        stack[++top] = item;
    }

    public int pop() throws CustomEmptyStackException {
        if (isEmpty()) {
            throw new CustomEmptyStackException("Ошибка: Попытка извлечь элемент из пустого стека.");
        }
        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
