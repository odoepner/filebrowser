package org.apache.catalina.realm;

import java.security.Principal;

import org.apache.catalina.Realm;

/**
 * A realm that delegates authorization (login validation) to one realm
 * and role lookup for authenticated users to another realm
 */
public class DelegatingRealm extends RealmBase {

    private Realm loginRealm;
    private Realm rolesRealm;

    /**
     * Called by the digester when parsing server.xml
     *
     * @param realm A nested realm instance
     */
    @SuppressWarnings("unused")
    public void addRealm(Realm realm) {
        if (loginRealm == null) {
            loginRealm = realm;
        } else if (rolesRealm == null) {
            rolesRealm = realm;
        } else {
            throw new IllegalArgumentException("Only 2 nested realms allowed");
        }
    }

    @Override
    protected String getName() {
        return getClass().getSimpleName();
    }

    @Override
    protected String getPassword(String s) {
        return getAsRealmBase(loginRealm).getPassword(s);
    }

    @Override
    protected Principal getPrincipal(String s) {
        return getAsRealmBase(rolesRealm).getPrincipal(s);
    }

    private RealmBase getAsRealmBase(Realm realm) {
        if (realm instanceof RealmBase) {
            return ((RealmBase) rolesRealm);
        } else {
            throw new IllegalArgumentException(
                "Nested realm is not instanceof " + RealmBase.class);
        }
    }
}
