package com.tdl.river.oauth;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
public class AESencrp {

	   private static SecretKeySpec secretKey;
	    private static byte[] key;
	    private static final String ALGO = "AES";
		private static final byte[] keyValue = new byte[]{ 'T', 'h', 'e', 'B', 'e', 's', 't','S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };
	   
//		public static void main(String[] args) {
//			System.out.println(AESencrp.decrypt("L9i5Sv5nYQh89n7qUvdDBw=="));
//		}
		public static void setKey(String myKey) 
	    {
	        MessageDigest sha = null;
	        try {
	            key = myKey.getBytes("UTF-8");
	            sha = MessageDigest.getInstance("SHA-1");
	            key = sha.digest(key);
	            key = Arrays.copyOf(key, 16); 
	            secretKey = new SecretKeySpec(key, "AES");
	        } 
	        catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        } 
	        catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    public static String encrypt(String Data) 
	    {
	    	if(Data==null)
	    		return null;
	    	String encryptedValue=null;
	        try
	        {
	        	Key key = generateKey();
	            Cipher cipher = Cipher.getInstance(ALGO);
	            cipher.init(Cipher.ENCRYPT_MODE, key);
	            byte[] encVal = cipher.doFinal(Data.getBytes());
	   		 	encryptedValue = Base64.getEncoder().encodeToString(encVal);
	   		}catch(Exception e){
	   			e.printStackTrace();
	   		}
	        return encryptedValue;
	    }
	    
	    private static Key generateKey() throws Exception 
		{
			Key key = new SecretKeySpec(keyValue, ALGO);
			return key;
		}
	 
	    public static String decrypt(String encryptedData) 
	    {
	    	String decryptedValue="";
	        try
	        {
	        	Key key = generateKey();
	            Cipher cipher = Cipher.getInstance(ALGO);
	            cipher.init(Cipher.DECRYPT_MODE, key);
	            if(encryptedData!=null && encryptedData.trim().length()!=0) {
					try {
						byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
						byte[] decValue = cipher.doFinal(decordedValue);
						 decryptedValue = new String(decValue);
					}catch(Exception e) {
						decryptedValue = encryptedData;
					}
				}
				}catch(Exception e){
					
					e.printStackTrace();
				}
				return decryptedValue;
	    }



	public static String decryptID(String encryptedData) 
	{
		String decryptedValue="";
	    try
	    {
	    	Key key = generateKey();
	        Cipher cipher = Cipher.getInstance(ALGO);
	        cipher.init(Cipher.DECRYPT_MODE, key);
	        if(encryptedData!=null && encryptedData.trim().length()!=0) {
				try {
					byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
					byte[] decValue = cipher.doFinal(decordedValue);
					 decryptedValue = new String(decValue);
				}catch(Exception e) {
					decryptedValue = null;
				}
			}
			}catch(Exception e){
				
				e.printStackTrace();
			}
			return decryptedValue;
	}
	
}
