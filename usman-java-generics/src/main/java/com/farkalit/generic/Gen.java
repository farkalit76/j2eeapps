/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.generic;

/**
 *
 * @author 72010995
 */
public class Gen<T>
{

    T ob;/*from   w  w w . j a  v a2  s .c o  m*/

    Gen(T o)
    {
        ob = o;
    }

    T getob()
    {
        return ob;
    }
}
