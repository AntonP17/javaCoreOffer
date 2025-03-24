package tasks;


import java.util.ArrayList;
import java.util.List;
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
        return new StringBuilderMemento(this.text);
    }

    private void restore(CustomStringBuilder.StringBuilderMemento memento) {
        if (memento != null) {
            this.text = memento.getState();
        }
    }

    private class StringBuilderCaretaker {
        private List<StringBuilderMemento> states = new ArrayList<>();
        private int currentStateIndex = -1;

        public void saveState(CustomStringBuilder stringBuilder) {
            if (currentStateIndex < states.size() - 1) {
                states.subList(currentStateIndex + 1, states.size()).clear();
            }
            states.add(stringBuilder.save());
            currentStateIndex++;
        }

        public void undo(CustomStringBuilder stringBuilder) {
            if (currentStateIndex > 0) {
                currentStateIndex--;
                stringBuilder.restore(states.get(currentStateIndex));
            } else {
                System.out.println("Nothing to undo.");
            }
        }

        public void redo(CustomStringBuilder stringBuilder) {
            if (currentStateIndex < states.size() - 1) {
                currentStateIndex++;
                stringBuilder.restore(states.get(currentStateIndex));
            } else {
                System.out.println("Nothing to redo.");
            }
        }
    }
}