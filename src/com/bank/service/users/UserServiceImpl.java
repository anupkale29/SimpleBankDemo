package com.bank.service.users;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.domain.account.Account;
import com.bank.domain.category.Category;
import com.bank.domain.creditdebit.CreditDebitCardInfo;
import com.bank.domain.customer.Customer;
import com.bank.domain.fingerprint.FingerPrint;
import com.bank.domain.users.Users;


@Repository
@Transactional
public class UserServiceImpl implements IUserService
{
	private HibernateTemplate hibernateTemplate;
	@SuppressWarnings("unused")
	private SessionFactory sessionFactory;
	@Autowired
	public void setSessionDataFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
		
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkIfUserExist(String username,String password) 
	{
		boolean flag=false;
		List<Users> employeesList=(List<Users>) hibernateTemplate.find("from Users where email='"+username+"' AND password='"+password+"'");
		if(employeesList.size()>0)
		{
			flag=true;
		}
		
		return flag;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkIfEmailExist(String email) 
	{
		boolean flag=false;
		List<Users> employeesList=(List<Users>) hibernateTemplate.find("from Users where email='"+email+"'");
		if(employeesList.size()>0)
		{
			flag=true;
		}
		
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Users getEmployeeByUserName(String username,String password){
		List<Users>employeesList=(List<Users>) hibernateTemplate.find("from Users where email='"+username+"'AND password='"+password+"'");
		if(employeesList.size()>0)
		{
			return employeesList.get(0);
		}
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Users saveUser(Users users){
		hibernateTemplate.save(users);
		return users;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return (List<Category>) hibernateTemplate.find("from Category");
	}
	
	@Override
	public void saveCustomer(Customer customer) {
		hibernateTemplate.saveOrUpdate(customer);
	}


	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return (List<Customer>) hibernateTemplate.find("from Customer");
	}
	
	@Override
	public Customer getCustomers(int customerId) {
		// TODO Auto-generated method stub
		return (Customer) hibernateTemplate.get(Customer.class.getName(), customerId);
	}
	
	@Override
	public void saveAccount(Account account) {
		hibernateTemplate.saveOrUpdate(account);
	}


	@Override
	public List<Account> getAccounts() {
		// TODO Auto-generated method stub
		return (List<Account>) hibernateTemplate.find("from Account");
	}


	@Override
	public Account getAccounts(int accountId) {
		// TODO Auto-generated method stub
		return (Account) hibernateTemplate.get(Account.class.getName(), accountId);
	}


	@Override
	public void saveCreditDebitCardInfo(CreditDebitCardInfo creditDebitCardInfo) {
		hibernateTemplate.saveOrUpdate(creditDebitCardInfo);
		
	}


	@Override
	public List<CreditDebitCardInfo> getCreditDebitCardInfoList() {
		// TODO Auto-generated method stub
		return (List<CreditDebitCardInfo>) hibernateTemplate.find("from CreditDebitCardInfo");
	}


	@Override
	public CreditDebitCardInfo getCreditDebitCardInfo(int creditDebitCardInfo) {
		// TODO Auto-generated method stub
		return (CreditDebitCardInfo) hibernateTemplate.get(CreditDebitCardInfo.class.getName(), creditDebitCardInfo);
	}
	
	@Override
	public void deleteAccount(int accountId) {
		Object object=hibernateTemplate.get(Account.class.getName(), accountId);
		Account accountInfo=object!=null?(Account) object:null;
		hibernateTemplate.delete(accountInfo);
		
	}
	
	@Override
	public void deleteCustomer(int customerId) {
		Object object=hibernateTemplate.get(Customer.class.getName(), customerId);
		Customer customerInfo=object!=null?(Customer) object:null;
		hibernateTemplate.delete(customerInfo);
		
	}
	
	@Override
	public void deleteCreditDebitCard(int creditDebitId) {
		Object object=hibernateTemplate.get(CreditDebitCardInfo.class.getName(), creditDebitId);
		CreditDebitCardInfo creditDebitCardInfo=object!=null?(CreditDebitCardInfo) object:null;
		hibernateTemplate.delete(creditDebitCardInfo);
		
	}


	@Override
	public List<FingerPrint> getFingerPrints() {
		List<FingerPrint> fingerPrints=null;
		fingerPrints=(List<FingerPrint>) hibernateTemplate.find("from FingerPrint where successFailure=false and verified=false");
		return fingerPrints;
	}


	@Override
	public void deletefingerPrintMap(int fingerPrintId) {
		Object object=hibernateTemplate.get(FingerPrint.class.getName(), fingerPrintId);
		FingerPrint fingerPrint=object!=null?(FingerPrint) object:null;
		hibernateTemplate.delete(fingerPrint);
		
	}
}
