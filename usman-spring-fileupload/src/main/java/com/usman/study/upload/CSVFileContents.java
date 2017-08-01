/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.study.upload;

/**
 *
 * @author 72010995
 */
public class CSVFileContents
{
    private String clientName;
    private String accountId;
    private String transcript;
    private String details;
    private String referenceId;

    public CSVFileContents()
    {
    }

    public CSVFileContents(String clientName, String accountId, String transcript, String details, String referenceId)
    {
        this.clientName = clientName;
        this.accountId = accountId;
        this.transcript = transcript;
        this.details = details;
        this.referenceId = referenceId;
    }

    public String getClientName()
    {
        return clientName;
    }

    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }

    public String getAccountId()
    {
        return accountId;
    }

    public void setAccountId(String accountId)
    {
        this.accountId = accountId;
    }

    public String getTranscript()
    {
        return transcript;
    }

    public void setTranscript(String transcript)
    {
        this.transcript = transcript;
    }

    public String getDetails()
    {
        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }

    public String getReferenceId()
    {
        return referenceId;
    }

    public void setReferenceId(String referenceId)
    {
        this.referenceId = referenceId;
    }

    @Override
    public String toString()
    {
        return "CSVFileContents{" + "clientName=" + clientName + ", accountId=" + accountId + ", transcript=" + transcript + ", details=" + details + ", referenceId=" + referenceId + '}';
    }
    
    
}
