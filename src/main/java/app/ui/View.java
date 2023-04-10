package app.ui;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class View extends DialogWrapper
{
    private JTextField entityPackageTextField,entityNamesTextField;
    public View()
    {
        super(true);
        setTitle("Generator");
        init();
		setSize(400,250);
    }
    protected @Nullable JComponent createCenterPanel()
    {
        JPanel dialogPanel = new JPanel(null);

        JLabel entityPackageLabel=new JLabel("Entity Package Name:");
        entityPackageLabel.setBounds(10,10,400,25);
        dialogPanel.add(entityPackageLabel);

        entityPackageTextField=new JTextField("entity");
        entityPackageTextField.setBounds(10,40,400,25);
        dialogPanel.add(entityPackageTextField);

        JLabel entityLabel=new JLabel("Entity Names:");
        entityLabel.setBounds(10,70,400,25);
        dialogPanel.add(entityLabel);

        entityNamesTextField=new JTextField("Book,Author");
        entityNamesTextField.setBounds(10,100,400,25);
        dialogPanel.add(entityNamesTextField);

        return dialogPanel;
    }
    public String getEntityNames()
    {
        return entityNamesTextField.getText();
    }
    public String getEntityPackage()
    {
        return entityPackageTextField.getText();
    }
}