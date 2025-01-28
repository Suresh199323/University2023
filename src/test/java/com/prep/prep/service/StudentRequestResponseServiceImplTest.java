package com.prep.prep.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StudentServiceImpl.class})
@ExtendWith(SpringExtension.class)
class StudentRequestResponseServiceImplTest {
    @MockBean(name = "scoppJDBCTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    /**
     * Method under test: {@link StudentServiceImpl#cool()}
     */
    @Test
    void testCool() throws ParseException, DataAccessException {
        when(jdbcTemplate.update(Mockito.<String>any())).thenReturn(1);
        assertEquals(1, studentServiceImpl.cool());
        verify(jdbcTemplate).update(Mockito.<String>any());
    }
}

