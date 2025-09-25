import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class calculator {
    public static void main(String[] args) {
        // Create the main frame (window)
        JFrame frame = new JFrame("Simple Calculator");
        frame.setSize(500, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.red); // Changed to a less jarring color

        // Using a null layout requires manual positioning with setBounds
        frame.setLayout(null);

        // First Number Label and Text Field
        JLabel firstnumberlabel = new JLabel();
        firstnumberlabel.setText("First number:");
        firstnumberlabel.setBounds(20, 20, 100, 30);
        frame.add(firstnumberlabel);

        JTextField firstnumberfield = new JTextField();
        firstnumberfield.setText("");
        firstnumberfield.setBounds(130, 20, 150, 30);
        frame.add(firstnumberfield);

        // Second Number Label and Text Field
        JLabel secondnumberlabel = new JLabel();
        secondnumberlabel.setText("Second number:");
        secondnumberlabel.setBounds(20, 60, 100, 30);
        frame.add(secondnumberlabel);

        JTextField secondnumberfield = new JTextField();
        secondnumberfield.setText("");
        secondnumberfield.setBounds(130, 60, 150, 30);
        frame.add(secondnumberfield);

        // Label to display the result
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(20, 100, 200, 30);
        resultLabel.setFont(new Font("Serif", Font.BOLD, 16));
        frame.add(resultLabel);

        // --- Button Panel with Grid Layout ---
        // Create a panel to hold the buttons in a grid
        JPanel buttonPanel = new JPanel();
        // Use a GridLayout: 2 rows, 4 columns, with 5px horizontal and vertical gaps
        buttonPanel.setLayout(new GridLayout(2, 2, 5, 5));
        // Position this panel on the main frame
        buttonPanel.setBounds(20, 140, 445, 70);
        buttonPanel.setBackground(frame.getContentPane().getBackground()); // Match frame color

        // Create the buttons
        JButton addButton = new JButton("Add");
        JButton subtractButton = new JButton("Subtract");
        JButton multiplyButton = new JButton("Multiply");
        JButton logButton = new JButton("log");
        JButton cosButton = new JButton("cos");
        JButton sinButton = new JButton("sin");
        JButton tanButton = new JButton("tan");
        JButton squareButton = new JButton("Square");
        JButton squareRootButton = new JButton("Square Root");
        JButton cubeButton = new JButton("Cube");
        JButton cubeRootButton = new JButton("Cube Root");
        JButton factorialButton = new JButton("Factorial");
        JButton clearButton = new JButton("Clear");

        // Add buttons to the panel. They will be arranged automatically by the
        // GridLayout.
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(logButton);
        buttonPanel.add(cosButton);
        buttonPanel.add(sinButton);
        buttonPanel.add(tanButton);
        buttonPanel.add(squareButton);
        buttonPanel.add(squareRootButton);
        buttonPanel.add(cubeButton);
        buttonPanel.add(cubeRootButton);
        buttonPanel.add(factorialButton);
        buttonPanel.add(clearButton);

        // Add the entire button panel to the frame
        frame.add(buttonPanel);

        // Add action listeners to the buttons using a lambda expression
        ActionListener calculationListener = e -> {
            try {
                double result = 0.0;
                Object source = e.getSource();

                // For binary operations (add, subtract, multiply), we need two numbers.
                if (source == addButton || source == subtractButton || source == multiplyButton) {
                    double num1 = Double.parseDouble(firstnumberfield.getText());
                    double num2 = Double.parseDouble(secondnumberfield.getText());

                    result = num1 + num2;
                    if (source == subtractButton) {
                        result = num1 - num2;
                    } else if (source == multiplyButton) {
                        result = num1 * num2;
                    }
                }
                // For unary scientific operations, we only need the first number.
                else {
                    double num1 = Double.parseDouble(firstnumberfield.getText());
                    if (source == logButton) {
                        // Math.log10 is for base-10 log, which is standard for a "log" button.
                        result = Math.log10(num1);
                    } else {
                        // Trig functions in Java's Math class expect radians, so we convert from
                        // degrees.
                        double num1InRadians = Math.toRadians(num1);
                        if (source == cosButton)
                            result = Math.cos(num1InRadians);
                        else if (source == sinButton)
                            result = Math.sin(num1InRadians);
                        else if (source == tanButton)
                            result = Math.tan(num1InRadians);
                    }
                }
                // For the rest of the buttons, we only need the first number.
                if (source == squareButton) {
                    double num1 = Double.parseDouble(firstnumberfield.getText());
                    result = num1 * num1;
                } else if (source == squareRootButton) {
                    double num1 = Double.parseDouble(firstnumberfield.getText());
                    result = Math.sqrt(num1);
                } else if (source == cubeButton) {
                    double num1 = Double.parseDouble(firstnumberfield.getText());
                    result = num1 * num1 * num1;
                } else if (source == cubeRootButton) {
                    double num1 = Double.parseDouble(firstnumberfield.getText());
                    result = Math.cbrt(num1);
                } else if (source == factorialButton) {
                    int num1 = Integer.parseInt(firstnumberfield.getText());
                    result = 1;
                    for (int i = 1; i <= num1; i++) {
                        result *= i;
                    }
                } else if (source == clearButton) {
                    firstnumberfield.setText("");
                    secondnumberfield.setText("");
                    resultLabel.setText("Result:");
                    return;
                }

                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numbers.", "Input Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        };

        addButton.addActionListener(calculationListener);
        subtractButton.addActionListener(calculationListener);
        multiplyButton.addActionListener(calculationListener);
        logButton.addActionListener(calculationListener);
        cosButton.addActionListener(calculationListener);
        sinButton.addActionListener(calculationListener);
        tanButton.addActionListener(calculationListener);
        squareButton.addActionListener(calculationListener);
        squareRootButton.addActionListener(calculationListener);
        cubeButton.addActionListener(calculationListener);
        cubeRootButton.addActionListener(calculationListener);
        factorialButton.addActionListener(calculationListener);
        clearButton.addActionListener(calculationListener);

        // Add the result label to the frame
        frame.add(resultLabel);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}