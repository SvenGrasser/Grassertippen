package de.svennetz.grasser.arctest;

import org.junit.runner.RunWith;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchRules;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "de.svennetz.grasser.tippspiel")
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
