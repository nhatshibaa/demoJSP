package com.example.demojsp.model;

import com.example.demojsp.entity.Account;
import com.example.demojsp.entity.enums.AccountStatus;
import com.example.demojsp.util.SHA512Hasher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlAccountModelTest {

    private MySqlAccountModel model;

    @BeforeEach
    void setUp() {
        model = new MySqlAccountModel();
    }

    @Test
    void save() {
        Account account = new Account();
        String salt = SHA512Hasher.randomString(10);
        account.setSalt(salt);
        account.setUsername("nhatdz");
        account.setPhone("0123454123");
        account.setEmail("nhat@gmail.com");
        account.setPassword("123123");
        account.setPasswordHash(SHA512Hasher.encode(account.getPassword(), salt));
        account.setStatus(AccountStatus.ACTIVE);
        model.save(account);
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByUsername() {
    }

    @Test
    void findByEmail() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}