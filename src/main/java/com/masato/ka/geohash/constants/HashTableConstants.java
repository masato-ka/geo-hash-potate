package com.masato.ka.geohash.constants;

public class HashTableConstants {

	private HashTableConstants(){};
	public static final String[] base32Table = {"0","1","2","3","4",
			"5","6","7","8","9",
			"b","c","d","e","f",
			"g","h","j","k","m",
			"n","p","q","r","s",
			"t","u","v","w","x","y","z"};

	public static final String[] decodeTable = {"00000","00001","00010","00011","00100",
        "00101","00110","00111","01000","01001",
        "01010","01011","01100","01101","01110",
        "01111","10000","10001","10010","10011",
        "10100","10101","10110","10111","11000",
        "11001","11010","11011","11100","11101","11110","11111"};

}
