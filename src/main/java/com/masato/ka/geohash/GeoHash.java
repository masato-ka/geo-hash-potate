/***********************************
 * Copyright 2016 Masato Kawamura
 * @Author masato-ka
 * 
 * This software is MIT LICENSE
 * 
 ***********************************/

package com.masato.ka.geohash;

public class GeoHash {

	private static GeoHashEncoder geoHashEncoder = null;	
	private static GeoHashDecoder geoHashDecoder = null;
	
	public static GeoHashEncoder getGeoHashEncoder(){
		
		if(geoHashEncoder == null){
			geoHashEncoder = new GeoHashEncoder();
		}
		
		return geoHashEncoder;
		
	}
	
	public static GeoHashDecoder getGeoHashDecocer(){
		
		if(geoHashDecoder == null){
			geoHashDecoder = new GeoHashDecoder();
		}
		
		return geoHashDecoder;
		
	}
	
}
