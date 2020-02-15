import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TqsStackTest {

    private final TqsStack stack = new TqsStack();

    @Test
    void isEmptyConstruction() {
        TqsStack stackA = new TqsStack();
        assertTrue(stackA.isEmpty());
    }

    @Test
    void size0Construction() {
        TqsStack stackA = new TqsStack();
        assertEquals (0,stackA.size());
    }

    @Test
    void pushThenPop() {
        stack.push(10);
        assertEquals(10, stack.pop());
    }

    @Test
    void pushThenPeek() {
        stack.push(2);
        int originalsize=stack.size();
        assertEquals(2, stack.peek());
        assertEquals(originalsize,stack.size());
    }

    @Test
    void nPops() {
        int size=stack.size();

        for(int a =0;a<size;a++){
            stack.pop();
        }

        assertTrue(stack.isEmpty());
        assertEquals(0,stack.size());
    }

    @Test
    void nPushes() {
        TqsStack stackA = new TqsStack();
        int n=4;

        for(int a =0;a<n;a++){
            stack.push(a);
        }


        assertTrue( !stack.isEmpty());
        assertEquals(n,stack.size());
    }

    @Test
    void popEmptyStack() {
        TqsStack stackA = new TqsStack();

        assertThrows(NoSuchElementException.class, () -> {
            stackA.pop();
        });
    }

    @Test
    void peekEmptyStack() {
        TqsStack stackA = new TqsStack();

        assertThrows(NoSuchElementException.class, () -> {
            stackA.peek();
        });
    }


}