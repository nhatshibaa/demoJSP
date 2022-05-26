package com.example.demojsp.model;

import com.example.demojsp.entity.Account;

import java.util.List;

public interface IAccount {
    Account save(Account obj); // lưu thông tin.

    List<Account> findAll();

    Account findById(int id);

    Account findByUsername(String username);

    Account findByEmail(String email);

    Account update(int id, Account updateObj);

    boolean delete(int id);
}
