package ru.job4j.early;

import org.checkerframework.checker.nullness.qual.Nullable;
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
    public void whenLengthShortIsLengthError() {
        String password = "aLOVbj~";
        assertThatIllegalArgumentException().isThrownBy(() -> PasswordValidator.validate(password))
                .withMessage(PasswordValidator.LENGTH_ERROR);
    }

    @Test
    public void whenWithoutUpperCaseIsUpError() {
        String password = "#alowbj31~";
        assertThatIllegalArgumentException().isThrownBy(() -> PasswordValidator.validate(password))
                .withMessage(PasswordValidator.UP_ERROR);
    }

    @Test
    public void whenWithoutLowerCaseIsLowError() {
        String password = "#ALOWBJ31~";
        assertThatIllegalArgumentException().isThrownBy(() -> PasswordValidator.validate(password))
                .withMessage(PasswordValidator.LOW_ERROR);
    }

    @Test
    public void whenWithoutNumsIsDigitError() {
        String password = "#aLOVbj~";
        assertThatIllegalArgumentException().isThrownBy(() -> PasswordValidator.validate(password))
                .withMessage(PasswordValidator.DIGIT_ERROR);
    }

    @Test
    public void whenWithoutCharsIsCharError() {
        String password = "fdaLowj31";
        assertThatIllegalArgumentException().isThrownBy(() -> PasswordValidator.validate(password))
                .withMessage(PasswordValidator.CHAR_ERROR);
    }

    @Test
    public void whenWithQwErtYIsQwertyError() {
        String password = "#ALOWQwErtYBJ31~";
        assertThatIllegalArgumentException().isThrownBy(() -> PasswordValidator.validate(password))
                .withMessage(PasswordValidator.QWERTY_ERROR);
    }

}