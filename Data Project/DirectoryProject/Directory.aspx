<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Directory.aspx.cs" Inherits="Directory" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            text-align: center;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div><h2 class="auto-style1">VSU Professor Directory</h2>
        </div>
        First Name:
        <asp:TextBox ID="txtFirstName" runat="server"></asp:TextBox>
&nbsp; 
        <br />
        <br />
        Last Name:
        <asp:TextBox ID="txtLastName" runat="server"></asp:TextBox>
        <br />
        <br />
        <asp:Button ID="btnSearch" runat="server" Text="Search Professor" OnClick="btnSearch_Click" />
        <br />
        <br />
        <asp:TextBox ID="txtSearchSummary" runat="server" Height="90px" Width="433px" TextMode="MultiLine"></asp:TextBox>
        <br />
        <br />
        First Name: <asp:TextBox ID="txtFirstName2" runat="server"></asp:TextBox>
&nbsp;<br />
        <br />
        Last Name:
        <asp:TextBox ID="txtLastName2" runat="server"></asp:TextBox>
&nbsp;<br />
        <br />
        Phone Number:
        <asp:TextBox ID="txtPhoneNum" runat="server"></asp:TextBox>
&nbsp;(Last 7 digits)<br />
        <br />
        <asp:Button ID="btnAdd" runat="server" Text="Add Professor" OnClick="btnAdd_Click" />
&nbsp;&nbsp;
        <asp:Button ID="btnRemove" runat="server" Text="Remove Professor" OnClick="btnRemove_Click" />
        <br />
        <br />
        <asp:TextBox ID="txtHashSummary" runat="server" Height="400px" Width="410px" TextMode="MultiLine"></asp:TextBox>
    </form>
</body>
</html>
