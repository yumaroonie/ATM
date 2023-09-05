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
}