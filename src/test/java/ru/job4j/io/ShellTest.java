package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShellTest {

    @Test
    public void whenCdBack() {
        Shell shell = new Shell();
        shell.cd("/user");
        shell.cd("../root");
        assertThat(
                shell.pwd()).isEqualTo("/root");
    }

    @Test
    public void whenAbsolutePath() {
        Shell shell = new Shell();
        shell.cd("/path/to/file");
        shell.cd("/new/path/to/my/file");
        assertThat(shell.pwd()).isEqualTo("/new/path/to/my/file");
    }

    @Test
    public void whenCdRoot() {
        Shell shell = new Shell();
        shell.cd("/");
        assertThat(
                shell.pwd()).isEqualTo("/");
    }

    @Test
    public void whenCdUserLocal() {
        Shell shell = new Shell();
        shell.cd("user");
        shell.cd("local");
        assertThat(
                shell.pwd()).isEqualTo("/user/local");
    }

    @Test
    public void whenCdUserBack() {
        Shell shell = new Shell();
        shell.cd("user");
        shell.cd("..");
        assertThat(
                shell.pwd()).isEqualTo("/");
    }
}