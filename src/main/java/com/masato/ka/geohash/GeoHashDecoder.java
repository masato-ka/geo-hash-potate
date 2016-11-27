package com.masato.ka.geohash;
/***********************************
 * Copyright 2016 Masato Kawamura
 * @Author masato-ka
 * 
 * This software is MIT LICENSE
 * 
 ***********************************/

import java.util.HashMap;
import java.util.Map;

import com.masato.ka.geohash.constants.HashTableConstants;
import com.masato.ka.geohash.exception.GeoHashDecodingException;

public class GeoHashDecoder {

	
	public Map<String,Double> decode(String hashCode){
		if(hashCode.length() == 0){throw new GeoHashDecodingException("GeoHash value empty.");}
		Map<String, Double> result = new HashMap<String,Double>();
		
		String hashBinary = decodeBase32(hashCode);
		String[] splitBinaries = splitBinary(hashBinary);
		double longitude = decodeFromBinary(splitBinaries[0], -180.0, 180.0);
		double latitude = decodeFromBinary(splitBinaries[1], -90.0, 90.0);
		
		result.put("latitude", latitude);
		result.put("longitude", longitude);
		
		return result;
		
	}
	
	private String decodeBase32(String base32Str) {
		
		String[] characters = base32Str.split("");
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i < characters.length; i++){
			for(int n=0; n < HashTableConstants.base32Table.length; n++){
				if(HashTableConstants.base32Table[n].equals(characters[i])){
					sb.append(HashTableConstants.decodeTable[n]);		
				}
			}
			
		}
		String result = sb.toString();
		if(result.length() != base32Str.length()*5){
			throw new GeoHashDecodingException("The given hash value is invalid. Hash value do not use ");
		}
		
		return sb.toString();
	}
	
	private String[] splitBinary(String binaryStr){
		String[] result= {"",""};
		StringBuffer evenBinary = new StringBuffer();
		StringBuffer oddBinary = new StringBuffer();
		
		String[] charcters = binaryStr.split("");
		
		for(int i=0; i < charcters.length; i+=2){	
			evenBinary.append(charcters[i]);
			if((i+1) < charcters.length){
				oddBinary.append(charcters[i+1]);
			}
		}
		
		result[0] = evenBinary.toString();
		result[1] = oddBinary.toString();
		
		return result;
		
	}
	
	private double decodeFromBinary(String binaryCode, double min, double max){
		double result = 0.0;
		double mid = 0.0;
		String[] binaryChar = binaryCode.split("");
		
		for(int i=0; i < binaryChar.length; i++){
			mid = (min+max)==0 ? 0:(min+max)/2;
			if(binaryChar[i].equals("1")){
				min = mid;
			}else{
				max = mid;
			}
		}
		result = (min+max)==0 ? 0:(min+max)/2; 
		return result;
	}
	
	
	
}
