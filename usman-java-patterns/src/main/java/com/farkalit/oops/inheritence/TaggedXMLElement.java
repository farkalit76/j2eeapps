/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.oops.inheritence;

/**
 *
 * @author fusman
 */
public class TaggedXMLElement implements TaggedIntf, XMLElementIntf{

    private TaggedIntf tag;
    private XMLElementIntf xml;
    
    public TaggedXMLElement(TaggedIntf tagging, XMLElementIntf xmlelement)
    {
        this.tag= tagging;
        this.xml = xmlelement;
    }
    
    @Override
    public void show() {
        this.tag.show();
    }

    @Override
    public void display() {
        this.xml.display();
    }
    
    public static void main(String[] args) {
        TaggedXMLElement tag = new TaggedXMLElement(new Tagged(), new XMLElement());
        tag.show();
        tag.display();
    }
}
