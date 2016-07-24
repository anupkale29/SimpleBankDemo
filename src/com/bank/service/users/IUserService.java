package com.bank.service.users;

import java.util.List;

import com.bank.domain.account.Account;
import com.bank.domain.category.Category;
import com.bank.domain.creditdebit.CreditDebitCardInfo;
import com.bank.domain.customer.Customer;
import com.bank.domain.fingerprint.FingerPrint;
import com.bank.domain.users.Users;



public interface IUserService
{
	public boolean checkIfUserExist(String username,String password);
	public boolean checkIfEmailExist(String email);
	public Users getEmployeeByUserName(String username,String encryptedPassword);
	public Users saveUser(Users users);
	public List<Category> getCategories();
	public void saveCustomer(Customer customer);
	public List<Customer> getCustomers();
	public Customer getCustomers(int customerId);
	public void saveAccount(Account account);
	public List<Account> getAccounts();
	public Account getAccounts(int accountId);
	public void saveCreditDebitCardInfo(CreditDebitCardInfo creditDebitCardInfo);
	public List<CreditDebitCardInfo> getCreditDebitCardInfoList();
	public CreditDebitCardInfo getCreditDebitCardInfo(int creditDebitCardInfo);
	public void deleteAccount(int accountId);
	public void deleteCustomer(int customerId);
	public void deleteCreditDebitCard(int creditDebitId);
	public void deletefingerPrintMap(int fingerPrintId);
	public List<FingerPrint> getFingerPrints();
	
	
}
