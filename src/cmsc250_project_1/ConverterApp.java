/*
 * JASON HOWARTH
 * UMGC CMSC 250-6382 PROJECT 1
 * 25 JAN 2022
 * CLASS DESCRIPTION:  USER INTERFACE FOR INPUTTING EXPRESSIONS
 */
package cmsc250_project_1;

//IMPORT
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConverterApp extends JFrame {

    private JTextField input = new JTextField(20), output = new JTextField(20);
    private final JButton preToPost = new JButton("Prefix to Postfix");
    private final JButton post_pre = new JButton("Postfix to Prefix");
    private ExpressionConverter expressionConverter = new ExpressionConverter();

    //PREFIX TO POSTFIX LISTENER
    private final ActionListener preToPostConvert = event -> {
        try {
            String value = expressionConverter.preToPost(input.getText());
            output.setText("" + value);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Expression", "Error", JOptionPane.ERROR_MESSAGE);
        }
    };

    //POSTFIX TO PREFIX LISTENER
    private final ActionListener postToPreConvert = event -> {
        try {
            String value = expressionConverter.postToPre(input.getText());
            output.setText("" + value);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Expression", "Error", JOptionPane.ERROR_MESSAGE);
        }
    };

    public ConverterApp() {
        super("Expression Converter");
        setSize(450, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));
        JComponent[] inputComponents = {new JLabel("Enter Expression"), input};
        makeFlowPanel(inputComponents);
        JComponent[] buttonComponents = {preToPost, post_pre};
        makeFlowPanel(buttonComponents);
        JComponent[] outputComponents = {new JLabel("Result"), output};
        makeFlowPanel(outputComponents);
        output.setEditable(false);
        
        //LISTENERS
        preToPost.addActionListener(preToPostConvert);
        post_pre.addActionListener(postToPreConvert);
    }

    private void makeFlowPanel(JComponent[] components) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        for (Component component : components) {
            panel.add(component);
        }
        add(panel);
    }

    // MAIN
    public static void main(String[] args) {
        ConverterApp frame = new ConverterApp();
        frame.setVisible(true);
    }
}
