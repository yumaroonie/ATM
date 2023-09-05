import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ATMTester {

    public static void main(String[] args) {
        ATM bank = new ATM();
        int workingFunctions = 0;

        try {
            bank.openAccount("user1@example.com", 1000);
            workingFunctions++;

            bank.openAccount("user2@example.com", 500);
            workingFunctions++;

            bank.depositMoney("user1@example.com", 200);
            workingFunctions++;

            bank.withdrawMoney("user2@example.com", 100);
            workingFunctions++;

            bank.transferMoney("user1@example.com", "user2@example.com", 150);
            workingFunctions++;

            System.out.println("Balance for user1@example.com: " + bank.checkBalance("user1@example.com")); // Should be
                                                                                                            // 1050.0
            workingFunctions++;

            System.out.println("Balance for user2@example.com: " + bank.checkBalance("user2@example.com")); // Should be
                                                                                                            // 550.0
            workingFunctions++;

            bank.openAccount("user101@aol.com", 42069);
            bank.openAccount("user102@aol.com", 2);
            bank.openAccount("user103@aol.com", 1010);
            bank.openAccount("user104@aol.com", 389);
            bank.openAccount("user105@aol.com", 2389);
            bank.withdrawMoney("user103@aol.com",bank.checkBalance("user103@aol.com"));
            bank.closeAccount("user103@aol.com");
            bank.transferMoney("user101@aol.com", "user102@aol.com", 69);

            bank.audit();
            workingFunctions++;

            System.out.println("Audit completed successfully.");
            verifyAuditFile("AccountAudit.txt", 6);

            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Valid Use Cases: " + workingFunctions);
        }

    }

    private static void verifyAuditFile(String fileName, int expectedEntries) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int entryCount = 0;
            while (reader.readLine() != null) {
                entryCount++;
            }
            if (entryCount == expectedEntries) {
                System.out.println("Audit file entries match expected count.");
            } else {
                System.out.println(
                        "Audit file entries" + entryCount + "do not match expected count" + expectedEntries + ".");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

