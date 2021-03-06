package org.nosreme.versioning;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.nosreme.semver.Version;
import org.nosreme.semver.VersionImpl;
import org.nosreme.system.logical.ComponentDescriptor;
import org.nosreme.system.logical.ComponentType;
import org.nosreme.system.logical.LogicalProduct;
import org.nosreme.system.logical.LogicalService;
import org.nosreme.system.logical.Product;
import org.nosreme.system.logical.Service;
import org.nosreme.system.physical.Build;
import org.nosreme.system.physical.BuildArtifactInformation;
import org.nosreme.system.physical.BuildImpl;
import org.nosreme.system.physical.BuildIncrement;
import org.nosreme.system.physical.BuildProcess;
import org.nosreme.system.physical.BuildProcessImpl;
import org.nosreme.system.physical.ComponentArtifact;
import org.nosreme.system.physical.ProductArtifact;

public class BuildProcessImplTest
{
    @Test
    public void testBuildProcessMethodShouldPass()
    {
    	BuildProcess buildProcess = new BuildProcessImpl();
    	
    	Product product = createProduct();
    	

		BuildArtifactInformation buildArtifactInformation = null;
		Build build = BuildImpl.newBuild("best build ever", LocalDateTime.now(), "hash-it-up", "tag-for-this-release");		
		Set<ComponentArtifact> dependents = null;
    	
		BuildIncrement buildIncrement = BuildIncrement.MAJOR;
    	
    	ProductArtifact productArtifact = buildProcess.build(product, buildArtifactInformation, buildIncrement);
        //Library classUnderTest = new Library();
        //assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }
    
    private Product createProduct()
    {
    	String name = "TAD";
    	String description = "Targetted Audience Delivery Product";
    	Version version = VersionImpl.newVersion(1, 0, 0);
    	
    	Set<ComponentDescriptor> dependencies = new HashSet<ComponentDescriptor>();
    	dependencies.add(ComponentDescriptor.newComponentDescriptor("AMP", "Relational Database", ComponentType.SCHEMA, VersionImpl.newVersion(1, 0, 0)));
    	dependencies.add(ComponentDescriptor.newComponentDescriptor("Jobs", "Relational Database", ComponentType.SCHEMA, VersionImpl.newVersion(1, 0, 0)));
    	dependencies.add(ComponentDescriptor.newComponentDescriptor("Target Creation", "Database", ComponentType.SCHEMA, VersionImpl.newVersion(1, 0, 0)));

    	Set<Service> services = new HashSet<Service>();
    	services.add(LogicalService.newService("TAD", "TAD API for the Browser Client", VersionImpl.newVersion(1, 0, 0)));
    	services.add(LogicalService.newService("Jobs", "Jobs API for Programmatic Client", VersionImpl.newVersion(1, 0, 0)));
    	    	
    	Product product = LogicalProduct.newProduct(name, description, version, dependencies, services);
    	
    	return product;
    }
}
