package com.realm.relearn.model.enumeration;
import com.google.common.collect.Sets;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.realm.relearn.model.enumeration.AppUserPermission.*;

public enum AppUserRole {
    VISITOR(Sets.newHashSet(READ_POST,READ_COMMENT)),
    USER(Sets.newHashSet(READ_POST,READ_COMMENT,WRITE_COMMENT)),
    AUTHOR(Sets.newHashSet(READ_POST,READ_COMMENT,WRITE_POST,WRITE_COMMENT)),
    ADMIN(Sets.newHashSet(READ_POST,READ_COMMENT,WRITE_POST,WRITE_COMMENT));
    private final Set<AppUserPermission> permissions;
    AppUserRole(Set<AppUserPermission> permissions) {
        this.permissions = permissions;
    }
    public Set<AppUserPermission> getPermissions() {
        return permissions;
    }
    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
       // permissions.add(new SimpleGrantedAuthority(this.name()));
        return permissions;
    }

}