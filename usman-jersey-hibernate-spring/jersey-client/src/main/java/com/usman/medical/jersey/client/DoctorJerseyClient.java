/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.jersey.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;
import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Doctor;
import java.net.URI;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author fusman
 */
public class DoctorJerseyClient {
    
    private static final String DATE_FORMAT = "dd-MM-yyyy";// "yyyy-MM-dd";

    private static final String WS_URL = "http://localhost:8030/jersey-web/";

    public static void main(String[] args)
    {
        System.out.println("Test started...");

        getText();
        getList();
        getDoctorList();
        getDoctorById("3142");
        createDoctor();
        updateDoctor();
        //deleteDoctor();
        //System.out.println("todos.create:" + create);

    }

    private static URI getBaseURI()
    {
        return UriBuilder.fromUri(WS_URL).build();
    }

    public static List<Doctor> getDoctorList()
    {
        List<Doctor> list = Client.create().resource(getBaseURI() + "rest/doctor/list").get(new GenericType<List<Doctor>>() {
        });
        for (Doctor doc : list)
        {
            System.out.println("Result:" + doc.toString());
        }
        return list;
    }

    public static Doctor getDoctorById(String doctId)
    {
        Doctor doc = Client.create().resource(getBaseURI() + "rest/doctor/find/" + doctId).get(new GenericType<Doctor>() {
        });
        System.out.println("doc:" + doc.toString());
        return doc;
    }

    private static void getText() throws RuntimeException, UniformInterfaceException, ClientHandlerException
    {
        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI() + "rest/doctor/text");
        ClientResponse response = webResource.accept("text/plain").get(ClientResponse.class);
        if (response.getStatus() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        String output = response.getEntity(String.class);
        System.out.println("output:" + output);
    }

    private static void getList() throws RuntimeException, UniformInterfaceException, ClientHandlerException
    {
        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI() + "rest/doctor/list");
        ClientResponse response = webResource.accept("text/xml").get(ClientResponse.class);
        if (response.getStatus() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        //response.getEntity(List<String>);
        String output = response.getEntity(String.class);
        System.out.println("doclist:" + output);
    }

    private static void createDoctor() throws RuntimeException, UniformInterfaceException, ClientHandlerException
    {
        System.out.println("Call create statement");
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource webResource = client.resource(UriBuilder.fromUri(getBaseURI() + "rest/doctor").build());

        Form form = new Form();
        form.add("name", "usman");
        form.add("degree", "MBBS");
        form.add("description", "Medical Practictioner");
        form.add("profession", "Doctor");
        form.add("address", "Dlehi");
        form.add("experience", "4");
        form.add("dateofbirth", "10-08-2017");
        form.add("sex", "M");

        System.out.println("Call create form:" + form.toString());
        //ClientResponse response = webResource.accept(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, form);
        //ClientResponse response = webResource.path("create").accept("text/plain").post(ClientResponse.class, form);
        ClientResponse response = webResource.path("create").accept(MediaType.APPLICATION_XML).post(ClientResponse.class, form);
        System.out.println("create response:" + response);
        if (response.getStatus() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        String output = response.getEntity(String.class);
        //AdminResponse output = response.getEntity(new GenericType<AdminResponse>(){});
        System.out.println("create output:" + output.toString());
    }

    public static void createDoctor(Doctor doct) throws RuntimeException, UniformInterfaceException, ClientHandlerException
    {
        System.out.println("Call create statement");
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource webResource = client.resource( UriBuilder.fromUri(getBaseURI() + "rest/doctor").build() );

        Form form = new Form();
        form.add("name", doct.getName());
        form.add("degree", doct.getDegree());
        form.add("description", doct.getDescription());
        form.add("profession", doct.getProfession());
        form.add("address", doct.getAddress());
        form.add("experience", doct.getExperience());
        form.add("dateofbirth", doct.getDateOfBirth());
        form.add("sex", String.valueOf(doct.getSex()));

        System.out.println("Call create form:" + form.toString());
        //ClientResponse response = webResource.path("create").accept(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, form);
        //ClientResponse response = webResource.path("create").accept("text/plain").post(ClientResponse.class, form);
        ClientResponse response = webResource.path("create").accept(MediaType.APPLICATION_XML).post(ClientResponse.class, form);
        System.out.println("create response:" + response);
        if (response.getStatus() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        String output = response.getEntity(String.class);
        //AdminResponse output = response.getEntity(new GenericType<AdminResponse>(){});
        System.out.println("create output:" + output.toString());
    }
    
    private static void updateDoctor()
    {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource webResource = client.resource( UriBuilder.fromUri(getBaseURI() + "rest/doctor").build() );
        Doctor doctor = new Doctor();
        doctor.setModuleId(3241);
         doctor.setName("name");
        doctor.setDegree("degree");
        doctor.setDescription("description");
        doctor.setProfession("profession");
        doctor.setAddress("address");
        doctor.setExperience(33.0);
        doctor.setDateOfBirth(DateUtils.getDate("10-08-2017", DATE_FORMAT));
        doctor.setSex('M');
        
        ClientResponse response = webResource.path("update").accept(MediaType.APPLICATION_XML).put(ClientResponse.class, doctor);
        //ClientResponse response = webResource.accept("text/plain").get(ClientResponse.class);
        if (response.getStatus() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        String output = response.getEntity(String.class);
        System.out.println("update output:" + output);
    }
    
     public static void updateDoctor(Doctor doc)
    {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource webResource = client.resource( UriBuilder.fromUri(getBaseURI() + "rest/doctor").build() );
        Doctor doctor = new Doctor();
        doctor.setModuleId(doc.getModuleId());
         doctor.setName(doc.getName());
        doctor.setDegree(doc.getDegree());
        doctor.setDescription(doc.getDescription());
        doctor.setProfession(doc.getProfession());
        doctor.setAddress(doc.getProfession());
        doctor.setExperience(doc.getExperience());
        doctor.setDateOfBirth(doc.getDateOfBirth());//DateUtils.getDate("10-08-2017", DATE_FORMAT));
        doctor.setSex(doc.getSex());
        
        ClientResponse response = webResource.path("update").accept(MediaType.APPLICATION_XML).put(ClientResponse.class, doctor);
        //ClientResponse response = webResource.accept("text/plain").get(ClientResponse.class);
        if (response.getStatus() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        String output = response.getEntity(String.class);
        System.out.println("update output:" + output);
    }

    public static void deleteDoctor()
    {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource webResource = client.resource( UriBuilder.fromUri(getBaseURI() + "rest/doctor").build() );
        Doctor doctor = new Doctor();
        doctor.setModuleId(3241);
         doctor.setName("name");
        doctor.setDegree("degree");
        doctor.setDescription("description");
        doctor.setProfession("profession");
        doctor.setAddress("address");
        doctor.setExperience(33.0);
        doctor.setDateOfBirth(new Date("10-08-2017"));
        doctor.setSex('M');
        
        ClientResponse response = webResource.path("delete").accept(MediaType.APPLICATION_XML).delete(ClientResponse.class, doctor);
        //ClientResponse response = webResource.accept("text/plain").get(ClientResponse.class);
        if (response.getStatus() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        String output = response.getEntity(String.class);
        System.out.println("delete output:" + output);
    }
}
