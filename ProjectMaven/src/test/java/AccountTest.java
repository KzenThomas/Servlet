import static org.junit.Assert.*;

import org.junit.Test;

import maven.Account;

public class AccountTest {

	Account ac = new Account("Thomas",488,5000);
	
	@Test
	public void Withdraw() throws Exception {
		assertTrue(false == ac.withdraw(2300,50));
		
		
	}
	
}
