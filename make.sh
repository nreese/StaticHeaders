#!/bin/bash
rm *.class
rm *.jar
javac -cp $CATALINA_HOME/lib/servlet-api.jar StaticHeaders.java
jar cvf StaticHeaders.jar StaticHeaders.class