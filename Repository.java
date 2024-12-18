import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Repository<T> {
    private List<T> items;

    public Repository() {
        this.items = new ArrayList<>();
    }

    // Добавление элемента
    public void add(T item) {
        items.add(item);
    }

    // Удаление элемента
    public boolean remove(T item) {
        return items.remove(item);
    }

    // Поиск элемента по индексу
    public Optional<T> get(int index) {
        if (index >= 0 && index < items.size()) {
            return Optional.of(items.get(index));
        }
        return Optional.empty();
    }

    // Обновление элемента по индексу
    public boolean update(int index, T newItem) {
        if (index >= 0 && index < items.size()) {
            items.set(index, newItem);
            return true;
        }
        return false;
    }

    // Получение всех элементов
    public List<T> getAll() {
        return new ArrayList<>(items);
    }
}
