package courses;

import users.Student;

public class Mark {
    private int value;

    public Mark(int value) {
        validateValue(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(int value) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException("Mark must be between 0 and 100.");
        }
    }
}
