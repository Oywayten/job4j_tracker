package ru.job4j.early;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    public void whenNullIsIAE() {
        assertThatIllegalArgumentException().isThrownBy(() -> PasswordValidator.validate(null));
    }

    @Test
    public void whenisValid() {
        String password = "#aLOVbj31~";
        String actual = PasswordValidator.validate(password);
        String expected = PasswordValidator.ALL_RIGHT;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenLengthIsShort() {
        String password = "aLOVbj~";
        String actual = PasswordValidator.validate(password);
        String expected = PasswordValidator.LENGTH_ERROR;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenWithoutUpperCase() {
        String password = "#alowbj31~";
        String actual = PasswordValidator.validate(password);
        String expected = PasswordValidator.UP_ERROR;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenWithoutLowerCase() {
        String password = "#ALOWBJ31~";
        String actual = PasswordValidator.validate(password);
        String expected = PasswordValidator.LOW_ERROR;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenWithoutNums() {
        String password = "#aLOVbj~";
        String actual = PasswordValidator.validate(password);
        String expected = PasswordValidator.DIGIT_ERROR;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenWithoutChars() {
        String password = "fdaLowj31";
        String actual = PasswordValidator.validate(password);
        String expected = PasswordValidator.CHAR_ERROR;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenWithQwErtY() {
        String password = "#ALOWQwErtYBJ31~";
        String actual = PasswordValidator.validate(password);
        String expected = PasswordValidator.QWERTY_ERROR;
        assertThat(actual).isEqualTo(expected);
    }

}