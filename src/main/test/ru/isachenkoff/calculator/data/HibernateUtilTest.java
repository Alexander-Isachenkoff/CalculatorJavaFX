package ru.isachenkoff.calculator.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HibernateUtilTest {
    
    @Test
    void getSessionFactory() {
        HibernateUtil.getSession();
    }
}