/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter1.ts;

import java.util.Date;
import javax.jws.WebService;

/**
 * The @WebService property endpointInterface links the SIB (this class) to the
 * SEI (com.farkalit.webreading.chapter1.ts.TimeServer). Note that the method implementations are not
 * annotated.
 *
 * @author fusman
 */
@WebService(endpointInterface = "com.farkalit.webreading.chapter1.ts.TimeServer")
public class TimeServerImpl implements TimeServer {

    @Override
    public String getTimeAsString()
    {
        return new Date().toString();
    }

    @Override
    public long getTimeAsElapsed()
    {
        return new Date().getTime();
    }

}
