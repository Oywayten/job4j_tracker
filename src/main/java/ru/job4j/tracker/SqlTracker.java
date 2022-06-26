package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

    public SqlTracker() {
    }

    public SqlTracker(Connection connection) {
        cn = connection;
    }

    /**
     * В методе устанавливается соединение с базой
     */
    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    /**
     * Метод добавляет переданный элемент в базу
     * @param item элемент для добавления в базу
     * @return возвращает переданный элемент
     */
    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = cn.prepareStatement("insert into items (fname, created) values (?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * Метод делает замену элемента
     * @param id переданный параметр id элемента для замены. id остается старый, время создания берется из нового.
     * @param item элемент, на который надо заменить старый элемент по переданному id
     * @return возвращает true, если замена проведена успешно, false, если не успешно.
     */
    @Override
    public boolean replace(int id, Item item) {
        boolean execute = false;
        try (PreparedStatement statement =
                     cn.prepareStatement("update items set fname = ?, created = ? where id = ?")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            execute = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return execute;
    }

    /**
     * Метод удаляет элемент по переданному id
     * @param id id элемента для удаления
     * @return true если удаление успешно
     */
    @Override
    public boolean delete(int id) {
        boolean execute = false;
        try (PreparedStatement statement = cn.prepareStatement("delete from items where id = ?")) {
            statement.setInt(1, id);
            execute = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return execute;
    }

    /**
     * Метод находит все записи в базе
     * @return полный список элементов базы List<Item>
     */
    @Override
    public List<Item> findAll() {
        List<Item> items = new LinkedList<>();
        try (PreparedStatement statement = cn.prepareStatement("select * from items")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(getItem(resultSet));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    /**
     * Метод находит все элементы с указанным именем
     * @param key имя для поиска элементов
     * @return список элементов List<Item> с указанным именем
     */
    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new LinkedList<>();
        try (PreparedStatement statement = cn.prepareStatement("select * from items where fname = ?")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(getItem(resultSet));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement statement = cn.prepareStatement("select * from items where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    item = getItem(resultSet);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    private Item getItem(ResultSet resultSet) throws SQLException {
        return new Item(
                resultSet.getInt("id"),
                resultSet.getString("fname"),
                resultSet.getTimestamp("created").toLocalDateTime()
        );
    }
}
