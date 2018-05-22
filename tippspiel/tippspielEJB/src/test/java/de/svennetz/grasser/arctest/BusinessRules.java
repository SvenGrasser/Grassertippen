package de.svennetz.grasser.arctest;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

public class BusinessRules {
	@ArchTest
	public static final ArchRule business_should_not_call_services = noClasses()
    .that().resideInAPackage("..business..")
    .should().accessClassesThat().resideInAPackage("..services..");
}
