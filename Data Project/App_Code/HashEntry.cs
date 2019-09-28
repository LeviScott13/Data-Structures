using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for HashEntry
/// </summary>
public class HashEntry
{
    String key;
    int value;

    public HashEntry(String key, int value)
    {
        this.key = key;
        this.value = value;
    }
    public String getKey()
    {
        return key;
    }
    public int getValue()
    {
        return value;
    }
}