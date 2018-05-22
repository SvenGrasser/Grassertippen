package de.svennetz.grasser.arctest;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

public class RepositoryRules {

	@ArchTest
	public static final ArchRule repository_should_not_call_business = noClasses()
    .that().resideInAPackage("..repositories..")
    .should().accessClassesThat().resideInAPackage("..business..");
	
	@ArchTest
	public static final ArchRule repository_should_not_call_services = noClasses()
    .that().resideInAPackage("..repositories..")
    .should().accessClassesThat().resideInAPackage("..services..");
}
