package com.masato.ka.geohash;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.masato.ka.geohash.exception.GeoHashDecodingException;

public class TestGeoHashDecode {

	
	private GeoHashDecoder geoHash;
	
	@Before
	public void setUp(){
		geoHash = GeoHash.getGeoHashDecocer();
	}
	
	
	@Test
	public void TestDecode_01() {

		Map<String, Double> result = geoHash.decode("xn76urw");
		if(result.get("latitude")!=35.68153381347656){
			fail();
		}
		if(result.get("longitude")!=139.76600646972656){
			fail();
		}
		
	}
	
	@Test
	public void TestDecode_02(){
		Map<String,Double> result = geoHash.decode("s0");
		
		if(result.get("latitude")!=2.8125){
			fail();
		}
		if(result.get("longitude")!=5.625){
			fail();
		}
	}
	
	@Test
	public void TestDecode_03(){
		Map<String, Double> result = geoHash.decode("1023456789bcdefghjkmnpqrstuvwxyz");
		
		if(result.get("latitude")!=-88.399505492625){
			fail();
		}
		if(result.get("longitude")!=-134.55743439816956){
			fail();
		}
	}
	
	@Test
	public void TestDecodeError_01(){
		
		try{
			Map<String,Double> result = geoHash.decode("");
			fail();
		}catch(GeoHashDecodingException e){
			
		}
		
	}
	
	@Test
	public void TestDecodeError_02(){
		
		try{
			Map<String,Double> result = geoHash.decode("162738as");
			fail();
		}catch(GeoHashDecodingException e){
			
		}
		
	}
	
	
	@Test
	public void TestDecodeError_03(){
		
		try{
			Map<String,Double> result = geoHash.decode("-+={}¥!~");
			fail();
		}catch(GeoHashDecodingException e){
			
		}
		
	}
	
	@Test
	public void TestDecodeError_04(){
		
		try{
			Map<String,Double> result = geoHash.decode("123456789_0");
			fail();
		}catch(GeoHashDecodingException e){
			
		}
		
	}
	
	
}
