package com.coopsanmartin.arqueo.auth;

public class JwtConfig {
	
	public static final String LLAVE_SECRETA = "alguna.clave.secreta";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpQIBAAKCAQEAxyOD46D2MKzkjrIitTZOofUDJqVnBmqYgeHNKLI85X6WlUCj\r\n" + 
			"+hAfc9KTQm3GEfR70p0SK4mH33/urwkAZ1nljDf3la6Yx467IkcM3ZHlFzBkLv4x\r\n" + 
			"EWOZx3ludqa2bGuqgojVm4QnO5n6b8Q9qctogrPjILFS6m9VCf0pufcJruFoDVGj\r\n" + 
			"/yxPWZHcjdp9ZLh5Lq6PQmyIE36FspiO6k1IxcvE9m7poixojHsmDCKugC7DyyEj\r\n" + 
			"py6u81qaEapfMpjsK1gzv0dyCfD4dZzGjo/z6eLVsG+Z4QQVSptVIehAWlDqAfBM\r\n" + 
			"ieet0V+GSyi1Cw7q/I20K1XOATNG5ezgmQUeXQIDAQABAoIBAQCJqZKONIKcaZji\r\n" + 
			"0GBP90fqjA7uk18iP2RIPUlvPa/9UkJU0UfKIYUss0BbprlLRkCm+zBJapzEM5NT\r\n" + 
			"6xwdVjbqdPIxxm4VXiUdcBKDxUyieDB5j/1psPnovJhRa7QmRVOtQ1yvUm8ws6Q9\r\n" + 
			"yWJ7U4Ne/24e9paEPAyEiD9lMFLAUhZ/HYbNfOwC7jHrkOCZwTmmbTwYlp9HqL/n\r\n" + 
			"GUQgZ8qW84tYBeUjjwNCP4TEvusTpSqSAL9BverMso66EFq3cbosk1cVnyp6dGYS\r\n" + 
			"uVi3igsOuBO3v0F5zTQ5XBt2MBly0JjJlV2PtQ0dZJyNIqwudWhgbklm4ySES4SY\r\n" + 
			"tGA/U6+BAoGBAPtKh1/uuF6++4XodTde6r7cPhGxTUzQSIWn37aTSYpJRTrxSk8K\r\n" + 
			"6H83av634WAoE4QfG0fB5QYv6fVQPgeooGECNe0eaEkEDsl6w5dgCC+IwZpOClfE\r\n" + 
			"wVqLZmGMT8tnhHBxhYfx7F2x+wlWalg0q0nYls+asmh5BYH4J4ginGe9AoGBAMre\r\n" + 
			"zjupaQgJpgCzssmSC+7RZzcFL8y9tb1pNdRHa2GwMCmctovhPH5GU97GJ+QDidAG\r\n" + 
			"0gfAteHGQIJrR41cqXRWE2ZZ3W+uG6K/nGGnSlvYRwPXDVhYW0Oiih5C+CyaunaI\r\n" + 
			"zgrXZoRZOONyp4nCR/K5gOjRo7u9k6Cd6UcmmyshAoGBALvxqf5eFRcH0Cb/DWw0\r\n" + 
			"WW4WW3XwHdhtj1AnlnJ/BmmfE2BaRzGG/wzm7edEsBOy5aXTfhvVMO3HuDv5n+sq\r\n" + 
			"e4kSljKao3S4zDZ00wTMllK2/dXiuGmchuCpkhEzWBrReYR/41ch4Z7SFueM8ky2\r\n" + 
			"V8YLcAAlu3nXyf7DEw4GlOQhAoGAF0c5ot7tjl6NDceQ3FBFzkF49ndB5Nxf3jwU\r\n" + 
			"USdgyvTMkfnJeIN/zX2EYiuaqC8/wP8HWpxiQmXdQRnOPApF53N5BmWJYyc3RJV3\r\n" + 
			"/DyV67QFcgtbHKgG0Nv1vUMx9uxKOQ+5lMTino0eWfrt/oCsgM2IXS6w+vnl1qhH\r\n" + 
			"/EIRzAECgYEA3iwAreFzaJL4EZsBsPnQkZvPLIZDdJRxSXDyEWRzDZsc5S3xlLAO\r\n" + 
			"QACHRPZKZl0oZ8uxJY4zGNqUM2oLYzv+GyzjkIEbR+6EAHDolNmOLjxddo6dKdda\r\n" + 
			"ijMY+/yQwtRAbyUMAeL+q7qQZ0GHrmSPz2xSPMDntyoIomGm5hN1HgU=\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxyOD46D2MKzkjrIitTZO\r\n" + 
			"ofUDJqVnBmqYgeHNKLI85X6WlUCj+hAfc9KTQm3GEfR70p0SK4mH33/urwkAZ1nl\r\n" + 
			"jDf3la6Yx467IkcM3ZHlFzBkLv4xEWOZx3ludqa2bGuqgojVm4QnO5n6b8Q9qcto\r\n" + 
			"grPjILFS6m9VCf0pufcJruFoDVGj/yxPWZHcjdp9ZLh5Lq6PQmyIE36FspiO6k1I\r\n" + 
			"xcvE9m7poixojHsmDCKugC7DyyEjpy6u81qaEapfMpjsK1gzv0dyCfD4dZzGjo/z\r\n" + 
			"6eLVsG+Z4QQVSptVIehAWlDqAfBMieet0V+GSyi1Cw7q/I20K1XOATNG5ezgmQUe\r\n" + 
			"XQIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";

}
