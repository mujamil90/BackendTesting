package org.api.util;

import java.util.regex.Pattern;
/***
 * @author mohammadmuzzamil
 */
public class EmailValidation {

    /***
     *  This function will check the local part (part before  @), as well as the domain part of the email:
     * The following RESTRICTION are imposed in the email address's LOCAL PART by regex:
     *
     * It allows numeric values from 0 to 9.
     * Both uppercase and lowercase letters from a to z are allowed.
     * Allowed are underscore “_”, hyphen “-“, and dot “.”
     * Dot isn't allowed at the start and end of the local part.
     * Consecutive dots aren't allowed.
     * For the local part, a maximum of 64 characters are allowed.
     *
     *
     * RESTRICTION for the DOMAIN part
     *
     * It allows numeric values from 0 to 9.
     * We allow both uppercase and lowercase letters from a to z.
     * Hyphen “-” and dot “.” aren't allowed at the start and end of the domain part.
     * No consecutive dots.
     *
     *
     * Some of the email addresses that will be VALID via this email validation technique are:
     *
     * username@domain.com
     * user.name@domain.com
     * user-name@domain.com
     * username@domain.co.in
     * user_name@domain.com
     *
     * Here's a shortlist of some email addresses that will be INVALID via this email validation:
     *
     * username.@domain.com
     * .user.name@domain.com
     * user-name@domain.com.
     * username@.com
     *
     * @param emailAddress to be validated in test case.
     *
     * @return true if email format is valid else return false.
     */
    public static boolean patternMatches(String emailAddress) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
}
