package app.action;

import com.intellij.ide.projectView.ProjectView;
import com.intellij.ide.projectView.impl.AbstractProjectViewPane;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;
import app.generator.GeneratorFacade;

import java.util.List;

public class GenerateAction extends AnAction
{
    private final GeneratorFacade generatorFacade;
    private final String entityPackage="entity";
    public GenerateAction()
    {
        generatorFacade=new GeneratorFacade();
    }
    public void actionPerformed(@NotNull AnActionEvent e)
    {
        String entityName=Messages.showInputDialog("Enter entity name","Generate",Messages.getQuestionIcon());
        if(entityName!=null&&entityName.length()>0)
        {
            try
            {
                String projectPath=e.getProject().getBasePath();
                AbstractProjectViewPane projectViewPane=ProjectView.getInstance(e.getProject()).getCurrentProjectViewPane();
                String basePackageName=projectViewPane.getSelectedPath().getLastPathComponent().toString();
                generatorFacade.generate(projectPath,basePackageName,entityPackage,List.of(entityName));
                Messages.showInfoMessage("Generated","Success");
            }
            catch(Exception ex)
            {
                Messages.showErrorDialog(ex.getMessage(),"Error");
            }
        }
    }
}
