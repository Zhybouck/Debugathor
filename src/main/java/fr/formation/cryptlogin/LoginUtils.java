package fr.formation.cryptlogin;

import org.mindrot.jbcrypt.BCrypt;

public class LoginUtils {

	
	private static int workload = 12;
	
	
	public static String hashPassword(String mdp) {
		String salt = BCrypt.gensalt(workload);
		String hashed_mdp = BCrypt.hashpw(mdp, salt);
		return hashed_mdp;
	}
	
	
	public static boolean checkmdp(String mdp, String stored_hash) {
		boolean mdp_verif = false;
		
		if(null==stored_hash || !stored_hash.startsWith("$2a$")) {
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
		}
		mdp_verif=BCrypt.checkpw(mdp, stored_hash);
		return mdp_verif;
	}
	
}
