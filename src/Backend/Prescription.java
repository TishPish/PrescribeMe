/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author tishpish
 */
public class Prescription implements Serializable
{
    private static Prescription prescription;
    private String time, date, doctorId;
    private ArrayList<Test> allTest;
    private ArrayList<Medicine> allMedicine;

    private Prescription(String doctorID,String time, String date)
    {
        this.doctorId = doctorID;
        this.time = time;
        this.date= date;
        allTest = new ArrayList<Test>();
        allMedicine = new ArrayList<Medicine>();
    }
    
    public static Prescription getEmptyPrescription(String doctorID,String time, String date)
    {
        if (prescription== null)
            prescription = new Prescription(doctorID, time, date);
        return prescription;
    }
    
    public String getDoctorId()
    {
        return doctorId;
    }
    
    public void setDoctorId(String doctorId)
    {
        this.doctorId = doctorId;
    }
 
    public String getDate()
    {
        return date;
    }

    public String getTime()
    {
        return time;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public void setTime(String time)
    {
        this.time = time;
    }
    
    public void addTest(Test test)
    {
        allTest.add(test);
    }
    public void addMedicine(Medicine med)
    {
        allMedicine.add(med);
    }
    
    public String convertToJson()
    {
        String data = "";
        data+="{";
        data+="\"doctorId\":\""+getDoctorId()+"\",\n";
        data+="\"time\":\""+getTime()+"\",\n";
        data+="\"date\":\""+getDate()+"\",\n";
        data+="\"tests\":"+"[\n";
        
        for (int i=0;i<allTest.size();i++)
        {
            data+= allTest.get(i).getJson();
            if (i+1<allTest.size())
            {
                data+=",";
            }
        }
        data+="],\n";
         data+="\"medicines\":"+"[\n";
        for (int i=0;i<allMedicine.size();i++)
        {
            data+= allMedicine.get(i).getJson();
            if (i+1<allMedicine.size())
            {
                data+=",\n";
            }
        }
        data+="]\n";
        data+="}\n";
        //return data;
        return data;
    }
    
    
    
}
