package de.svennetz.grasser.arctest;

import org.junit.runner.RunWith;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "de.svennetz.grasser.tippspiel")
public class ArcTestPackageRules {
	@ArchTest
	public static final ArchRule servicesRule = classes()
    .that().resideInAPackage("..services..")
    .should().accessClassesThat().resideInAPackage("..business..");
	
	@ArchTest
	public static final ArchRule businessRule = noClasses()
    .that().resideInAPackage("..business..")
    .should().accessClassesThat().resideInAPackage("..services..");
	
	@ArchTest
	public static final ArchRule repositoriesRule1 = classes()
    .that().resideInAPackage("..repositories..")
    .should().onlyBeAccessed().byAnyPackage("..business..");
	
	
	@ArchTest
	public static final ArchRule entitiesRule1 = noClasses()
    .that().resideInAPackage("..entities..")
    .should().accessClassesThat().resideInAPackage("..business..");
	
	@ArchTest
	public static final ArchRule entitiesRule2 = noClasses()
    .that().resideInAPackage("..entities..")
    .should().accessClassesThat().resideInAPackage("..repositories..");

}
