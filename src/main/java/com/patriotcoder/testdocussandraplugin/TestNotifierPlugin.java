package com.patriotcoder.testdocussandraplugin;

import com.pearson.docussandra.domain.objects.Document;
import com.pearson.docussandra.plugininterfaces.NotifierPlugin;

/**
 * This is a test notifier plugin.
 * @author https://github.com/JeffreyDeYoung
 */
public class TestNotifierPlugin extends NotifierPlugin
{

    public TestNotifierPlugin()
    {
        //setup stuff would go here
    }

    @Override
    public void doNotify(MutateType type, Document document)
    {
        //test implementation
        System.out.println("Test plugin notified of mutation (" + type + ") for document: ");
        if(document != null){
            System.out.println(document.getObjectAsString());
        } else {
            System.out.println("null");
        }
    }

    @Override
    public String getPluginName()
    {
        return "Test-Notifier-Plugin";
    }
    
    
}
