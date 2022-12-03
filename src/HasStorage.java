package src;

public interface HasStorage<T> {

    boolean canAddToStorage(T item);

    T removeFromStorage();
    T removeFromStorage(T item);

}
