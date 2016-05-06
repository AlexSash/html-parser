How to import certificate funtime.kiev.ua.crt to Java keystore

	- use cmd with admin
	- password min six char
	- after import change path in property file

keytool -import -v -file /you_path_to_certifacate/funtime.kiev.ua.crt -keystore /you_path_to_keystore/funtime.kiev.ua.jks -storepass you_path