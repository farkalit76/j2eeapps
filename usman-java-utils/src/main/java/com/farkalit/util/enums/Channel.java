/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.farkalit.util.enums;

/**
 *
 * @author 72010995
 */
public enum Channel
{
    //<editor-fold defaultstate="collapsed" desc="Values">
     /**
     * The offline case work-item channel.
     * 
     * @since 1.0
     */
    ADHOC_WORK('D'),
    /**
     * The web-based chat contact channel.
     *
     * @since 2.0
     */
    CHAT('H'),
    /**
     * The customer information system contact channel.
     *
     * @since 2.0
     */
    CIS('C'),
    /**
     * The (shared inbox) email contact channel.
     *
     * @since 2.0
     */
    EMAIL('E'),
    /**
     * The Facebook(c) contact channel.
     *
     * @since 2.0
     */
    FACEBOOK('F'),
    /**
     * The fax contact channel.
     *
     * @since 2.0
     */
    FAX('X'),
    /**
     * The LinkedIn(c) contact channel.
     *
     * @since 2.0
     */
    LINKED_IN('L'),
    /**
     * The mobile application (thick client) contact channel.
     *
     * @since 2.0
     */
    MOBILE_APP('A'),
    /**
     * The mobile web site contact channel.
     *
     * @since 2.0
     */
    MOBILE_WEB('O'),
    /**
     * The (snail) mail contact channel.
     *
     * @since 2.0
     */
    PAPER_MAIL('M'),
    /**
     * The phone contact channel.
     *
     * @since 2.0
     */
    PHONE('P'),
    /**
     * The SMS contact channel.
     *
     * @since 2.0
     */
    SMS('S'),
    /**
     * The Twitter(c) contact channel.
     *
     * @since 2.0
     */
    TWITTER('T'),
    /**
     * The web-form contact channel.
     *
     * @since 2.0
     */
    WEB_MAIL('B'),
    /**
     * The (full) web site contact channel.
     *
     * @since 2.0
     */
    WEB_SITE('W'),
    /**
     * The YouTube(c) contact channel.
     *
     * @since 2.0
     */
    YOU_TUBE('Y');
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Fields">
    /**
     * The character code to use in persistent records to represent this
     * {@link Channel}.
     *
     * @since 2.0
     */
    private final char character;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    /**
     * Creates a new {@link Channel} instance with the specified character
     * value.
     *
     * @since 2.0
     * @param value the character code to use in persistent records to represent
     * this {@link Channel}.
     */
    private Channel(char value)
    {
        //ReferenceValidator.validate(getClass(), value);
        this.character = value;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    /**
     * Gets the character code to use in persistent records to represent this
     * {@link Channel}.
     *
     * @since 2.0
     * @return the character code to use in persistent records to represent this
     * {@link Channel}.
     */
    public char getCharacter()
    {
        return character;
    }
    //</editor-fold>
}
