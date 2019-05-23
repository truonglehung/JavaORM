package com.kevintruong.hibernatecfgexample.utils;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
  
    public static SessionFactory getSessionFactory() {
    	
    	if(sessionFactory==null) {
    		try {
    			registry  = new StandardServiceRegistryBuilder().configure().build();
    			MetadataSources metadatasource = new MetadataSources(registry);
    			Metadata metadata = metadatasource.getMetadataBuilder().build();
    			sessionFactory = metadata.getSessionFactoryBuilder().build();
    			
    		}catch(Exception ex) {
    			ex.printStackTrace();
    			if(registry!=null) {
    				StandardServiceRegistryBuilder.destroy(registry);
    			}
    		}
    	}
    	
    	return sessionFactory;
    }
    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
