# Overview

A example app using RMI & JDBC to operate remote database. You can finish basic operations for database. This is Client Side, and you must need a servr side in this [repository](https://github.com/Sunlcy/RMIDBManagerServer). 

# Run

Double click the executable jar 'RmiClient.jar' and you can run the client side. However, you need to start server side first and you can get it from this [repository](https://github.com/Sunlcy/RMIDBManagerServer).

When you have run it, a login GUI will display and you need to input user and its password, who has permissions to access remote database and do some basic operations. After that, you need to input the database name which exists in remote server.

Having done that, you can get a manager GUI, and you can do some basic operations for database.
 
**NOTE:** This executable jar is exported in Java 8 environment, so you must have Java 8 if you want to run it.

# Config

You can set the url of remote server and its port according to your need.

# Download

You can get it from [here](http://git.oschina.net/chaoyangliu/RMIDBManagerClient/releases/v1.1).

# Develop

If you want to compile my source code, you need to install 'mysql-connector-java-5.0.8-bin.jar'.
