# StaticHeaders
Create static headers in Apache Tomcat just by editing web.xml.

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
