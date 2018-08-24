package de.svennetz.grasser.arctest;

import org.junit.runner.RunWith;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchRules;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;

import de.svennetz.base.test.archunit.PackageRules.BusinessRules;
import de.svennetz.base.test.archunit.PackageRules.EntityRules;
import de.svennetz.base.test.archunit.PackageRules.RepositoryRules;
import de.svennetz.base.test.archunit.PackageRules.ServiceRules;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "de.svennetz.grasser.tippspiel", importOptions = ImportOption.DontIncludeTests.class)
public class ArcTestPackageRules {
	@ArchTest
    public static final ArchRules serviceRules = ArchRules.in(ServiceRules.class);
	
	@ArchTest
    public static final ArchRules businessRules = ArchRules.in(BusinessRules.class);
	
	@ArchTest
    public static final ArchRules repositoryRules = ArchRules.in(RepositoryRules.class);
	
	@ArchTest
    public static final ArchRules entityRules = ArchRules.in(EntityRules.class);
}
