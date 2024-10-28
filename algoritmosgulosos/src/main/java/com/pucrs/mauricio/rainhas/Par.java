package com.pucrs.mauricio.rainhas;

public class Par {
    final int x, y;

    public Par(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Par p)) // pattern-matching my beloved <3
            return false;
        return this.x == p.x &&
            this.y == p.y;
    }
    @Override
    public String toString() {
        return String.format("(%d, %d)", this.x, this.y);
    }
}
