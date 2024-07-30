import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter extends JFrame {

    private JTextField amountField;
    private JComboBox<String> fromCurrency;
    private JComboBox<String> toCurrency;
    private JLabel resultLabel;

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(20, 20, 100, 25);
        add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(120, 20, 200, 25);
        add(amountField);

        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(20, 60, 100, 25);
        add(fromLabel);

        fromCurrency = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "INR"});
        fromCurrency.setBounds(120, 60, 200, 25);
        add(fromCurrency);

        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(20, 100, 100, 25);
        add(toLabel);

        toCurrency = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "INR"});
        toCurrency.setBounds(120, 100, 200, 25);
        add(toCurrency);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(120, 140, 100, 25);
        add(convertButton);

        resultLabel = new JLabel("Result: ");
        resultLabel.setBounds(20, 180, 300, 25);
        add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
        String amountText = amountField.getText();
        String from = (String) fromCurrency.getSelectedItem();
        String to = (String) toCurrency.getSelectedItem();

        if (amountText.isEmpty()) {
            resultLabel.setText("Please enter an amount.");
            return;
        }

        double amount = Double.parseDouble(amountText);

        try {
            double rate = getExchangeRate(from, to);
            double result = amount * rate;
            resultLabel.setText("Result: " + result);
        } catch (Exception e) {
            resultLabel.setText("Error: " + e.getMessage());
        }
    }

    private double getExchangeRate(String from, String to) throws Exception {
        
        String urlStr = "https://v6.exchangerate-api.com/v6/69be6438131f8aeb982e334b/latest/USD";
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        conn.disconnect();

        String response = content.toString();
        int start = response.indexOf(to) + 5;
        int end = response.indexOf(",", start);
        if (end == -1) {
            end = response.indexOf("}", start);
        }

        return Double.parseDouble(response.substring(start, end));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CurrencyConverter().setVisible(true);
            }
        });
    }
}
