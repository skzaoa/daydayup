package com.sk1.server;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sk
 * create on  2020/1/5:21:55
 */
public class Mapping {
    private String name;
    private Set<String> patterns;

    public Mapping() {
        patterns = new HashSet<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPatterns() {
        return patterns;
    }

    public void setPatterns(Set<String> patterns) {
        this.patterns = patterns;
    }

    public void addPattern(String pattern){
        this.patterns.add(pattern);
    }
}
