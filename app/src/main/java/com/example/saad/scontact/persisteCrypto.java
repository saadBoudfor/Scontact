package com.example.saad.scontact;

import java.io.Serializable;

/**
 * Created by saad on 2/11/16.
 */
public class persisteCrypto implements Serializable {
    private static final long serialVersionUID = 0L;
    private String salt;
    private String initCipher;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getInitCipher() {
        return initCipher;
    }

    public void setInitCipher(String initCipher) {
        this.initCipher = initCipher;
    }

    public persisteCrypto(String salt, String initCipher) {
        this.salt = salt;
        this.initCipher = initCipher;
    }

    public persisteCrypto() {
    }
}
