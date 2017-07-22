package com.ai.ge.util;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class IgnorePropertyPreFilter extends SimplePropertyPreFilter {
    private Set<String> excludes = new HashSet<String>();

    public void setExcludes(Set<String> excludes) {
        this.excludes = excludes;
    }

    public IgnorePropertyPreFilter(String... excludes) {
        this.excludes.addAll(Arrays.asList(excludes));
    }

    @Override
    public Set<String> getExcludes() {
        return excludes;
    }


    public boolean apply(JSONSerializer serializer, Object source, String name) {
        if (source == null) {
            return true;
        }

        return !this.excludes.contains(name);

    }
}
