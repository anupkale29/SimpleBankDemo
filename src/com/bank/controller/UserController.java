package com.bank.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.domain.account.Account;
import com.bank.domain.creditdebit.CreditDebitCardInfo;
import com.bank.domain.customer.Customer;
import com.bank.domain.fingerprint.FingerPrint;
import com.bank.domain.users.Users;
import com.bank.service.users.IUserService;
import com.bank.utility.EncryptPassword;
import com.bank.utility.JSGD;

@RestController
@RequestMapping("/rest/user")
public class UserController {
	private IUserService employeeService;
	private EncryptPassword encryptPassword;

	@Autowired
	public UserController(IUserService employeeService, EncryptPassword encryptPassword) {
		this.employeeService = employeeService;
		this.encryptPassword = encryptPassword;
	}

	@RequestMapping(value = "/saveUser.json", method = RequestMethod.POST, headers = "Accept=application/json", produces = { "application/xml", "application/json" })
	public @ResponseBody Users saveUser(@RequestParam Map<String, String> userMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		Users user = new Users();
		// ModelMap modelMap = new ModelMap();
		// String message = "Sign Up process was not successfull.";
		// userMap=new HashMap<String, String>();
		String usernamesignup = userMap.get("usernamesignup");
		String emailsignup = userMap.get("emailsignup");
		String passwordsignup = userMap.get("passwordsignup");
		String passwordsignup_confirm = userMap.get("passwordsignup_confirm");
		if (passwordsignup != null && !passwordsignup.equals("") && passwordsignup_confirm.equals(passwordsignup)) {
			user = new Users();
			user.setEmail(emailsignup);
			user.setUserName(usernamesignup);
			String encryptedPassword = encryptPassword.encrypt(passwordsignup);
			user.setPassword(encryptedPassword);
			boolean flag = false;
			if (emailsignup != null && !emailsignup.equals("")) {
				flag = employeeService.checkIfEmailExist(emailsignup);
			}
			if (!flag) {
				user.setEmail(emailsignup);
				employeeService.saveUser(user);
				// message = "Congrats!!! You are an official user now.";
			}
		}
		return user;
	}

	@RequestMapping(value = "/saveCustomer.json", headers = "Accept=application/json", produces = { "application/xml", "application/json" }, method = RequestMethod.POST)
	public @ResponseBody Customer saveCustomer(@RequestParam Map<String, String> customerMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		Customer customer = new Customer();
		String firstName = customerMap.get("firstName");
		String lastName = customerMap.get("lastName");
		String emailID = customerMap.get("emailID");
		long phoneNumber = Long.parseLong(customerMap.get("phoneNumber"));
		String address = customerMap.get("address");
		String city = customerMap.get("city");
		String pincode = customerMap.get("pincode");
		String country = customerMap.get("country");

		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmailID(emailID);
		customer.setPhoneNumber(phoneNumber);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setPincode(pincode);
		customer.setCountry(country);
		employeeService.saveCustomer(customer);
		return customer;
	}

	@RequestMapping(value = "/saveAccount.json", headers = "Accept=application/json", produces = { "application/xml", "application/json" }, method = RequestMethod.POST)
	public void saveAccount(@RequestParam Map<String, String> accountMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		Account account = new Account();
		String accountType = accountMap.get("accountType");
		double openingBalance = Double.parseDouble(accountMap.get("openingBalance"));
		long accountNumber = Long.parseLong(accountMap.get("accountNumber"));
		int customerId = (accountMap.containsKey("customerId") && accountMap.get("customerId") != null && !accountMap.get("customerId").equals("")) ? Integer.parseInt(accountMap.get("customerId"))
				: 0;
		Map<Integer, Customer> customers = new HashMap<Integer, Customer>();
		account.setAccountBalance(openingBalance);
		account.setAccountType(accountType);
		account.setAccountNumber(accountNumber);
		if (customerId != 0) {
			Customer customer = employeeService.getCustomers(customerId);
			customers.put(customerId, customer);
			account.setCustomers(customers);
			employeeService.saveAccount(account);
		}
	}

	@RequestMapping(value = "/saveCardDetails.json", method = RequestMethod.POST, headers = "Accept=application/json", produces = { "application/xml", "application/json" })
	public void saveCardDetails(@RequestParam Map<String, String> cardMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		CreditDebitCardInfo creditDebitCardInfo = new CreditDebitCardInfo();
		String expiryDate = cardMap.get("expiryDate");
		String cardHolderName = cardMap.get("cardHolderName");
		int accountId = (cardMap.containsKey("accountId") && cardMap.get("accountId") != null && !cardMap.get("accountId").equals("")) ? Integer.parseInt(cardMap.get("accountId")) : 0;
		long creditDebitCardNumber = Long.parseLong(cardMap.get("creditDebitCardNumber"));
		int cardType = (cardMap.containsKey("cardType") && cardMap.get("cardType") != null && !cardMap.get("cardType").equals("")) ? Integer.parseInt(cardMap.get("cardType")) : 0;
		int cvv = (cardMap.containsKey("cvv") && cardMap.get("cvv") != null && !cardMap.get("cvv").equals("")) ? Integer.parseInt(cardMap.get("cvv")) : 0;
		creditDebitCardInfo.setCardHolderName(cardHolderName);
		creditDebitCardInfo.setCardType(cardType);
		creditDebitCardInfo.setCreditDebitCardNumber(creditDebitCardNumber);
		creditDebitCardInfo.setExpiryDate(expiryDate);
		creditDebitCardInfo.setCvv(cvv);
		if (accountId != 0) {
			Account account = employeeService.getAccounts(accountId);
			creditDebitCardInfo.setCardAccount(account);
			employeeService.saveCreditDebitCardInfo(creditDebitCardInfo);
		}
	}

