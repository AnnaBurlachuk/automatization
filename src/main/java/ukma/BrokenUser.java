package ukma;

import java.util.Objects;

public class BrokenUser {
    String name;

    public BrokenUser(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode("Hi");
    }
}
