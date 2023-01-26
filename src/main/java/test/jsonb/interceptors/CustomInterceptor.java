package test.jsonb.interceptors;


import org.hibernate.CallbackException;
import org.hibernate.Interceptor;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.jsonb.interceptors.entity.Information;

public class CustomInterceptor implements Interceptor {
    private static final Logger logger = LoggerFactory.getLogger(CustomInterceptor.class);

    @Override
    public boolean onSave(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        if (entity instanceof Information) {
            logger.debug(entity.toString());
        }
        return Interceptor.super.onSave(entity, id, state, propertyNames, types);
    }



}


