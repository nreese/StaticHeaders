# StaticHeaders
Create static headers in Apache Tomcat just by editing web.xml.

This project came about when trying to debug a CORS problem. Tomcat has a built in CORS filter `org.apache.catalina.filters.CorsFilter` but this filter has lots of internal logic that masked the problem I was trying to debug. [A stack overflow question](http://stackoverflow.com/questions/24386712/tomcat-cors-filter#comment71763154_24386712) suggested building a new filter that just returned static values. I found having to write a java class, compile into byte code, and then package into a jar file a large hassel just to test a couple of headers. As a result, I created this generic filter that allows for the easy creation of headers by simply editing the web.xml file.

## Usage
* Install release jar in CATALINA_HOME/lib
* Add filter to CATALINA_HOME/conf/web.xml
```
<filter>
  <filter-name>StaticHeadersFilter</filter-name>
  <filter-class>StaticHeaders</filter-class>
  <init-param>
    <param-name>hello</param-name>
    <param-value>world</param-value>
  </init-param>
</filter>
<filter-mapping>
    <filter-name>StaticHeadersFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```
* restart apache tomcat
* test headers `curl -XGET -I 'http://localhost:8080'`

## Build
* Set CATALINA_HOME env
* run `make.sh`
