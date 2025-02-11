class Node {
    String textState;
    Node prev, next;

    public Node(String textState) {
        this.textState = textState;
        this.prev = this.next = null;
    }
}

class TextEditor {
    private Node head, tail, current;
    private final int maxHistory;
    private int size;

    public TextEditor(int maxHistory) {
        this.maxHistory = maxHistory;
        this.head = this.tail = this.current = null;
        this.size = 0;
    }

    public void type(String newText) {
        Node newNode = new Node(newText);

        if (current != null) {
            current.next = newNode;
            newNode.prev = current;
        }

        current = newNode;

        if (head == null) {
            head = tail = newNode;
        } else {
            tail = newNode;
        }

        size++;
        trimHistory();
        System.out.println("Typed: " + newText);
    }

    private void trimHistory() {
        while (size > maxHistory) {
            head = head.next;
            if (head != null)
                head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.textState);
        } else {
            System.out.println("No more undo actions.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.textState);
        } else {
            System.out.println("No more redo actions.");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.textState);
        } else {
            System.out.println("No text available.");
        }
    }
}

public class TextEditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);

        editor.type("Hello");
        editor.type("Hello, World!");
        editor.type("Hello, World! How are you?");

        editor.displayCurrentState();

        editor.undo();
        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();
    }
}
