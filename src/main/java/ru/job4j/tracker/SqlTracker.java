package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

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

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = cn.prepareStatement("insert into items (fname, created) values (?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
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

    @Override
    public boolean replace(int id, Item item) {
        boolean execute = false;
        try (PreparedStatement statement =
                     cn.prepareStatement("update items set fname = ?, created = ? where id = ?")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            statement.setInt(3, id);
            execute = statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return execute;
    }

    @Override
    public boolean delete(int id) {
        boolean execute = false;
        try (PreparedStatement statement = cn.prepareStatement("delete from items where id = ?")) {
            statement.setInt(1, id);
            execute = statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return execute;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new LinkedList<>();
        try (PreparedStatement statement = cn.prepareStatement("select * from items")) {
            statement.execute();
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("fname"),
                            resultSet.getTimestamp("created").toLocalDateTime()
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new LinkedList<>();
        try (PreparedStatement statement = cn.prepareStatement("select * from items where fname = ?")) {
            statement.setString(1, key);
            statement.execute();
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("fname"),
                            resultSet.getTimestamp("created").toLocalDateTime()
                    ));
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
            statement.execute();
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                item = new Item(
                        resultSet.getInt("id"),
                        resultSet.getString("fname"),
                        resultSet.getTimestamp("created").toLocalDateTime()
                );

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
}