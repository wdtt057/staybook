package com.wdt.staybook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "user")
@JsonDeserialize(builder = User.Builder.class)
public class User implements Serializable {
    private static final long serialVersionUID = 1l;
    @Id
    private String username;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private boolean enabled;

    public User() {
    }

    public User(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.enabled = builder.enabled;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public User setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public static class Builder{

        @JsonProperty("username")
        private String username;

        @JsonProperty("password")
        private String password;

        @JsonProperty("enabled")
        private boolean enabled;


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

        public Builder setEnabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
