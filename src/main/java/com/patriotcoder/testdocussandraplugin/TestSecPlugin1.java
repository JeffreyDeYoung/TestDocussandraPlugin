package com.patriotcoder.testdocussandraplugin;

import com.pearson.docussandra.plugininterfaces.PermissionDeniedException;
import com.pearson.docussandra.plugininterfaces.SecurityPlugin;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * This is a test notifier plugin
 * @author https://github.com/JeffreyDeYoung
 */
public class TestSecPlugin1 extends SecurityPlugin
{

    public TestSecPlugin1()
    {
        //setup stuff would go here
    }

    /**
     * Perform your custom validations here.
     * @param headers
     * @param requestedPath
     * @param method
     * @throws PermissionDeniedException Throw this if the client/user shouldn't be able to perform this action.
     */
    @Override
    public void doValidate(HashMap<String, List<String>> headers, String requestedPath, HttpMethod method) throws PermissionDeniedException
    {
        System.out.println("Security plugin " + getPluginName() + " is in validate.");
        Set<String> headerNames = headers.keySet();
        for(String headerName : headerNames){
            System.out.println("Header: " + headerName + " has a value of: " + headers.get(headerName));
        }
        System.out.println("The path was: " + requestedPath);
        System.out.println("The method was: " + method.toString());
        System.setProperty("com.pearson.docussandra.testHeader_2.secondtest", headers.get("testHeader_2").get(0));//set the first header as a system prop so we can confirm this was called in a test
    }
    
    
    
    @Override
    public String getPluginName()
    {
        return "Test-Sec-Plugin2";
    }
}
