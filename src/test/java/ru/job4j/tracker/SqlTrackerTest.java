package ru.job4j.tracker;

import org.junit.jupiter.api.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    /**
     * В методе выполняется инициализация подключения. Метод выполняется один раз до начала тестов.
     */
    @BeforeAll
    public static void initConnection() {
        try (InputStream in = new FileInputStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * В методе выполняется закрытие подключения. Метод выполняется один раз после тестов;
     *
     * @throws SQLException ошибка работы с базой
     */
    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    /**
     * В методе чистим таблицу items после внесенных изменений. Выполняется до и после каждого теста.
     *
     * @throws SQLException ошибка работы с базой
     */
    @BeforeEach
    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("truncate table items restart identity")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSameAndDeleteItemMustByTrueAndFindByIdMustBeNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        int id = item.getId();
        assertThat(tracker.findById(id)).isEqualTo(item);
        assertThat(tracker.delete(id)).isTrue();
        assertThat(tracker.findById(id)).isNull();
    }

    @Test
    public void whenSaveFewItemsAndFindAllItemsThenMustBeTheSameItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        Item item3 = tracker.add(new Item("item3"));
        assertThat(tracker.findAll()).isEqualTo(List.of(item1, item2, item3));
        assertThat(tracker.findAll().size()).isEqualTo(3);
    }

    @Test
    public void whenSave2ItemsWithSameNameAnd1ItemWithDiffNameAndFindByNameThenMustBeListWith2ItemsWithSameName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item"));
        Item item2 = tracker.add(new Item("item"));
        tracker.add(new Item("itemNew"));
        assertThat(tracker.findByName("item")).isEqualTo(List.of(item1, item2));
    }

    @Test
    public void whenAddItemAndReplaceWithNewItemThenMustBeNewItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        Item item1 = new Item("newItem");
        int id = item.getId();
        assertThat(tracker.replace(item.getId(), item1)).isTrue();
        assertThat(tracker.findById(id).getName()).isEqualTo("newItem");
    }
}