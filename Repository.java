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

    // Основной метод для тестирования репозитория
    public static void main(String[] args) {
        Repository<String> repository = new Repository<>();

        // Добавление элементов
        repository.add("Item 1");
        repository.add("Item 2");
        repository.add("Item 3");

        // Вывод всех элементов
        System.out.println("All items:");
        repository.getAll().forEach(System.out::println);

        // Поиск элемента по индексу
        Optional<String> item = repository.get(1);
        item.ifPresentOrElse(
            value -> System.out.println("Found item at index 1: " + value),
            () -> System.out.println("Item not found at index 1")
        );

        // Обновление элемента
        boolean updated = repository.update(1, "Updated Item 2");
        if (updated) {
            System.out.println("Item at index 1 updated.");
        } else {
            System.out.println("Failed to update item at index 1.");
        }

        // Удаление элемента
        boolean removed = repository.remove("Item 1");
        if (removed) {
            System.out.println("Item 'Item 1' removed.");
        } else {
            System.out.println("Failed to remove 'Item 1'.");
        }

        // Вывод всех элементов после обновлений
        System.out.println("All items after updates:");
        repository.getAll().forEach(System.out::println);
    }
}
