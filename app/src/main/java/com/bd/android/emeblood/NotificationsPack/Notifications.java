package com.bd.android.emeblood.NotificationsPack;



public class Notifications {

    /**
     * Default translation for the word
     */
    private String mTitle;

    /**
     * Miwok translation for the word
     */
    private String mMessege;
    /*
    Miwok image resource id
     */

    /**
     * +     * Create a new Word object.
     * +     *
     * +     * @param defaultTranslation is the word in a language that the user is already familiar with
     * +     *                           (such as English)
     * +     * @param miwokTranslation is the word in the Miwok language
     * +
     */
    public Notifications(String Title, String message) {
        mTitle = Title;
        mMessege = message;

    }


    /**
     * +     * Get the default translation of the word.
     * +
     */
    public String getmTitle() {
        return mTitle;
    }

    /**
     * +     * Get the Miwok translation of the word.
     * +
     */
    public String getmMessege() {
        return mMessege;
    }



}