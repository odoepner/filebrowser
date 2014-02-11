package net.doepner.tomcat;

import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.X509Certificate;

import org.apache.catalina.Container;
import org.apache.catalina.Context;
import org.apache.catalina.Realm;
import org.apache.catalina.Wrapper;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.deploy.SecurityConstraint;
import org.ietf.jgss.GSSContext;

/**
 * A realm that delegates authorization (login validation) to one realm
 * and role lookup for authenticated users to another realm
 * <p/>
 * TODO: Actual implementation and figure out how the server.xml realm config works here
 */
public class DelegatingRealm implements Realm {

    private final Realm loginRealm;
    private final Realm rolesRealm;

    public DelegatingRealm(Realm loginRealm, Realm rolesRealm) {
        this.loginRealm = loginRealm;
        this.rolesRealm = rolesRealm;
    }


    @Override
    public Container getContainer() {
        return null;
    }

    @Override
    public void setContainer(Container container) {

    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {

    }

    @Override
    public Principal authenticate(String s, String s2) {
        return null;
    }

    @Override
    public Principal authenticate(String s, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
        return null;
    }

    @Override
    public Principal authenticate(GSSContext gssContext, boolean b) {
        return null;
    }

    @Override
    public Principal authenticate(X509Certificate[] x509Certificates) {
        return null;
    }

    @Override
    public void backgroundProcess() {

    }

    @Override
    public SecurityConstraint[] findSecurityConstraints(Request request, Context context) {
        return new SecurityConstraint[0];
    }

    @Override
    public boolean hasResourcePermission(Request request, Response response, SecurityConstraint[] securityConstraints, Context context) throws IOException {
        return false;
    }

    @Override
    public boolean hasRole(Wrapper wrapper, Principal principal, String s) {
        return false;
    }

    @Override
    public boolean hasUserDataPermission(Request request, Response response, SecurityConstraint[] securityConstraints) throws IOException {
        return false;
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {

    }
}
