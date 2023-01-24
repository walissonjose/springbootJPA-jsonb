package test.jsonb.interceptors;


import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.jsonb.interceptors.entity.User;

import java.io.Serializable;

public class CustomInterceptor extends EmptyInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(CustomInterceptor.class);

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if(entity instanceof User) {
            logger.debug(entity.toString());
        }
        return super.onSave(entity, id, state, propertyNames, types);
    }
}
