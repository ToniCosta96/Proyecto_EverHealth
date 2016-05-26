package BDD;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.swing.JOptionPane;

public class ActiveDirectori {
	
	public ActiveDirectori() {

		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.PROVIDER_URL, "ldap://10.2.72.131");
		
		//Rellenamos con el usuario/dominio y password
		env.put(Context.SECURITY_PRINCIPAL, "ana@sistemasAlPaToWIN12.com");
		env.put(Context.SECURITY_CREDENTIALS, "alpatoDAM1");

		DirContext ctx;

		try {
			// Authenticate the logon user
			ctx = new InitialDirContext(env);
			System.out.println("El usuario se ha autenticado correctamente");			
			ctx.close();
			JOptionPane.showMessageDialog(null, "SE HA REALIZADO LA CONEXION CON ACTIVE DIRECTORY");

		} catch (NamingException ex) {
			System.out.println("Ha habido un error en la autenticación");
		}
			

	}

}