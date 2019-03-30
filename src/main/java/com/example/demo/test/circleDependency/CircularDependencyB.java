package com.example.demo.test.circleDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyB {
	
//	 private CircularDependencyA circA;
//	 
//	    @Autowired
//	    public CircularDependencyB(CircularDependencyA circA) {
//	        this.circA = circA;
//	    }
	    
    @Autowired
    private CircularDependencyA circA;
 
}
