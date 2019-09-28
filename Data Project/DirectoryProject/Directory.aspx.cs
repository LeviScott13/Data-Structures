using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Directory : System.Web.UI.Page
{
    HashTable hashTable = new HashTable(1000);

    protected void Page_Load(object sender, EventArgs e)
    {
        if (!Page.IsPostBack)
        {
            displayProfessors();
        }
    }
    public void displayProfessors()
    {
        readFile();

        StringBuilder buildProfessor = new StringBuilder("");
        String header = String.Format("{0, -25} {1, -16} {2, -8} ", "Name", "Phone Number", "Index") + Environment.NewLine;
        buildProfessor.Append("------------------------  -------------    -------");
        buildProfessor.Append(Environment.NewLine);

        txtHashSummary.Text = header + buildProfessor.ToString() + hashTable.printHashTable();
    }
    public void readFile()
    {
        StreamReader file = new StreamReader(Server.MapPath("~/DirectoryProject/TeacherList.txt"));
        try
        {
            String line = file.ReadLine();
            String key = file.ReadLine();
            int value = Convert.ToInt32(key);

            while (line != null)
            {
                hashTable.insert(line, value);

                line = file.ReadLine();
                key = file.ReadLine();
                if (key == null)
                {
                    break;
                }
                value = Convert.ToInt32(key);
            }
            file.Close();
        }
        catch (IOException e)
        {
            txtSearchSummary.Text = e.Message;
            txtHashSummary.Text = e.Message;
        }
        catch (FormatException e)
        {
            txtHashSummary.Text = e.Message;
        }
    }
    protected void btnSearch_Click(object sender, EventArgs e)
    {
        StreamReader readFile = new StreamReader(Server.MapPath("~/DirectoryProject/TeacherList.txt"));

        String names = txtFirstName.Text + " " + txtLastName.Text;

        StringBuilder buildProfessor = new StringBuilder("");
        String header = String.Format("{0, -23} {1, -16} ", "Name", "Phone Number") + Environment.NewLine;
        buildProfessor.Append("---------------------   -------------");
        buildProfessor.Append(Environment.NewLine);

        try
        {
            String line = readFile.ReadLine();
            String key = readFile.ReadLine();

            while (line != null)
            {
                if(line == names)
                {
                    int value = Convert.ToInt32(key);

                    buildProfessor.Append(names + " ");
                    buildProfessor.Append("\t\t229-" + value.ToString("###-####"));
                    txtSearchSummary.Text = header + buildProfessor.ToString();
                }
                line = readFile.ReadLine();
                key = readFile.ReadLine();
            }
            readFile.Close();

        }
        catch (IOException e2)
        {
            txtSearchSummary.Text = e2.Message;
        }
        catch (FormatException e2)
        {
            txtSearchSummary.Text = e2.Message;
        }
    }
    protected void btnAdd_Click(object sender, EventArgs e)
    {
        String names = txtFirstName2.Text + " " + txtLastName2.Text;
        String phone = txtPhoneNum.Text;
        int phoneNumb = Convert.ToInt32(phone);
        hashTable.insert(names, Convert.ToInt32(phoneNumb));

        try
        {
            using (StreamWriter tw = new StreamWriter("C:\\Users\\Levi\\Documents\\Data Project\\DirectoryProject\\TeacherList.txt", true))
            {
                tw.WriteLine(names);
                tw.WriteLine(phone);
                tw.Close();
            }
        }
        catch(Exception e2)
        {
            txtHashSummary.Text = e2.Message;
        }
        displayProfessors();
        Response.Redirect("Directory.aspx");
    }

    protected void btnRemove_Click(object sender, EventArgs e)
    {
        StreamReader ourread = new StreamReader(Server.MapPath("~/DirectoryProject/TeacherList.txt"));
        string tempFile = Path.GetTempFileName();
        var temp = new StreamWriter(tempFile);

        String names = txtFirstName2.Text + " " + txtLastName2.Text;

        try
        {
            String line = ourread.ReadLine();
            String number = ourread.ReadLine();

            while (line != null)
            {
                hashTable.remove(line);

                if (line != names)
                {
                    temp.WriteLine(line);
                    temp.WriteLine(number);
                }
                line = ourread.ReadLine();
                number = ourread.ReadLine();
            }
            ourread.Close();
            temp.Close();

        }
        catch (IOException e2)
        {
            txtSearchSummary.Text = e2.Message;
        }
        catch (FormatException e2)
        {
            txtSearchSummary.Text = e2.Message;
        }
        File.Delete(Server.MapPath("~/DirectoryProject/TeacherList.txt"));
        File.Move(tempFile, Server.MapPath("~/DirectoryProject/TeacherList.txt"));

        displayProfessors();
        Response.Redirect("Directory.aspx");
    }
}