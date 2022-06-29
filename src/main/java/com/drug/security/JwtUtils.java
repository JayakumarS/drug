package com.drug.security;

import java.nio.charset.StandardCharsets;
import java.security.DigestException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.drug.usermanagement.UserDetailsImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${app.jwtSecret}")
	private String jwtSecret;

	@Value("${app.jwtExpirationMs}")
	private int jwtExpirationMs;

	@Value("${app.secretKey}")
	private String secretKey;

	public String generateJwtToken(Authentication authentication) {

		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

		return Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}

	public String decrypt(String cipherText) {
		String decryptedText = null;
		try {
			byte[] cipherData = Base64.getDecoder().decode(cipherText);
			byte[] saltData = Arrays.copyOfRange(cipherData, 8, 16);
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			final byte[][] keyAndIV = GenerateKeyAndIV(32, 16, 1, saltData, secretKey.getBytes(StandardCharsets.UTF_8),
					md5);
			SecretKeySpec key = new SecretKeySpec(keyAndIV[0], "AES");
			IvParameterSpec iv = new IvParameterSpec(keyAndIV[1]);
			byte[] encrypted = Arrays.copyOfRange(cipherData, 16, cipherData.length);
			Cipher aesCBC = Cipher.getInstance("AES/CBC/PKCS5Padding");
			aesCBC.init(Cipher.DECRYPT_MODE, key, iv);
			byte[] decryptedData = aesCBC.doFinal(encrypted);
			decryptedText = new String(decryptedData, StandardCharsets.UTF_8);
			decryptedText = decryptedText.replace("\"", "");
		} catch (Exception e) {

		}
		return decryptedText;

	}

	public static byte[][] GenerateKeyAndIV(int keyLength, int ivLength, int iterations, byte[] salt, byte[] password,
			MessageDigest md) {

		int digestLength = md.getDigestLength();
		int requiredLength = (keyLength + ivLength + digestLength - 1) / digestLength * digestLength;
		byte[] generatedData = new byte[requiredLength];
		int generatedLength = 0;

		try {
			md.reset();
			// Repeat process until sufficient data has been generated
			while (generatedLength < keyLength + ivLength) {
				// Digest data (last digest if available, password data, salt if available)
				if (generatedLength > 0)
					md.update(generatedData, generatedLength - digestLength, digestLength);
				md.update(password);
				if (salt != null)
					md.update(salt, 0, 8);
				md.digest(generatedData, generatedLength, digestLength);
				// additional rounds
				for (int i = 1; i < iterations; i++) {
					md.update(generatedData, generatedLength, digestLength);
					md.digest(generatedData, generatedLength, digestLength);
				}
				generatedLength += digestLength;
			}
			// Copy key and IV into separate byte arrays
			byte[][] result = new byte[2][];
			result[0] = Arrays.copyOfRange(generatedData, 0, keyLength);
			if (ivLength > 0)
				result[1] = Arrays.copyOfRange(generatedData, keyLength, keyLength + ivLength);
			return result;
		} catch (DigestException e) {
			throw new RuntimeException(e);
		} finally {
			// Clean out temporary data
			Arrays.fill(generatedData, (byte) 0);
		}
	}
}
