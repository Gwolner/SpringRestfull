package br.com.acolhimento.lgbtq.util;

import java.security.MessageDigest;

public class Criptografia {

	public static String gerarHash(String senha) throws Exception {
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte hash[] = algorithm.digest(senha.getBytes("UTF-8"));
		StringBuilder texto = new StringBuilder();
		
		for (byte b : hash) {
			texto.append(String.format("%02X", 0xFF & b));
		}

		return texto.toString();
	}
}
