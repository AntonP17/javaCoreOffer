package tasks;


import java.util.Stack;

public class CustomStringBuilder {

    private String text;
    private StringBuilderCaretaker caretaker = new StringBuilderCaretaker();

    public CustomStringBuilder() {
        this.text = "";
    }

    public void append(String s) {
        this.text += s;
        caretaker.saveState(this);
    }

    public String getText() {
        return this.text;
    }

    public void undo() {
        caretaker.undo(this);
    }

    public void redo() {
        caretaker.redo(this);
    }

    static class StringBuilderMemento {
        private final String state;

        public StringBuilderMemento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    private StringBuilderMemento save() {
        return new CustomStringBuilder.StringBuilderMemento(this.text);
    }

    private void restore(CustomStringBuilder.StringBuilderMemento memento) {
        if (memento != null) {
            this.text = memento.getState();
        }
    }

    private class StringBuilderCaretaker {
        private Stack<StringBuilderMemento> undoStack = new Stack<>();
        private Stack<StringBuilderMemento> redoStack = new Stack<>();

        public void saveState(CustomStringBuilder stringBuilder) {
            undoStack.push(stringBuilder.save());
            redoStack.clear();
        }

        public void undo(CustomStringBuilder stringBuilder) {
            if (!undoStack.isEmpty()) {
                StringBuilderMemento memento = undoStack.pop();
                redoStack.push(memento);
                stringBuilder.restore(memento);
            } else {
                System.out.println("Nothing to undo.");
            }
        }

        public void redo(CustomStringBuilder stringBuilder) {
            if (!redoStack.isEmpty()) {
                StringBuilderMemento memento = redoStack.pop();
                undoStack.push(memento);
                stringBuilder.restore(memento);
            } else {
                System.out.println("Nothing to redo.");
            }
        }
    }
}