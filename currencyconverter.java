import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class currencyconverter {
    public static void main(String[] args) {
        // --- Step 1: Define Exchange Rates ---
        // In a real app, you'd get these from an API. Here, we use USD as a base.
        Map<String, Double> exchangeRates = new HashMap<>();
        // Base currency
        exchangeRates.put("USD", 1.0); // United States Dollar

        // East African Currencies
        exchangeRates.put("KES", 130.0); // Kenyan Shilling
        exchangeRates.put("UGX", 3750.0); // Ugandan Shilling
        exchangeRates.put("TZS", 2580.0); // Tanzanian Shilling
        exchangeRates.put("RWF", 1300.0); // Rwandan Franc

        // Other World Currencies
        exchangeRates.put("CAD", 1.37); // Canadian Dollar
        exchangeRates.put("ZAR", 18.80); // South African Rand
        exchangeRates.put("GBP", 0.79); // British Pound
        exchangeRates.put("SAR", 3.75); // Saudi Arabian Riyal
        exchangeRates.put("CNY", 7.24); // Chinese Yuan
        exchangeRates.put("JPY", 157.0); // Japanese Yen
        exchangeRates.put("INR", 83.50); // Indian Rupee
        exchangeRates.put("AUD", 1.50); // Australian Dollar
        exchangeRates.put("NGN", 1480.0); // Nigerian Naira
        exchangeRates.put("GHS", 14.50); // Ghanaian Cedi
        exchangeRates.put("ZMW", 27.20); // Zambian Kwacha

        // --- Step 2: Set up the main window (JFrame) ---
        JFrame frame = new JFrame("Currency Converter");
        frame.setSize(400, 450); // Made the window taller to better fit all results
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.green); // A calmer color

        // Using a null layout requires manual positioning with setBounds
        frame.setLayout(null);

        // --- Step 3: Create and position the UI components ---

        // Amount to convert
        JLabel amountLabel = new JLabel("Amount (KES):");
        amountLabel.setBounds(20, 20, 100, 30);
        frame.add(amountLabel);

        JTextField amountField = new JTextField();
        amountField.setBounds(130, 20, 230, 30);
        frame.add(amountField);

        // Convert button
        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(130, 70, 100, 30);
        frame.add(convertButton);

        // Result display area for showing multiple conversions
        JTextArea resultArea = new JTextArea("Results will be shown here...");
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultArea.setEditable(false); // Make it read-only
        resultArea.setMargin(new Insets(5, 5, 5, 5)); // Add some padding inside the text area

        // Create a scroll pane to hold the text area
        // This ensures all results are visible, even if the list grows
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBounds(20, 120, 340, 270); // Made the results area much taller
        frame.add(scrollPane);

        // --- Step 4: Add the conversion logic to the button's action listener ---
        convertButton.addActionListener(e -> {
            try {
                // Get user input (which is always in KES)
                double amountInKes = Double.parseDouble(amountField.getText());
                double kesRate = exchangeRates.get("KES");

                // Use a StringBuilder to efficiently build the result string
                StringBuilder resultsText = new StringBuilder();
                resultsText.append(String.format("Conversions for %.2f KES:\n\n", amountInKes));

                // Iterate through all currencies to perform the conversion
                for (Map.Entry<String, Double> entry : exchangeRates.entrySet()) {
                    String targetCurrency = entry.getKey();
                    if (targetCurrency.equals("KES")) {
                        continue; // Skip converting KES to itself
                    }
                    double targetRate = entry.getValue();
                    double convertedAmount = amountInKes * (targetRate / kesRate);
                    resultsText.append(String.format("%-4s: %.2f\n", targetCurrency, convertedAmount));
                }

                // Display the final list of results in the text area
                resultArea.setText(resultsText.toString());

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid amount.", "Input Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }
}
