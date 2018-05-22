package de.svennetz.grasser.arctest;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

public class EntityRules {
	@ArchTest
	public static final ArchRule entity_should_not_call_business = noClasses()
    .that().resideInAPackage("..entities..")
    .should().accessClassesThat().resideInAPackage("..business..");
	
	@ArchTest
	public static final ArchRule entity_should_not_call_repositories = noClasses()
    .that().resideInAPackage("..entities..")
    .should().accessClassesThat().resideInAPackage("..repositories..");
	
	@ArchTest
	public static final ArchRule entity_should_not_call_services = noClasses()
    .that().resideInAPackage("..entities..")
    .should().accessClassesThat().resideInAPackage("..services..");
}
