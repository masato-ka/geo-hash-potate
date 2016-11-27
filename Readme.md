GeoHashedPotate
====

Overview

## Description

GeoHashedPotate is GeoHash utility library for Java.
The library can encode and decode GeoHash variable.

[GeoHash] is base32 based hash value for Geocooding application.
You can see detail of [GeoHash](https://en.wikipedia.org/wiki/Geohash). 

## Usage

Encode to GeoHash

~~~~
String result = GeoHash.getGeoHashEncoder.encodeToGeoHash(7, 35.681298,139.766247);
System.out.println("result is :" + result);
~~~~
result is "xn76urw"

Decode from GeoHash

~~~~
Map<String,Double> result = GeoHash.getGeoHashDecoder.decodeFromGeoHash(xn76urw)
System.out.println("latitude:" + result.get("latitude") + " longitude:" + result.get("longitude") );
~~~~

latitude: 35.68153381347656 longitude:139.76600646972656

## Licence

MIT LICENCE

The library do not depends other library.

## Author

[masato-ka](https://twitter.com/masato_ka)