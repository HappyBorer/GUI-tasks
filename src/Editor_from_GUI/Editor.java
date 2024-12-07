package Editor_from_GUI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Editor extends JFrame {
    private JButton openTheFileButton;
    private JButton saveButton;
    private JButton saveAsButton;
    private JTextArea textArea1;
    private JScrollPane scroll;
    private JPanel panel;
    private JLabel theFileIsOpenLabel;
    private JLabel defaultTxtLabel;
    private JFileChooser chooser;
    private File file;

    Editor() {
        this.getContentPane().add(panel);
        chooser = new JFileChooser("D:\\save", FileSystemView.getFileSystemView());
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Only .txt files", "txt");
        chooser.addChoosableFileFilter(filter);
        openTheFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = chooser.showOpenDialog(Editor.this);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    file = chooser.getSelectedFile();
                    defaultTxtLabel.setText(file.getName());
                    textArea1.setText("");
                    try(BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))){
                        String str;
                        while((str = br.readLine()) != null){
                            textArea1.append(str + "\n");
                        }
                    }catch(IOException ex){
                        ex.printStackTrace();
                    }
                }
            }
        });

        saveAsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = chooser.showSaveDialog(Editor.this);
                if(choice == JFileChooser.APPROVE_OPTION){
                    defaultTxtLabel.setText(chooser.getSelectedFile().getName());
                    file = new File(chooser.getSelectedFile().getAbsolutePath());
                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()))) {
                        bw.write(textArea1.getText());
                        bw.flush();
                    }catch(IOException ex){
                        ex.printStackTrace();
                    }
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(file == null){
                    file = new File("D:\\save\\default.txt");
                }
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()))) {
                    bw.write(textArea1.getText());
                    bw.flush();
                }catch(IOException ex){
                    ex.printStackTrace();
                }

            }
        });
    }
}
