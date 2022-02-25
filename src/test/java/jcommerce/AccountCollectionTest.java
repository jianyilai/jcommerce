/**
 * 
 */
package jcommerce;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author jimmy
 *
 */
class AccountCollectionTest {

	private AccountCollection ac;
	private Account a1;
	private Account a2;
	private Account a3;
	private final int ACCOUNT_COLLECTION_SIZE = 3;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		ac = new AccountCollection();
		a1 = new Account("adminTest", "password", "admin@email.com");
		a2 = new Account("userTest", "password", "user@email.com");
		a3 = new Account("jianyi", "pass123", "jianyi@email.com");
		ac.addAccount(a1);
		ac.addAccount(a2);
		ac.addAccount(a3);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link jcommerce.AccountCollection#AccountCollection(int)}.
	 */
	@Test
	void testAccountCollectionInt() {
		System.out.println("testAccountCollectionInt");
		// count of AccountColleciton
		List<Account> testAc = ac.getAccounts();
		assertEquals(testAc.size(), ACCOUNT_COLLECTION_SIZE);
		System.out.println(testAc.size());
	}

	/**
	 * Test method for {@link jcommerce.AccountCollection#getAccounts()}.
	 */
	@Test
	void testGetAccounts() {
		System.out.println("testGetAccounts");
		System.out.println(ac.getAccounts());

	}

	/**
	 * Test method for
	 * {@link jcommerce.AccountCollection#addAccount(jcommerce.Account)}.
	 */
	@Test
	void testAddAccount() {
		System.out.println("testAddAccount");
		// fail("Not yet implemented");
		List<Account> testAc = ac.getAccounts();
		// Assert that Account Collection is equals to account collection size 3
		assertEquals(testAc.size(), ACCOUNT_COLLECTION_SIZE);
		// Act
		ac.addAccount(a1);
		// Assert that Song Collection is equals to song collection size 3 + 1
		assertEquals(ac.getAccounts().size(), ACCOUNT_COLLECTION_SIZE + 1);
	}

}
