/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.jersey.web;

import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Doctor;
import com.usman.medical.service.DoctorService;
import com.usman.medical.util.DateUtils;
import com.usman.medical.util.IDGenerator;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author fusman
 */
@Path("/doctor")
@Component
public class DoctorResource {

    private static final String DATE_FORMAT = "dd-MM-yyyy";// "yyyy-MM-dd";

    @Autowired
    private DoctorService doctorService;

    @GET
    @Path("list")
    @Produces(
            {
                MediaType.TEXT_XML,MediaType.APPLICATION_XML
            })
    //@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    //@Consumes({MediaType.APPLICATION_JSON })
    //@Produces({MediaType.APPLICATION_JSON })
    public List<Doctor> showDoctor()
    {
        System.out.println("Doctor display ");
        List<Doctor> doctors = doctorService.listDoctor();
        System.out.println("doctors.size:" + doctors.size());
        return doctors;
    }

    @GET
    @Path("find/{doctorId}")
    @Produces(
            {
                MediaType.TEXT_XML,MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON
            })
    public Doctor findDoctorById(@PathParam("doctorId") long doctorId)
    {
        Doctor doctor = doctorService.findDoctorById(doctorId);
        System.out.println("doctor:"+doctor.toString());
        return doctor;
    }

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(
    {
        MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON
    })
    public String createDoctor( @FormParam("name")String name,
            @FormParam("degree")String degree, @FormParam("description")String description,
            @FormParam("profession")String profession, @FormParam("address")String address,
            @FormParam("experience")String experience, @FormParam("dateofbirth")String dateofbirth,@FormParam("sex")String sex)
    {
        System.out.println("Doctor create.....sex:"+sex);
        Doctor doctor = new Doctor();
        //set all the values
        doctor.setModuleId(IDGenerator.getRandomNum());
        doctor.setName(name);
        doctor.setDegree(degree);
        doctor.setDescription(description);
        doctor.setProfession(profession);
        doctor.setAddress(address);
        doctor.setExperience(Double.valueOf(experience));
        doctor.setDateOfBirth(DateUtils.getDate(dateofbirth, DATE_FORMAT));
        doctor.setSex(sex.charAt(0));
        System.out.println("Doctor:" + doctor.toString());
        //DoctorDao dao = new DoctorDao();
        AdminResponse admResponse = doctorService.createDoctor(doctor);
        System.out.println("Doctor create done. admResponse:"+admResponse.toString());

        return admResponse.toString();
    }
    
    @PUT
    @Path("update")
    @Produces(
            {
                MediaType.TEXT_XML,MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON
            })
    public AdminResponse updateDoctor(Doctor doctor)
    {
        AdminResponse response = doctorService.updateDoctor(doctor);
        System.out.println("...update doctor:"+response.toString());
        return response;
    }
    
    @DELETE
    @Path("delete")
    @Produces(
            {
                MediaType.TEXT_XML,MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON
            })
    public AdminResponse deleteDoctor(Doctor doctor)
    {
        AdminResponse response = doctorService.deleteDoctor(doctor);
        System.out.println("...delete doctor:"+response.toString());
        return response;
    }
    

    @GET
    @Path("text")
    public String getText()
    {
        return "Hello Usman!";
    }

    @GET
    @Path("count")
    public String getProductCount()
    {
        return String.valueOf(5);
    }
}