	@RequestMapping(value = "/getCustomers.json", headers = "Accept=application/json", produces = { "application/xml", "application/json" }, method = RequestMethod.GET)
	public @ResponseBody List<Customer> getCustomers(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		List<Customer> customers = employeeService.getCustomers();
		return customers;
	}

	@RequestMapping(value = "/getAccounts.json", method = RequestMethod.GET, headers = "Accept=application/json", produces = { "application/xml", "application/json" })
	public @ResponseBody List<Account> getAccounts(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		List<Account> accounts = employeeService.getAccounts();
		return accounts;
	}

	@RequestMapping(value = "/getCards.json", method = RequestMethod.GET, headers = "Accept=application/json", produces = { "application/xml", "application/json" })
	public @ResponseBody List<CreditDebitCardInfo> getCards(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		List<CreditDebitCardInfo> creditDebitCardInfoList = employeeService.getCreditDebitCardInfoList();
		return creditDebitCardInfoList;
	}

	@RequestMapping(value = "/getFrauds.json", method = RequestMethod.GET, headers = "Accept=application/json", produces = { "application/xml", "application/json" })
	public @ResponseBody List<FingerPrint> getFrauds(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		List<FingerPrint> fingerPrints = employeeService.getFingerPrints();
		return fingerPrints;
	}

	@RequestMapping(value = "checkvaliduser.json", method = RequestMethod.POST, headers = "Accept=application/json", produces = { "application/xml", "application/json" })
	public @ResponseBody Users checkValidUser(@RequestParam Map<String, String> userMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		ModelMap modelMap = new ModelMap();
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		Users users = null;
		boolean checkValidUser = false;
		if (emailId != null && password != null && emailId.equals("admin") && password.equals("admin")) {
			users = new Users();
			users.setUserId(0);
			users.setUserName("admin");
			users.setEmail("admin@gmail.com");
			users.setPassword("password");
			session.setAttribute("loginUser", emailId);
			modelMap.addAttribute("message", "Welcome to Bank Demo Admin ");
		} else if (emailId != null && password != null) {
			String encryptedPassword = encryptPassword.encrypt(password);
			boolean flag = employeeService.checkIfUserExist(emailId, encryptedPassword);
			if (flag == true) {
				users = employeeService.getEmployeeByUserName(emailId, encryptedPassword);
			} else {
				modelMap.addAttribute("message", "Invalid User!");
			}
		}
		return users;
	}

	@RequestMapping(value = "callFingerPrint.json", method = RequestMethod.POST, headers = "Accept=application/json", produces = { "application/xml", "application/json" })
	public void callFingerPrint(@RequestParam Map<String, String> creditDebitCardInfoMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		JSGD jsgd = new JSGD();
		int creditDebitId = (creditDebitCardInfoMap.containsKey("creditDebitId") && creditDebitCardInfoMap.get("creditDebitId") != null && !creditDebitCardInfoMap.get("creditDebitId").equals(""))
				? Integer.parseInt(creditDebitCardInfoMap.get("creditDebitId")) : 0;
		CreditDebitCardInfo creditDebitCardInfo = employeeService.getCreditDebitCardInfo(creditDebitId);
		jsgd.setiUserService(employeeService);
		jsgd.setCreditDebitCardInfo(creditDebitCardInfo);
		jsgd.setVisible(true);
	}

	@RequestMapping(value = "deleteAccount.json", method = RequestMethod.POST, headers = "Accept=application/json", produces = { "application/xml", "application/json" })
	public void deleteAccount(@RequestParam Map<String, String> accountInfoMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		int accountId = (accountInfoMap.containsKey("accountId") && accountInfoMap.get("accountId") != null && !accountInfoMap.get("accountId").equals(""))
				? Integer.parseInt(accountInfoMap.get("accountId")) : 0;
		employeeService.deleteAccount(accountId);
	}

	@RequestMapping(value = "deleteCustomer.json", method = RequestMethod.POST, headers = "Accept=application/json", produces = { "application/xml", "application/json" })
	public void deleteCustomer(@RequestParam Map<String, String> customerInfoMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		int customerId = (customerInfoMap.containsKey("customerId") && customerInfoMap.get("customerId") != null && !customerInfoMap.get("customerId").equals(""))
				? Integer.parseInt(customerInfoMap.get("customerId")) : 0;
		employeeService.deleteCustomer(customerId);
	}

	@RequestMapping(value = "deleteFingerPrint.json", method = RequestMethod.POST, headers = "Accept=application/json", produces = { "application/xml", "application/json" })
	public void deleteFingerPrint(@RequestParam Map<String, String> creditDebitCardInfoMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		int creditDebitId = (creditDebitCardInfoMap.containsKey("creditDebitId") && creditDebitCardInfoMap.get("creditDebitId") != null && !creditDebitCardInfoMap.get("creditDebitId").equals(""))
				? Integer.parseInt(creditDebitCardInfoMap.get("creditDebitId")) : 0;
		employeeService.deleteCreditDebitCard(creditDebitId);
	}

	@RequestMapping(value = "deleteFrauds.json", method = RequestMethod.POST, headers = "Accept=application/json", produces = { "application/xml", "application/json" })
	public void deleteFrauds(@RequestParam Map<String, String> fingerPrintMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		int fingerPrintId = (fingerPrintMap.containsKey("fingerPrintId") && fingerPrintMap.get("fingerPrintId") != null && !fingerPrintMap.get("fingerPrintId").equals(""))
				? Integer.parseInt(fingerPrintMap.get("fingerPrintId")) : 0;
		employeeService.deletefingerPrintMap(fingerPrintId);
	}
}
