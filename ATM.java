import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class ATM{
    private HashMap <String, Double> accountMap;

    public ATM ()
    {
        accountMap = new HashMap <String, Double> ();
    }

    public void openAccount (String userId, double amount) throws Exception
    {
        if (accountMap.containsKey (userId))
        {
            throw new java.lang.Error ("An account with the email \"" + userId + "\" already exists.");
        }
        accountMap.put (userId, amount);
    }

    public void closeAccount (String userId) throws Exception
    {
        if (accountMap.get (userId) != 0)
        {
            throw new java.lang.Error ("Balance must be withdrawn prior to account closure.");
        }
        accountMap.remove (userId);
    }

    public double checkBalance (String userId) throws Exception
    {
        if (!accountMap.containsKey (userId))
        {
            throw new java.lang.Error ("No account found with this email.");
        }
        return accountMap.get (userId);
    }

    public double depositMoney (String userId, double amount) throws Exception
    {
        if (!accountMap.containsKey (userId))
        {
            throw new java.lang.Error ("You're broke AF.");
        }
        accountMap.put (userId, accountMap.get (userId) + amount);
        return amount;
    }

    public double withdrawMoney (String userId, double amount) throws Exception
    {
        if ((!accountMap.containsKey (userId)) || accountMap.get (userId) < amount)
        {
            throw new java.lang.Error ("You're broke AF.");
        }
        accountMap.put (userId, accountMap.get (userId) - amount);
        return amount;
    }

    public boolean transferMoney (String fromAccount, String toAccount, double amount)
    {
        if (!accountMap.containsKey (fromAccount) || !accountMap.containsKey (toAccount) || accountMap.get (fromAccount) < amount)
        {
            return false;
        }
        accountMap.put (fromAccount, accountMap.get (fromAccount) - amount);
        accountMap.put (toAccount, accountMap.get (toAccount) + amount);
        return true;
    }

    public void audit () throws IOException
    {
        FileWriter writer = new FileWriter("AccountAudit.txt",false);
        PrintWriter out = new PrintWriter(writer);
        for (String key : accountMap.keySet ())
        {
            out.println (key + ": " + accountMap.get (key));
        }
        writer.close ();
        out.close ();
    }
}