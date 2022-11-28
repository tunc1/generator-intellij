package app.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;
import app.generator.GeneratorFacade;

import java.io.IOException;
import java.util.List;

public class GenerateAction extends AnAction
{
    private GeneratorFacade generatorFacade;
    private final String basePackageName="app";
    private final String entityPackage="entity";
    public GenerateAction()
    {
        generatorFacade=new GeneratorFacade();
    }
    public void actionPerformed(@NotNull AnActionEvent e)
    {
        String entityName=Messages.showInputDialog("Enter entity name","Generator",Messages.getQuestionIcon());
        if(entityName!=null&&entityName.length()>0)
        {
            String projectPath=e.getProject().getBasePath();
            try
            {
                generatorFacade.generate(projectPath,basePackageName,entityPackage,List.of(entityName));
                Messages.showInfoMessage("Generated","Success");
            }
            catch(IOException ex)
            {
                Messages.showErrorDialog(ex.getMessage(),"Error");
            }
        }
    }
}
