using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Web;

/// <summary>
/// Summary description for HashTable
/// </summary>
public class HashTable
{
    public int maxTableSize;
    public int currentSize;
    public HashEntry[] hashTable;
    public int primeSize;
    public HashTable(int maxTableSize)
    {
        currentSize = 0;
        this.maxTableSize = maxTableSize;
        hashTable = new HashEntry[this.maxTableSize];

        for(int i = 0; i < this.maxTableSize; i++)
            hashTable[i] = null;

        primeSize = getPrime();
    }
    public int getPrime()
    {
        for(int i = maxTableSize - 1; i >= 1; i--)
        {
            int factor = 0;
            for (int j = 2; j < (int)Math.Sqrt(i); j++)

                if (i % j == 0)
                    factor++;

            if (factor == 0)
                return i;
        }
        return 3;
    }
    public int get(String key)
    {
        int hash1 = firstHashFunction(key);
        int hash2 = secondHashFunction(key);
        while (hashTable[hash1] != null && !hashTable[hash1].getKey().Equals(key))
        {
            hash1 += hash2;
            hash1 %= maxTableSize;
        }
        return hashTable[hash1].getValue();
    }
    public void insert(String key, int value)
    {
        if(currentSize == maxTableSize)
        {
            String msg = "Table full";
            Console.WriteLine(msg);
        }
        int hash1 = firstHashFunction(key);
        int hash2 = secondHashFunction(key);

        while(hashTable[hash1] != null)
        {
            hash1 += hash2;
            hash1 %= maxTableSize;
        }

        hashTable[hash1] = new HashEntry(key, value);
        currentSize++;
    }
    public void remove(String key)
    {
        int hash1 = firstHashFunction(key);
        int hash2 = secondHashFunction(key);

        while(hashTable[hash1] != null && !hashTable[hash1].getKey().Equals(key))
        {
            hash1 += hash2;
            hash1 %= maxTableSize;
        }
        hashTable[hash1] = null;
        currentSize--;
    }
    public int firstHashFunction(String x)
    {
        int hashValue = x.GetHashCode();
        hashValue %= maxTableSize;

        if(hashValue < 0)
        {
            hashValue += maxTableSize;
        }
        return hashValue;
    }
    public int secondHashFunction(String y)
    {
        int hashValue = y.GetHashCode();
        hashValue %= maxTableSize;
        if (hashValue < 0)
            hashValue += maxTableSize;

        return primeSize - hashValue % primeSize;
    }
    public string printHashTable()
    {
        StringBuilder hashSummary = new StringBuilder();

        for(int i = 0; i < maxTableSize; i++)
        {
            if(hashTable[i] != null)
            {
                hashSummary.Append(String.Format("{0, -25} {1, -18} {2, -8} ", hashTable[i].getKey(), "229-" + hashTable[i].getValue().ToString("###-####"), i));
                hashSummary.Append(Environment.NewLine);
            }
        }
        return hashSummary.ToString();
    }
}