/**
 * 
 */
package com.sirius.uwi.helpers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * This program provides methods to generate a 128 symmetric key using AES Rijndeal 
 * algorithm, encrypt plain text using the key and decrypt the encrypted text.
 * The utility can be invoked from command-line.
 */

public class CryptoUtil {

  
	private static boolean isLoggingEnabled=false;
	
	private static void logDebug(String msg) {
		/* try {
			Class.forName("org.apache.log4j.Logger");
			org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CryptoUtil.class);
			logger.debug(msg);
		} catch (ClassNotFoundException cnf) {
			System.out.println(msg);
		} catch (NoClassDefFoundError ncdf) { */
			System.out.println(msg);
	}
	
	private static void logError(String msg,Throwable error) {
		/* try {
			Class.forName("org.apache.log4j.Logger");
			org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CryptoUtil.class);
			logger.error(msg);
		} catch (ClassNotFoundException cnf) {
			System.out.println(msg);
		} catch (NoClassDefFoundError ncdf) { */
			System.out.println(msg);
	}

	private static final String algorithm = "AES";
	
	private static final String cipherTransformation = "AES/CBC/PKCS5Padding";
	
	private static final String jceProvider = "BC";
	
	private static int keyStrength = 128;
	
	private static final String defaultHashAlgorithm = "MD5"; 
	
	private static final byte[] AESIinitVector = { 
	    (byte) 0x01, (byte) 0x02, (byte) 0x03, (byte) 0x04, 
	    (byte) 0x05, (byte) 0x06, (byte) 0x07, (byte) 0x08, 
	    (byte) 0x09, (byte) 0x0a, (byte) 0x0b, (byte) 0x0c, 
	    (byte) 0x0d, (byte) 0x0e, (byte) 0x0f, (byte) 0x10 
	  }; 

	/**
	 * Turns array of bytes into string
	 * @param buf Array of bytes to convert to hex string
	 * @return Generated hex string
	 */
	public static String convertToHex(byte buf[]) {
		StringBuffer strbuf = new StringBuffer(buf.length * 2);
		int i;

		for (i = 0; i < buf.length; i++) {
			if (((int) buf[i] & 0xff) < 0x10)
				strbuf.append("0");
			strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
		}
		return strbuf.toString();
	}
	
