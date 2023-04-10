package app.action;

import app.ui.View;
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
    private GeneratorFacade generatorFacade;
    private View view;
    public void actionPerformed(@NotNull AnActionEvent e)
    {
		if(generatorFacade==null)
			generatorFacade=new GeneratorFacade();
		if(view==null)
			view=new View();
        view.show();
        if(view.isOK())
        {
            try
            {
                String[] entityNames=view.getEntityNames().split(",");
                String entityPackage=view.getEntityPackage();
                String projectPath=e.getProject().getBasePath();
                AbstractProjectViewPane projectViewPane=ProjectView.getInstance(e.getProject()).getCurrentProjectViewPane();
                String basePackageName=projectViewPane.getSelectedPath().getLastPathComponent().toString();
                generatorFacade.generate(projectPath,basePackageName,entityPackage,List.of(entityNames));
                Messages.showInfoMessage("Generated","Success");
            }
            catch(Exception ex)
            {
                Messages.showErrorDialog(ex.getMessage(),"Error");
            }
        }
    }
}
