package com.wdt.staybook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "_user")
@JsonDeserialize(builder = User.Builder.class)
public class User implements UserDetails {
    private static final long serialVersionUID = 1l;
    @Id
    private String username;

    @JsonIgnore
    private String password;

    private boolean isEnable;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnable;
    }

    public User() {
    }

    public User(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.role = builder.role;
        this.isEnable = builder.isEnabled;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public User setEnable(boolean enable) {
        isEnable = enable;
        return this;
    }

    public UserRole getRole() {
        return role;
    }

    public User setRole(UserRole role) {
        this.role = role;
        return this;
    }

    public void setEnabled(boolean b) {

    }

    public static class Builder{

        @JsonProperty("username")
        private String username;

        @JsonProperty("password")
        private String password;

        @JsonProperty("user_role")
        private UserRole role;

        @JsonProperty("is_enabled")
        private boolean isEnabled;


//        public Builder(String username, String password) {
//            this.username = username;
//            this.password = password;
//        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setRole(UserRole role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}
