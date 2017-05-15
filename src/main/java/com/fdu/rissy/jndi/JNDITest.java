package com.fdu.rissy.jndi;

import javax.naming.*;
import java.util.Hashtable;


public class JNDITest {

    public static void main(String[] args) {

        Hashtable envMap = new Hashtable();

        envMap.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");

        envMap.put(Context.PROVIDER_URL, args[0]);

        try {
            Context context = new InitialContext(envMap);
            if (args.length == 1) {
                NamingEnumeration namingEnumeration = context.listBindings("");
                while (namingEnumeration.hasMore()) {
                    Binding binding = (Binding) namingEnumeration.next();
                    System.out.println(binding.getName()  + " " + binding.getObject());
                }
            } else {
                for (int i = 1; i < args.length; i++) {
                    Object object = context.lookup(args[1]);
                    System.out.println(args[1] + " " + object);
                }
            }
            context.close();
        } catch (NamingException namingException) {
            namingException.printStackTrace();
        }
    }
}
