package www.butle.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.butle.models.Account;
import www.butle.repos.AccountRepo;
import www.butle.services.AccountServices;

import java.util.List;

@Service
public class AccountImpl implements AccountServices {

    private AccountRepo repo;

    @Autowired
    public AccountImpl(AccountRepo repo) {
        this.repo = repo;
    }

    @Override
    public Account add(Account account) {
        return repo.save(account);
    }

    @Override
    public Account update(Account account) {
        long accountId = account.getId();
        Account account1 = repo.findAccountById(Long.valueOf(accountId));
        if(account1 == null){
            return null;
        }
        repo.save(account);
        return account;
    }

    @Override
    public boolean delete(long id) {
        Account account = repo.findAccountById(Long.valueOf(id));
        if (account == null){
            return false;
        }
        repo.delete(account);
        return true;
    }

    @Override
    public List<Account> getAll() {
        return repo.findAll();
    }
}
