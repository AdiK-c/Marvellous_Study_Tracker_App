import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.*;

class StudyLog
{
    private LocalDate Date;
    private String Subject;
    private double Duration;
    private String Description;

    public StudyLog(LocalDate a,String b,double c,String d)
    {
        this.Date=a;
        this.Subject=b;
        this.Duration=c;
        this.Description=d;
    }

    public LocalDate getDate()
    {
        return this.Date;
    }

    public String getSubject()
    {
        return this.Subject;
    }

    public double getDuration()
    {
        return this.Duration;
    }

    public String getDescription()
    {
        return this.Description;
    }


    @Override
    public String toString()
    {
        return Date+" | "+Subject+" | "+Duration+" | "+Description;
    }
}

class StudyTracker
{
    public ArrayList<StudyLog>Database=new ArrayList<StudyLog>();

    public void InsertLog()
    {
        Scanner sobj=new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("------------------------------------Enter Valid Details Of Your Study-----------------------------------");
        System.out.println("--------------------------------------------------------------------------------------------------------");

        LocalDate Dataobj=LocalDate.now();

        System.out.println("Please Enter the Name of Subject Like C/C++/Java?Python");
        String sub=sobj.nextLine();

        System.out.println("Enter the Time Period of Your Study in Hrs");
        Double dobj=sobj.nextDouble();
        sobj.nextLine();

        System.out.println("Please Provide the Description of the study");
        String des=sobj.nextLine();

        StudyLog studyobj =new StudyLog(Dataobj, sub, dobj, des);
        Database.add(studyobj);

        System.out.println("Study Logs Gets Stored Successfully");
        System.out.println("--------------------------------------------------------------------------------------------------------");

    }

    public void DisplayLog()
    {
        
        System.out.println("--------------------------------------------------------------------------------------------------------");
        if(Database.isEmpty())
        {
            System.out.println("-------------------------------------------Nothing to Display-------------------------------------------");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            return;
        }
        System.out.println("---------------------------------Log Report of Marvellous Study Tracker---------------------------------");
        System.out.println("--------------------------------------------------------------------------------------------------------");

        for(StudyLog s: Database)
        {
            System.out.println(s);
        }
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }

    public void ExportCsv()
    {
        if(Database.isEmpty())
        {
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------Nothing to Display-------------------------------------------");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            return;
        }

        String filename="MarvellousStudyTracker.csv";

        try(FileWriter fwobj = new FileWriter(filename))
        {
            fwobj.write("Date,Subject,Duration,Description\n");

            for(StudyLog s:Database)
            {
                fwobj.write(s.getDate()+","+
                            s.getSubject().replace(","," ")+","+
                            s.getDuration()+","+
                            s.getDescription().replace(","," ")+"\n");
            }

            System.out.println("Data get Exported in CSV :"+filename);
        }
        catch(Exception eobj)
        {
            System.out.println("Exception Occured While CSV Handling");
        }
    }

    public void SummarybySubject()
    {
        System.out.println("--------------------------------------------------------------------------------------------------------");

        if(Database.isEmpty())
        {
            System.out.println("-------------------------------------------Nothing to Display-------------------------------------------");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            return;
        }

        System.out.println("----------------------------------Summary  by Subject from Study Tracker---------------------------------");
        System.out.println("--------------------------------------------------------------------------------------------------------");

        TreeMap<String, Double> tobj = new TreeMap<String, Double>();

        String s = null;
        double d = 0.0, old = 0.0;

        for(StudyLog sobj : Database)
        {
            s = sobj.getSubject();
            d = sobj.getDuration();

            if(tobj.containsKey(s))
            {
                old = tobj.get(s);
                tobj.put(s, d + old);
            }
            else
            {
                tobj.put(s, d);
            }
        }

        // Display Summary
        for(String str : tobj.keySet())
        {
            System.out.println("Subject : " + str + "  Total Study Duration : " + tobj.get(str) + " Hrs");
        }

        System.out.println("--------------------------------------------------------------------------------------------------------");
}

    public void SummarybyDate()
    {
        System.out.println("--------------------------------------------------------------------------------------------------------");

        if(Database.isEmpty())
        {
            System.out.println("-------------------------------------------Nothing to Display-------------------------------------------");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            return;
        }

        System.out.println("----------------------------------Summary by Date from Study Tracker---------------------------------");
        System.out.println("--------------------------------------------------------------------------------------------------------");

        TreeMap<LocalDate, Double> tobj = new TreeMap<LocalDate, Double>();

        LocalDate lobj = null;
        double d = 0.0, old = 0.0;

        for(StudyLog sobj : Database)
        {
            lobj = sobj.getDate();
            d = sobj.getDuration();

            if(tobj.containsKey(lobj))
            {
                old = tobj.get(lobj);
                tobj.put(lobj, d + old);
            }
            else
            {
                tobj.put(lobj, d);
            }
        }

        // Display Summary
        for(LocalDate l : tobj.keySet())
        {
            System.out.println("Date : " + l + "  Total Study Duration : " + tobj.get(l) + " Hrs");
        }

        System.out.println("--------------------------------------------------------------------------------------------------------");
    }    
}
class MarvellousStudyTracker
{
    public static void main(String A[]) 
    {
        Scanner sobj = new Scanner(System.in);

        StudyTracker stobj = new StudyTracker();

        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------Welcome to Marvellous Study Tracker----------------------------------");
        System.out.println("--------------------------------------------------------------------------------------------------------");

        int iChoice = 0;

        do
        {
            System.out.println("\nPlease Select Appropriate Option");
            System.out.println("1 : Insert new Study Log");
            System.out.println("2 : View all Study Logs");
            System.out.println("3 : Export Study Logs to CSV File");
            System.out.println("4 : Summary of Study Log by Date");
            System.out.println("5 : Summary of Study Log by Subject");
            System.out.println("6 : Exit the Application");

            iChoice = sobj.nextInt();

            switch(iChoice)
            {
                case 1:
                    stobj.InsertLog();
                    break;

                case 2:
                    stobj.DisplayLog();
                    break;

                case 3:
                    stobj.ExportCsv();
                    break;

                case 4:
                    stobj.SummarybyDate();
                    break;

                case 5:
                    stobj.SummarybySubject();
                    break;

                case 6:
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    System.out.println("------------------------------Thank you for using Marvellous Study Tracker------------------------------");
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    break;

                default:
                    System.out.println("Invalid Choice... Please Entry valid Choice");
                    break;
            }

        }while(iChoice != 6); //end of do while
    } //end of main
}// end od starter class
