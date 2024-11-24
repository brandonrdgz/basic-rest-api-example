# Basic Rest Api Example

To be able to run this project you must meet the following requirements

 - Java 17
 - MySQL 8<sup>1</sup>

<hr>

 - <sup>1</sup>You can use another relational database of your choice, but you have to modify the application.properties configuration with the appropriate ones and also the database scripts with the proper syntax.
<hr>

Inside the static directory of the resources directory, you'll find the following files:

 - schema.sql : SQL script to create the schema<sup>2</sup>
 - data.sql : SQL script to populate the tables with initial data<sup>2, 3</sup>
 - db diagram.pdf : Diagram of the schema

<hr>

 - <sup>2</sup>If you change the database, you also need to adequate the scripts with the proper syntax.

 - <sup>3</sup>You can see that the password of the user inside the data.sql script is hashed, which corresponds to the following value: *letmein*

<hr>

You need to set the following environment variables, which are used by the application.properties:

 - DB_HOST
 - DB_PORT
 - DB_NAME
 - DB_USER
 - DB_PASSWORD
 - JWT_SECRET<sup>4</sup>
<hr>

 - <sup>4</sup>The secret must be generated using the HMAC SHA512 algorithm, which requests 2 values for its generation:
	 - A key
	 - A value

<hr>

If you don't want to set up the environment variables, you can directly replace them with the values in the application.properties
