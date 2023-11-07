package com.ecomArt.service.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionsTest {

    @Test
    public void testBadRequest() {
        BadRequestException firstException = new BadRequestException("ExceptionTestMessage");
        assertEquals("ExceptionTestMessage", firstException.getMessage());

        Throwable cause = new RuntimeException("testCause");
        BadRequestException secondException = new BadRequestException("ExceptionTestMessage", cause);
        assertEquals("ExceptionTestMessage", secondException.getMessage());
        assertEquals(cause, secondException.getCause());
    }

    @Test
    public void testForbiddenException() {
        ForbiddenException firstException = new ForbiddenException("ExceptionTestMessage");
        assertEquals("ExceptionTestMessage", firstException.getMessage());

        Throwable cause = new RuntimeException("testCause");
        ForbiddenException secondException = new ForbiddenException("ExceptionTestMessage", cause);
        assertEquals("ExceptionTestMessage", secondException.getMessage());
        assertEquals(cause, secondException.getCause());
    }

    @Test
    public void testInvalidUser() {
        InvalidUserLoginAccessException exception = new InvalidUserLoginAccessException("ExceptionTestMessage");
        assertEquals("ExceptionTestMessage", exception.getMessage());
    }

    @Test
    public void testResource() {
        ResourceNotFoundException firstException = new ResourceNotFoundException("ExceptionTestMessage");
        assertEquals("ExceptionTestMessage", firstException.getMessage());

        Throwable cause = new RuntimeException("testCause");
        ResourceNotFoundException secondException = new ResourceNotFoundException("ExceptionTestMessage", cause);
        assertEquals("ExceptionTestMessage", secondException.getMessage());
        assertEquals(cause, secondException.getCause());
    }
}