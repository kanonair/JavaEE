package io.kanonair.generic;

class Generic<T> {
    private T t;

    T getT() {
        return t;
    }

    void setT(T t) {
        this.t = t;
    }

    <E> E getE(E e) {
        return e;
    }

}
