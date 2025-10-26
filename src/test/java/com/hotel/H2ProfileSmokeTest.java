package com.hotel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("h2")
public class H2ProfileSmokeTest {

    @Autowired
    private DataSource dataSource;

    @Test
    void dataSourceLooksLikeH2() throws SQLException {
        assertNotNull(dataSource, "DataSource should be present when h2 profile is active");
        try (Connection c = dataSource.getConnection()) {
            String url = c.getMetaData().getURL();
            assertNotNull(url);
            assertTrue(url.contains("jdbc:h2:"), () -> "DataSource URL should be H2 but was: " + url);
        }
    }
}
