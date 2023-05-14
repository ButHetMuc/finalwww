package www.butle.services;

import www.butle.models.Account;

import java.util.List;

public interface AccountServices{
    public Account add (Account account);
    public Account update (Account account);
    public boolean delete(long id);
    public List<Account> getAll();
}
