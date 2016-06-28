/************************************************************************
 Copyright (C) Unpublished Electronic Arts (EA) Software, Inc.
 All rights reserved. EA Software, Inc., Confidential and Proprietary.

 This software is subject to copyright protection
 under the laws of the Canada and other countries.

 Unless otherwise explicitly stated, this software is provided
 by Electronic Arts (EA).

 *************************************************************************/
package com.ea.online.ebisu.loginregistration.utils;

import com.ea.rs4.Logger;
import com.ea.rs4.utils.StringUtils;

/**
 * This class for validate the correct of expression or parameters
 *
 * @author Dean.Song
 *
 */
public final class RegexCheckUtils {

    private static final Logger LOG = new Logger(RegexCheckUtils.class.getSimpleName());

    // regular expression of pure number.
    private static final String REG_NUMBER = "[0-9,]+";

    // regular expression of email.
    private static final String REG_EMAIL = "(?:[a-z0-9A-Z!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9A-Z!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9A-Z](?:[a-z0-9A-Z-]*[a-z0-9A-Z])?\\.)+[a-z0-9A-Z](?:[a-z0-9A-Z-]*[a-z0-9A-Z])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9A-Z-]*[a-z0-9A-Z]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

    // regular expression of boolean.
    private static final String REG_BOOLEAN = "^(true|false|TRUE|FALSE)$";

    // regular expression of password for special charactor.
    private static final String REG_PASSWORD = "^[\\[\\]0-9a-zA-Z'`!@#\\$%^\\&*()_\\={}\\:\\;\\<\\>+-]{4,16}";

    // regular expression of dob
    private static final String REG_DOB = "[0-9]{4,4}-[0-9]{1,2}-[0-9]{1,2}";

    private static final String REG_PLUS_INT = "^[1-9]\\d*$";

    private RegexCheckUtils() {
    }

    /**
     * Verifys the String value is null or not.
     *
     * @param value string parameter to test.
     * @return if the parameter is not empty return true, else return false.
     */
    public static boolean checkValueNull(String value) {
        return !StringUtils.isEmpty(value);
    }

    /**
     * Validates the boolean value is match the regular expression or not
     *
     * @param boolValue string parameter to test.
     * @return if the parameter is boolean format return true, else return false.
     */
    public static boolean checkBoolean(String boolValue) {
        return isValid(REG_BOOLEAN, boolValue);
    }

    /**
     * Validates user's email is match the regular expression or not
     *
     * @param email the value of user's email
     * @return if the parameter is email format return true, else return false.
     */
    public static boolean checkEmailFormat(String email) {
        return isValid(REG_EMAIL, email);
    }

    /**
     * Validates length of user's password is correct or not
     *
     * @param password user's password
     * @return if the parameter is password format return true, else return false.
     */
    public static boolean checkPasswordFormat(String password) {
        return isValid(REG_PASSWORD, password);
    }

    /**
     * Validates user's dob is match the regular expression or not
     *
     * @param dob date of birth of the user
     * @return if the parameter is dob format return true, else return false.
     */
    public static boolean checkDobFormat(String dob) {
        return isValid(REG_DOB, dob);
    }

    /**
     * Validates the legal of parameters
     *
     * @param regex string parameter to test
     * @param context string parameter to test
     * @return if the parameter is valid return true, else return false.
     */
    public static boolean isValid(String regex, String context) {
        return context.matches(regex);
    }

    /**
     * Judges if the parameter is a pure number string.
     *
     * @param number string parameter to test.
     * @return if the parameter is a number return true, else return false.
     */
    public static boolean isNumber(String number) {
        if (StringUtils.isEmpty(number)) {
            return false;
        }
        return number.matches(REG_NUMBER);
    }

    /**
     * Convert single quote marks to double quote marks in string and convert % to /%.
     *
     * @param s
     * @return
     */
    public static String dealSpecialCharacter(String s) {
        StringBuffer sb = new StringBuffer();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '\'') {
                sb.append('\'').append('\'');
            } else if (c == '%' || c == '/') {
                sb.append("/").append(c);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Convert object to Long value.
     *
     * @param ob a object
     * @return a Long value
     */
    public static Long convertObjectToLong(Object ob) {
        if (ob == null || !isNumber(ob.toString())) {
            LOG.warn("The value is null or is not a number! return null as default. errorCode=%s",
                    Constant.ERROR_CODE_PARAM_INVALID);
            return null;
        }
        return Long.valueOf(ob.toString());
    }

    /**
     * Convert object to Integer value.
     *
     * @param ob a object
     * @return a Integer value
     */
    public static Integer convertObjectToInteger(Object ob) {
        if (ob == null || !isNumber(ob.toString())) {
            LOG.warn("The value is null or is not a number! return null as default. errorCode=%s",
                    Constant.ERROR_CODE_PARAM_INVALID);
            return null;
        }
        return Integer.valueOf(ob.toString());
    }

    public static boolean checkPlusInteger(String key) {
        return isValid(REG_PLUS_INT, key);
    }

    /**
     * Check the password if match regex.
     *
     * @param password, user password
     * @param regex, the characters that are valid
     * @return true means the characters of password are valid else false
     */
    public static boolean checkPasswrodStrength(String password, String regex) {
        return password.matches(regex);
    }
}
