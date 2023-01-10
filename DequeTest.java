import static org.junit.jupiter.api.Assertions.*;

import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

class DequeTest {

    @Test
    void constructor() {
        Deque<Integer> deck = new Deque<>();
        assertTrue(deck.isEmpty());
        assertEquals(0, deck.size());
    }
    @Test
    void isEmptyOnInit() {
        Deque<Integer> deck = new Deque<>();
        assertTrue(deck.isEmpty());
        assertEquals(0, deck.size());
    }
    
    @Test
    void addFirst() {
        Deque<Integer> deck = new Deque<>();
        assertThrows(IllegalArgumentException.class, () -> deck.addFirst(null));
        deck.addFirst(5);
        deck.addFirst(4);
        deck.addFirst(3);
        deck.addFirst(2);
        deck.addFirst(1);
        int i = 1;
        for ( int num : deck) {
            assertEquals(i++, num);
        }
    }
    
    @Test
    void addLast() {
        Deque<Integer> deck = new Deque<>();
        assertThrows(IllegalArgumentException.class, () -> deck.addLast(null));
        deck.addLast(1);
        deck.addLast(2);
        deck.addLast(3);
        deck.addLast(4);
        deck.addLast(5);
        int i = 1;
        for ( int num : deck) {
            assertEquals(i++, num);
        }
    }
    
    @Test
    void size() {
        Deque<Integer> deck = new Deque<>();
        assertEquals(0, deck.size());
        deck.addLast(1);
        deck.addLast(2);
        deck.addLast(3);
        deck.addLast(4);
        deck.addLast(5);
        assertEquals(5, deck.size());
        deck.removeLast();
        assertEquals(4, deck.size());
        deck.removeFirst();
        assertEquals(3, deck.size());
        deck.addFirst(3);
        assertEquals(4, deck.size());
        deck.addLast(5);
        assertEquals(5, deck.size());
    }
    
    @Test
    void removeFirst() {
        Deque<Integer> deck = new Deque<>();
        assertThrows(NoSuchElementException.class, () -> deck.removeFirst());
        deck.addLast(1);
        assertEquals(1, deck.removeFirst());
        deck.addFirst(5);
        assertEquals(5, deck.removeFirst());
        assertTrue(deck.isEmpty());
    }
    
    @Test
    void removeLast() {
        Deque<Integer> deck = new Deque<>();
        assertThrows(NoSuchElementException.class, () -> deck.removeLast());
        deck.addFirst(1);
        assertEquals(1, deck.removeLast());
        deck.addLast(5);
        assertEquals(5, deck.removeLast());
        assertTrue(deck.isEmpty());
    }
    
    @Test
    void isEmptyOnRemoveFirst() {
        Deque<Integer> deck = new Deque<>();
        deck.addLast(1);
        assertEquals(1, deck.removeFirst());
        deck.addFirst(5);
        assertEquals(5, deck.removeFirst());
        assertTrue(deck.isEmpty());
    }
    
    @Test
    void isEmptyOnRemoveLast() {
        Deque<Integer> deck = new Deque<>();
        deck.addLast(1);
        assertEquals(1, deck.removeLast());
        deck.addFirst(2);
        assertEquals(2, deck.removeLast());
        deck.addFirst(3);
        assertEquals(3, deck.removeLast());
        assertTrue(deck.isEmpty());
    }
    
    @Test
    void isEmptyRemoveFirstThenLast() {
        Deque<Integer> deck = new Deque<>();
        deck.addLast(1);
        assertEquals(1, deck.removeFirst());
        deck.addFirst(5);
        assertEquals(5, deck.removeLast());
        assertTrue(deck.isEmpty());
    }
    
    @Test
    void isEmptyRemoveLastThenFirst() {
        Deque<Integer> deck = new Deque<>();
        deck.addLast(1);
        assertEquals(1, deck.removeLast());
        deck.addFirst(5);
        assertEquals(5, deck.removeFirst());
        assertTrue(deck.isEmpty());
    }
    
    
    @Test
    void iterator() {
        Deque<Integer> deck = new Deque<>();
        assertThrows(UnsupportedOperationException.class, () -> {
            deck.iterator().remove();
        });
        deck.addLast(1);
        deck.addLast(2);
        deck.addLast(3);
    
        Iterator<Integer> iter = deck.iterator();
        assertEquals(1, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(2, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(3, iter.next());
        assertFalse(iter.hasNext());
    }
}