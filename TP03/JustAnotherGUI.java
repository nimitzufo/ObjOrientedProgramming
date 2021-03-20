import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JustAnotherGUI extends JPanel implements ActionListener {

	JTextArea topTextArea;
    JTextArea bottomTextArea;
    JButton button1, button2;
    final static String newline = "\n";

    
    public JustAnotherGUI() {
        super(new GridBagLayout());
        GridBagLayout gridbag = (GridBagLayout)getLayout();
        GridBagConstraints c = new GridBagConstraints();

        JLabel l = null;

        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = GridBagConstraints.REMAINDER;
        l = new JLabel("Leia Fake News:");
        gridbag.setConstraints(l, c);
        add(l);

        c.weighty = 1.0;
        topTextArea = new JTextArea();
        topTextArea.setEditable(false);
        JScrollPane topScrollPane = new JScrollPane(topTextArea);
        Dimension preferredSize = new Dimension(800, 600);
        topScrollPane.setPreferredSize(preferredSize);
        gridbag.setConstraints(topScrollPane, c);
        add(topScrollPane);

        c.weightx = 0.0;
        c.weighty = 0.0;
        l = new JLabel("Salvar Fake News:");
        gridbag.setConstraints(l, c);
        add(l);

        c.weighty = 1.0;
        bottomTextArea = new JTextArea();
        bottomTextArea.setLineWrap(true);
        JScrollPane bottomScrollPane = new JScrollPane(bottomTextArea);
        bottomScrollPane.setPreferredSize(preferredSize);
        gridbag.setConstraints(bottomScrollPane, c);
        add(bottomScrollPane);

        c.weightx = 1.0;
        c.weighty = 0.0;
        c.gridwidth = 1;
        c.insets = new Insets(10, 10, 0, 10);
        button1 = new JButton("Ler Fake News");
        gridbag.setConstraints(button1, c);
        add(button1);

        c.gridwidth = GridBagConstraints.REMAINDER;
        button2 = new JButton("Escrever Fake News");
        gridbag.setConstraints(button2, c);
        add(button2);

        button1.addActionListener(this);

        button2.addActionListener(new WriteFakeNews(bottomTextArea));

        setPreferredSize(new Dimension(450, 450));
        setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createMatteBorder(
                                                1,1,2,2,Color.black),
                                BorderFactory.createEmptyBorder(5,5,5,5)));
    }

    
    public void actionPerformed(ActionEvent e) {
		Random randomInt = new Random();
		ArrayList<String> fakeNewsToRead = News.fakeNews();
		int randomNews = randomInt.nextInt(fakeNewsToRead.size());
		String news = fakeNewsToRead.get(randomNews);
		
        topTextArea.append(news + newline + newline);
        topTextArea.setCaretPosition(topTextArea.getDocument().getLength());
    }

    
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Fake News ReaderI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new JustAnotherGUI();
        newContentPane.setOpaque(true); 
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
	
	
	public static void main(String[] args) {
		createAndShowGUI();

	}

}

class WriteFakeNews implements ActionListener {
    JTextArea myTextArea;
    public WriteFakeNews(JTextArea ta) {
        myTextArea = ta;
    }

    public void actionPerformed(ActionEvent e) {
    	ArrayList<String> fakeNewsToRead = News.fakeNews();
    	String contents = myTextArea.getText();
    	fakeNewsToRead.add(contents);
        myTextArea.append("\nFake News copiada! Você já pode compartilhar no zap! \n" + contents);
 
        
        myTextArea.setCaretPosition(myTextArea.getDocument().getLength());
    }
}
