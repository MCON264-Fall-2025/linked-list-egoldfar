package stacks;


public class LinkedStack <T> implements StackInterface<T> {

    @Override
    public void push(T element) throws StackOverflowException {

    }

    @Override
    public T pop() throws StackUnderflowException {
        return null;
    }

    @Override
    public T top() throws StackUnderflowException {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
