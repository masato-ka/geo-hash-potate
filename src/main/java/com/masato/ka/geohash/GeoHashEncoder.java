/***********************************
 * Copyright 2016 Masato Kawamura
 * @Author masato-ka
 * 
 * This software is MIT LICENSE
 * 
 ***********************************/

package com.masato.ka.geohash;

import java.util.HashMap;
import java.util.Map;

import com.masato.ka.geohash.constants.HashTableConstants;
import com.masato.ka.geohash.exception.GeoHashDecodingException;
import com.masato.ka.geohash.exception.GeoHashEncodingException;


public class GeoHashEncoder {
	 
	public String encodeToGeoHash(int digit, double latitude, double longitude) throws GeoHashEncodingException {
		//World Geodetic System
		if(digit < 0){
			throw new GeoHashEncodingException("Hash digits must be greater than 0.");
		}
		
		if(latitude <= 90.0 && latitude >= -90.00){
			
		}else{
			throw new GeoHashEncodingException("Malformed Latitude value. latitude must be greater than "
					+ "-90.0 and less than 90.0.");
		}
		
		if(longitude <= 180.0 && longitude >= -180.00){
			
		}else{
			throw new GeoHashEncodingException("Malformed Longitude value. latitude must be greater than "
					+ "-180.0 and less than 180.0.");
		}
		
		int binaryEncodeDigit = (digit * 5)/2;
		if((binaryEncodeDigit % 5)!=0){
			binaryEncodeDigit += 1;
		}
		String latitudeBinary = encodeToBinary(binaryEncodeDigit,latitude, -90, 90);
		String longitudeBinary = encodeToBinary(binaryEncodeDigit,longitude, -180,180);
		String mergedBinary = merge(longitudeBinary,latitudeBinary);
		return encodeBase32(digit, mergedBinary);
		
	}
	
	private String encodeBase32(int digit, String binaryStr){
		int encodeDigit = 5;
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i < digit*encodeDigit; i+=encodeDigit){
			String binary = binaryStr.substring(i,i+encodeDigit);
			int index = Integer.valueOf(binary, 2);
			sb.append(HashTableConstants.base32Table[index]);
		}
		
		return sb.toString();
	}
	

	
	//偶数, 奇数
	private String merge(String evenBinary, String oddBinary){
		String[] even = evenBinary.split("");
		String[] odd = oddBinary.split("");
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i < even.length; i++){
			sb.append(even[i]);
			sb.append(odd[i]);
		}
		return sb.toString();
	}
	

	
	private String encodeToBinary(int encodeDigit, double num, double min, double max){
		
		if(encodeDigit != 0){
			double mid = (min+max)==0 ? 0:(min+max)/2;
			if( mid <= num && num <= max){
				return recursiveEncodeToBinary(encodeDigit-1, "1", num, mid, max);
			}else{
				return recursiveEncodeToBinary(encodeDigit-1, "0", num, min, mid);
			}
		}

		return "";
	
	}
	
	private String recursiveEncodeToBinary(int encodeDigit, String str, 
				double num, double min, double max){

		if(encodeDigit != 0){
			StringBuffer sb = new StringBuffer();
			sb.append(str);
			double mid = (min+max)==0 ? 0:(min+max)/2;
		
			if( mid <= num && num <= max){
				sb.append("1");
				return recursiveEncodeToBinary(encodeDigit-1, sb.toString(), num, mid, max);
			}else{
				sb.append("0");
				return recursiveEncodeToBinary(encodeDigit-1, sb.toString(), num, min, mid);
			}
		}
		return str;
	}
	
}