	/**
	 * @param hexString
	 * @return
	 */
	public static byte[] convertToBytes(String hexString) {
		byte[] bytes = new byte[hexString.length() / 2];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) Integer.parseInt(hexString.substring(2*i, 2*i+2), 16);
		}
		return bytes;
	}

	private static String readKeyFromFile(String keyFile) {
//		File file = new File(keyFile);
		byte [] key = null;
//		if(!file.exists() || !file.canRead()) {
//			logger.error("cannot read the key from file : " + keyFile);
//			System.out.println("cannot read the key from file : " + keyFile);
//			return null;
//		}
		
		BufferedInputStream buf = null;
		try {
			InputStream is = Resource.load(keyFile);
			if(is == null) {
				logError("File not found :" + keyFile,null);
				return null;
			}
			buf = new BufferedInputStream(is);
			key = new byte[buf.available()];
			buf.read(key);
		} catch (FileNotFoundException e) {
			logError("File not found :" + keyFile,e);
		} catch (IOException e) {
			logError("File not found :" + keyFile,e);
		}finally {
			if(buf != null) {
				try { 
				  buf.close();
				} 
				catch(Exception e) { 
	       
				}
			}
		}
		return new String(key);
	}

	/**
	 * Takes an encrypted hex string and decrypts it with the key passed-in
	 * @param message
	 * @param secretKey
	 * @return
	 */
	public static String decryptMessage(String message,String hexEncodedSecretKey) {
		
		// get the Key Spec. for the AES algorithm
		SecretKeySpec skeySpec = new SecretKeySpec(convertToBytes(hexEncodedSecretKey), algorithm);
		IvParameterSpec ivSpec = new IvParameterSpec(AESIinitVector, 0, AESIinitVector.length); 

		// Instantiate the cipher

		Cipher cipher;
		byte[] decryptedMessage=null;
		try {
			cipher = Cipher.getInstance(cipherTransformation,jceProvider);
			cipher.init(Cipher.DECRYPT_MODE, skeySpec,ivSpec);
			// convert the message to bytes.
			decryptedMessage=cipher.doFinal(convertToBytes(message));
		} catch(Exception e) {
			logError("Error decryping the message,"+e.getMessage(),e);
			e.printStackTrace();
		}
		/*
		catch (NoSuchAlgorithmException e) {
			errorMsg = e.getMessage();
			logError("File not found :" + keyFile,e);("AES algorithm not impl. in JVM version : " + System.getProperty("java.vm.version"),e);
		}  catch (NoSuchPaddingException e) {
			errorMsg = e.getMessage();
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			errorMsg = e.getMessage();
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			errorMsg = e.getMessage();
			e.printStackTrace();
		} catch (IllegalStateException e) {
			errorMsg = e.getMessage();
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			errorMsg = e.getMessage();
			e.printStackTrace();
		} catch (BadPaddingException e) {
			errorMsg = e.getMessage();
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			errorMsg = e.getMessage();
			e.printStackTrace();
		}
		*/
		if(decryptedMessage==null) {
			return "";
		}
		return new String(decryptedMessage);
	}
	

	/**
	 * Takes a plain text string and encrypts it to a hex string using the 
	 * key passed-in
	 * @param message
	 * @param secretKey
	 * @return
	 */
	public static String encryptMessage(String message,String hexEncodedSecretKey) {
		
		// get the Key Spec. for the AES algorithm
		SecretKeySpec skeySpec = new SecretKeySpec(convertToBytes(hexEncodedSecretKey), algorithm);
		IvParameterSpec ivSpec = new IvParameterSpec(AESIinitVector, 0, AESIinitVector.length); 

		// Instantiate the cipher

		Cipher cipher;
		byte[] encryptedMessage=null;
		try {
			cipher = Cipher.getInstance(cipherTransformation,jceProvider);
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec,ivSpec);
			encryptedMessage=cipher.doFinal(message.getBytes());
		} catch(Exception e) {
			logError("Error encryping the message,"+e.getMessage(),e);
		}
		/*
		catch (NoSuchAlgorithmException e) {
			errorMsg = e.getMessage();
			logger.error("AES algorithm not impl. in JVM version : " + System.getProperty("java.vm.version"),e);
		}  catch (NoSuchPaddingException e) {
			errorMsg = e.getMessage();
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			errorMsg = e.getMessage();
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			errorMsg = e.getMessage();
			e.printStackTrace();
		} catch (IllegalStateException e) {
			errorMsg = e.getMessage();
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			errorMsg = e.getMessage();
			e.printStackTrace();
		} catch (BadPaddingException e) {
			errorMsg = e.getMessage();
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			errorMsg = e.getMessage();
			e.printStackTrace();
		}
		*/
		if(encryptedMessage==null) {
			return "";
		}
		// Return the encrypted message in hex format.
		return convertToHex(encryptedMessage);
	}
	
	/**
	 * @param fileName 
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String generateKey() {
		// Initialize a Symmetric Key generator with AES Algorithm-Specific Initialization
		// using the provider.
		KeyGenerator kgen = null;
		byte[] encodedKey=null;
		String keyInHexFormat = "";
		try {
			kgen = KeyGenerator.getInstance(algorithm,jceProvider);
			logDebug("Using JCE Provider : " + kgen.getProvider().getInfo() + " " + 
					kgen.getProvider().getName()+ " " + 
					kgen.getProvider().getVersion());
			//	set the key size.default impl. only provides 128 bit,BC provides upt 256 
			kgen.init(keyStrength); 
			SecretKey skey = kgen.generateKey();
			logDebug("Secret Key Format :" + skey.getFormat());
			logDebug("Secret Key Algorithm :" + skey.getAlgorithm());
			encodedKey = skey.getEncoded();

			keyInHexFormat = convertToHex(encodedKey);
			// if a file name is specified, write the key to it.
		} catch (Exception e) {
			logError("Error generating the key.check the stacktrace,"+e.getMessage(),e);
		}
		/*
		catch (NoSuchAlgorithmException e) {
			errorMsg = e.getMessage();
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			errorMsg = e.getMessage();
			e.printStackTrace();
		}
		*/
		return keyInHexFormat;
	}
	
	private static void writeToFile(String fileName,String hexEncodedKey) {
		if(fileName != null) {
			File keyFile = new File(fileName);
			if(keyFile.exists() && keyFile.canWrite()) {
				logError("Overwriting the existing key file..",null);
			}
			BufferedOutputStream buf = null;
			try {
				buf = new BufferedOutputStream(new FileOutputStream(keyFile));
				buf.write(hexEncodedKey.getBytes());
				buf.flush();
			} catch (FileNotFoundException e) {
				logError("Cannot create the file : " + fileName,e);
			} catch (IOException e) {
				logError("Cannot write to file : " + fileName,e);
			}finally {
				if(buf != null) {
					try {
						buf.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	/**
	 * creates an MD5 hash of the data provided using the algorithm supplied by JDK.
	 * Does not add any padding to the hash.
	 * @param data
	 * @return
	 */
	public static String createHash(String data) {
		MessageDigest md = null;
		String hashInHex = null;
		try {
			md = MessageDigest.getInstance(defaultHashAlgorithm);
			md.update(data.getBytes());
			byte [] hashBytes = md.digest();
			hashInHex = convertToHex(hashBytes);
		} catch (NoSuchAlgorithmException e) {
			logError("Error creating hash for msg :" + data + " :"+e.getMessage(),e);
		}
		return hashInHex;
	}
	
	public static void main(String[] args) {
		System.out.println("Using java version : " + System.getProperty("java.vm.version"));
		if(args == null || args.length ==0) {
			usage();
			return ;
		}
		String command = args[0];
		
		if("keygen".equalsIgnoreCase(command) || "TokenGenKey".equalsIgnoreCase(command)) {
			
			// Use 256 as keyStrength for TokenGenKey
			if ("TokenGenKey".equalsIgnoreCase(command)) {
				keyStrength = 256;
			}
			
			System.out.println("Generating secret Key.");
			String keyFile=null;
			if(args.length == 2) {
				keyFile=args[1];
			}
			String keyInHexFormat = generateKey();
			logDebug("Generated Key in hex format:\n"+keyInHexFormat + "\n");
			
			if(keyFile != null) {
				writeToFile(keyFile,keyInHexFormat);
			}
		}else if("encrypt".equalsIgnoreCase(command)) {
			if(args.length != 3) {
				usage();
				return;
			}
			System.out.println("Encrypting the message");
			// we can modify to accept these args one by one,user hits enter
			// to take spaces in the messag.But its unlikely,a password will
			// have spaces.
			String key = args[1];
			String message = args[2];
			
			String encMsg = encryptMessage(message,key);
			System.out.println("Encrypted message in hex format :\n"+encMsg + "\n");
		} else if("decrypt".equalsIgnoreCase(command)) {
			if(args.length != 3) {
				usage();
				return;
			}
			System.out.println("Decrypting the message");
			String key = args[1];
			String encMsg = args[2];
			String decMsg = decryptMessage(encMsg,key);
			System.out.println("Decrypted message :\n"+decMsg+"\n");
		} else if("hash".equalsIgnoreCase(command)) {
			if(args.length != 2) {
				usage();
				return;
			}
			System.out.println("generating the MD5 hash for :"+args[1]);
			String hashInHex = createHash(args[1]);
			System.out.println("generated hash :\n"+hashInHex+"\n");
		} else {
			usage();
			return;
		}
//		String keyFile = "H:/UWI/crypto/secret_key.txt";
//		try {
//			logger.debug("java.vm.version : " + System.getProperty("java.vm.version"));
//			generateKey(keyFile);
//			byte[] key = readKeyFromFile(keyFile);
//			String encMsg = encryptMessage(message,key);
//			
//			logger.debug("Original message "+message);
//			logger.debug("Encrypted message "+encMsg);
//			
//			String decMsg = decryptMessage(encMsg,key);
//			
//			logger.debug("Decrypted message from encMsg "+decMsg);
//			
//		} catch (Exception e) {
//			logger.error("Error...",e);
//		}
	}
	
	private static void usage() {
		logDebug("Encryption utility Command line Usage----------------------\n");
		logDebug("java option args");
		logDebug("\n \t where option and its matching args are one of :\n");
		logDebug("\n \t keygen <optional fileName>");
		logDebug("\n \t encrypt <key> <text> ");
		logDebug("\n \t decrypt <key> <text> ");
		logDebug("\n \t hash <text> ");
	}

	/**
	 * @return Returns the keyStrength.
	 */
	public static int getKeyStrength() {
		return keyStrength;
	}

	/**
	 * @param keyStrength The keyStrength to set.
	 */
	public static void setKeyStrength(int keyStrength) {
		CryptoUtil.keyStrength = keyStrength;
	}
}