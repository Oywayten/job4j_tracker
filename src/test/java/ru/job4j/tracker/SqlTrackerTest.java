package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

  /*  private static Connection connection;

    *//**
     * В методе выполняется инициализация подключения. Метод выполняется один раз до начала тестов.
     *//*
    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
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

    *//**
     * В методе выполняется закрытие подключения. Метод выполняется один раз после тестов;
     * @throws SQLException ошибка работы с базой
     *//*
    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    *//**
     * В методе чистим таблицу items после внесенных изменений. Выполняется после каждого теста.
     * @throws SQLException ошибка работы с базой
     *//*
    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSameAndDeleteItemMustByTrueAndFindByIdMustBeNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        int id = item.getId();
        assertThat(tracker.findById(id), is(item));
        assertThat(tracker.delete(id), is(true));
        assertNull(tracker.findById(id));
    }

    @Test
    public void whenSaveFewItemsAndFindAllItemsThenMustBeTheSameItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        Item item3 = tracker.add(new Item("item3"));
        assertThat(tracker.findAll().size(), is(3));
        assertThat(tracker.findAll(), is(List.of(item1, item2, item3)));
    }

    @Test
    public void whenSave2ItemsWithSameNameAnd1ItemWithDiffNameAndFindByNameThenMustBeListWith2ItemsWithSameName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item"));
        Item item2 = tracker.add(new Item("item"));
        tracker.add(new Item("itemNew"));
        assertThat(tracker.findByName("item"), is(List.of(item1, item2)));
    }

    @Test
    public void whenAddItemAndReplaceWithNewItemThenMustBeNewItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        Item item1 = new Item("newItem");
        int id = item.getId();
        assertThat(tracker.replace(item.getId(), item1), is(true));
        assertThat(tracker.findById(id).getName(), is("newItem"));
    }*/

}