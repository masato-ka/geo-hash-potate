package com.masato.ka.geohash;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.masato.ka.geohash.exception.GeoHashEncodingException;

public class TestGeoHashEncode {

	private GeoHashEncoder geoHashEncoder;
	
	@Before
	public void setUp(){
		geoHashEncoder = GeoHash.getGeoHashEncoder();

	}
		
	@Test
	public void TestEncode01() {
			
		String result = geoHashEncoder.encodeToGeoHash(7, 35.681298,139.766247);
		System.out.println(result);
		if(!result.equals("xn76urw")){
			fail();
		}
			
	}
	
	@Test
	public void TestEncode02() {
		
		String result = geoHashEncoder.encodeToGeoHash(1, 35.681298,139.766247);
		if(!result.equals("x")){
			fail();
		}		
		
	}
	
	@Test
	public void TestEncode03() {
		
		String result = geoHashEncoder.encodeToGeoHash(2, 35.681298,139.766247);
		if(!result.equals("xn")){
			fail();
		}		

	}
	
	@Test
	public void TestEncode04() {
		
		String result = geoHashEncoder.encodeToGeoHash(3, 35.681298,139.766247);
		if(!result.equals("xn7")){
			fail();
		}			
		
	}

	@Test
	public void TestEncode05(){
		
		String result = geoHashEncoder.encodeToGeoHash(0, 35.681298,139.766247);
		if(!result.equals("")){
			fail();
		}
		
	}
	
	@Test
	public void TestEncode06(){
		
		String result = geoHashEncoder.encodeToGeoHash(30, 35.681298,139.766247);
		System.out.println(result);
		if(!result.equals("xn76urwdts53760v6qrfptbpbpbpbp")){
			fail();
		}
		
	}
	
	@Test
	public void TestEncode07(){
	
		String result = geoHashEncoder.encodeToGeoHash(30, 0, 0);
		if(!result.equals("s00000000000000000000000000000")){
			fail();
		}
			
	}
	
	@Test
	public void TestErrorEncode01(){
		
		try {
			String result = geoHashEncoder.encodeToGeoHash(10, 91.000, 139.787);
			fail();
		} catch (GeoHashEncodingException e) {
		}
	}
	
	@Test
	public void TestErrorEncode02(){
		
		try {
			String result = geoHashEncoder.encodeToGeoHash(10, -91.000, 139.787);
			fail();
		} catch (GeoHashEncodingException e) {
		}
		
	}
	
	@Test
	public void TestErrorEncode03(){
		
		try {
			String result = geoHashEncoder.encodeToGeoHash(10, 45.939, 180.787);
			fail();
		} catch (GeoHashEncodingException e) {
		}
		
	}
	
	@Test
	public void TestErrorEncode04(){
		
		try {
			String result = geoHashEncoder.encodeToGeoHash(10, 45.939, -180.787);
			fail();
		} catch (GeoHashEncodingException e) {
		}
		
	}
	
	@Test
	public void TestErrorEncode06(){
		
		try{
			String result = geoHashEncoder.encodeToGeoHash(-1, 45.939, -1.787);
			fail();
		}catch(GeoHashEncodingException e){
		
		}
	}
	
}
