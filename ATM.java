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
}