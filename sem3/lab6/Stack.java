package lab6;

public class Stack<T> {
    private T[] data;
    private int size;

    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            throw new StackOverflowError("Стек переполнен");
        }
        data[size++] = element;
    }

    public T pop() throws CustomEmptyStackException {
        if (isEmpty()) {
            throw new CustomEmptyStackException("Ошибка: Попытка извлечь элемент из пустого стека.");
        }
        T element = data[--size];
        data[size] = null;
        return element;
    }

    public T peek() throws CustomEmptyStackException {
        if (isEmpty()) {
            throw new CustomEmptyStackException("Ошибка: Попытка прочесть элемент из пустого стека.");
        }
        return data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        try {
            System.out.println(stack.pop()); // выводит 3
            System.out.println(stack.peek()); // выводит 2
            stack.push(4);
            System.out.println(stack.pop()); // выводит 4
        } catch (CustomEmptyStackException e) {
            System.out.println(e.getMessage());
        }
    }
}
