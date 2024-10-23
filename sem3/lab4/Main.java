package lab4;

public class Main {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(2);

        try {
            stack.pop();
        } catch (CustomEmptyStackException e) {
            System.out.println(e.getMessage());
        }

        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
        } catch (CustomEmptyStackException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Извлеченный элемент: " + stack.pop());
            System.out.println("Извлеченный элемент: " + stack.pop());
            System.out.println("Извлеченный элемент: " + stack.pop());
        } catch (CustomEmptyStackException e) {
            System.out.println(e.getMessage());
        }
    }
}
