package by.academy.pharmacy.service.util;

import org.junit.jupiter.api.Test;

import static by.academy.pharmacy.service.TestConstant.STRONG_PASSWORD;
import static by.academy.pharmacy.service.TestConstant.UPDATED_STRING;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordUtilTest {
    @Test
    public void testPasswordHashingPositive() {
        String hashedPassword = PasswordUtil.generateStrongPasswordHash(STRONG_PASSWORD);
        assertTrue(PasswordUtil.validatePassword(STRONG_PASSWORD, hashedPassword));
    }

    @Test
    public void testPasswordHashingNegative() {
        String hashedPassword = PasswordUtil.generateStrongPasswordHash(STRONG_PASSWORD);
        assertFalse(
                PasswordUtil.validatePassword(STRONG_PASSWORD + UPDATED_STRING, hashedPassword));
    }
}
