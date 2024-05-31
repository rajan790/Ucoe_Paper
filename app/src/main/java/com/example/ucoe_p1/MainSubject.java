package com.example.ucoe_p1;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainSubject extends AppCompatActivity{
    RecyclerView recyclerView;
    ArrayList<parent_model> parent_modelArrayList;
    ArrayList<child_model> child_modelArrayList;
    ArrayList<child_model> child_modelArrayList2;
    NetworkChangeLisetner networkChangeLisetner=new NetworkChangeLisetner();
    int branch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_subject);
//        getSupportActionBar().hide();
        Intent foryear=getIntent();
        int year=foryear.getIntExtra("year",0);
         branch=foryear.getIntExtra("branch",0);
        recyclerView = findViewById(R.id.recyclerView);
        child_modelArrayList=new ArrayList<>();
        child_modelArrayList2=new ArrayList<>();
        parent_modelArrayList=new ArrayList<>();
        parent_adapter parent1;
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        // Get the default display
        Display display = windowManager.getDefaultDisplay();
        // Create a DisplayMetrics object
        DisplayMetrics displayMetrics = new DisplayMetrics();
        // Populate the DisplayMetrics object
        display.getMetrics(displayMetrics);

        // Get the width in pixels
        int width = displayMetrics.widthPixels;
        
        if(year==1)
        {
            if(branch==1)
            {
                child_modelArrayList.add(new child_model(" Applied   Physics",1));
                child_modelArrayList.add(new child_model(" Applied    Math-1",1));
                child_modelArrayList.add(new child_model("Basic   Electronics E",1));
                child_modelArrayList.add(new child_model("Computer Programming",1));
                child_modelArrayList.add(new child_model("Manufacturing Process",1));
                parent_modelArrayList.add(new parent_model("First Sem",child_modelArrayList));
                child_modelArrayList2.add(new child_model("Applied Chemistry",1));
                child_modelArrayList2.add(new child_model(" Applied    Math-2",1));
                child_modelArrayList2.add(new child_model("DC&LD",1));
                child_modelArrayList2.add(new child_model("OOPS",1));
                child_modelArrayList2.add(new child_model("Engineering Graphics",1));
                child_modelArrayList2.add(new child_model("Communication Skills",1));
                parent_modelArrayList.add(new parent_model("Second Sem",child_modelArrayList2));
            }
            else
            {
                year1();
            }

        }
        else if(year==2)
        {
            if(branch==1)
            {
                child_modelArrayList.add(new child_model("Computer Network",1));
                child_modelArrayList.add(new child_model("  Data    Structure",1));
                child_modelArrayList.add(new child_model("Computer System Arc",1));
                child_modelArrayList.add(new child_model("Python Programming",1));
                child_modelArrayList.add(new child_model("Discete Mathematical St",1));
                parent_modelArrayList.add(new parent_model("Third Sem",child_modelArrayList));
                child_modelArrayList2.add(new child_model("Operating System",1));
                child_modelArrayList2.add(new child_model("Software Engineering",1));
                child_modelArrayList2.add(new child_model("DBMS",1));
                child_modelArrayList2.add(new child_model("Microprocessor & ALP",1));
                child_modelArrayList2.add(new child_model("Algorithm  Analy & Des",1));
                parent_modelArrayList.add(new parent_model("fourth Sem",child_modelArrayList2));
            }
            else if (branch==2)
            {
                child_modelArrayList.add(new child_model("Numerical Method & Appl",1));
                child_modelArrayList.add(new child_model("Operations Research",1));
                child_modelArrayList.add(new child_model("Strength of Materials",1));
                child_modelArrayList.add(new child_model("Manufacturing Technology",1));
                child_modelArrayList.add(new child_model("Basic Thermodynamics",3));
                parent_modelArrayList.add(new parent_model("Third Sem",child_modelArrayList));
                child_modelArrayList2.add(new child_model("Theory of Machines",1));
                child_modelArrayList2.add(new child_model("Fluid  Mechanics",1));
                child_modelArrayList2.add(new child_model("Applied Thermodynamics",3));
                child_modelArrayList2.add(new child_model("Machine Desigen-1",1));
                child_modelArrayList2.add(new child_model("Mechanical Meas. & Metrology",3));
                parent_modelArrayList.add(new parent_model("Fourth Sem",child_modelArrayList2));
            }
            else if (branch==3)
            {
                child_modelArrayList.add(new child_model("Numerical Method & Appl",1));
                child_modelArrayList.add(new child_model("Electronic Devices",1));
                child_modelArrayList.add(new child_model("Electro - Magnetic Field",1));
                child_modelArrayList.add(new child_model("OOPS",1));
                child_modelArrayList.add(new child_model("Electrical & Electronic Instr.",1));
                child_modelArrayList.add(new child_model("Management Practices & Organizational B",3));
                parent_modelArrayList.add(new parent_model("Third Sem",child_modelArrayList));
                child_modelArrayList2.add(new child_model("Digital Electronic C",1));
                child_modelArrayList2.add(new child_model("Analog Electronic C",1));
                child_modelArrayList2.add(new child_model("Pulse & Digital Switching C",1));
                child_modelArrayList2.add(new child_model("    Circuit     Theory",1));
                child_modelArrayList2.add(new child_model("Signals & Systems",1));
                child_modelArrayList2.add(new child_model("Antenna & Wave Propagation",3));
                parent_modelArrayList.add(new parent_model("Fourth Sem",child_modelArrayList2));
            }
            else if (branch==4)
            {
                child_modelArrayList.add(new child_model("Wave Propagation",1));
                child_modelArrayList.add(new child_model("Electronic Devices",1));
                child_modelArrayList.add(new child_model("Data Structure & Alg",1));
                child_modelArrayList.add(new child_model("OOPS",1));
                child_modelArrayList.add(new child_model("Discrete Mathematics.",1));
                child_modelArrayList.add(new child_model("Management Practices & Organizational B",3));
                parent_modelArrayList.add(new parent_model("Third Sem",child_modelArrayList));
                child_modelArrayList2.add(new child_model("Digital Electronic C",1));
                child_modelArrayList2.add(new child_model("Analog Electronic C",1));
                child_modelArrayList2.add(new child_model("Computer System Arc",1));
                child_modelArrayList2.add(new child_model("    Circuit     Theory",1));
                child_modelArrayList2.add(new child_model("Signals & Systems",1));
                child_modelArrayList2.add(new child_model("Antenna & Wave Propagation",3));
                child_modelArrayList2.add(new child_model("Operating System",1));
                parent_modelArrayList.add(new parent_model("Fourth Sem",child_modelArrayList2));
            }
            else if(branch==5)
            {
                child_modelArrayList.add(new child_model("Building Materials",1));
                child_modelArrayList.add(new child_model(" Fluid  Mechanics",1));
                child_modelArrayList.add(new child_model("Survey-1",1));
                child_modelArrayList.add(new child_model("Building Construction",1));
                child_modelArrayList.add(new child_model("Management Practices & Organizational B",3));
                child_modelArrayList.add(new child_model("Hydrology And Dams",1));
                parent_modelArrayList.add(new parent_model("Third Sem",child_modelArrayList));
                child_modelArrayList2.add(new child_model("Concrete Technology",1));
                child_modelArrayList2.add(new child_model("Rock Mech & Engin Geology",1));
                child_modelArrayList2.add(new child_model(" Solid  Mechanics",1));
                child_modelArrayList2.add(new child_model("Survey 2",1));
                child_modelArrayList2.add(new child_model("Transportation Engineering-1",1));
                child_modelArrayList2.add(new child_model("Construction Mac & Work Mng",1));
                parent_modelArrayList.add(new parent_model("fourth Sem",child_modelArrayList2));
            }
        }
        else if(year==3)
        {
            if(branch==1)
            {
                child_modelArrayList.add(new child_model("RDBMS PL/SQL",1));
                child_modelArrayList.add(new child_model("Java Language",1));
                child_modelArrayList.add(new child_model("Theory of Computation",1));
                child_modelArrayList.add(new child_model("Artificial Intelligence",1));
                child_modelArrayList.add(new child_model("Cryptography & Network Sty",1));
                parent_modelArrayList.add(new parent_model("Fifth Sem",child_modelArrayList));
                child_modelArrayList2.add(new child_model("Machine Learning",1));
                child_modelArrayList2.add(new child_model("Mobile App Devel",1));
                child_modelArrayList2.add(new child_model("Computer Graphics",1));
                child_modelArrayList2.add(new child_model("Cloud Computing",1));
                child_modelArrayList2.add(new child_model("Compiler Design",1));
                parent_modelArrayList.add(new parent_model("Sixth Sem",child_modelArrayList2));
            }
            else if (branch==2)
            {
                child_modelArrayList.add(new child_model("Visual Prog. using VB.Net",1));
                child_modelArrayList.add(new child_model("Machine Desigen-2",1));
                child_modelArrayList.add(new child_model("Dynamics of Machines",1));
                child_modelArrayList.add(new child_model("Heat & Mass Transfer",1));
                child_modelArrayList.add(new child_model("Industrial Meta.. & Materials",3));
                child_modelArrayList.add(new child_model("Industrial Engineering",1));
                parent_modelArrayList.add(new parent_model("Fifth Sem",child_modelArrayList));
                child_modelArrayList2.add(new child_model(" Computer  Aided Design",1));
                child_modelArrayList2.add(new child_model("Machine Science",1));
                child_modelArrayList2.add(new child_model("Refrigeration & Air C",1));
                child_modelArrayList2.add(new child_model("Mechanical Vibrations",1));
                parent_modelArrayList.add(new parent_model("Sixth Sem",child_modelArrayList2));
            }
            else if (branch==3)
            {
                child_modelArrayList.add(new child_model("Analog Comm Sys",1));
                child_modelArrayList.add(new child_model("Micro  Processor & Appl",1));
                child_modelArrayList.add(new child_model("Digital System Design",1));
                child_modelArrayList.add(new child_model("Linear Integ. Circuit & Appl",1));
                child_modelArrayList.add(new child_model("Control Engineering",1));
                parent_modelArrayList.add(new parent_model("Fifth Sem",child_modelArrayList));
                child_modelArrayList2.add(new child_model("Digital Signal Processing",1));
                child_modelArrayList2.add(new child_model("Digital Comm System",1));
                child_modelArrayList2.add(new child_model("Micro electronics",1));
                child_modelArrayList2.add(new child_model("Radar and Satellite Comm",1));
                parent_modelArrayList.add(new parent_model("Sixth Sem",child_modelArrayList2));
            }
            else if (branch==4)
            {
                child_modelArrayList.add(new child_model("Analog & Dig Comm Sys",1));
                child_modelArrayList.add(new child_model("Micro  Processor & Appl",1));
                child_modelArrayList.add(new child_model("Web Prog & Scripting",1));
                child_modelArrayList.add(new child_model("Mobile App Development",1));
                child_modelArrayList.add(new child_model("Computer Networks",1));
                parent_modelArrayList.add(new parent_model("Fifth Sem",child_modelArrayList));
                child_modelArrayList2.add(new child_model("Digital Signal Processing",1));
                child_modelArrayList2.add(new child_model("AI & ML",1));
                child_modelArrayList2.add(new child_model("DBMS",1));
                child_modelArrayList2.add(new child_model("IOT and Application",1));
                parent_modelArrayList.add(new parent_model("Sixth Sem",child_modelArrayList2));
            }
            else if (branch==5)
            {
                child_modelArrayList.add(new child_model("Transportation Engg-2",1));
                child_modelArrayList.add(new child_model("Structure Analysis - 1",1));
                child_modelArrayList.add(new child_model("Water Supply Engineering",1));
                child_modelArrayList.add(new child_model("Estimation & Costing",1));
                child_modelArrayList.add(new child_model("Irrigation Engg-1",1));
                child_modelArrayList.add(new child_model("Steel Structure D-1",1));
                parent_modelArrayList.add(new parent_model("Fifth Sem",child_modelArrayList));
                child_modelArrayList2.add(new child_model("Geo Techonology -1",1));
                child_modelArrayList2.add(new child_model("Steel Structure Design -2",1));
                child_modelArrayList2.add(new child_model("Structure Analysis - 2",1));
                child_modelArrayList2.add(new child_model("Concrete Structure Desigen -1",3));
                parent_modelArrayList.add(new parent_model("Sixth Sem",child_modelArrayList2));
            }
        }
        else if(year==4)
        {
            if(branch==1)
            {
                child_modelArrayList.add(new child_model("System Simulation & Modeling",1));
                child_modelArrayList.add(new child_model("Computer Crime Inv & Fore",1));
                child_modelArrayList.add(new child_model("Data Mining & Warehousing",1));
                parent_modelArrayList.add(new parent_model("Seventh Sem",child_modelArrayList));
                child_modelArrayList2.add(new child_model("*Project Based Industrial Training (One semester training in industry)",10));
                parent_modelArrayList.add(new parent_model("Eighth Sem",child_modelArrayList2));
            }
            else if(branch==2)
            {
                child_modelArrayList.add(new child_model("Computer Integrated MS",1));
                child_modelArrayList.add(new child_model("Automobile Engineering",1));
                child_modelArrayList.add(new child_model("  Fluid   Machines",1));
                child_modelArrayList.add(new child_model("I.C. Engines",1));
                parent_modelArrayList.add(new parent_model("Seventh Sem",child_modelArrayList));
                child_modelArrayList2.add(new child_model("*Project Based Industrial Training (One semester training in industry)",10));
                parent_modelArrayList.add(new parent_model("Eighth Sem",child_modelArrayList2));

            }
            else if (branch==3)
            {
                child_modelArrayList.add(new child_model("Microwave Engineering",1));
                child_modelArrayList.add(new child_model("Wireless & Mobile Comm",1));
                child_modelArrayList.add(new child_model("Cryptography & Network St",1));
                child_modelArrayList.add(new child_model("Optical Fiber Comm",1));
                parent_modelArrayList.add(new parent_model("Seventh Sem",child_modelArrayList));
                child_modelArrayList2.add(new child_model("*Project Based Industrial Training (One semester training in industry)",10));
                parent_modelArrayList.add(new parent_model("Eighth Sem",child_modelArrayList2));
            }
            else if (branch==4)
            {
                child_modelArrayList.add(new child_model("Big Data & Cloud Comp",1));
                child_modelArrayList.add(new child_model("Wireless & Mobile Comm",1));
                child_modelArrayList.add(new child_model("Cryptography & Network St",1));
                child_modelArrayList.add(new child_model("Digital System Design",1));
                parent_modelArrayList.add(new parent_model("Seventh Sem",child_modelArrayList));
                child_modelArrayList2.add(new child_model("*Project Based Industrial Training (One semester training in industry)",10));
                parent_modelArrayList.add(new parent_model("Eighth Sem",child_modelArrayList2));
            }
            else if (branch==5)
            {
                child_modelArrayList.add(new child_model(" Numerical  Methods",1));
                child_modelArrayList.add(new child_model("Structure Analysis - 3",1));
                child_modelArrayList.add(new child_model("Concrete Structure Desigen -2",3));
                child_modelArrayList.add(new child_model("Geo Techonology -2",1));
                parent_modelArrayList.add(new parent_model("Seventh Sem",child_modelArrayList));
                child_modelArrayList2.add(new child_model("*Project Based Industrial Training (One semester training in industry)",10));
                parent_modelArrayList.add(new parent_model("Eighth Sem",child_modelArrayList2));
            }
        }

        parent1=new parent_adapter(parent_modelArrayList,this,branch,year,width);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(parent1);
        parent1.notifyDataSetChanged();
        //noinspection deprecation
        recyclerView.setLayoutFrozen(true);
    }
    public void year1()
    {
        child_modelArrayList.add(new child_model(" Applied   Physics",1));
        child_modelArrayList.add(new child_model(" Applied    Math-1",1));
        child_modelArrayList.add(new child_model("Applied Chemistry",1));
        child_modelArrayList.add(new child_model(" Basic    Electrical E",1));
        child_modelArrayList.add(new child_model("Communication Skills",1));
        child_modelArrayList.add(new child_model("Engenerring Graphics",1));
        parent_modelArrayList.add(new parent_model("First Sem",child_modelArrayList));
        child_modelArrayList2.add(new child_model(" Applied    Math-2",1));
        child_modelArrayList2.add(new child_model("Basic Electronics E",1));
        child_modelArrayList2.add(new child_model("Computer Programming",1));
        child_modelArrayList2.add(new child_model("Manufacturing Process",1));
        if(branch==2)
        {
            child_modelArrayList2.add(new child_model("Applied Mechanics",1));
        }
        else if(branch==3||branch==4)
        {
            child_modelArrayList2.add(new child_model("Python Programming",1));
        }
        else if(branch==5)
        {
            child_modelArrayList2.add(new child_model("Basic Concept  of Civil Eng",1));
        }
        parent_modelArrayList.add(new parent_model("Second Sem",child_modelArrayList2));
    }
    @Override
    protected void onStart()
    {
        IntentFilter filter= new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeLisetner,filter);
        super.onStart();
    }
    @Override
    protected void onStop() {
        unregisterReceiver(networkChangeLisetner);
        super.onStop();
    }
}