package org.apache.catalina.realm;

import java.security.Principal;

import org.apache.catalina.Realm;

/**
 * Delegates authorization (login validation) to its first nested realm
 * and role lookup for authenticated users to its second nested realm
 */
public final class DelegatingRealm extends RealmBase {

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
    protected String getPassword(String username) {
        return realmBase(loginRealm).getPassword(username);
    }

    @Override
    protected Principal getPrincipal(String username) {
        return realmBase(rolesRealm).getPrincipal(username);
    }

    private RealmBase realmBase(Realm realm) {
        if (realm instanceof RealmBase) {
            return (RealmBase) rolesRealm;
        } else {
            throw new IllegalArgumentException(
                    "Nested realm " + realm.getClass()
                            + " is not instanceof " + RealmBase.class);
        }
    }
}
