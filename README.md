1) Get tomcat 7, install into path that has no spaces in it
2) Make sure JAVA_HOME points to a recent JRE or JDK (path with not spaces in it)
2) move webapps/ROOT to webapps/ROOT.orig
4) Edit conf/web.xml as described in
    http://stackoverflow.com/questions/7068046/how-can-i-list-all-the-files-in-folder-on-tomcat
5) run bin/startup.*

Problem: A realm always does authentication _and_ role assignment.

=> Seems you have to extend the JNDIRealm that comes with Tomcat, similar to this:
http://stackoverflow.com/questions/1138450/implement-a-tomcat-realm-with-ldap-authentication-and-jdbc-authorization


Reference docs:
http://tomcat.apache.org/tomcat-7.0-doc/realm-howto.html
http://tomcat.apache.org/whichversion.html
Tomcat 7 implements Java Servlet Spec 3.0:
http://download.oracle.com/otndocs/jcp/servlet-3.0-fr-eval-oth-JSpec/
