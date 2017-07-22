package com.ai.ge.util;

import org.apache.commons.beanutils.BeanPropertyValueEqualsPredicate;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

/**
 * 字段包含
 */
public class BeanPropertyValueLikePredicate extends BeanPropertyValueEqualsPredicate {

    private static final Logger logger = LoggerFactory.getLogger(BeanPropertyValueLikePredicate.class);

    private boolean contain;

    public BeanPropertyValueLikePredicate(String propertyName, Object propertyValue, boolean contain) {
        super(propertyName, propertyValue);
        this.contain = contain;
    }

    @Override
    public boolean evaluate(Object object) {
        try {
            Object propertyName = PropertyUtils.getProperty(object, getPropertyName());
            if (null == propertyName || null == getPropertyValue()) {
                return false;
            }
            String propNameVal = propertyName.toString();
            String propVal = getPropertyValue().toString();
            if (contain && StringUtils.contains(propNameVal, propVal)) {
                return true;
            }

            if (!contain && !StringUtils.contains(propNameVal, propVal)) {
                return true;
            }
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage());
        } catch (InvocationTargetException e) {
            logger.error(e.getMessage());
        } catch (NoSuchMethodException e) {
            logger.error(e.getMessage());
        }


        return false;
    }
}
