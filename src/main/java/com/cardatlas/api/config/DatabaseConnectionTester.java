package com.cardatlas.api.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class DatabaseConnectionTester implements CommandLineRunner {

    private final DataSource dataSource;

    public DatabaseConnectionTester(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- ADATBÁZIS KAPCSOLAT TESZTELÉSE ---");
        try (Connection connection = dataSource.getConnection()) {
            if (connection.isValid(1)) {
                System.out.println("✅ SIKERES KAPCSOLAT AZ ADATBÁZISSAL!");
            } else {
                System.out.println("❌ SIKERTELEN KAPCSOLAT!");
            }
        } catch (Exception e) {
            System.err.println("❌ HIBA A KAPCSOLÓDÁS SORÁN: " + e.getMessage());
        }
        System.out.println("------------------------------------");
    }
}